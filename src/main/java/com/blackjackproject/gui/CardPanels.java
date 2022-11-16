package com.blackjackproject.gui;

import com.blackjackproject.cards.BlackJackHand;
import com.blackjackproject.cards.Card;
import com.blackjackproject.cards.Deck;
import com.blackjackproject.cards.Hand;
import com.blackjackproject.players.Player;

import javax.swing.*;
import java.awt.*;


public class CardPanels extends JPanel {

    public CardPanels(BlackJackHand hand, int left, int top, int width, int height, int gap){

        int numCards = hand.getCards().size();

        setBounds(left,top, 35 + numCards * (width + gap), height);
        setLayout(null);
        setOpaque(false);




        int total = hand.getHandValue();



        // player Labels
        JLabel playerScore = new JLabel((total == 21 ? "BJ" : total) + "");
        playerScore.setForeground(Color.WHITE);
        playerScore.setFont(new Font("Lucida Grande",Font.BOLD, 20));
        playerScore.setVerticalAlignment(SwingConstants.CENTER);
        playerScore.setHorizontalAlignment(SwingConstants.RIGHT);
        playerScore.setBounds(0,0,30, height);
        add(playerScore);

        for(int i = 0; i < numCards; i++){
            Images cardImages  = new Images(hand.getCards().get(i).getImgFile());
            cardImages.setBounds(35 + i * (width + gap), 0,width,height);
            add(cardImages);
        }


    }

}
