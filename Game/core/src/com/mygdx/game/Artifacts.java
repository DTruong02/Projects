package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.utils.Constants;

public class Artifacts {
	public World world;
	public Body body;
	
	public Artifacts(World world, int x, int y) {
		this.world = world;
		defineArtifact(x, y);
	}
	
	public Body defineArtifact(int x, int y) {
		BodyDef bdef = new BodyDef();
		bdef.position.set(x / Constants.PPM, y / Constants.PPM);
		bdef.type = BodyDef.BodyType.StaticBody;
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
