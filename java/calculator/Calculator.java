package main.entitydistance.calculator;

public class Calculator {

    private static final double DISTANCE_MULTIPLIER = 0.70;
    private static final double BLOCKS_PER_CHUNK = 16.0;

    public static double calculateLimit(int renderDistanceChunks) {
        int safeRenderDistance = Math.max(0, renderDistanceChunks);

        return safeRenderDistance * BLOCKS_PER_CHUNK * DISTANCE_MULTIPLIER;
    }

    public static boolean isBeyondLimit(
            double squaredDistance,
            int renderDistanceChunks
    ) {
        double limit = calculateLimit(renderDistanceChunks);

        return squaredDistance > limit * limit;
    }
}