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

        if(this.getValue() == 0){
            return "cardImages/backCover.png" ;
        }

        return String.format("CardImages/%s/%s.png", this.suit,this.rank.getName());
    }
}
