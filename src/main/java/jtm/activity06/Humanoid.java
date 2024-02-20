package jtm.activity06;

public interface Humanoid {

	/**
	 * Birth weight for Humanoids
	 */
	final static int BirthWeight = 2;

	/**
	 * @param If Humanoid's stomach is empty, eat food and gain weight
	 */
	public void eat(Integer food);

	/**
	 * @return eaten food from the stomach
	 */
	public Object vomit();

	/**
	 * @return "Alive" or "Dead" depending on his status
	 */
	public String isAlive();

	/**
	 * @return "Dead" if humanoid successfully killed himself
	 */
	public String killHimself();

	/**
	 * 
	 * @return current weight = BirthWeight + weight of the stomach of the current
	 *         humanoid.
	 */
	public int getWeight();

	/**
	 * @return value of Humanoid in form "ImplementingType: weight
	 *         [contentOfstomach]";
	 */
	public String toString();
}
