package cs.battleofthespirits.entities;

import java.util.Random;

/**
 * This class controls the main functionality of the enemies.
 * @authors Danny T., Esha S., Ahmad G.
 *
 */

public class Enemy {
	protected int enemyDamageMin; 
	protected int enemyDamageMax;
	protected int enemyDamage; 
	protected int enemyHealthPoints;
	
	
	public Enemy(int damageMin, int damageMax, int healthPoints) {
		enemyDamageMin = damageMin;
		enemyDamageMax = damageMax;
		enemyHealthPoints = healthPoints;
	}
	
	public int getHealthPoints() {
		return enemyHealthPoints;
	}
	
	public void setHealthPoints(int healthPoints) {
		enemyHealthPoints = healthPoints;
	}
	
	public int getDamageMin() {
		return enemyDamageMin;
	}
	
	public void setDamageMin(int damageAdded) {
		enemyDamageMin = enemyDamageMin + damageAdded;
	}
	
	public int getDamageMax() {
		return enemyDamageMax;
	}
	
	public void setDamageMax(int damageAdded) {
		enemyDamageMax = enemyDamageMax + damageAdded;
	}
	
	public int attack() {
		Random r = new Random();
		enemyDamage = r.nextInt(enemyDamageMax - enemyDamageMin) + enemyDamageMin;
		return enemyDamage;
	}
}
