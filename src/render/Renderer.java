package render;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import core.Window;

// The Renderer class extends JPanel and is responsible for rendering all Renderable objects.
public class Renderer extends JPanel {
    // List of all Renderable objects that need to be rendered.
    private static ArrayList<Renderable> renderableObjects = new ArrayList<Renderable>(); // Create a new ArrayList of Renderable objects

    // Temporary list of Renderable objects to be added to the main list.
    private static ArrayList<Renderable> addRenderableObjects = new ArrayList<Renderable>();

    // Temporary list of Renderable objects to be removed from the main list.
    private static ArrayList<Renderable> removeRenderableObjects = new ArrayList<Renderable>();

    // The paintComponent method is called to render the component.
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g); // Call the super method to ensure proper painting.
        Graphics2D g2d = (Graphics2D) g; // Create a new Graphics2D object for better graphics control.

        // Loop through all the objects in the renderableObjects list and draw them.
        for (Renderable object : renderableObjects) {
            object.drawSprite(g2d); // Draw the object using its drawSprite method.
        }

        // Remove the objects that are marked for removal.
        renderableObjects.removeAll(removeRenderableObjects); // Remove the objects in the removeRenderableObjects ArrayList

        // Add the objects that are marked for addition.
        if (addRenderableObjects.size() > 0) {
            renderableObjects.addAll(addRenderableObjects); 
            Collections.sort(renderableObjects); // Sort the objects if necessary.
        }

        // Clear the temporary lists after processing.
        addRenderableObjects.clear(); // Clear the addRenderableObjects ArrayList
        removeRenderableObjects.clear(); // Clear the removeRenderableObjects ArrayList
    }

    // Method to add a Renderable object to the temporary add list.
    public static void addRenderableObjects(Renderable object) { 
        addRenderableObjects.add(object); // Add the object to the addRenderableObjects ArrayList
    }

    // Method to remove a Renderable object to the temporary remove list.
    public static void removeRenderableObjects(Renderable object) {
        removeRenderableObjects.add(object); // Add the object to the removeRenderableObjects ArrayList   
    }

    // Override the getPreferredSize method to set the preferred size of the panel.
    @Override
    public Dimension getPreferredSize() {
        // Return the preferred size of the panel based on the window dimensions.
        return new Dimension((int) Window.getWinWidth(), (int) Window.getWinHeight());
    }
}