package mixin;

import controller.Controller;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderManager.class)
public class RenderMixin {

    @Inject(
            method = "shouldRender(Lnet/minecraft/entity/Entity;Lnet/minecraft/client/render/Frustum;DDD)Z",
            at = @At("HEAD"),
            cancellable = true
    )
    private <E extends Entity> void onShouldRender(
            E entity,
            Frustum frustum,
            double x,
            double y,
            double z,
            CallbackInfoReturnable<Boolean> cir
    ) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.world == null || client.options == null) {
            return;
        }

        int renderDistance = client.options.getViewDistance().getValue();

        double squaredDistance = entity.squaredDistanceTo(x, y, z);

        if (Controller.shouldCull(
                entity,
                squaredDistance,
                renderDistance
        )) {
            cir.setReturnValue(false);
        }
    }
}