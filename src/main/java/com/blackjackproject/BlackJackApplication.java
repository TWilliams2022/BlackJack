package com.blackjackproject;


import com.blackjackproject.gui.BlackJackGUI;

public class BlackJackApplication implements Runnable {



    public static void main(String[] args) {

        new Thread( new BlackJackApplication()).start();


    }

    @Override
    public void run() {

    }
}
