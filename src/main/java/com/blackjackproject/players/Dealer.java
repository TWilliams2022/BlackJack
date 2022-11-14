package com.blackjackproject.players;

import com.blackjackproject.cards.BlackJackHand;
import com.blackjackproject.cards.Card;
import com.blackjackproject.cards.Deck;

public class Dealer {

    private BlackJackHand dealerHand;
    private Deck cards;


    public Dealer() {
        dealerHand = new BlackJackHand();
        cards = new Deck();
    }


    public Card dealACard(){

        return cards.deal();
    }

    public void addACard(Card c){

        dealerHand.addCard(c);

    }


    public int showHandValue(){

        return dealerHand.findHandValue();
    }


    public int remainingCards(){

        return cards.checkDeckSize();
    }

    public void shuffle(){

        cards.shuffle();
    }

    public void clearHand(){

        dealerHand.clear();
    }

    public void dealersTurn(){

        while (dealerHand.findHandValue() < 17){
            addACard(dealACard());
        }
    }



}
