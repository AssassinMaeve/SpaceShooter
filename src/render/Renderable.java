package render;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

// The Renderable interface defines the methods that must be implemented by any class that wants to be rendered.
public interface Renderable extends Comparable<Object> {
    // The getLayer method to know what order to render the objects in.
    public int getLayer();

    // The getX method to get the x position of the object.
    public double getX();

    // The getY method to get the y position of the object.
    public double getY();

    // The getWidth method to get the width of the object.
    public double getWidth();

    // The getHeight method to get the height of the object.
    public double getHeight();

    // The drawCollisionBox method to determine if the collision box should be drawn.
    public boolean drawCollisionBox();

    // The getBufferedImage method to get the image of the object.
    public BufferedImage getBufferedImage();

    // The drawSprite method is a default method that draws the sprite using the Graphics2D object.
    public default void drawSprite(Graphics2D g) {
        // Draw the image of the object at its x and y position with its width and height.
        g.drawImage(getBufferedImage(), (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);

        // Uncomment the following lines to draw the collision box for the sprite.
        // if(drawCollisionBox()) {
        //     g.drawRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
        // }
    }

    // The compareTo method is a default method that compares the layers of the objects.
    public default int compareTo(Object o) {
        // Cast the object to a Renderable object.
        Renderable object = (Renderable) o;

        // Compare the layers of the objects.
        if (getLayer() < object.getLayer()) {
            return -1;
        } else if (getLayer() > object.getLayer()) {
            return 1;
        } else {
            return 0;
        }
    }
}