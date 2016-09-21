package com.mydev.game.screens;

import com.badlogic.gdx.Screen;
import com.mydev.game.ManOnAMissionGame;
import com.mydev.game.objects.GameObject;

public class DialogScreen implements Screen {
	
	private ManOnAMissionGame game;
	private GameObject gameObject;
	private GameScreen gameScreen;
	
	public DialogScreen(ManOnAMissionGame game, GameObject go, GameScreen gameScreen) { 
		this.game = game;
		this.gameObject = go;
		this.gameScreen = gameScreen;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
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
