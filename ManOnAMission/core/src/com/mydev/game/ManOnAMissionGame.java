package com.mydev.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mydev.game.screens.MenuScreen;

public class ManOnAMissionGame extends Game {
	
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 900;
		
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
}