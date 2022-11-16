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


    public int numOfAces(){

        int count = 0;

        for(Card card : cards){
            if(card.getValue() == 11){
               count++;
            }
        }
        return count;
    }




}
