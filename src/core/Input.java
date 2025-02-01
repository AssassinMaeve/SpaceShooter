package core;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    public static final int SPACE = 4;

    public static boolean[] keys = new boolean[5];

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {                // This method is called when a key is pressed
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[LEFT] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {       // If the key is the right arrow key
            keys[RIGHT] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {          // If the key is the up arrow key
            keys[UP] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {        // If the key is the down arrow key
            keys[DOWN] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {          // If the key is the space bar
            keys[SPACE] = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {               // This method is called when a key is released
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {            // If the key is the left arrow key
            keys[LEFT] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {       // If the key is the right arrow key
            keys[RIGHT] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {       // If the key is the up arrow key
            keys[UP] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {    // If the key is the down arrow key
            keys[DOWN] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {    // If the key is the space bar
            keys[SPACE] = false;
        }
        
    }

}
