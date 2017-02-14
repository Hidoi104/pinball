package actores;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import interfaces.IBumper;

public class BumperA extends Actor implements IBumper {
	public int puntuacion;
	//public int choques=0;

	//TODO: las coordenadas donde se tienen que dibujar
	public BumperA(int puntuacion) {
		this.puntuacion=puntuacion;
	}
	
	@Override
	public int choque(Ball ball) {
		//body.applyLinearImpulse(new Vector2(-10, 0), body.getWorldCenter(), true);
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
