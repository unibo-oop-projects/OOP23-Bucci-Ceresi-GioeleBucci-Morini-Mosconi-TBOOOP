package tbooop.model.pickupables.items.impl;

import tbooop.commons.api.Point2d;
import tbooop.model.core.api.GameTag;
import tbooop.model.pickupables.UnmovableName;
import tbooop.model.pickupables.items.api.ItemAbs;
import tbooop.model.pickupables.items.api.PickupablePrices;
import tbooop.model.pickupables.items.api.PickupableStatus;
import tbooop.model.player.api.Player;

/**
 * Class rapresenting "GlassHeart" item in the
 * game. If picked up by the player, it
 * will increase its health to max level.
 */
public class GlassHeart extends ItemAbs {

    private final int itemCost = PickupablePrices.GOLDENHEART_PRICE.getItemPrice();
    private PickupableStatus itemTag = PickupableStatus.NORMAL;
    private final UnmovableName pickupTag = UnmovableName.GLASS_HEART;
    /**
     * Create a new istance of a GlassHeart.
     * 
     * @param position       spawn position (as a Point2d)
     * @param colliderRadius radius of the circle collider (hitbox).
     *                       The center of the collider will be this game object's
     *                       position
     * @param tag            the tag of this game object
     * @throws NullPointerException if any parameter passed is null
     */
    protected GlassHeart(final Point2d position, final double colliderRadius, final GameTag tag) {
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
     * When the GlassHeart is picked up
     * by the player, its health will
     * be fulled to max level.
     * 
     * @param player
    */
    private void onPickup(final Player player) {
        if (this.itemTag.equals(PickupableStatus.SPECIAL)) {
            if (player.getCoin() >= this.itemCost) {
                player.maxRecovery();
                player.setCoin(-itemCost);
            }
        } else {
            player.maxRecovery();
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