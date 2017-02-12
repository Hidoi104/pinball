package actores;

import com.badlogic.gdx.scenes.scene2d.Actor;

import interfaces.ILaberinto;

public class Laberinto extends Actor implements ILaberinto{

	
	
	boolean puertaDeAcceso[] = new boolean[4];
	
	@Override
	public boolean isNivelSuperado() {
		for (boolean niv : puertaDeAcceso) {
			if(niv == false){
				return false;
			}
		}
		return true;
	}

	@Override
	public void resetearNivel() {
		for (boolean niv : puertaDeAcceso) {
			niv = false;
		}
	}

}
