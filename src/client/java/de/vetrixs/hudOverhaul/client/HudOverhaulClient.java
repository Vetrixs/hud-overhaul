package de.vetrixs.hudOverhaul.client;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class HudOverhaulClient implements ClientModInitializer {

    CordInHud cordInHud = new CordInHud();

    @Override
    public void onInitializeClient() {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);

        cordInHud.onInitializeClient();
    }
}
