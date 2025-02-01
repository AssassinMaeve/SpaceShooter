package update;

import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import render.Renderable;

// The Updatable interface defines the methods that must be implemented by any class that wants to be updated each frame.
public interface Updatable {
    // The update method is called each frame to update the object's state.
    public void update() throws IOException, UnsupportedAudioFileException, LineUnavailableException;

    // The getID method returns a unique identifier for the object.
    public String getID();

    // The getRenderable method returns the Renderable representation of the object.
    public Renderable getRenderable();

    // The isColliding method checks if this object is colliding with another object with the specified ID.
    public default Updatable isColliding(Renderable thisObject, String otherObjectID) {
        
        // Get the list of all Updatable objects from the Updater.
        ArrayList<Updatable> objects = Updater.getUpdateableObject();

        // Iterate through each Updatable object in the list.
        for (Updatable object : objects) {

            // Check if the object's ID matches the specified ID.
            if (object.getID() == otherObjectID) {

                // Check for collision on the X axis.
                if (thisObject.getX() < object.getRenderable().getX() + object.getRenderable().getWidth() &&
                    thisObject.getX() + thisObject.getWidth() > object.getRenderable().getX()) {

                    // Check for collision on the Y axis.
                    if (thisObject.getY() < object.getRenderable().getY() + object.getRenderable().getHeight() &&
                        thisObject.getY() + thisObject.getHeight() > object.getRenderable().getY()) {

                        // Return the colliding object.
                        return object;
                    }
                }
            }
        }

        // Return null if no collision is detected.
        return null;
    }
}