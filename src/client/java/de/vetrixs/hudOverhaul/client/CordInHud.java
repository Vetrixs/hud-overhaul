package de.vetrixs.hudOverhaul.client;

import de.vetrixs.hudOverhaul.HudOverhaul;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;

import java.awt.*;

public class CordInHud implements ClientModInitializer {

    private static final Identifier MAIN_LAYER = Identifier.of(HudOverhaul.MOD_ID, "cord-in-hud");

    @Override
    public void onInitializeClient() {
        // Attach our rendering code to before the chat hud layer. Our layer will render right before the chat. The API will take care of z spacing and automatically add 200 after every layer.
        HudLayerRegistrationCallback.EVENT.register(layeredDrawer -> layeredDrawer.attachLayerBefore(IdentifiedLayer.CHAT, MAIN_LAYER, CordInHud::render));
    }

    private static void render(DrawContext context, RenderTickCounter tickCounter) {
        int color = Color.white.getRGB(); // WHITE
        MinecraftClient client = MinecraftClient.getInstance();
        // when for what ever reason player is null, just don't render it
        if (client.player == null) {
            return;
        }
        double lastX = client.player.lastX;
        double lastY = client.player.lastY;
        double lastZ = client.player.lastZ;

        String text = "X: %.3f, Y: %.3f, Z: %.3f".formatted(lastX, lastY, lastZ);

        ModConfig modConfig = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        if (client.getDebugHud().shouldShowDebugHud()) {
            context.drawText(client.textRenderer, "", modConfig.cordsLocationX, modConfig.cordsLocationY, color, false);
        } else {
            context.drawText(client.textRenderer, text, modConfig.cordsLocationX, modConfig.cordsLocationY, color, true);
        }
    }
}