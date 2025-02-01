package update;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// The Updater class is responsible for managing and updating all Updatable objects in the game.
public class Updater {
    
    // List of all Updatable objects that need to be updated each frame.
    private static ArrayList<Updatable> updatableObjects = new ArrayList<Updatable>();

    // Temporary list of Updatable objects to be added to the main list.
    private static ArrayList<Updatable> addUpdatableObjects = new ArrayList<Updatable>();

    // Temporary list of Updatable objects to be removed from the main list.
    private static ArrayList<Updatable> removeUpdatableObjects = new ArrayList<Updatable>();

    // The update method is called each frame to update all Updatable objects.
    public static void update() throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        // Iterate through each Updatable object in the main list and call its update method.
        for (Updatable object : updatableObjects) {
            object.update();
        }

        // Remove all objects that are marked for removal.
        updatableObjects.removeAll(removeUpdatableObjects);

        // Add all objects that are marked for addition.
        updatableObjects.addAll(addUpdatableObjects);

        // Clear the temporary lists after processing.
        addUpdatableObjects.clear();
        removeUpdatableObjects.clear();
    }

    // Method to add an Updatable object to the temporary add list.
    public static void addUpdatableObjects(Updatable object) {
        addUpdatableObjects.add(object);
    }

    // Method to add an Updatable object to the temporary remove list.
    public static void removeUpdatableObjects(Updatable object) {
        removeUpdatableObjects.add(object);
    }

    // Method to get the list of all Updatable objects.
    public static ArrayList<Updatable> getUpdateableObject() {
        return updatableObjects;
    }
}
