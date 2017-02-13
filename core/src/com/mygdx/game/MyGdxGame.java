package com.mygdx.game;

import java.net.DatagramSocketImplFactory;

import javax.swing.plaf.basic.BasicLabelUI;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import actores.Ball;
import comunes.GestorElementos;
import comunes.MakingACage;
import comunes.Utiles;

public class MyGdxGame extends ApplicationAdapter {
	private static final float GRAVEDAD_Y = -9.8f;
	public static final int FactorZoomCamara = 9;
	SpriteBatch batch;
	World world;
	Box2DDebugRenderer debugRenderer;
	Matrix4 debugMatrix;
	OrthographicCamera camera;
	Body body;
	MakingACage caja;
	Stage escenario;
	Viewport viewport;
	GestorElementos gestor;

	@Override
	public void create() {
		gestor=new GestorElementos();
		batch = new SpriteBatch();
		world = new World(new Vector2(0, 0), true);
		world.setGravity(new Vector2(0, -9.8f));
		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		viewport = new ScreenViewport(camera);
		escenario = new Stage(viewport, batch);
		gestor.generarElementos(world);
		gestor.anadirElementosStage(escenario);
		caja = new MakingACage(world, 0, Gdx.graphics.getWidth() / Utiles.PIXELS_TO_METERS,
				Gdx.graphics.getHeight() / Utiles.PIXELS_TO_METERS, 1);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.step(1f / 60f, 6, 2);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		debugMatrix = batch.getProjectionMatrix().cpy().scale(Utiles.PIXELS_TO_METERS, Utiles.PIXELS_TO_METERS, 0);
		escenario.act();

		escenario.draw();
		batch.begin();
		batch.end();

		debugRenderer.render(world, debugMatrix);

	}

	@Override
	public void dispose() {
		batch.dispose();
		world.dispose();
		escenario.dispose();
	}

}
