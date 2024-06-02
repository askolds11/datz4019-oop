package jtm.extra09;

import java.util.ArrayList;

public class GameFactory {

	/**
	 * Sets new board for the game
	 * 
	 * @param board
	 *            reference to the new board
	 */
	public static void setBoard(Board board) {
		// #1: set passed board to the CrocodileGame
		CrocodileGame.board = board;
	}

	/**
	 * Adds new crocodile to the list of the game
	 * 
	 * @param crocodileType
	 *            type of the crocodile (CrocodileSimple or CrocodileGreedy)
	 */
	public static void addCrocodile(String crocodileType) {
		// #2: add new Crocodile to the list according of CrocodileGame
		// according to the passed type
		// Check if list is initialized and initialize it if necessary
		if (CrocodileGame.crocodile == null) {
			CrocodileGame.crocodile = new ArrayList<>();
		}
		if (crocodileType.equals("CrocodileSimple")) {
			CrocodileGame.crocodile.add(new CrocodileSimple());
		} else if(crocodileType.equals("CrocodileGreedy")) {
			CrocodileGame.crocodile.add(new CrocodileGreedy());
		}
	}

}
