package jtm.extra09;

public class Board {
	// Array which holds cells of the board
	// Valid values are following:
	// ○ — empty cell
	// ● — is cell with candy
	// ◎ — is cell with crocodile footstep
	char[][] board;

	/**
	 * @param board
	 *            create new Board object and set passed array as its internal
	 *            structure
	 */
	public Board(char[][] board) {
		this.board = board;
	}

	/**
	 * Set value on the board with specified coordinates
	 * 
	 * @param x
	 *            — X coordinates
	 * @param y
	 *            — Y coordinates
	 * @param value
	 *            — value of the cell
	 */
	public void setCandy(int x, int y, char value) {
		// Note that in mathematical presentation X (horizontal) axis is used
		// first, but Y (vertical) second
		// but in array [][] first dimension represents external group (shown on
		// Y axis), but second — internal group (X axis)
		board[y][x] = value;
	}

	/**
	 * @param x
	 *            — X coordinates
	 * @param y
	 *            — Y coordinates
	 * @return value of the given cell
	 */
	public char getCandy(int x, int y) {
		return board[y][x];
	}

	/**
	 * @return X axis size of the board
	 */
	public int getX() {
		return board[0].length;
	}

	/**
	 * @return Y axis size of the board
	 */
	public int getY() {
		return board.length;
	}

	/**
	 * @return number of candies (marked as '●') on the board
	 */
	public int countBoardCandies() {
		int candies = 0;
		for (int j = 0; j < getY(); j++) {
			for (int i = 0; i < getX(); i++) {
				if (getCandy(i, j) == '●')
					candies++;
			}
		}
		return candies;
	}

	/**
	 * @return cloned copy of the new Board object Note that simple .clone()
	 *         method will not work
	 */
	public Board getClone() {
		char[][] tmpArr = new char[getY()][getX()];
		for (int j = 0; j < getY(); j++)
			for (int i = 0; i < getX(); i++)
				tmpArr[j][i] = board[j][i];
		Board tmpBoard = new Board(tmpArr);
		return tmpBoard;
	}

	/*-
	 * Returns String representation of the board e.g.
	 * ◎◎◎◎
	 * ○●●◎
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < getY(); j++) {
			for (int i = 0; i < getX(); i++) {
				sb.append(getCandy(i, j));
			}
			if (j < getY() - 1)
				sb.append('\n');
		}
		return sb.toString();
	}

}
