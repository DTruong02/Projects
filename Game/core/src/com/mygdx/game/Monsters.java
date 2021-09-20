package com.mygdx.game;

import static com.mygdx.game.utils.Constants.PPM;

import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.utils.Constants;

public class Monsters {
	boolean isAlive;
	
	public Body body;
	public World world;

	public Monsters(World world, int x, int y, int width, int height) {
		this.world = world;
		defineMonster(x, y, width, height);
	}

	public Body defineMonster(int x, int y, int width, int height) {
		BodyDef bdef = new BodyDef();
		bdef.position.set(x / Constants.PPM, y / Constants.PPM);
		bdef.type = BodyDef.BodyType.KinematicBody;
		body = world.createBody(bdef);
		
		FixtureDef fdef = new FixtureDef();
		PolygonShape shape = new PolygonShape();
		
		shape.setAsBox(width / 2 / Constants.PPM, height / 2 /Constants.PPM);
		
		fdef.shape = shape;
		Fixture fixture = body.createFixture(fdef);
		fixture.setUserData(this);
		return body;
	}
	
	
	/*public static Body createMonster(int x, int y, int width, int height, World world) {
		Body mBody;
		BodyDef def = new BodyDef();
		def.type = BodyDef.BodyType.KinematicBody;
		
		def.position.set(x / PPM, y / PPM);
		
		def.fixedRotation = true;
		mBody = world.createBody(def);
		
		PolygonShape shape = new PolygonShape();
		//Giving to game so divide by PPM
		shape.setAsBox(width / 2 / PPM, height / 2 / PPM);
		
		mBody.createFixture(shape, 1.0f);
		shape.dispose();
		return mBody;
	}
	
	public static Body monsterMovement(int x, int y, int x2, int y2, float forceX, float forceY) {
		//Body.applyLinearImpulse(forceX, forceY, x, y, true);
		Body mBody = null;
		
		return mBody;
	} */
	
	public void monsterMovementUpdateX(float delta, int x, int force, int dist) {
		if (body.getPosition().x * PPM >= (x + dist)) {
			body.setLinearVelocity(-force, body.getLinearVelocity().y);
			} 
		if (body.getPosition().x * PPM <= x) {
			body.setLinearVelocity(force, body.getLinearVelocity().y);;
			}			
	}
	public void monsterMovementUpdateY(float delta, int y, int force, int dist) {
		if (body.getPosition().y * PPM >= (y + dist)) {
			body.setLinearVelocity(body.getLinearVelocity().x, -force);
			} 
		if (body.getPosition().y * PPM <= y) {
			body.setLinearVelocity(body.getLinearVelocity().x, force);
			}			
	}
	public void hit() {
		System.out.println(body.getUserData() + "I've been hit!");
	}
}
