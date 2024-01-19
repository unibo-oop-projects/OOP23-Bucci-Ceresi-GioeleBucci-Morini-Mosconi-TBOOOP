package tbooop.model.player.api;

import tbooop.model.core.api.movable.Damageable;
import tbooop.commons.Point2ds;

/**
 * A Player is a game object that can move on a 2D space,
 * a player can interact with an enemy trying to kill him or can collect
 * objects on the map.
*/
public interface Player extends Damageable {

    /**
     * Set the current health equals to the max health.
     */
    void maxRecovery();

    /**
     * Increase the current health by 1.
     * @throws IllegalArgumentException if the input parameter is
     * a negative number.
     */
    void recovery();

    /**
    * This method increases the amount of damage the Player can do.
    * @param amount it's the amount of damege to increase.
    */
    void increaseDamage(int amount);

    /**
    * This method increases the number of keys in the player's possession.
    */
    void pickupKeys();

    /**
     * This method it's used for moving the playere in the four direction.
     * @param direction can be UP,DOWN,LEFT,RIGHT.
     */
    void move(Point2ds direction);
}
