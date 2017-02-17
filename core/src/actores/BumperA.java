package actores;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

import interfaces.IBumper;

public class BumperA extends Actor implements IBumper {
	public int puntuacion;
	//public int posX, posY;
	Body body;
	BodyDef bodyDef;
	Fixture fixture;
	FixtureDef fixtureDef;

	//TODO: las coordenadas donde se tienen que dibujar
	public BumperA(int puntuacion, int posX, int posY, World world) {
		this.puntuacion=puntuacion;
		//this.posX=posX;
		//this.posY=posY;
		bodyDef=new BodyDef();
		bodyDef.type = BodyDef.BodyType.StaticBody;
		bodyDef.position.set(posX, posY);
		fixtureDef.restitution=1f;
		body = world.createBody(bodyDef);
		body.createFixture(fixtureDef);
	}
	
	@Override
	public int choque(Ball ball) {
		//body.applyLinearImpulse(new Vector2(ball.getX(), ball.getY()), body.getWorldCenter(), true);
		return this.puntuacion;
	}

	@Override
	public void subirNivel() {
		puntuacion=puntuacion*2;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
	}
	
}
