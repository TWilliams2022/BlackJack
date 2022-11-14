package com.blackjackproject;


public class BlackJackApplication implements Runnable {
     GUI gui = new GUI();


    public static void main(String[] args) {

        new Thread( new BlackJackApplication()).start();


    }

    @Override
    public void run() {

    }
}
