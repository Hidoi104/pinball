package comunes;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import actores.Ball;
import actores.BumperA;
import actores.BumperB;

public class GestorElementos {
		Ball ball;
		ArrayList<BumperA> bumperAs=new ArrayList<BumperA>();
		ArrayList<BumperB> bumperBs=new ArrayList<BumperB>();
		
	
	public GestorElementos() {
		
	}
	
	public void generarElementos(World world){
		ball=new Ball(world,0, 400);
	}
	
	public void anadirElementosStage(Stage stage){
		stage.addActor(ball);
	}
	
}
