package jtm.extra09;

/**
 * This is general interface for all Crocodiles
 */
public interface Crocodile {

	/**
	 * Moves crocodile on the passed board eats candies and counts moves and
	 * candies
	 */
	public void move(Board board);

	/**
	 * @return number of passed moves
	 */
	public int getMoves();

	/**
	 * @return number of eaten candies
	 */
	public int getCandies();

	/**
	 * @return type of the crocodile
	 */
	public String getType();

}
