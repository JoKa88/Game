package com.mydev.game.screens;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mydev.game.ManOnAMissionGame;
import com.mydev.game.objects.Ally;
import com.mydev.game.objects.Enemy;
import com.mydev.game.objects.GameObject;
import com.mydev.game.objects.GameObjectManager;
import com.mydev.game.objects.Player;

public class GameScreen implements Screen{
	
	public static final float PLAYERSPEED = 120;
	public static final float ENEMYSPEED = 60;
	
	private Random random = new Random();
	
	private ManOnAMissionGame game;
		
	public GameScreen(ManOnAMissionGame game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		Player player = new Player(new Texture("player.png"), new Vector2(ManOnAMissionGame.WIDTH / 2, ManOnAMissionGame.HEIGHT / 2));
		player.setTarget(new Vector2(ManOnAMissionGame.WIDTH / 2, ManOnAMissionGame.HEIGHT / 2));
		GameObjectManager.getInstance().addGameObject(player);
		GameObjectManager.getInstance().addGameObject(new Enemy(new Texture("enemy.png"), new Vector2(ManOnAMissionGame.WIDTH * 3 / 4, ManOnAMissionGame.HEIGHT * 3 / 4)));
		GameObjectManager.getInstance().addGameObject(new Ally(new Texture("ally.png"), new Vector2(ManOnAMissionGame.WIDTH / 4, ManOnAMissionGame.HEIGHT / 4)));
	}

	@Override
	public void render(float delta) {
		
		// set movement target for the player
		if (Gdx.input.justTouched()) {
			Player player = GameObjectManager.getInstance().getPlayer();
			player.setTarget(new Vector2(Gdx.input.getX() - player.getTexture().getWidth() / 2, ManOnAMissionGame.HEIGHT - Gdx.input.getY() - player.getTexture().getHeight() / 2));
		}
		
		// check for collisions and order movement
		for (GameObject go : GameObjectManager.getInstance().getAllGameObjects()) {
			
			go.move(delta);
			
			if (! (go instanceof Player)) {
				if (go.collidesWithPlayer()) {
					if (go instanceof Enemy) {
						gameLost();
						break;
					} else if (go instanceof Ally) {
						//TODO
						// game.setScreen(new DialogScreen(game, go));
						GameObjectManager.getInstance().removeGameObjectById(go.getId());
						GameObjectManager.getInstance().addGameObject(new Ally(new Texture("ally.png"), new Vector2(random.nextFloat() * ManOnAMissionGame.WIDTH, random.nextFloat() * ManOnAMissionGame.HEIGHT)));
					}
				}
			}
						
		}
		
		// press escape to go back to the menu
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			this.dispose();
			game.setScreen(new MenuScreen(game));
		}
		
		// draw the background
		Gdx.gl.glClearColor(0, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// draw the game objects
		game.batch.begin();
		for (GameObject go : GameObjectManager.getInstance().getAllGameObjects()) {
			game.batch.draw(go.getTexture(), go.getPosition().x, go.getPosition().y);
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
		GameObjectManager.clear();
	}
	
	private void gameLost() {
		this.dispose();
		game.setScreen(new MenuScreen(game));
		}

}
