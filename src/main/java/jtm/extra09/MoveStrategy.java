package jtm.extra09;

/*-
 * General interface of crocodile movement
 * crocodile always starts movement on [0,0] (top left) cell,
 * and finishes on [i,j] (bottom right) cell. It eats candies on his path
 * (if there are any) and leaves his footsteps on the board.
 * Actual movements depend on implemented MoveStrategy.
 */
public interface MoveStrategy {
	/*-
	 * @param crocodile
	 *   — reference to the crocodile
	 * @param board
	 *   — reference to the game board Cell of the board has following
	 */
	public void move(Crocodile crocodile, Board board);
}
