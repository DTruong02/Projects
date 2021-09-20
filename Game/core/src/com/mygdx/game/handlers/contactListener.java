package com.mygdx.game.handlers;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.mygdx.game.Artifacts;
import com.mygdx.game.Monsters;
import com.mygdx.game.Player;


public class contactListener implements ContactListener {
	
	private static int hit = 0;
	private static int collected = 0;
	
	@Override
	public void beginContact(Contact contact) {
		Fixture A = contact.getFixtureA();
		Fixture B = contact.getFixtureB();
		if (A == null || B == null) return;
		if (A.getUserData() == null || B.getUserData() == null) return;
		
		if (isContactArtifact(A, B)) {
			if (A.getUserData() instanceof Artifacts) {
				A.setUserData("destroy");
				collected++;	
			} else if (B.getUserData() instanceof Artifacts) {
				B.setUserData("destroy");
				collected++;
			}
		}
		
		if (collected == 3 && A.getUserData() instanceof Player | B.getUserData() instanceof Player) {
			getCollected();
			}
		//Change user data of player to dead
		if (isContactMonster(A, B)) {
			if (A.getUserData() instanceof Monsters) {
				hit++;
				System.out.println(hit);
				if (hit >= 3) {
					B.setUserData("Dead");
				}
				
			} else if (B.getUserData() instanceof Monsters) {
				hit++;
				System.out.println(hit);
				if (hit >= 3) {
					A.setUserData("Dead");
				}
			}
		}
		System.out.println(A.getUserData() + ", " + B.getUserData());
	}
	

	@Override
	public void endContact(Contact contact) {
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
	}

	//If contacting an artifact boolean
	public boolean isContactArtifact(Fixture a, Fixture b) {
		if (a.getUserData() instanceof Artifacts || b.getUserData() instanceof Artifacts) {
			if (a.getUserData() instanceof Player || b.getUserData() instanceof Player) {
				return true;
			}
		}
		return false;
	}
	
	//If contacting a monster boolean
	private boolean isContactMonster(Fixture a, Fixture b) {
		if (a.getUserData() instanceof Monsters || b.getUserData() instanceof Monsters) {
			if (a.getUserData() instanceof Player || b.getUserData() instanceof Player) {
				return true;
			}
		}
		return false;
	}
	
	public static int getCollected() {
		return collected;
		
	}
	
	public static int getHit() {
		return hit;
	}
	
	public static boolean isDead() {
		return true;
	}
}
