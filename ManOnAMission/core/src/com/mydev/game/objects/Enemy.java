package com.mydev.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mydev.game.screens.GameScreen;

public class Enemy extends GameObject {
	
	private Texture texture;
	private Vector2 position;
	private int id;
	private Rectangle collisionBox;
	
	public Enemy(Texture texture, Vector2 position) {
		this.texture = texture;
		this.position = position;
		this.collisionBox = new Rectangle();
		collisionBox.setWidth(texture.getWidth());
		collisionBox.setHeight(texture.getHeight());
	}

	@Override
	public boolean collidesWithPlayer() {
		return this.getCollisionBox().overlaps(GameObjectManager.getInstance().getPlayer().getCollisionBox());
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
		Vector2 direction = new Vector2(findTarget().x - position.x, findTarget().y - position.y);
		direction.limit(GameScreen.ENEMYSPEED * delta);
		position.add(direction);
		}

	public Vector2 findTarget() {
		return GameObjectManager.getInstance().getPlayer().getPosition();
	}

	@Override
	public void setId(int id) {
		this.id = id;	
	}

}
