package com.blackjackproject.cards;

public class BlackJackHand extends Hand {

    public BlackJackHand() {
    }

    public int findHandValue() {
    int value = cards.stream()
            .mapToInt(x -> x.getValue())
            .sum();
    return value;
}
}
