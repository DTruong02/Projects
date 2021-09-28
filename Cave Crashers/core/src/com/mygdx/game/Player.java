package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.utils.Constants;

public class Player {
	public World world;
	public Body body;
	
	public Player(World world) {
		this.world = world;
		definePlayer();
	}
	
	public Body definePlayer() {
		BodyDef bdef = new BodyDef();
		bdef.position.set(100 / Constants.PPM, 135 / Constants.PPM);
		bdef.type = BodyDef.BodyType.DynamicBody;
		body = world.createBody(bdef);
		
		FixtureDef fdef = new FixtureDef();
		PolygonShape shape = new PolygonShape();
		
		shape.setAsBox(16 / 2 / Constants.PPM, 16 / 2 /Constants.PPM);
		
		fdef.shape = shape;
		Fixture fixture = body.createFixture(fdef);
		fixture.setUserData(this);
		return body;
	}
}
