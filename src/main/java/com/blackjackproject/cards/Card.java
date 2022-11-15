package com.blackjackproject.cards;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getValue() {
        return rank.getValue();
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }

    public String getImgFile() {

        if(getValue() == 0){
            return "" ;//TODO BACK OF CARD IMG
        }

        return String.format("", this.rank,this.suit);
    }
}
