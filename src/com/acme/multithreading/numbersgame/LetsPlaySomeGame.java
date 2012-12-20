package com.acme.multithreading.numbersgame;

import java.util.Arrays;
import java.util.List;

public class LetsPlaySomeGame {

    public static void main(String[] args) {
        final NumbersGame server = new Game();

        System.out.println("egy jatekos in.");
        new Thread() {
            public void run() {
                System.out.println("gamer1 indit");
                Thread.currentThread().setName("gamer1");
                Client gamer1 = new Client();

                gamer1.register(server);
                gamer1.placeBet(0, 10);
        System.out.println("masik");        
            }
        }.start();
        
        System.out.println("ket jatekos in.");
        new Thread() {
            public void run() {
                System.out.println("gamer2 indit");
                Thread.currentThread().setName("gamer2");
                Client gamer1 = new Client();

                gamer1.register(server);
                gamer1.placeBet(15, 20);
        System.out.println("egyik");        
            }
        }.start();

        

    }

}
