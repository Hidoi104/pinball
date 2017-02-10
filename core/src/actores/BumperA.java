package actores;

import interfaces.IBumper;

public class BumperA implements IBumper {
	public int puntuacion;
	//public int choques=0;

	public BumperA(int puntuacion) {
		this.puntuacion=puntuacion;
	}
	
	@Override
	public int choque(Ball ball) {
		// TODO: hacer lo de la direccion y la velocidad
		return this.puntuacion;
	}

	@Override
	public void subirNivel() {
		puntuacion=puntuacion*2;
	}
	
}
