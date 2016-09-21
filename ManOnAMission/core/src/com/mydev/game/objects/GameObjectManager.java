package com.mydev.game.objects;

import java.util.Collection;
import java.util.HashMap;

public class GameObjectManager {
	
	private static GameObjectManager instance;
	HashMap<Integer, GameObject> objects;
	private Player player;
	private Enemy enemy;
	private Ally ally;

	public static GameObjectManager getInstance() {
		if (instance == null) {
			instance = new GameObjectManager();
		}
		
		return instance;
		
	}
	
	private GameObjectManager() {
		objects = new HashMap<Integer, GameObject>();
	}
	
	public void addGameObject(GameObject go) {
		int i = 0;
		while (i < Integer.MAX_VALUE) {
			if (objects.putIfAbsent(i, go) == null) {
				if (go instanceof Player) {
					this.player = (Player) go;
				} else if (go instanceof Enemy) {
					this.enemy = (Enemy) go;
				} else if (go instanceof Ally) {
					this.ally = (Ally) go;
				}
				go.setId(i);
				break;
			}
			i++;
		}
		
	}
	
	public Collection<GameObject> getAllGameObjects() {
		return objects.values();
	}
	
	public GameObject getGameObjectById(int id) {
		return objects.get(id);
	}
	
	public void removeGameObjectById(int id) {
		objects.remove(id);
	}
	
	
	public static void clear() {
		instance = null;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Enemy getEnemy() {
		return this.enemy;
	}
	
	public Ally getAlly() {
		return this.ally;
	}
	
}
