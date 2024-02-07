package tbooop.model.pickupables.items.impl;

import tbooop.commons.api.Point2d;
import tbooop.model.core.api.GameTag;
import tbooop.model.pickupables.UnmovableName;
import tbooop.model.pickupables.items.api.ItemAbs;
import tbooop.model.pickupables.items.api.PickupablePrices;
import tbooop.model.pickupables.items.api.PickupableStatus;
import tbooop.model.player.api.Player;
/**
 * Class rapresenting Iron Bar item in the
 * game. If picked up by the player, it
 * will increase its damage.
 */
public class LockedRing extends ItemAbs {
    private final int itemCost = PickupablePrices.IRONBAR_PRICE.getItemPrice();
    private PickupableStatus itemTag = PickupableStatus.NORMAL;
    private static final int DAMAGE_TO_INCREASE = 1;
    private final UnmovableName pickupTag = UnmovableName.LOCKED_RING;
    /**
     * Create a new istance of Iron Bar item.
     * 
     * @param position       spawn position (as a Point2d)
     * @param colliderRadius radius of the circle collider (hitbox).
     *                       The center of the collider will be this game object's
     *                       position
     * @param tag            the tag of this game object
     * @throws NullPointerException if any parameter passed is null
     */
    protected LockedRing(final Point2d position, final double colliderRadius, final GameTag tag) {
        super(position, colliderRadius, tag);
    }

    /** {@inheritDoc} 
     * 
     * @param player
    */
    @Override
    public void onPlayerCollision(final Player player) {
        onPickup(player);
    }

    /**
     * When the Iron Bar item is picked up
     * by the player, its
     * damage will increse.
     * 
     * @param player
    */
    private void onPickup(final Player player) {
        if (this.itemTag.equals(PickupableStatus.SPECIAL)) {
            if (player.getCoin() >= this.itemCost) {
                player.increaseDamage(DAMAGE_TO_INCREASE);
                player.setCoin(-itemCost);
            }
        } else {
            player.increaseDamage(DAMAGE_TO_INCREASE);
        }
        destroy();
    }

    /** {@inheritDoc} */
    @Override
    public void setInShop() {
        this.itemTag = PickupableStatus.SPECIAL;
    }

    /** {@inheritDoc} */
    @Override
    public int getPrice() {
        return this.itemCost;
    }

    /** {@inheritDoc} */
    @Override
    public UnmovableName getObjectName() {
        return this.pickupTag;
    } 
}