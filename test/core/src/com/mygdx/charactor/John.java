package com.mygdx.charactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class John extends Texture{
	int x, y;
	
	public John() {
		super("assets/badlogic.jpg");
		x = 0;
		y = 0;
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
		if(x > Gdx.graphics.getWidth()) {
			x = 0;
			y = 0;
		}
			
	}
	
	public void plusY() {
		y += 1;
		if(y > Gdx.graphics.getHeight()) {
			x = 0;
			y = 0;
		}
			
	}
	
}
