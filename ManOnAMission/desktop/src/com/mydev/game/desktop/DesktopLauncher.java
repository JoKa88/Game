package com.mydev.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mydev.game.ManOnAMissionGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.backgroundFPS = 6;
		config.resizable = false;
		config.height = ManOnAMissionGame.HEIGHT;
		config.width = ManOnAMissionGame.WIDTH;
		new LwjglApplication(new ManOnAMissionGame(), config);
	}
}
