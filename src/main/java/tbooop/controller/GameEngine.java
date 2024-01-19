package tbooop.controller;

import java.util.ArrayList;
import java.util.List;

import tbooop.controller.api.Event;
import tbooop.controller.api.EventListener;
import java.util.logging.Logger;

/**
 * The GameEngine class is responsible for managing the game loop and processing
 * events.
 */
public final class GameEngine implements EventListener {

    private final List<Event> eventQueue = new ArrayList<>();
    // private final World world = new World();
    private final Logger logger = Logger.getLogger(GameEngine.class.getName());

    private static final int FPS = 60;
    private static final long REFRESH_PERIOD = 1L / FPS * 1000; // in ms

    /**
     * The main game loop that processes input and updates the game state.
     */
    public void mainLoop() {
        long prevStartTime = System.currentTimeMillis();
        while (true) {
            final long startTime = System.currentTimeMillis();
            final long elapsed = startTime - prevStartTime;
            // processInput();
            updateGame(elapsed);
            // render();
            waitForNextFrame(startTime);
            prevStartTime = startTime;
        }
        // gameOver();
    }

    private void updateGame(final long elapsed) {
        // TODO Auto-generated method stub
        logger.info("elapsed: " + elapsed);
        throw new UnsupportedOperationException("Unimplemented method 'updateGame'");
    }

    @Override
    public void notifyEvent(final Event event) {
        logger.info("new event recieved.");
        eventQueue.add(event);
    }

    private void waitForNextFrame(final long startTime) {
        final long dt = System.currentTimeMillis() - startTime;
        if (dt < REFRESH_PERIOD) {
            try {
                Thread.sleep(REFRESH_PERIOD - dt);
            } catch (InterruptedException ex) {
                logger.fine("InterruptedException occurred while waiting for next frame: " + ex.getMessage());
            }
        }
    }
}
