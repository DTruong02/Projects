package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.utils.Constants;

public class Box {
	
	public Body body;
	public String id;
	
	public Box(World world, String id, float x, float y) {
		this.id = id;
		createBoxBody(world, x, y);
	}
	
	private void createBoxBody(World world, float x, float y) {
		BodyDef bdef = new BodyDef();
		bdef.fixedRotation = true;
		bdef.type = BodyDef.BodyType.DynamicBody;
		bdef.position.set(x / Constants.PPM, y / Constants.PPM);
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(32 / Constants.PPM, 32 / Constants.PPM);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1.0f;
		
		this.body = world.createBody(bdef);
		this.body.createFixture(fixtureDef).setUserData(this);
		
	}
}
