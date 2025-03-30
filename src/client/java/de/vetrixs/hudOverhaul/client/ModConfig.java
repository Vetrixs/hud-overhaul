package de.vetrixs.hudOverhaul.client;

import de.vetrixs.hudOverhaul.HudOverhaul;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = HudOverhaul.MOD_ID)
public class ModConfig implements ConfigData {
    int cordsLocationX;
    int cordsLocationY;
}
