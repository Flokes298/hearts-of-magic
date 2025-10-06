package net.flokes.heartsofmagic.component;

import net.flokes.heartsofmagic.HeartsOfMagic;
import net.flokes.heartsofmagic.util.PortalFrameSlottable;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModComponents {
    public static final ComponentType<PortalFrameSlottable> PORTAL_FRAME_SLOTTABLE_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(HeartsOfMagic.MOD_ID, "portal_frame_slottable_component"),
            ComponentType.<PortalFrameSlottable>builder().codec(PortalFrameSlottable.CODEC).build()
    );

    public static void initialize() {
        HeartsOfMagic.LOGGER.info("Registering components...");
    }
}
