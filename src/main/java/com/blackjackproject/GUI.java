package com.blackjackproject;

import javax.swing.*;


public class GUI extends JFrame {

    private int aW = 1200;
    private int aH = 800;


    public GUI(){
        this.setSize(aW,aH); /// width and height of border
        this.setTitle("Team 6 blackjack Game"); // game title
        this.setVisible(true); // set border visable to true
        this.setResizable(true); // allow border to be visable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes application

    }




}
