package com.blackjackproject.gui;

import com.blackjackproject.players.Dealer;
import com.blackjackproject.players.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJackLogic {

    private static JFrame frame = new BlackJackGUI();

    // card panels
    private CardPanels dealerPanel;
    private CardPanels playerPanel;

    //buttons
    private JButton newGame;
    private JButton endGame;
    private JButton hitButton;
    private JButton standButton;

    // object
    private Dealer dealer;
    private Player player;

    //labels for board
    private JLabel labelPlayer;
    private JLabel labelDealer;


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

        labelDealer = new JLabel("Dealer");
        labelDealer.setForeground(Color.WHITE);
        labelDealer.setFont(new Font("Arial Black",Font.BOLD, 20));
        labelDealer.setBounds(415,158,82,28);
        frame.getContentPane().add(labelDealer);

        labelPlayer = new JLabel("Player");
        labelPlayer.setForeground(Color.WHITE);
        labelPlayer.setFont(new Font("Arial Black", Font.BOLD,20));
        labelPlayer.setBounds(415,266,82,28);
        frame.getContentPane().add(labelPlayer);



        hitButton = new JButton("Hit!");

        hitButton.setBounds(290,515,140,35);
        hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hit();
            }
        });
        frame.getContentPane().add(hitButton);
        hitButton.requestFocus();

        standButton = new JButton("Stand");
        standButton.setBounds(470,515,140,35);
        standButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stand();
            }
        });

        //TODO finish

    }

    private void hit(){
        player.receiveCard(dealer.dealACard());
        updateCardsOnTable();

    }

    private boolean testWinCondition(){

        //TODO TEST BASIC WIN CODITION
        return false;

    }

    private void stand(){

        if(testWinCondition()){
            return;
        }

        int playerScore = player.getHandValue();


    }


    private void updateCardsOnTable(){
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
