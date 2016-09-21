package com.mydev.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mydev.game.ManOnAMissionGame;

public class MenuScreen implements Screen{
	
	private ManOnAMissionGame game;
	private Texture buttonBackground;
	private Texture playButtonActive;
	private Texture playButtonInactive;
	private Texture exitButtonActive;
	private Texture exitButtonInactive;
	private Texture optionsButtonActive;
	private Texture optionsButtonInactive;
	
	public MenuScreen(ManOnAMissionGame game) {
		this.game = game;
		buttonBackground = new Texture("button_background.png");
		playButtonActive = new Texture("button_play_active.png");
		playButtonInactive = new Texture("button_play_inactive.png");
		exitButtonActive = new Texture("button_exit_active.png");
		exitButtonInactive = new Texture("button_exit_inactive.png");
		optionsButtonActive = new Texture("button_options_active.png");
		optionsButtonInactive = new Texture("button_options_inactive.png");
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		
		// play button background and text
		game.batch.draw(buttonBackground, ManOnAMissionGame.WIDTH / 2 - buttonBackground.getWidth() / 2, ManOnAMissionGame.HEIGHT * 3 / 4 - buttonBackground.getHeight() / 2);
		
		if (Gdx.input.getX() < ManOnAMissionGame.WIDTH / 2 + buttonBackground.getWidth() / 2 
				&& Gdx.input.getX() > ManOnAMissionGame.WIDTH / 2 - buttonBackground.getWidth() / 2 
				&& ManOnAMissionGame.HEIGHT - Gdx.input.getY() < ManOnAMissionGame.HEIGHT * 3 / 4 + buttonBackground.getHeight() / 2 
				&& ManOnAMissionGame.HEIGHT - Gdx.input.getY() > ManOnAMissionGame.HEIGHT * 3 / 4 - buttonBackground.getHeight() / 2) {
			
			game.batch.draw(playButtonActive, ManOnAMissionGame.WIDTH / 2 - playButtonActive.getWidth() / 2, ManOnAMissionGame.HEIGHT * 3 / 4 - playButtonActive.getHeight() / 2);
			
			if (Gdx.input.isTouched()) {
				this.dispose();
				game.setScreen(new GameScreen(game));
			}
			
		} else {
			game.batch.draw(playButtonInactive, ManOnAMissionGame.WIDTH / 2 - playButtonInactive.getWidth() / 2, ManOnAMissionGame.HEIGHT * 3 / 4 - playButtonInactive.getHeight() / 2);
		}
		
		// options button background and text
		game.batch.draw(buttonBackground, ManOnAMissionGame.WIDTH / 2 - buttonBackground.getWidth() / 2, ManOnAMissionGame.HEIGHT / 2 - buttonBackground.getHeight() / 2);
		
		if (Gdx.input.getX() < ManOnAMissionGame.WIDTH / 2 + buttonBackground.getWidth() / 2 
				&& Gdx.input.getX() > ManOnAMissionGame.WIDTH / 2 - buttonBackground.getWidth() / 2 
				&& ManOnAMissionGame.HEIGHT - Gdx.input.getY() < ManOnAMissionGame.HEIGHT / 2 + buttonBackground.getHeight() / 2 
				&& ManOnAMissionGame.HEIGHT - Gdx.input.getY() > ManOnAMissionGame.HEIGHT / 2 - buttonBackground.getHeight() / 2) {
			
			game.batch.draw(optionsButtonActive, ManOnAMissionGame.WIDTH / 2 - optionsButtonActive.getWidth() / 2, ManOnAMissionGame.HEIGHT / 2 - optionsButtonActive.getHeight() / 2);
			
		} else {
			game.batch.draw(optionsButtonInactive, ManOnAMissionGame.WIDTH / 2 - optionsButtonInactive.getWidth() / 2, ManOnAMissionGame.HEIGHT / 2 - optionsButtonInactive.getHeight() / 2);
		}
			
		// exit button background and text
		game.batch.draw(buttonBackground, ManOnAMissionGame.WIDTH / 2 - buttonBackground.getWidth() / 2, ManOnAMissionGame.HEIGHT / 4 - buttonBackground.getHeight() / 2);
		
		if (Gdx.input.getX() < ManOnAMissionGame.WIDTH / 2 + buttonBackground.getWidth() / 2 
				&& Gdx.input.getX() > ManOnAMissionGame.WIDTH / 2 - buttonBackground.getWidth() / 2 
				&& ManOnAMissionGame.HEIGHT - Gdx.input.getY() < ManOnAMissionGame.HEIGHT / 4 + buttonBackground.getHeight() / 2 
				&& ManOnAMissionGame.HEIGHT - Gdx.input.getY() > ManOnAMissionGame.HEIGHT / 4 - buttonBackground.getHeight() / 2) {
			
			game.batch.draw(exitButtonActive, ManOnAMissionGame.WIDTH / 2 - exitButtonActive.getWidth() / 2, ManOnAMissionGame.HEIGHT / 4 - exitButtonActive.getHeight() / 2);
			
			if (Gdx.input.isTouched()) {
				Gdx.app.exit();
			}
			
		} else {
			game.batch.draw(exitButtonInactive, ManOnAMissionGame.WIDTH / 2 - exitButtonInactive.getWidth() / 2, ManOnAMissionGame.HEIGHT / 4 - exitButtonInactive.getHeight() / 2);
		}
		
		
		game.batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
