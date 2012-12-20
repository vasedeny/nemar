package com.acme.multithreading.numbersgame;

public class Client {
    
    private NumbersGame server = null;
    
    public void register(NumbersGame server) {
        this.server = server;
        server.register();
    }
    
    public void unregister() {
        if (server == null) {
            System.out.println("nem regisztralt");
        } else {
            server.unregister();
        }
    }
    
    public void placeBet(int low, int high) {
        if (server == null) {
            System.out.println("nem regisztralt");
        } else {
            GameResult result = server.placeBet(low, high);
            System.out.println("nyertes:" + result.getWinner());
        }
    }
    
}
