package tbooop.model.player.impl;

import tbooop.model.player.api.key.AbstractKey;
import tbooop.model.player.api.key.PlayerKey;

/**
 * Represents the key of a player.
 */
public class BaseKeyImpl extends AbstractKey implements PlayerKey {

    private static final int MAX_KEYS = 20;
    private static final int INITIAL_KEYS = 2;

    /**
     * Create a new instance of a BaseKey.
     */
    public BaseKeyImpl() {
        super(INITIAL_KEYS);
    }

    /** {@inheritDoc} */
    @Override
    public void pickupKey() {
        if (getKey() < MAX_KEYS) {
            super.pickupKey();
        }
    }
}
