package actores;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

import comunes.Utiles;

public class Ball extends Actor {
	Sprite sprite;
	TextureAtlas textureMapa;
	TextureRegion textura;
	public Body body;
	boolean dead = false;

	public Ball(World world,int posX, int posY) {
		textureMapa = new TextureAtlas(Gdx.files.internal("bola.atlas"));
		textura = new TextureRegion(textureMapa.findRegion("bola" + getRandomColor()));
		sprite = new Sprite(textura);
		sprite.setPosition(posX, posY);
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set((sprite.getX() + sprite.getWidth() / 2) / Utiles.PIXELS_TO_METERS,
				(sprite.getY() + sprite.getHeight() / 2) / Utiles.PIXELS_TO_METERS);
		this.body = world.createBody(bodyDef);
		CircleShape shape = new CircleShape();
		shape.setRadius(sprite.getWidth() / 2 / Utiles.PIXELS_TO_METERS);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density=1;
		body.createFixture(fixtureDef);
		shape.dispose();
		body.setFixedRotation(false);
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		sprite.setPosition((body.getPosition().x * Utiles.PIXELS_TO_METERS) - sprite.getWidth() / 2,
				(body.getPosition().y * Utiles.PIXELS_TO_METERS) - sprite.getHeight() / 2);
	}



	
	public static String getRandomColor() {
		switch (new Random().nextInt(6)) {
		default:
		case 0:
			return "amarilla";
		case 1:
			return "azul";
		case 2:
			return "morada";
		case 3:
			return "naranja";
		case 4:
			return "roja";
		case 5:
			return "verde";
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		sprite.draw(batch);
	}
}
