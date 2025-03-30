package de.vetrixs.hudOverhaul.client;

import net.fabricmc.api.ClientModInitializer;

public class HudOverhaulClient implements ClientModInitializer {

    CordInHud cordInHud = new CordInHud();

    @Override
    public void onInitializeClient() {
        cordInHud.onInitializeClient();
    }
}
