package com.blackjackproject.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJackLogic {

    private static JFrame frame = new BlackJackGUI();

    //buttons
    JButton newGame;
    JButton endGame;

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



    }

    public void startGame(){
        newGame.setEnabled(false);

        // TODO INITAILIZE DEALER AND DECK AND SHUFFLE;

    }

}
