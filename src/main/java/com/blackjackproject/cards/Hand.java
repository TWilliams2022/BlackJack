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
    public void addCard(Card card){
        cards.add(card);
        setHandValue(findHandValue());
    }

    public void clear(){}

    abstract int findHandValue();

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
