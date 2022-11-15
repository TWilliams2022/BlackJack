package com.blackjackproject.cards;

public class BlackJackHand extends Hand {

    // Blackjack hand constructor
    public BlackJackHand() {
    }


    // blackjack hand business methods
    @Override
    public int findHandValue() {          //calculate hand value
        handValue = cards.stream()
            .mapToInt(x -> x.getValue())
            .sum();
        return handValue;
    }




}
