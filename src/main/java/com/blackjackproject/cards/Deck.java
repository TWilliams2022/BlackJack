package com.blackjackproject.cards;

import java.util.*;

public class Deck {

    private List<Card> cards = new ArrayList<>();


    public Deck() {
        createDeck();
    }

    private void createDeck(){

        try {
            for (Suit suits : Suit.values()) {
                for (Rank ranks : Rank.values()) {
                    cards.add(new Card(ranks, suits));
                }
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("A deck was not created: " + e);
        }

    }

    public int checkDeckSize(){
        return cards.size();
    }

    public Card deal(){

        Card cardTodeal = this.cards.remove(0);

        return cardTodeal;
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

}
