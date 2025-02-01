package core;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import objects.Background;
import objects.Spaceship;
import render.Renderer;
import update.Updater;
import objects.AsteroidsSpawner;

public class Entry {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException{
        Window window = new Window("Space Invaders", Window.getWinWidth(), Window.getWinHeight()); // Create a new window
        Renderer renderer = new Renderer(); // Create a new renderer
        

        window.add(renderer); // Add the renderer to the window
        window.addKeyListener(new Input()); // Add the input listener to the window


        window.packWindow(); // Pack the window
        window.setVisible(true); // Set the window to be visible


        boolean runGame = true;
        new Spaceship((Window.getWinWidth() / 2) - (Spaceship.width / 2), Window.getWinHeight() - 150);

        new Background(-Window.getWinHeight());
        new AsteroidsSpawner();


        FPS.calcBeginTime(); // Set the time of the current frame

        // This is where the main game will be running
        while(runGame){         

            // update the game state
            Updater.update(); // Update the game state

            // render the game state
            renderer.repaint(); // Repaint the renderer

            // Calculate the delta time
            FPS.calcDeltaTime();
        }
    }
}
