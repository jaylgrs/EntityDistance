package manager;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.vehicle.VehicleEntity;

public class ExclusionManager {

    public static boolean isExcluded(Entity entity) {
        return entity instanceof PlayerEntity
                || entity instanceof ProjectileEntity
                || entity instanceof ItemEntity
                || entity instanceof ExperienceOrbEntity
                || entity instanceof VehicleEntity;
    }
}