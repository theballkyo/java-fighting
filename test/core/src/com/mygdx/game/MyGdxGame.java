package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.charactor.John;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	John john;
	Random rand;
	
	float r,g,b;
	
	Task changeColor;
	@Override
	public void create () {
		rand = new Random();
		batch = new SpriteBatch();
		john = new John();
		System.out.println(Gdx.files.internal("assets/badlogic.jpg").path());
		changeColor = Timer.schedule(new Task(){
		    @Override
		    public void run() {
		        r = rand.nextFloat();
		        g = rand.nextFloat();
		        b = rand.nextFloat();
		        // System.out.printf("%s %s %s\n", r, g, b);
		    }
		}, 0.0f, 0.1f);
		
		Timer.schedule(new Task(){
		    @Override
		    public void run() {
		    	Gdx.graphics.setTitle(String.format("%s - %d FPS", Game.title, Gdx.graphics.getFramesPerSecond()));
		    }
		}, 0.0f, 0.2f);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(r, g, b, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		john.plusX();
		john.plusY();
		batch.draw(john, john.getX(), john.getY());
		batch.end();
		
	}
}
