package com.mygdx.charactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class John extends Texture{
	
	Task run;
	SpriteBatch batch;
	
	int x, y;
	
	public John() {
		super("assets/pika.png");
		x = 0;
		y = 0;
		
	}
	
	public John(SpriteBatch batch) {
		super("assets/sun.jpg");
		this.batch = batch;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void plusX() {
		x += 1;
	}
	
	public void plusY() {
		y += 1;
	}
	
	public void plusX(int a) {
		x += a;
	}
	
	public void plusY(int a) {
		y += a;
	}
	public void move() {
		plusX();
		plusY();
	}
	
	public John run() {
		run = Timer.schedule(new Task(){
		    @Override
		    public void run() {
		    	move();
		    }
		}, 0.0f, 1/60f);
		return this;
	}
	
	public void fixOverFlow(int w, int h) {
		if(y > h || y < -super.getHeight()) {
			x = 0;
			y = 0;
		}
		if(x > w || x < -super.getWidth()) {
			x = 0;
			y = 0;
		}
	}
	
	public boolean isAnimation() {
		return run.isScheduled();
	}
	public void toggle() {
		if(run.isScheduled()) {
			run.cancel();
		} else {
			run();
		}
	}
}
