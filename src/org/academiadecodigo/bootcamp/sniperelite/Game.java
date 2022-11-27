package org.academiadecodigo.bootcamp.sniperelite;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.Destroyable;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.GameObjectFactory;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.GameObject;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.weapons.SniperRifle;

/**
 * Sniper Elite
 */
public class Game {

    public static final double ENEMY_PROBABILITY = 0.7;
    public static final int BULLET_DAMAGE = 1;

    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;

    /**
     * Construct the game
     * @param numberObjects the number of game objects to create
     */
    public Game(int numberObjects) {

        this.sniperRifle = new SniperRifle(BULLET_DAMAGE);
        this.gameObjects = createGameObjects(numberObjects);

    }

    /**
     * Start shooting
     */
    public void start() {

        for (GameObject gameObject : gameObjects) {

            System.out.println(gameObject.getMessage());

            if (gameObject instanceof Destroyable) {

                Destroyable target = (Destroyable) gameObject;
                while (!target.isDestroyed()) {

                    System.out.println("Making the shot...");
                    sniperRifle.shoot(target);

                }

                System.out.println("Target is neutralized. I repeat, Target is neutralized!");

            }

        }

        System.out.println("All targets are down. I repeat all targets are down. " + sniperRifle.getShotsFired() + " shots.");

    }

    private GameObject[] createGameObjects(int numberObjects) {

        GameObject[] gameObjects = new GameObject[numberObjects];

        for (int i = 0; i <gameObjects.length ; i++) {

            gameObjects[i] = Math.random() < ENEMY_PROBABILITY ? GameObjectFactory.createEnemy() : GameObjectFactory.createObject();

        }

        return gameObjects;

    }



}
