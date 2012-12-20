package com.acme.multithreading.numbersgame;

/**
 * Represents the outcome of a round of NumbersGame.
 */
public class GameResult {
	/**
	 * Name of winning thread.
	 */
	private final String winner;

	/**
	 * Lower bound of winning range.
	 */
	private final int low;
	/**
	 * Upper bound of winning range.
	 */
	private final int high;

	public GameResult(String winner, int low, int high) {
		this.winner = winner;
		this.low = low;
		this.high = high;}

	/**
	 * Returns the winning thread's name.
	 *
	 * @return the winning thread's name
	 */
	public String getWinner() {
		return winner;
	}

	/**
	 * Returns the lower bound of the winning bet.
	 *
	 * @return the lower bound of the winning bet.
	 */
	int getWinningLow() {
		return low;
	}

	/**
	 * Returns the upper bound of the winning bet.
	 *
	 * @return the upper bound of the winning bet.
	 */
	int getWinningHigh() {
		return high;
	}
}
