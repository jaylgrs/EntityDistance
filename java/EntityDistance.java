package main.entitydistance;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityDistance implements ModInitializer {

    public static final String MOD_ID = "entitydistance";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("EntityDistance initialized.");
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}