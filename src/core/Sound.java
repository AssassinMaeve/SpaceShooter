package core;

import java.io.IOException;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// The Sound class is used to play sound effects in the game.
public class Sound {
    // Method to play a sound from a given file path.
    public static void playSound(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Get an audio input stream from the specified file.
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
        
        // Get a sound clip resource.
        Clip clip = AudioSystem.getClip();
        
        // Open the audio clip and load samples from the audio input stream.
        clip.open(audioInputStream);
        
        // Set the clip's position to the beginning.
        clip.setMicrosecondPosition(0);
        
        // Start playing the clip.
        clip.start();
    }
}