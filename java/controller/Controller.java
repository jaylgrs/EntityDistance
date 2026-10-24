package main.entitydistance.controller;

import main.entitydistance.calculator.Calculator;
import main.entitydistance.manager.ExclusionManager;
import net.minecraft.entity.Entity;

public class Controller {

    public static boolean shouldCull(
            Entity entity,
            double squaredDistance,
            int renderDistanceChunks
    ) {
        if (ExclusionManager.isExcluded(entity)) {
            return false;
        }

        return Calculator.isBeyondLimit(
                squaredDistance,
                renderDistanceChunks
        );
    }
}