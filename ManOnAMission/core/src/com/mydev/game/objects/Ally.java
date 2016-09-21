package com.mydev.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mydev.game.screens.GameScreen;

public class Ally extends GameObject{
	
	private Texture texture;
	private Vector2 position;
	private Vector2 target;
	private int id;
	private Rectangle collisionBox;
	
	public Ally(Texture texture, Vector2 position) {
		this.texture = texture;
		this.position = position;
		this.target = new Vector2(position.x, position.y);
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
		Vector2 enemyPos = GameObjectManager.getInstance().getEnemy().getPosition();
		if (enemyPos.dst(this.position) < GameScreen.ENEMYSPEED * 2) {
			Vector2 out = new Vector2(this.position.x - (enemyPos.x - this.position.x), this.position.y - (enemyPos.y - this.position.y));
			return out;
		} else {
			return target;
		}
		
	}

	@Override
	public void setId(int id) {
		this.id = id;		
	}
	
	public void setTarget(Vector2 target) {
		this.target = target;		
	}

}
