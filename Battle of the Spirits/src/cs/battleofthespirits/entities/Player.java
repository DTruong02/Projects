package cs.battleofthespirits.entities;

import java.util.Random;

/**
 * This class controls the functionality of the main character.
 * @authors Danny T., Esha S., Ahmad G.
 *
 */

public class Player {
	private int characterDamageMin; 
	private int characterDamageMax;
	private int characterDamage; 
	private int characterHealthPoints; 
	
	
	public Player(int damageMin, int damageMax, int healthPoints) {
		characterDamageMin = damageMin;
		characterDamageMax = damageMax;
		characterHealthPoints = healthPoints;
	}
	
	public int getCharacterHealthPoints() {
		return characterHealthPoints;
	}
	
	public void setCharacterHealthPoints(int healthPoints) {
		characterHealthPoints = healthPoints;
	}
	
	public int getCharacterDamageMin() {
		return characterDamageMin;
	}
	
	public void setCharacterDamageMin(int damageAdded) {
		characterDamageMin = characterDamageMin + damageAdded;
	}
	
	public int getCharacterDamageMax() {
		return characterDamageMax;
	}
	
	public void setCharacterDamageMax(int damageAdded) {
		characterDamageMax = characterDamageMax + damageAdded;
	}
	
	public int swordSwingAttack() {
		Random r = new Random();
		characterDamage = r.nextInt(characterDamageMax - characterDamageMin) + characterDamageMin;
		return characterDamage;
	}
	
	public int punchAttack() {
		Random r = new Random();
		characterDamage = (r.nextInt(characterDamageMax - characterDamageMin) + characterDamageMin)/2;
		return characterDamage;
	}
	
	public int shieldProtection() {
		Random r = new Random();
		characterDamage = (r.nextInt(characterDamageMax - characterDamageMin) + characterDamageMin)/2;
		return characterDamage;
	}
	
	public int shieldReflection() {
		characterDamage = 125;
		return characterDamage;
	}
	
	public int newSwordSwingAttack() {
		Random r = new Random();
		characterDamage = (r.nextInt(characterDamageMax - characterDamageMin) + characterDamageMin)*2;
		return characterDamage;
	}
}
