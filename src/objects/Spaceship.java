package objects;

// Import necessary classes for image handling, file I/O, and audio handling.
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// Import core classes for window management, FPS control, input handling, sound, and timing.
import core.Window;
import core.FPS;
import core.Input;
import core.Sound;
import core.Timer;

// Import render and update interfaces and classes.
import render.Renderable;
import render.Renderer;
import update.Updatable;
import update.Updater;

// The Spaceship class implements Renderable and Updatable interfaces.
public class Spaceship implements Renderable, Updatable {
    // Static variables for the width and height of the spaceship.
    public static double width = 75;
    private static double height = 75;

    // Variables for the x and y position of the spaceship.
    private double x;
    private double y;

    // Variable for the rendering layer of the spaceship.
    private int layer = 2;

    // Variable for the image of the spaceship.
    private static BufferedImage spaceShip;

    // Variable for the speed of the spaceship.
    private double speed = 200;

    // Variable for the shooting timer interval in milliseconds.
    private static int shootTimerMillis = 500;

    // Timer object for controlling the shooting interval.
    Timer timer = new Timer(shootTimerMillis);

    // Constructor for the Spaceship class.
    public Spaceship(double x, double y) throws IOException {
        this.x = x;
        this.y = y;

        // Load the image of the spaceship.
        spaceShip = ImageIO.read(new File("C://College//My Projects//SpaceShooter//res//spaceship.png"));

        // Add the spaceship to the renderer and updater.
        Renderer.addRenderableObjects(this);
        Updater.addUpdatableObjects(this);
    }

    // Method to get the width of the spaceship.
    public double getWidth() {
        return width;
    }

    // Method to get the height of the spaceship.
    public double getHeight() {
        return height;
    }

    // Method to get the x position of the spaceship.
    public double getX() {
        return x;
    }

    // Method to get the y position of the spaceship.
    public double getY() {
        return y;
    }

    // Method to get the rendering layer of the spaceship.
    public int getLayer() {
        return layer;
    }

    // Method to get the image of the spaceship.
    public BufferedImage getBufferedImage() {
        return spaceShip;
    }

    // Method to determine if the collision box should be drawn.
    public boolean drawCollisionBox() {
        return false;
    }

    // Method to update the state of the spaceship.
    public void update() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        // Handle input for moving the spaceship and shooting bullets.
        if (Input.keys[Input.RIGHT] && x <= Window.getWinWidth() - width)
            x += speed * FPS.getDeltaTime();

        if (Input.keys[Input.LEFT] && x >= 0)
            x -= speed * FPS.getDeltaTime();

        if (Input.keys[Input.UP] && y >= 0)
            y -= speed * FPS.getDeltaTime();

        if (Input.keys[Input.DOWN] && y <= Window.getWinHeight() - height)
            y += speed * FPS.getDeltaTime();

        if (Input.keys[Input.SPACE] && timer.isRinging()) {
            new Bullets(x + (width / 2), y);
            timer.resetTimer();
            Sound.playSound("C://College//My Projects//SpaceShooter//res//SpaceshipShoot.wav");
        }

        // Check for collisions with asteroids.
        Updatable collidingObject = isColliding(this, "asteroid");
        if (collidingObject != null) {
            System.out.println("Colliding with: " + collidingObject.getID());
            Updater.removeUpdatableObjects(this);
            Renderer.removeRenderableObjects(this);

            if (collidingObject.getRenderable() != null) {
                Renderer.removeRenderableObjects(collidingObject.getRenderable());
            } else {
                System.err.println("Error: collidingObject.getRenderable() is null");
            }

            Updater.removeUpdatableObjects(collidingObject);
            Sound.playSound("C://College//My Projects//SpaceShooter//res//PlayerDied.wav");
        }
    }

    // Method to get the ID of the spaceship.
    public String getID() {
        return "spaceShip";
    }

    // Method to get the renderable representation of the spaceship.
    public Renderable getRenderable() {
        return this;
    }
}