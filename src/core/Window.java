package core;

public class Window extends javax.swing.JFrame {
    private static double winWidth = 500; // Set the default width of the window
    private static double winHeight = 600; // Set the default height of the window

    private static String winName; // Variable to store the title of the window

    // Constructor for the Window class.
    public Window(String winName, double winWidth, double winHeight) {
        super(winName); // Set the title of the window

        Window.winName = winName; // Set the title of the window
        Window.winWidth = winWidth; // Set the width of the window
        Window.winHeight = winHeight; // Set the height of the window

        setWindowAttribute(); // Set the window attributes
    }

    // Method to pack the window and set its attributes.
    public void packWindow() {
        pack(); // Pack the components within the window
        setResizable(false); // Set the window to be non-resizable
        setLocationRelativeTo(null); // Center the window on the screen
    }

    // Method to set the window attributes.
    private void setWindowAttribute() {
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE); // Set the default close operation to exit the application
    }

    // Method to get the width of the window.
    public static double getWinWidth() {
        return winWidth; // Return the width of the window
    }

    // Method to get the height of the window.
    public static double getWinHeight() {
        return winHeight; // Return the height of the window
    }

    // Method to get the title of the window.
    public static String getWinName() {
        return winName; // Return the title of the window
    }
}