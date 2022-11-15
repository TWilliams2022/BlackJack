package com.blackjackproject.gui;

import com.blackjackproject.players.Dealer;
import com.blackjackproject.players.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJackLogic {

    private static JFrame frame = new BlackJackGUI();

    // card panels
    CardPanels dealerPanel;
    CardPanels playerPanel;

    //buttons
    JButton newGame;
    JButton endGame;

    // object
    Dealer dealer;
    Player player;

    public void intiGui(){
        newGame = new JButton("New Game");

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        newGame.setBounds(20,610,99,50);
        frame.getContentPane().add(newGame);

        // End Game
        endGame = new JButton("End Game");
        endGame.setEnabled(false);
        endGame.setBounds(121,610,99,50);
        endGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                intiGui();
            }
        });
        frame.getContentPane().add(endGame);

    }


    public void  deal(){

        player = new Player();
        dealer = new Dealer();



    }

    public void hit(){
        player.receiveCard(dealer.dealACard());


    }

    public boolean testWinCondition(){

        //TODO TEST BASIC WIN CODITION
        return false;

    }


    public void updateCardsOnTable(){
        if(dealerPanel != null){
            frame.getContentPane().remove(dealerPanel);
            frame.getContentPane().remove(playerPanel);
        }

        dealerPanel = new CardPanels(dealer.getDealerHand(),420 -(dealer.getDealerHandCount() * 40),50,70,104,10);
        frame.getContentPane().add(dealerPanel);

        playerPanel = new CardPanels(player.getPlayerHand(),420 -(player.playerHandCount() * 40),300,70,104,10);
        frame.getContentPane().add(playerPanel);
        frame.repaint();
    }


    public void startGame(){
        newGame.setEnabled(false);

        // TODO INITAILIZE DEALER AND DECK AND SHUFFLE;

    }

}
