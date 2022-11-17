package com.blackjackproject.cards;

import java.util.*;

public class Deck {

    // Deck Fields
    private final List<Card> cards = new ArrayList<>();


    // Deck Constructor
    public Deck() {
        createDeck();
    }


    // Deck Business Methods
    private void createDeck(){                                  // Create a new deck of 52 unique Cards
        try {
            for (Suit suits : Suit.values()) {
                for (Rank ranks : Rank.values()) {
                    cards.add(new Card(ranks, suits));
                }
            }
        } catch (NullPointerException e) {
            throw new NullPointerException
                    ("A deck was not created: " + e);
        }
    }

    public int checkDeckSize(){                                 // returns the deck size
        return cards.size();
    }

    public Card deal(){                                         // deal a single card from the deck
        Card cardTodeal = this.cards.remove(0);
        return cardTodeal;
    }

    public void shuffle(){                                      // shuffle the cards in the deck
        Collections.shuffle(this.cards);
    }

}
