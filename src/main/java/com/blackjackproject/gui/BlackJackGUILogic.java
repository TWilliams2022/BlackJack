package com.blackjackproject.gui;

import com.blackjackproject.BlackJackLogic;
import com.blackjackproject.players.Dealer;
import com.blackjackproject.players.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJackGUILogic {

    private static JFrame frame = new BlackJackGUI();

    // card panels
    private CardPanels dealerPanel;
    private CardPanels playerPanel;

    //buttons
    private JButton newGame;
    private JButton endGame;
    private JButton hitButton;
    private JButton standButton;
    private JButton dealButton;
    private JButton continueButton;

    // object
    private Dealer dealer;
    private Player player;

    //labels for board
    private JLabel labelPlayer;
    private JLabel labelDealer;


    public void intiGui(){
        newGame = new JButton("New Game");

        newGame.addActionListener( new ActionListener() {
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

        dealButton.setEnabled(false);

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
        frame.getContentPane().add(standButton);

        continueButton = new JButton("Continue");
        continueButton.setEnabled(false);
        continueButton.setVisible(false);
        continueButton.setBounds(290,444,320,35);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO FIND CONTINUE;
            }
        });

        frame.getContentPane().add(continueButton);
        frame.repaint();
        //TODO METHOD TO GIVE PLAYER TWO CARDS AND DEAL ONE AND A HIDDEN - check
        BlackJackLogic.clearBothHandsAndDeal(dealer,player);

        updateCardsOnTable();

        testWinCondition();


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
        // Ace values take care of them
        int playerScore = player.getHandValue();
        // TODO DEALER HITS AND WHILE UNDER 17 AND THEN REFRESH THEN CHECK WIN CONDITION - check
        BlackJackLogic.flipDealerCard(dealer);
        int dealerScore = dealer.showHandValue();
        dealer.dealersTurn();

        updateCardsOnTable();

        testWinCondition();

    }


    private void updateCardsOnTable(){
        if(dealerPanel != null){
            frame.getContentPane().remove(dealerPanel);
            frame.getContentPane().remove(playerPanel);
        }

        dealerPanel = new CardPanels(dealer.getDealerHand(),420 - (dealer.getDealerHandCount() * 40),50,70,104,10);
        frame.getContentPane().add(dealerPanel);

        playerPanel = new CardPanels(player.getPlayerHand(),420 - (player.playerHandCount() * 40),300,70,104,10);
        frame.getContentPane().add(playerPanel);
        frame.repaint();
    }


    public void startGame(){
        newGame.setEnabled(false);
        player =new Player();
        dealer = new Dealer();
        dealer.shuffle();

        dealButton = new JButton("Deal");

        dealButton.setBounds(679,610,200,50);
        dealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deal();
            }
        });
        frame.getContentPane().add(dealButton);
        dealButton.requestFocus();
        frame.repaint();


    }

    public static void main(String[] args) {
        BlackJackGUILogic h = new BlackJackGUILogic();
        h.intiGui();
        frame.setVisible(true);
    }



}

