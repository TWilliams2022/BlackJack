package com.blackjackproject;


public class BlackJackApplication implements Runnable {



    public static void main(String[] args) {

        new Thread( new BlackJackApplication()).start();


    }

    @Override
    public void run() {

    }
}
