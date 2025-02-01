package objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import render.Renderable;
import render.Renderer;
import update.Updatable;
import update.Updater;
import core.FPS;
import core.Window;

// The Background class implements Renderable and Updatable interfaces.
public class Background implements Renderable, Updatable {

    // Static variables for the width and height of the background.
    private static double width = Window.getWinWidth();         // Set the width of the background to the window width
    private static double height = Window.getWinHeight() * 2;   // Set the height of the background to twice the window height
    private static double x;    // Static variable for the x position of the background
    private double y;   // Instance variable for the y position of the background

    // Variable for the rendering layer of the background.
    private final int layer = 0;    // Set the rendering layer of the background to 0

    // Variable for the image of the background.
    private static BufferedImage background;    // Static variable for the background image

    // Variable for the speed of the background.
    private double speed = 300;     // Set the speed of the background to 300

    // Constructor for the Background class.
    public Background(double y) throws IOException {
        this.y = y;     // Initialize the y position of the background
        
        background = ImageIO.read(new File("C://College//My Projects//SpaceShooter//res//Space3.jpg"));      // Load the background image
        
        // Add the background to the renderer and updater.
        Renderer.addRenderableObjects(this);    // Add the background to the renderer
        Updater.addUpdatableObjects(this);      // Add the background to the updater
        

    }

    // Method to update the state of the background.
    @Override
    public void update() throws IOException {
        y += speed * FPS.getDeltaTime();

        // Reset the background position if it goes off the screen.
        if(y >= 0){
            y = -Window.getWinHeight();     // Reset the y position of the background
        }
    }

    // Method to get the rendering layer of the background.
    @Override
    public int getLayer() {
        return layer;       // Return the rendering layer of the background
    }

    // Method to get the x position of the background.
    @Override
    public double getX() {
        return x;   // Return the x position of the background
    }

    // Method to get the y position of the background.
    @Override
    public double getY() {
        return y;       // Return the y position of the background
    }

    // Method to get the width of the background.
    @Override
    public double getWidth() {
        return width;           // Return the width of the background
    }

    // Method to get the height of the background.
    @Override
    public double getHeight() {
        return height;      // Return the height of the background
    }

    // Method to get the image of the background.
    @Override
    public BufferedImage getBufferedImage() {
        return background;      // Return the image of the background
    }

    // Method to get the ID of the background.
    @Override
    public String getID() {
        return null;        // Return null as the background does not have an ID
    }

    // Method to get the renderable representation of the background.
    @Override
    public Renderable getRenderable() {
        return null;        // Return null as the background does not have a separate renderable representation
    }

    // Method to determine if the collision box should be drawn.
    @Override
    public boolean drawCollisionBox() {
        return false;   // Return false as the collision box should not be drawn for the background
    }

}
