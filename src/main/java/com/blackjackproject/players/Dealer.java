package com.blackjackproject.players;

import com.blackjackproject.cards.BlackJackHand;
import com.blackjackproject.cards.Card;
import com.blackjackproject.cards.Deck;

public class Dealer {

    // Dealer Fields
    private BlackJackHand dealerHand;
    private Deck cards;

    // Dealer constructor
    public Dealer() {
        dealerHand = new BlackJackHand();
        cards = new Deck();
    }

    // Dealer Business methods
    public Card dealACard(){       // pull a card from the deck
        return cards.deal();
    }

    public void addACard(Card c){   // add card to dealers hand
        dealerHand.addCard(c);
    }

    public int showHandValue(){
        int handValue = dealerHand.findHandValue();// calculate dealer hand value

        return handValue;
    }

    public int remainingCards(){        //
        return cards.checkDeckSize();
    }

    public void shuffle(){
        cards.shuffle();
    }

    public void clearHand(){
        dealerHand.clear();
    }

    public void displayDealerHand() {
        dealerHand.displayCards();
    }

    public BlackJackHand getDealerHand() {
        return dealerHand;
    }

    public int getDealerHandCount(){

        return dealerHand.getCards().size();
    }

    public void dealersTurn(){

        while (dealerHand.findHandValue() < 17){
            addACard(dealACard());

        }
    }




}
