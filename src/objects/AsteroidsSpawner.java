package objects;

import java.io.IOException;
import core.Timer;
import render.Renderable;
import update.Updatable;
import update.Updater;

// The AsteroidsSpawner class implements the Updatable interface.
public class AsteroidsSpawner implements Updatable {
    // Timer object to control the spawning interval of asteroids.
    Timer timer = new Timer(500); // Set the timer interval to 500 milliseconds

    // Constructor for the AsteroidsSpawner class.
    public AsteroidsSpawner() {
        Updater.addUpdatableObjects(this); // Add the AsteroidsSpawner to the updater
    }

    // Method to update the state of the AsteroidsSpawner.
    @Override
    public void update() throws IOException {
        if (timer.isRinging()) { // Check if the timer is ringing
            new Asteroids(); // Create a new asteroid
            timer.resetTimer(); // Reset the timer
        }
    }

    // Method to get the ID of the AsteroidsSpawner.
    @Override
    public String getID() {
        return null; // Return null as the AsteroidsSpawner does not have an ID
    }

    // Method to get the renderable representation of the AsteroidsSpawner.
    @Override
    public Renderable getRenderable() {
        return null; // Return null as the AsteroidsSpawner does not have a separate renderable representation
    }
}