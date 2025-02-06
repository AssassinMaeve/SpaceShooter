package objects;

// Import necessary classes for updating, rendering, FPS control, and sound.
import update.Updatable;
import update.Updater;
import render.Renderable;
import render.Renderer;
import core.FPS;
import core.Sound;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// The Bullets class implements Updatable and Renderable interfaces.
public class Bullets implements Updatable, Renderable {
    // Static variables for the width and height of the bullet.
    private static double width = 10;
    private static double height = 10;

    // Variables for the x and y position of the bullet.
    private double x;
    private double y;

    // Variable for the rendering layer of the bullet.
    private final int layer = 1;

    // Variable for the image of the bullet.
    private static BufferedImage bullet;

    // Variable for the speed of the bullet.
    private static double speed = 800;

    // Constructor for the Bullets class.
    public Bullets(double x, double y) throws IOException {
        this.x = x - (getWidth() / 2); // Set the x position of the bullet so it spawns in the middle of the spaceship
        this.y = y;

        // Load the bullet image.
        bullet = ImageIO.read(new File("res\\Bullet.png"));

        // Add the bullet to the renderer and updater.
        Renderer.addRenderableObjects(this);
        Updater.addUpdatableObjects(this);
    }

    // Method to get the rendering layer of the bullet.
    @Override
    public int getLayer() {
        return layer;
    }

    // Method to get the x position of the bullet.
    @Override
    public double getX() {
        return x;
    }

    // Method to get the y position of the bullet.
    @Override
    public double getY() {
        return y;
    }

    // Method to get the width of the bullet.
    @Override
    public double getWidth() {
        return width;
    }

    // Method to get the height of the bullet.
    @Override
    public double getHeight() {
        return height;
    }

    // Method to get the image of the bullet.
    @Override
    public BufferedImage getBufferedImage() {
        return bullet;
    }

    // Method to update the state of the bullet.
    @Override
    public void update() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        y -= speed * FPS.getDeltaTime(); // Move the bullet up the screen

        // Remove the bullet if it goes off the screen.
        if (y < -getHeight()) {
            Updater.removeUpdatableObjects(this); // Remove the bullet from the updater
            Renderer.removeRenderableObjects(this); // Remove the bullet from the renderer
        }

        // Check for collisions with asteroids.
        Updatable collidingObject = isColliding(this, "asteroid");
        if (collidingObject != null) {
            Updater.removeUpdatableObjects(this); // Remove the bullet from the updater
            Renderer.removeRenderableObjects(this); // Remove the bullet from the renderer

            if (collidingObject.getRenderable() != null) {
                Renderer.removeRenderableObjects(collidingObject.getRenderable()); // Remove the colliding object from the renderer
            }

            Updater.removeUpdatableObjects(collidingObject); // Remove the colliding object from the updater
            Sound.playSound("res\\Explosion.wav"); // Play explosion sound
        }
    }

    // Method to get the ID of the bullet.
    @Override
    public String getID() {
        return "bullet";
    }

    // Method to get the renderable representation of the bullet.
    @Override
    public Renderable getRenderable() {
        return this;
    }

    // Method to determine if the collision box should be drawn.
    @Override
    public boolean drawCollisionBox() {
        return true;
    }
}