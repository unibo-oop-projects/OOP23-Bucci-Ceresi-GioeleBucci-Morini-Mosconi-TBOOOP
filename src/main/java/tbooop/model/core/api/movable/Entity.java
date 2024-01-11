package tbooop.model.core.api.movable;

import tbooop.commons.Vector2d;
import tbooop.commons.api.Health;
import tbooop.commons.Point2d;
import tbooop.model.core.api.GameObjectAbs;
import tbooop.model.core.api.GameTag;

/**
 * A Entity is an abstraction of anything that is Damageable and Movable in the
 * game.
 * Every object can take damage and can move must extends this abstact class.
 */
public abstract class Entity extends GameObjectAbs implements Damageable {

    private final Health health;
    private Vector2d direction; // NOPMD suppressed as it is a false positive
    private double velocity;

    /**
     * Create a new istance of a Entity.
     * 
     * @param position      starting position (as a {@link javafx.geometry.Point2D
     *                      Point2D})
     * @param health the entity's health
     * @param velocity      it is the Entity velocity
     * @throws NullPointerException if any parameter passed is null
     */

    protected Entity(final Point2d position, final Health health, final double velocity) {
        super(position, 1, GameTag.ENEMY);
        this.health = health;
        this.velocity = velocity;
        this.direction = new Vector2d(
            super.getPosition().getX(),
            super.getPosition().getY());
    }

    /** {@inheritDoc} */
    @Override
    public void takeDamage(final int damage) {
        this.health.decreaseHealth(damage);
    }

    /** {@inheritDoc} */
    @Override
    public int getHealth() {
        return this.health.getCurrenthHealth();
    }

    /** {@inheritDoc} */
    @Override
    public int getMaxHealth() {
        return this.health.getMaxHealth();
    }

    /**
     * This method it is used to get the velocity with a safe method.
     * 
     * @return immutableDirection
     */
    protected Vector2d getDirection() {
        return new Vector2d(this.direction);
    }

    /**
     * Sets the Entity's velocity value.
     * @param newValue the new value.
     */
    protected void setVelocity(final double newValue) {
        this.velocity = newValue;
    }

    /**
     * Getter for the Entity's velocity.
     * @return the velocity value.
     */
    protected double getVelocity() {
        return this.velocity;
    }

    /**
     * Increases the current healt value.
     * @param amount to add to the max health.
     */
    public void increaseMaxHealth(final int amount) {
        this.health.increaseMaxHealth(amount);
    }

    /**
     * Increases the current healt value.
     * @param amount to add to the current health.
     */
    public void increaseHealth(final int amount) {
        this.health.increaseHealth(amount);
    }
}
