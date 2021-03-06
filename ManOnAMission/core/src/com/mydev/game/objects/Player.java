package com.mydev.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mydev.game.ManOnAMissionGame;
import com.mydev.game.screens.GameScreen;

public class Player extends GameObject{
	
	private Texture texture;
	private Vector2 position;
	private Vector2 target;
	private int id;
	private Rectangle collisionBox;

	public Player(Texture texture, Vector2 position) { 
		this.texture = texture;
		this.position = position;
		this.collisionBox = new Rectangle();
		collisionBox.setWidth(texture.getWidth());
		collisionBox.setHeight(texture.getHeight());
	}

	@Override
	public boolean collidesWithPlayer() {
		return false;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public Vector2 getPosition() {
		return this.position;
	}

	@Override
	public Texture getTexture() {
		return this.texture;
	}

	@Override
	public Rectangle getCollisionBox() {
		collisionBox.setCenter(position.x, position.y);
		return collisionBox;
	}
	
	@Override
	public void move(float delta) {
		Vector2 direction = new Vector2(target.x - position.x, target.y - position.y);
		direction.limit(GameScreen.PLAYERSPEED * delta);
		position.add(direction);		
	}
	
	public void setTarget(Vector2 target) {
		if (target.x < texture.getWidth() / 2) {
			target.x = texture.getWidth() / 2;
		}
				
		if (target.x > ManOnAMissionGame.WIDTH - texture.getWidth() / 2) {
			target.x = ManOnAMissionGame.WIDTH - texture.getWidth() / 2;
		}
		
		if (target.y < texture.getHeight() / 2) {
			target.y = texture.getHeight() / 2;
		}
		
		if (target.y > ManOnAMissionGame.HEIGHT - texture.getHeight() / 2) {
			target.y = ManOnAMissionGame.HEIGHT - texture.getHeight() / 2;
		}
		
		
		this.target = target;		
	}

	@Override
	public void setId(int id) {
		this.id = id;		
	}



}
