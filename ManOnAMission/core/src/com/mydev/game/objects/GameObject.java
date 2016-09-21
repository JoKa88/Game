package com.mydev.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	
	public abstract boolean collidesWithPlayer();
	public abstract int getId();
	public abstract Vector2 getPosition();
	public abstract Texture getTexture();
	public abstract Rectangle getCollisionBox();
	public abstract void move(float delta);
	public abstract void setId(int id);
	
}
