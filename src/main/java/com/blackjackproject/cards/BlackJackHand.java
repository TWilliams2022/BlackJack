package com.blackjackproject.cards;

public class BlackJackHand extends Hand {


    public BlackJackHand() {
    }

    @Override
    public int findHandValue() {
        handValue = cards.stream()
            .mapToInt(x -> x.getValue())
            .sum();
        return handValue;
    }




}
