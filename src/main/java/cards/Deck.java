package cards;

import java.util.List;

public class Deck {

    private List<Card> cards;

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

}
