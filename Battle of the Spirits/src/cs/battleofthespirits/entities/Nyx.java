package cs.battleofthespirits.entities;


/**
 * This class controls the functionality of the second enemy.
 * @authors Danny T., Esha S., Ahmad G.
 *
 */

public class Nyx extends Enemy {
	
	public Nyx(int damageMin, int damageMax, int healthPoints) {
		super(damageMin, damageMax, healthPoints);
	}

	
	public int biteLeg() {
		enemyDamage = 100;
		return enemyDamage;
	}
}
