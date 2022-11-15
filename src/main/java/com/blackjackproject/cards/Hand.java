package com.blackjackproject.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

    // Fields
    protected List<Card> cards;
    protected int handValue;


    // Constructor
    public Hand() {
        cards = new ArrayList<>();
    }


    // Business Methods
    public void addCard(Card card){             // add a card to hand
        cards.add(card);
        setHandValue(findHandValue());
    }

    public void displayCards(){                 // display all cards in hand
        for (Card card : cards) {
            System.out.println(card.getRank()
                    + " " + card.getSuit());
        }
    }

    public void clear(){                        // clears hand
        cards = new ArrayList<>();
    }

    abstract int findHandValue();               // refer to subclass


    // Setters and Getters
    public List<Card> getCards() {
        return cards;
    }
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    public int getHandValue() {
        return handValue;
    }
    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }



    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                ", handValue=" + handValue +
                '}';
    }
}
