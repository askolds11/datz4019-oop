package jtm.activity03;

/**
 * Black Knight is brave soldier who fights till he is alive. He doesn't bother
 * if some of his arms or legs are cut off. You can kill him only when he lose
 * head. More info at:
 * https://en.wikipedia.org/wiki/Black_Knight_%28Monty_Python%29
 */
public class BlackKnight {
	// Class variables which are shared between all class members (objects)
	public static short totalKnights; // total number of knights at the start of
										// the battle
	public static short aliveKnights; // total number of alive knights
	public static short deadKnights; // total number of dead knights
	public static BlackKnight[] knights; // array of knights in the battle

	// instance variables which are separate for each class member (object)
	public String name; // knight name
	public byte arms, legs, head; // number of limbs
	public boolean alive; // is knight alive

	public static void setBattle(int initialNumber) {
		// initialize array of knights with the passed size.
		BlackKnight.knights = new BlackKnight[initialNumber];
		// Reset total numbers of total, alive and dead knights to zero
		totalKnights = 0;
		aliveKnights = 0;
		deadKnights = 0;
	}

	public BlackKnight(String name) {
		// set name of newly created knight
		// HINT: use "this.name" to access name of knight which otherwise is shadowed
		// by parameter of constructor, which is also called "name"
		this.name = name;
		// 1. set proper count of his arms, legs and head,
		this.arms = 2;
		this.legs = 2;
		this.head = 1;
		// 2. set his status to alive
		this.alive = true;
		// 3. put reference of this knight into next free cell of knights static
		// array
		BlackKnight.knights[aliveKnights] = this;
		// 4. increase number of total and alive knights of static counters
		BlackKnight.totalKnights++;
		BlackKnight.aliveKnights++;
		
	}

	public String cutOffArm() {
		// handle cutting off knight's arms in following way:
		// If knight is dead, return "Only chicken beats dead!"
		// If knight has some arms, cut one off and return "Tis but a scratch!"
		// Else return just "Haah!"
		String returnable;
		if (!this.alive) {
			returnable = "Only chicken beats dead!";
		} else if (this.arms > 0) {
			this.arms--;
			returnable = "Tis but a scratch!";
		} else {
			returnable = "Haah!";
		}
		return returnable;
	}

	public String cutOffLeg() {
		// handle cutting off legs knight's legs in following way:
		// If knight is dead, return "Only chicken beats dead!"
		// If knight has some legs, cut one off and return "Had worse!"
		// Else return just "Haah!"
		String returnable;
		if (!this.alive) {
			returnable = "Only chicken beats dead!";
		} else if (this.legs > 0) {
			this.legs--;
			returnable = "Had worse!";
		} else {
			returnable = "Haah!";
		}
		return returnable;
	}

	public String cutOffHead() {
		// handle cutting off knight's head in following way:
		// If knight is dead, return "Only chicken beats dead!"
		if (!this.alive) {
			return "Only chicken beats dead!";
		}
		// If knight is alive and has head, cut it off and update
		// number of total alive and dead knights and then
		if (this.head > 0) {
			this.head--;
			this.alive = false;
			BlackKnight.aliveKnights--;
			BlackKnight.deadKnights++;
			// If there are other knights alive return:
			// "You'l never win! Arthur, Cnut will still fight!"
			// Where "Arthur, Cnut" are names of still alive knights
			// Else return "You'l burn in hell forever!"
			if (BlackKnight.aliveKnights > 0) {
				StringBuilder aliveKnights = new StringBuilder();
				for (BlackKnight knight: BlackKnight.knights) {
					if (knight != null && knight.alive == true) {
						aliveKnights.append(knight.name + ", ");
					}
				}
				if (aliveKnights.length() > 2) {
					aliveKnights.delete(aliveKnights.length() - 2, aliveKnights.length());
				}
				if (aliveKnights.length() > 0) {
					return "You'l never win! " + aliveKnights + " will still fight!";
				}
				
				}
		}
		
		return "You'l burn in hell forever!";
	}

}
