package com.blackjackproject.gui;

//import com.blackjackproject.BlackJackLogic;
import com.blackjackproject.cards.Card;
import com.blackjackproject.players.Dealer;
import com.blackjackproject.players.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class BlackJackGUILogic {

    private static final JFrame frame = new BlackJackGUI();

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
    private Card hiddenCard;


    //labels for board
    private JLabel labelPlayer;
    private JLabel labelDealer;
    private JLabel infoLabel;


    public BlackJackGUILogic() {
        intiGui();
        frame.setVisible(true);
    }


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
        endGame.setEnabled(true);
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

        infoLabel = new JLabel("Please Hit or Stand");
        infoLabel.setBackground(Color.ORANGE);
        infoLabel.setOpaque(false);
        infoLabel.setForeground(Color.ORANGE);
        infoLabel.setFont(new Font("Arial",Font.BOLD,16));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setBounds(290,482,320,28);
        frame.getContentPane().add(infoLabel);


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

        frame.getContentPane().add(standButton);

        continueButton = new JButton("Continue");
        continueButton.setEnabled(false);
        continueButton.setVisible(false);
        continueButton.setBounds(290,444,320,35);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acceptOutcome();
            }
        });


        frame.getContentPane().add(continueButton);
        frame.repaint();

        clearBothHandsAndDeal(dealer,player);
        hiddenCard = dealer.dealACard();
        updateCardsOnTable();


    }

    private void hit(){
        player.receiveCard(dealer.dealACard());

        testBustCondition();
        updateCardsOnTable();

    }

    public boolean testBustCondition() {
        boolean endGame = false;
        int playerScore = player.getHandValue();

        if(playerScore == 21){

            dealer.addACard(hiddenCard);
            updateCardsOnTable();
            infoLabel.setText("PLAYER HIT BLACKJACK !!!");
        }

        if (playerScore > 21 && player.getPlayerHand().numOfAces() > 0) {

            playerScore = playerScore - 10;

            if(playerScore == 21){

                dealer.addACard(hiddenCard);
                updateCardsOnTable();
                infoLabel.setText("PLAYER HIT BLACKJACK !!!");
            }

            endGame = true;
            winLoseHappen();
        }
        else if(playerScore > 21) {
            infoLabel.setText("YOU HIT BUST DEALER WINS!!!!");
            dealer.addACard(hiddenCard);
            updateCardsOnTable();
            endGame = true;
            winLoseHappen();
        }
        return endGame;
    }





    private void stand(){

        if(testBustCondition()){

            return;
        }

        // Ace values take care of them
        int playerScore = player.getHandValue();

        if(playerScore > 21 && player.getPlayerHand().numOfAces() > 0){
            playerScore = playerScore - 10;
        }

        dealer.addACard(hiddenCard);

        dealer.dealersTurn();

        int dealerScore = dealer.showHandValue();

        if(dealerScore > 21 && dealer.getDealerHand().numOfAces() > 0){
            dealerScore = dealerScore - 10;
        }

        updateCardsOnTable();



        if(playerScore > dealerScore){
            infoLabel.setText("PLAYER WINS!!!");
        }
        else if(dealerScore == 21){
            infoLabel.setText("DEAL HIT BLACKJACK!!!");
        }

        else if(dealerScore > 21){
            infoLabel.setText("DEALER GOES BUST!!! YOU WIN!!");

        }
        else if(playerScore == dealerScore){
            infoLabel.setText("DEALER WINS !!!");
        }
        else {
            infoLabel.setText("DEALER WINS!!!");
        }
        winLoseHappen();

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

    public static void clearBothHandsAndDeal(Dealer dealer, Player player){
        dealer.clearHand();
        player.clearPlayerHand();
        // Deal player and Dealer cards at the beginning of the game
        player.receiveCard(dealer.dealACard());
        dealer.addACard(dealer.dealACard());
        player.receiveCard(dealer.dealACard());

    }


    public void winLoseHappen(){
        hitButton.setEnabled(false);
        standButton.setEnabled(false);

        TimerTask countDown = new TimerTask(){

            @Override
            public void run() {
                continueButton.setEnabled(true);
                continueButton.setVisible(true);
                continueButton.requestFocus();
            }
        };
        countDown.scheduledExecutionTime();
        new Timer().schedule(countDown, 500);
    }


    public void acceptOutcome(){

        frame.getContentPane().remove(hitButton);
        frame.getContentPane().remove(standButton);
        frame.getContentPane().remove(labelDealer);
        frame.getContentPane().remove(dealerPanel);
        frame.getContentPane().remove(playerPanel);
        frame.getContentPane().remove(continueButton);
        frame.getContentPane().remove(infoLabel);
        frame.getContentPane().remove(labelPlayer);

        dealButton.setVisible(true);
        dealButton.requestFocus();
        frame.repaint();

        int choice = JOptionPane.showOptionDialog(null, "Do yo want to continue playing?", "Continue? ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);


        if(choice == JOptionPane.YES_OPTION){
            intiGui();
            dealButton.setEnabled(true);

            if(dealer.remainingCards() < 10){
                dealer = new Dealer();
                dealer.shuffle();
            }
        }
        else {
            frame.getContentPane().removeAll();
            frame.repaint();
            intiGui();
            return;
        }

    }


}

