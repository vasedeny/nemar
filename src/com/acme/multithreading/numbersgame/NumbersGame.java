package com.acme.multithreading.numbersgame;

/**
 * Server class for numbers game. Players place bets, specifying an interval
 * in [0; 100]. The longest interval that does not overlap with any others wins.
 * If two intervals have exactly the same length, the one with lower bounds wins.
 */
public interface NumbersGame {
	/**
	 * Registers a player. The player will be identified by the name
	 * of the Thread it's running in.
	 */
	void register();

	/**
	 * Removes a registered player. The player will be identified by the name
	 * of the Thread it's running in.
	 */
	void unregister();

	/**
	 * Returns the maximum allowed length of range that may be submitted when betting.
	 * @return the maximum allowed length of a range
	 */
	double getMaxLength();

	/**
	 * Places a bet in NumbersGame, attempting to allocate the range
	 * [low; high].
	 * 
	 *  The method will be blocked until all registered
	 * players place their bet or cancel their registration.
	 * 
	 * If the server receives a request to shut down while a round
	 * of the game is in progress, it will wait until the round ends,
	 * then perform the shutdown; upon returning from this method,
	 * the caller thread will be interrupted to indicate shutdown.
	 * Subsequent bets will result in IllegalStateException.
	 *
	 * @param low
	 * @param high
	 * @return information on the winner and its range
	 * @throws IllegalStateException if the server is not running
	 * @throws IllegalArgumentException if the range has an invalid length, or any of its bounds are outside of [0;100]
	 */
	GameResult placeBet(int low, int high) throws IllegalStateException, IllegalArgumentException;
}
