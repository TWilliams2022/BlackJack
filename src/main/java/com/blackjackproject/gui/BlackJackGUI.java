package com.blackjackproject.gui;

import javax.swing.*;

public class BlackJackGUI extends JFrame {

    BlackJackGUI(){
       setTitle("Team 6 BlackJack Game");
       setSize(900,700);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(null);
       setResizable(false);

       //TODO BACK GROUnD
        Images backgroundImage = new Images("TOOD");
        backgroundImage.setBounds(0,0,this.getWidth(),this.getHeight());
    }
}
