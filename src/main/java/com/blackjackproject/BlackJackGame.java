package com.blackjackproject;

import com.blackjackproject.cards.Card;
import com.blackjackproject.players.Dealer;
import com.blackjackproject.players.Player;

import java.util.Locale;
import java.util.Scanner;

public class BlackJackGame {

    private boolean play = true;
    private boolean hit = true;
    private Scanner playerAction = new Scanner(System.in);
    Dealer dealer = new Dealer();
    Player player = new Player();



    public void playGame() {
        // Suffle deck and deal initial cards
        dealer.shuffle();

        // while loop to deal a new game until exit is chosen
        while (play) {

            // set conditions for a new game
            setHit(true);
            dealer.clearHand();
            player.clearPlayerHand();

            // deal cards to begin game
            Card player1 = dealer.dealACard();
            Card dealer1 = dealer.dealACard();
            Card player2 = dealer.dealACard();
            Card hiddenCard = dealer.dealACard(); //this is the dealers face down card
            player.receiveCard(player1);
            dealer.addACard(dealer1);
            player.receiveCard(player2);
            System.out.println("<<Dealer Hand>>");
            dealer.displayDealerHand();
            System.out.println("Dealer Hand: " + dealer.showHandValue());


//            Begins the players turn
//            hit button or stay button
//            will add a card to the players hand on hit and move to dealers turn on stay
//            player hand above 21 also exits loop

            while (hit && player.getHandValue() <= 21) {
                System.out.println("<<Player Hand>>");
                player.displayPlayerCards();
                System.out.println("Hand Value: " + player.getHandValue());
                System.out.println("type Hit (H) to add a card to your hand");
                String action = playerAction.nextLine();
                if (action.toLowerCase().startsWith("h")) {
                    System.out.println("the dealer deals you a new card");
                    Card newCard = dealer.dealACard();
                    player.receiveCard(newCard);
                } else {
                    System.out.println("you decide to stay");
                    setHit(false);
                }
            }

//             player loss if hand is bust

            if (player.getHandValue() > 21) {
                System.out.println("your hand is bust, sorry you lose...");
            }

//             beginning of the Dealers turn
//             dealer will add a card to its hand until hand value is greater than 17

            else {
                System.out.println("Your final hand value: " + player.getHandValue());
                System.out.println("its now the dealers turn");

                dealer.addACard(hiddenCard);  // turns over the dealers hidden card
                System.out.println("<<Dealer Hand>>");
                dealer.displayDealerHand();
                System.out.println("Dealer Value: " + dealer.showHandValue());


                while (dealer.showHandValue() < 17) {

                    System.out.println("the dealer draws another card");
                    dealer.addACard(dealer.dealACard());
                    System.out.println("<<Dealer Hand>>");
                    dealer.displayDealerHand();
                    System.out.println("Dealer Value: " + dealer.showHandValue());
                }
                if (dealer.showHandValue() > 21) {
                    System.out.println("dealer hand is bust you win!!!");
                } else {
                    if (dealer.showHandValue() > player.getHandValue()) {
                        System.out.println("The dealer is the winner...");
                    } else {
                        System.out.println("Congratulations you win!!!");
                    }
                }
            }

//             this hand is over,
//             continue button, exit button

            System.out.println("type yes (y) to continue...");
            String playAgain = playerAction.nextLine();
            if (playAgain.toLowerCase().startsWith("y")) {
                System.out.println("get ready for the next round!!!");
            }
            else {
                System.out.println("Goodbye, play again soon");
                setPlay(false);
            }
        }
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public boolean isHit () {
            return hit;
        }

        public void setHit ( boolean hit){
            this.hit = hit;
        }


        public static void main (String[]args){
            BlackJackGame blackJackGame = new BlackJackGame();
            blackJackGame.playGame();
        }
    }


