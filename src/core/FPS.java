package core;

import java.time.Duration;
import java.time.Instant;

public class FPS {
        private FPS() {}

        private static Duration fpsDeltaTime = Duration.ZERO;  // The time between frames
        private static Duration lastTime = Duration.ZERO;       // The time of the last frame
        private static Instant beginTime = Instant.now();      // The time of the current frame
        private static double deltaTime = fpsDeltaTime.toMillis() - lastTime.toMillis();        // The time between frames in milliseconds

        public static void calcBeginTime() {
            beginTime = Instant.now();      // Set the time of the current frame
            fpsDeltaTime = Duration.ZERO; // Reset the time between frames
        }

        public static void calcDeltaTime() {
            fpsDeltaTime = Duration.between(beginTime, Instant.now()); // Calculate the time between frames
            deltaTime = (double)fpsDeltaTime.toMillis() - lastTime.toMillis(); // Calculate the time between frames in milliseconds
            lastTime = fpsDeltaTime; // Set the time of the last frame
        }

        public static double getDeltaTime() {
            return deltaTime / 1000; // Return the time between frames in seconds
        }
}
