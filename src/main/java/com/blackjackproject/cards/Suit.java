package com.blackjackproject.cards;

public enum Suit {
    Diamond("Diamonds"),
    Clubs("Clubs"),
    Spades("Spades"),
    Hearts("Hearts");

   final private String name;

    Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ""+ this.name;
    }
}

