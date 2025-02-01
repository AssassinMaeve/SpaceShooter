package core;

import java.io.IOException;

import render.Renderable;
import update.Updatable;
import update.Updater;

// The Timer class is used to manage timing events in the game.
public class Timer implements Updatable {
    int setMillisTime = 0; // The current time remaining on the timer in milliseconds
    int beginningMillisTime = 0; // The initial time set for the timer in milliseconds

    // Constructor for the Timer class.
    public Timer(int setMillisTime) {
        this.beginningMillisTime = setMillisTime; // Set the initial time for the timer
        this.setMillisTime = setMillisTime; // Initialize the current time remaining on the timer

        Updater.addUpdatableObjects(this); // Add the Timer to the updater
    }

    // Method to update the timer.
    @Override
    public void update() throws IOException {
        setMillisTime -= FPS.getDeltaTime() * 1000; // Decrease the timer by the elapsed time in milliseconds
    }

    // Method to check if the timer is ringing (i.e., time has elapsed).
    public boolean isRinging() {
        if (setMillisTime <= 0) // Check if the remaining time is less than or equal to zero
            return true; // Return true if the timer has elapsed
        return false; // Return false if the timer has not elapsed
    }

    // Method to reset the timer to its initial value.
    public void resetTimer() {
        setMillisTime = beginningMillisTime; // Reset the current time remaining to the initial time
    }

    // Method to get the ID of the timer (not used in this implementation).
    @Override
    public String getID() {
        return null; // Return null as the timer does not have an ID
    }

    // Method to get the renderable representation of the timer (not used in this implementation).
    @Override
    public Renderable getRenderable() {
        return null; // Return null as the timer does not have a renderable representation
    }
}