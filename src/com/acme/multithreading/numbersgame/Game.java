package com.acme.multithreading.numbersgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class Game implements NumbersGame {

  private AtomicInteger clients = new AtomicInteger(0);
  private volatile boolean running = true;
  private Interval range = new Interval(0, 100);
  private ArrayList<Bet> bets = new ArrayList<Bet>();
  private GameResult gameResult;

  @Override
  public void register() {
    clients.incrementAndGet();
    if (clients.get() < 2) {
      while (clients.get() < 2) {
        synchronized (bets) {
          try {
            bets.wait();
          } catch (InterruptedException e) {}
        }
      }
    } else {
      synchronized (bets) {
        bets.notifyAll();
      }
    }
  }

  @Override
  public void unregister() {
    clients.decrementAndGet();
  }

  @Override
  public double getMaxLength() {
    return range.getLength();
  }

  @Override
  public GameResult placeBet(int low, int high) throws IllegalStateException,
      IllegalArgumentException {

    // if (!running) {
    // throw new IllegalStateException();
    // }
    //
    Interval i = new Interval(low, high);
    //
    // if (!i.inInterval(range) || i.getLength() >= getMaxLength()) {
    // throw new IllegalArgumentException();
    // }



    synchronized (this) {
      String name = Thread.currentThread().getName();
      Bet bet = new Bet(i, name);
      addTobets(bet);

      if (clients.get() == 1) {
        System.out.println("utolso jatekos " + name);
        createGameResult();
      } else {
        System.out.println("nem utolso jatekos " + name);
        try {
          while (clients.get() != 0) {
            unregister();
            wait();
          }

        } catch (InterruptedException e) {}
      }

      notifyAll();
    }

    return gameResult;
  }

  private void createGameResult() {
    Collections.sort(bets);
    Bet winnerBet = bets.get(bets.size() - 1);
    gameResult = new GameResult(winnerBet.getName(), winnerBet.getLow(), winnerBet.getHigh());
  }

  private void addTobets(Bet bet) {

    bets.add(bet);
    System.out.println(bets);

    /*
     * boolean isBetCrossingAnotherInterval = false; for (Bet b : bets) { if(bet.crosses(b)){
     * isBetCrossingAnotherInterval = true; System.out.println("ez a baj"); break; } } if
     * (!isBetCrossingAnotherInterval){ bets.add(bet); }
     * 
     * System.out.println(bets);
     */
  }
}
