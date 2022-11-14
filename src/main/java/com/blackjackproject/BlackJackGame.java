package com.blackjackproject;

import com.blackjackproject.cards.Card;
import com.blackjackproject.players.Dealer;
import com.blackjackproject.players.Player;

import java.util.Locale;
import java.util.Scanner;

public class BlackJackGame {

    private boolean hit = true;
    private Scanner playerAction = new Scanner(System.in);
    Dealer dealer = new Dealer();
    Player player = new Player();



    public void playGame() {
        // Suffle deck and deal initial cards
        dealer.shuffle();
        Card player1 = dealer.dealACard();
        Card dealer1 = dealer.dealACard();
        Card player2 = dealer.dealACard();
        Card hiddenCard = dealer.dealACard(); //this is the dealers face down card
        player.receiveCard(player1);
        dealer.addACard(dealer1);
        player.receiveCard(player2);

        System.out.println("The Dealer Has: " + dealer.showHandValue());

        // Begins the players turn asking for a hit or stay prompt
        while (hit == true) {
            System.out.println("Your hand is: " + player.getHandValue());
            System.out.println("type Hit (H) to add a card to your hand");
            String action = playerAction.nextLine();
            if (action.toLowerCase().startsWith("h")){
                Card newCard = dealer.dealACard();
                player.receiveCard(newCard);
                System.out.println(newCard);
            }
            else {
                setHit(false);
            }

        }
        if (player.getHandValue() > 21) {
            System.out.println("your hand is bust, sorry you lose");
        }

        else {
            // this is the beginning of the Dealers turn
            System.out.println("Your final hand value: " + player.getHandValue());
            System.out.println("its now the dealers turn");


            dealer.addACard(hiddenCard);  // turns over the dealers hidden card
            System.out.println("dealer hand: " + dealer.showHandValue());
            if (dealer.showHandValue() < 17) {
                dealer.addACard(dealer.dealACard());
            }
            else if (dealer.showHandValue() > 21) {
                System.out.println("dealer hand is bust you win");
            }
            else {
                if (dealer.showHandValue() > player.getHandValue()) {
                    System.out.println("the dealer is the winner");
                }
                else {
                    System.out.println("congratulations you win");
                }
            }
        }


    }




    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
