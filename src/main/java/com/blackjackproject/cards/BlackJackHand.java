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

        if(handValue > 21 && numOfAces() > 0){
            handValue = handValue - 10;
        }
        return handValue;
    }


    private int numOfAces(){

        int count = 0;

        for(Card card : cards){
            if(card.getValue() == 11){
               count++;
            }
        }
        return count;
    }




}
