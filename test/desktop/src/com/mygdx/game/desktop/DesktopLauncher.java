package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Game;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		// Config
		config.title = Game.title;
		config.width = Game.width;
		config.height = Game.height;
		config.resizable = false;
		config.vSyncEnabled = false;
		config.useGL30 = true;
		
		// Launch Application
		new LwjglApplication(new MyGdxGame(), config);
	}
}
