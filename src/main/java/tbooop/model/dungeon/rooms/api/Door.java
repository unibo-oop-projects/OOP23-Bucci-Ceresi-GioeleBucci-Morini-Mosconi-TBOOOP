package tbooop.model.dungeon.rooms.api;

/** A door representation. */
public interface Door {

    /** @return the room this door leads to. */
    Room getRoom();

    /** @return whether this door is special or not. */
    boolean isSpecial();

}
