package com.blackjackproject.cards;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>();


    public Deck() {
        createDeck();
    }

    private void createDeck(){
        for (Suit suits : Suit.values()) {
            for (Rank ranks : Rank.values()) {
                cards.add(new Card(ranks, suits));
            }
        }
    }

    public int checkDeckSize(){
        return cards.size();
    }

    public Card deal(){

        Card cardTodeal = this.cards.remove(0);

        return cardTodeal;
    }

}
