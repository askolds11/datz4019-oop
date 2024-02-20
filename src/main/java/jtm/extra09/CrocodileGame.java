package jtm.extra09;

import java.util.List;

/**
 * Crocodile board game which compares scores of different crocodiles
 * 
 */
public class CrocodileGame {
	public static Board board; // Shared board of the game
	public static List<Crocodile> crocodile; // List of crocodiles

	public static String runGame() {
		// TODO #1: Reset game board before each crocodile movement by using
		// .getClone()
		// method of the Board
		// TODO #2: Go through the list of Crocodiles and move them on the Board
		// using
		// .move() method of crocodile
		// TODO #3: Store score of the crocodile as ratio of eaten candies /
		// made moves
		// Calculate winning crocodile in following way:
		// 1. if score between previous and current crocodile is < 0.001, return
		// "Tie"
		// 2. if score of current crocodile is better return its "getType wins",
		// e.g. "CrocodileGreedy wins"

		return "";
	}

}
