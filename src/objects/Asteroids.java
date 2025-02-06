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
import java.util.Random;

// The Asteroids class represents an asteroid in the game and implements the Updatable and Renderable interfaces.
public class Asteroids implements Updatable, Renderable {
    // Variables for the width and height of the asteroid.
    private double width;
    private double height;
    // Variables for the x and y position of the asteroid.
    private double x;
    private double y;

    // Variable for the rendering layer of the asteroid.
    private final int layer = 2;

    // Variable for the image of the asteroid.
    private BufferedImage asteroid;

    // Variable for the speed of the asteroid.
    private double speed = 150;

    // Random object to generate random values.
    Random rand = new Random();

    // Constructor for the Asteroids class.
    public Asteroids() throws IOException {
        // Generate random dimensions for the asteroid.
        int dimensions = rand.nextInt(75 + 1);

        // Ensure the dimensions are at least 35.
        if (dimensions < 35)
            dimensions = 35;

        // Set the width and height of the asteroid.
        width = dimensions;
        height = dimensions;

        // Generate a random x position for the asteroid within the window width.
        int posX = rand.nextInt((int) Window.getWinWidth() - (int) getWidth() + 1);
        this.x = posX;
        // Set the y position of the asteroid to be above the window height.
        this.y = -getHeight();

        // Load the asteroid image.
        asteroid = ImageIO.read(new File("res\\asteroids.png"));
        // Add the asteroid to the renderer and updater.
        Renderer.addRenderableObjects(this);
        Updater.addUpdatableObjects(this);
    }

    // Method to update the state of the asteroid.
    @Override
    public void update() throws IOException {
        // Move the asteroid down the screen.
        y += speed * FPS.getDeltaTime();

        // Remove the asteroid if it goes off the screen.
        if (y >= Window.getWinHeight()) {
            Updater.removeUpdatableObjects(this);
            Renderer.removeRenderableObjects(this);
        }
    }

    // Method to get the rendering layer of the asteroid.
    @Override
    public int getLayer() {
        return layer;
    }

    // Method to get the x position of the asteroid.
    @Override
    public double getX() {
        return x;
    }

    // Method to get the y position of the asteroid.
    @Override
    public double getY() {
        return y;
    }

    // Method to get the width of the asteroid.
    @Override
    public double getWidth() {
        return width;
    }

    // Method to get the height of the asteroid.
    @Override
    public double getHeight() {
        return height;
    }

    // Method to get the image of the asteroid.
    @Override
    public BufferedImage getBufferedImage() {
        return asteroid;
    }

    // Method to get the ID of the asteroid.
    @Override
    public String getID() {
        return "asteroid";
    }

    // Method to get the renderable representation of the asteroid.
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