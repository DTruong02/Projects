package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.utils.Constants;
import com.mygdx.game.utils.TiledObjectUtil;

import box2dLight.PointLight;
import box2dLight.RayHandler;

import static com.mygdx.game.utils.Constants.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mygdx.game.Monsters;
import com.mygdx.game.Player;
import com.mygdx.game.handlers.contactListener;;


public class Cave extends ApplicationAdapter {
	

	private OrthographicCamera camera;
	
	World world;
	private Box2DDebugRenderer debugRenderer;
	Player player;

	private Body platform;
	private Box player2, obj1, obj2;

	Monsters bat, bat2, bat3, bat4, bat5, spider, spider2, spider3, spider4, spider5, slime, slime2, slime3, slime4;
	Artifacts ArtifactA, ArtifactB, ArtifactC; 
	
	private RayHandler rayHandler;
	private PointLight ring;
	
	private SpriteBatch batch;
	private Texture texture, spiderTexture, batTexture, slimeTexture, mainMenuTexture, winScreenTexture, instructionTexture, deathScreenTexture, artifactATexture, artifactBTexture, artifactCTexture;
	private Texture Gradient;
	private Texture walkSheetLeft;
	private Texture walkSheetUp;
	private Texture walkSheetRight;
	private Texture walkSheetDown;
	Animation<TextureRegion> walkLeft;
	Animation<TextureRegion> walkUp;
	Animation<TextureRegion> walkRight;
	Animation<TextureRegion> walkDown;
	float stateTime;
	float timer;
	
	private boolean gameScreen = true;
	private boolean enableGradient = true;
	private boolean instructionScreen = true;
	private boolean move = false;
	
	private Sprite sprite, gradientView, sprite2, batSprite, spiderSprite, slimeSprite, mainMenuSprite, winScreenSprite, instructionSprite, deathScreenSprite, artifactASprite, artifactBSprite, artifactCSprite;
	
	private OrthogonalTiledMapRenderer tmr;
	private TiledMap map;

	
	TextureAtlas atlas;
	
	@Override
	public void create() {
		Box2D.init();
		
		//walkSheetLeft = new Texture(Gdx.files.internal("WalkLeft.png"));
		//walkSheetUp = new Texture(Gdx.files.internal("WalkUp.png"));
		//walkSheetRight = new Texture(Gdx.files.internal("WalkRight.png"));
		//walkSheetDown = new Texture(Gdx.files.internal("WalkDown.png"));
		
		//TextureRegion[] walkLeftFrames = new TextureRegion[2];
		//TextureRegion[] walkUpFrames = new TextureRegion[3];
		//TextureRegion[] walkRightFrames = new TextureRegion[2];
		//TextureRegion[] walkDownFrames = new TextureRegion[2];
		
		//walkLeft = new Animation<TextureRegion>(0.5f, walkLeftFrames);
		//walkUp = new Animation<TextureRegion>(0.33f, walkUpFrames);
		//walkRight = new Animation<TextureRegion>(0.5f, walkRightFrames);
		//walkDown = new Animation<TextureRegion>(0.5f, walkDownFrames);
		
		stateTime = 0f;
		
		float w = Gdx.graphics.getHeight();
		float h = Gdx.graphics.getWidth();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w/2, h/2);
		
		world = new World(new Vector2(0, 0), true);
		world.setContactListener(new contactListener());
		//debugRenderer = new Box2DDebugRenderer(true, true, true, true, true, true);
		debugRenderer = new Box2DDebugRenderer(false, false, false, false, false, false);
		
		//Textures and sprites
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("PlayerDown_0.png"));
		sprite = new Sprite(texture);
				
		Gradient = new Texture(Gdx.files.internal("Gradient.png"));
		gradientView = new Sprite(Gradient);
		
		batTexture = new Texture(Gdx.files.internal("Bat_0.png"));
		batSprite = new Sprite(batTexture);
		
		spiderTexture = new Texture(Gdx.files.internal("Spider.png"));
		spiderSprite = new Sprite(spiderTexture);
		
		slimeTexture = new Texture(Gdx.files.internal("Slime_0.png"));
		slimeSprite = new Sprite(slimeTexture);
		
		mainMenuTexture = new Texture(Gdx.files.internal("Mainscreen.png"));
		mainMenuSprite = new Sprite(mainMenuTexture);
		
		winScreenTexture = new Texture(Gdx.files.internal("Winscreen.png"));
		winScreenSprite = new Sprite(winScreenTexture);
		
		instructionTexture = new Texture(Gdx.files.internal("Instructions.png"));
		instructionSprite = new Sprite(instructionTexture);
		
		deathScreenTexture = new Texture(Gdx.files.internal("Deathscreen.png"));
		deathScreenSprite = new Sprite(deathScreenTexture);
		
		artifactATexture = new Texture(Gdx.files.internal("Artifact1.png"));
		artifactASprite = new Sprite(artifactATexture);
		
		artifactBTexture = new Texture(Gdx.files.internal("Artifact-2.png"));
		artifactBSprite = new Sprite(artifactBTexture);
		
		artifactCTexture = new Texture(Gdx.files.internal("Artifact-3.png"));
		artifactCSprite = new Sprite(artifactCTexture);
		
		//Initializing Bodies
		player = new Player(world);
		
		bat = new Monsters(world, 200, 200, 16, 16);
		bat2 = new Monsters(world, 272, 272, 16, 16);
		bat3 = new Monsters(world, 140 * 16, 31 * 16, 16, 16);
		bat4 = new Monsters(world, 62 * 16, 23 * 16, 16, 16);
		bat5 = new Monsters(world, 99 * 16, 71 * 16, 16, 16);
		spider = new Monsters(world, 32 * 16, 63 * 16, 16, 16);
		spider2 = new Monsters(world, 19 * 16, 32 * 16, 16, 16);
		spider3 = new Monsters(world, 70 * 16, 67 * 16, 16, 16);
		spider4 = new Monsters(world, 41 * 16, 20 * 16, 16, 16);
		spider5 = new Monsters(world, 79 * 16, 44 * 16, 16, 16);
		slime = new Monsters(world, 19 * 16, 59 * 16, 16, 16);
		slime2 = new Monsters(world, 41 * 16, 16 * 16, 16, 16);
		slime3 = new Monsters(world, 56 * 16, 40 * 16, 16, 16);
		slime4 = new Monsters(world, 99 * 16, 29 * 16, 16, 16);
		
		ArtifactA = new Artifacts(world, 520, 1384);
		ArtifactB =  new Artifacts(world, 1064, 392);
		ArtifactC = new Artifacts(world, 2248, 440);
		
		//Map and collision lines
		map = new TmxMapLoader().load("Maps/GameMap.tmx");
		tmr = new OrthogonalTiledMapRenderer(map);
		TiledObjectUtil.parseTiledObjectLayer(world, map.getLayers().get("collision-layer").getObjects());
		
	}

	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());
		
		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		tmr.render();
		stateTime += Gdx.graphics.getDeltaTime();
		
		
		batch.begin();
		batch.draw(sprite, player.body.getPosition().x * PPM - sprite.getWidth()/2, player.body.getPosition().y * PPM - sprite.getHeight()/2);
		sprite.setPosition(player.body.getPosition().x * PPM - sprite.getWidth() / 2, player.body.getPosition().y * PPM - sprite.getHeight() / 2);
		//Animation Drawings
		
		
		//Bat Drawings
		batch.draw(batSprite, bat.body.getPosition().x * PPM - batTexture.getWidth()/2, bat.body.getPosition().y * PPM - batTexture.getHeight()/2);
		batch.draw(batSprite, bat2.body.getPosition().x * PPM - batTexture.getWidth()/2, bat2.body.getPosition().y * PPM - batTexture.getHeight()/2);
		batch.draw(batSprite, bat3.body.getPosition().x * PPM - batTexture.getWidth()/2, bat3.body.getPosition().y * PPM - batTexture.getHeight()/2);
		batch.draw(batSprite, bat4.body.getPosition().x * PPM - batTexture.getWidth()/2, bat4.body.getPosition().y * PPM - batTexture.getHeight()/2);
		batch.draw(batSprite, bat5.body.getPosition().x * PPM - batTexture.getWidth()/2, bat5.body.getPosition().y * PPM - batTexture.getHeight()/2);

		//Spider Drawings
		batch.draw(spiderSprite, spider.body.getPosition().x * PPM - spiderTexture.getWidth()/2, spider.body.getPosition().y * PPM - spiderTexture.getHeight()/2);
		batch.draw(spiderSprite, spider2.body.getPosition().x * PPM - spiderTexture.getWidth()/2, spider2.body.getPosition().y * PPM - spiderTexture.getHeight()/2);
		batch.draw(spiderSprite, spider3.body.getPosition().x * PPM - spiderTexture.getWidth()/2, spider3.body.getPosition().y * PPM - spiderTexture.getHeight()/2);
		batch.draw(spiderSprite, spider4.body.getPosition().x * PPM - spiderTexture.getWidth()/2, spider4.body.getPosition().y * PPM - spiderTexture.getHeight()/2);
		batch.draw(spiderSprite, spider5.body.getPosition().x * PPM - spiderTexture.getWidth()/2, spider5.body.getPosition().y * PPM - spiderTexture.getHeight()/2);
		
		//Slime Drawings
		batch.draw(slimeSprite, slime.body.getPosition().x * PPM - slimeTexture.getWidth()/2, slime.body.getPosition().y * PPM - slimeTexture.getHeight()/2);
		batch.draw(slimeSprite, slime2.body.getPosition().x * PPM - slimeTexture.getWidth()/2, slime2.body.getPosition().y * PPM - slimeTexture.getHeight()/2);
		batch.draw(slimeSprite, slime3.body.getPosition().x * PPM - slimeTexture.getWidth()/2, slime3.body.getPosition().y * PPM - slimeTexture.getHeight()/2);
		batch.draw(slimeSprite, slime4.body.getPosition().x * PPM - slimeTexture.getWidth()/2, slime4.body.getPosition().y * PPM - slimeTexture.getHeight()/2);
		//When button pressed start a timer with an if statement and then set a boolean to true
		//if timer exceeds certain amount of time boolean becomes false and timer reset to 0
		
		/* Things to do for this game:
		 * -animations with if statements inside of this render method between the batch so that when certain key pressed the animation plays in that direction using texture atlas
		 * -Gamescreen using if statements and boolean that is set to true after key pressed so that it wont pop back up
		 */
		
		//Artifacts
		//if (!contactListener.isArtifactAD) {
			batch.draw(artifactASprite, ArtifactA.body.getPosition().x * PPM - artifactATexture.getWidth() / 2, ArtifactA.body.getPosition().y * PPM - artifactATexture.getHeight() / 2);
		//}
		
		//if (!contactListener.isArtifactBDead()) {
			batch.draw(artifactBSprite, ArtifactA.body.getPosition().x * PPM - artifactBTexture.getWidth() / 2, ArtifactB.body.getPosition().y * PPM - artifactBTexture.getHeight() / 2);
		//}
		
		//if (!contactListener.isArtifactCDead()) {
			batch.draw(artifactCSprite, ArtifactC.body.getPosition().x * PPM - artifactCTexture.getWidth() / 2, ArtifactC.body.getPosition().y * PPM - artifactCTexture.getHeight() / 2);
		//}		

		//Illuminate entire cave power up
		if (!Gdx.input.isKeyPressed(Keys.F) && timer < 5 && enableGradient) {
			batch.draw(gradientView, player.body.getPosition().x * PPM - Gradient.getWidth()/2, player.body.getPosition().y * PPM - Gradient.getHeight()/2);
		} else {
			timer += Gdx.graphics.getDeltaTime();
			enableGradient = false;
			if (timer > 5) {
				enableGradient = true;
				timer = 0;
			}
			System.out.println(timer);
		}
		
		//Scalable main menu and all game screens
		float currentWidth = Gdx.graphics.getWidth();
		float currentHeight = Gdx.graphics.getHeight();
		if (contactListener.isDead() && contactListener.getHit() == 3) {
			batch.draw(deathScreenSprite, player.body.getPosition().x * PPM - sprite.getWidth()/2 - currentWidth / 2, player.body.getPosition().y * PPM - sprite.getHeight()/2 - currentHeight / 2, currentWidth, currentHeight);
		}
		if (!Gdx.input.isKeyPressed(Keys.ENTER) && instructionScreen) {
			batch.draw(instructionSprite, player.body.getPosition().x * PPM - sprite.getWidth()/2 - currentWidth / 2, player.body.getPosition().y * PPM - sprite.getHeight()/2 - currentHeight / 2, currentWidth, currentHeight);
		} else {
			move = true;
			camera.zoom = 1f;
			instructionScreen = false;
		}
		if (!Gdx.input.isKeyPressed(Keys.G) && gameScreen) {
			camera.zoom = 1.95f;
			batch.draw(mainMenuSprite, player.body.getPosition().x * PPM - sprite.getWidth()/2 - currentWidth / 2, player.body.getPosition().y * PPM - sprite.getHeight()/2 - currentHeight / 2, currentWidth, currentHeight);
		} else {
			camera.zoom = 1f;
			gameScreen = false;
		}
		
		if ((player.body.getPosition().x * PPM < 1950 && player.body.getPosition().x * PPM > 1912) && (player.body.getPosition().y * PPM > 1176 && player.body.getPosition().y * PPM < 1192) && contactListener.getCollected() == 3) {
			gameScreen = true;
			player.body.setLinearVelocity(0, 0);
			batch.draw(winScreenSprite, player.body.getPosition().x * PPM - sprite.getWidth()/2 - currentWidth / 2, player.body.getPosition().y * PPM - sprite.getHeight()/2 - currentHeight / 2, currentWidth, currentHeight);
		}
		
		batch.end();
		
		System.out.println(player.body.getUserData());
		debugRenderer.render(world, camera.combined.scl(PPM));

	}
	
	@Override
	public void dispose () {
		world.dispose();
		tmr.dispose();
		map.dispose();
		debugRenderer.dispose();	
	}
	
	public void resize(int width, int height) {
		camera.setToOrtho(false, width / 2, height / 2);
	}
	
	public void update(float delta) {
		world.step(1/60f, 6, 2);
		sweepDeadBodies();
		if (!Gdx.input.isKeyPressed(Keys.G) && gameScreen) {
			
		} else {
			gameScreen = false;
			camera.zoom = 1f;
			if (move) {
				inputUpdate(delta);
			}
		}
		cameraUpdate(delta);
		monsterMovementUpdate(delta);
		tmr.setView(camera);
		
	}
	public void cameraUpdate(float delta) {
		Vector3  position = camera.position;
		//Taking from game so multiplied by PPM
		
		position.x = player.body.getPosition().x * PPM;
		position.y = player.body.getPosition().y * PPM;
		camera.position.set(position);
		
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
	}
	
	public void inputUpdate(float delta) {
		
		if(Gdx.input.isKeyPressed(Keys.W) && player.body.getLinearVelocity().y < MAX_VEL1) {
			player.body.applyLinearImpulse(0, 0.5f,player.body.getPosition().x, player.body.getPosition().y,  true);
			//isMovingUp = true;
		}
		if(Gdx.input.isKeyPressed(Keys.A) && player.body.getLinearVelocity().x >- MAX_VEL2 ) {
			player.body.applyLinearImpulse(-0.5f, 0,player.body.getPosition().x, player.body.getPosition().y, true);
			//isMovingLeft = true;
		}
		if(Gdx.input.isKeyPressed(Keys.S) && player.body.getLinearVelocity().y > -MAX_VEL1) {
			player.body.applyLinearImpulse(0, -0.5f,player.body.getPosition().x, player.body.getPosition().y, true);
			//isMovingDown = true;
		}
		if(Gdx.input.isKeyPressed(Keys.D) && player.body.getLinearVelocity().x < MAX_VEL2) {
			player.body.applyLinearImpulse( 0.5f, 0,player.body.getPosition().x, player.body.getPosition().y, true);
			//isMovingRight = true;
			
		}
		if (!Gdx.input.isKeyPressed(Keys.W) && !Gdx.input.isKeyPressed(Keys.S)){
			player.body.setLinearVelocity(player.body.getLinearVelocity().x, 0);
		}
		if (!Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D)){
			player.body.setLinearVelocity(0, player.body.getLinearVelocity().y);
		}
		
	}
	
	public void monsterMovementUpdate(float delta) {
		bat.monsterMovementUpdateX(delta, 200, 1, 100);
		bat2.monsterMovementUpdateY(delta, 272, 2, 200);
		bat3.monsterMovementUpdateY(delta, 31 * 16, 3, 18 * 16);
		bat4.monsterMovementUpdateX(delta, 62 * 16, 4, 31 * 16);
		bat5.monsterMovementUpdateX(delta, 99 * 16, 7, 27 * 16);
		spider.monsterMovementUpdateY(delta, 63 * 16, 3, 20 * 16);
		spider2.monsterMovementUpdateX(delta, 19 * 16, 2, 8 * 16);
		spider3.monsterMovementUpdateY(delta, 67 * 16, 3, 21 * 16);
		spider4.monsterMovementUpdateY(delta, 20 * 16, 5, 14 * 16);
		spider5.monsterMovementUpdateY(delta, 44 * 16, 4, 17 * 16);
		slime.monsterMovementUpdateX(delta, 19 * 16, 1, 19 * 16);
		slime2.monsterMovementUpdateX(delta, 41 * 16, 3, 22 * 16);
		slime3.monsterMovementUpdateX(delta, 56 * 16, 2, 11 * 16);
		slime4.monsterMovementUpdateY(delta, 29 * 16, 3, 12 * 16);
		
	}
	
	public Body createBox(int x, int y, int width, int height, boolean isStatic) {
		Body pBody;
		BodyDef def = new BodyDef();
		
		if(isStatic) { 
			def.type = BodyDef.BodyType.StaticBody;
		}
		
		else {
			def.type = BodyDef.BodyType.DynamicBody;
		}
		
		def.position.set(x / PPM, y /PPM);
		
		def.fixedRotation = true;
		pBody = world.createBody(def);
		
		PolygonShape shape = new PolygonShape();
		//Giving to game so divide by PPM
		shape.setAsBox(width / 2 / PPM, height / 2 / PPM);
		
		pBody.createFixture(shape, 1.0f);
		shape.dispose();
		return pBody;
	}
	
	public void animation(int width, int height,  String path) {
		
	}

	public void sweepDeadBodies() {
		//System.out.println("deleting bodies");
		Array<Body> bodies = new Array<Body>();
		world.getBodies(bodies);
		for(Body bod: bodies) {
	    	if ("destroy".equals(bod.getUserData())) {
	    		world.destroyBody(bod);
	    		bod.setUserData(null);
	    	}
	    }
	    //System.out.println("deleted bodies");
	}
	//Array<Body> bodies = new Array<Body>();
	
	
}
