package jtm.activity06;

public interface Alien {

	/**
	 * Weight of aliens is -1 at the birth
	 */
	final static int BirthWeight = -1;

	/**
	 * @param If Alien is hungry (stomach is empty), eat Object. Possibly eaten
	 *           items are:
	 * 
	 *           1. Integer, 2. Humanoid, 3. Alien.
	 * 
	 *           Gain weight of eaten item, and kill it, if possible
	 */
	public void eat(Object item);

	/**
	 * @return content of the Alien stomach
	 *
	 */
	public Object vomit();

	/**
	 * 
	 * @return weight of the alien
	 */
	public int getWeight();

	/**
	 * @return "I AM IMMORTAL!" because alien is immortal
	 */
	public String isAlive();

	/**
	 * @return "I AM IMMORTAL!" because alien is immortal
	 */
	public String killHimself();

	/**
	 * @return string in form "ImplementingType: weight [contenOfstomach]";
	 */
	public String toString();
}
