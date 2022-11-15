package com.blackjackproject.cards;

public class Card {

    // Card Fields
    private Rank rank;
    private Suit suit;


    // Card Constructors
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }


    // Card Setters and Getters
    public int getValue() {
        return rank.getValue();
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
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
