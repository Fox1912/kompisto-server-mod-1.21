package net.fox.kompistoservermod.sound;

import net.fox.kompistoservermod.KompistoServerMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent BIG_FUCK_OFF_DILDO_STICK_HIT1 = registerSoundEvent("big_fuck_off_dildo_stick_hit1");
    public static final SoundEvent BIG_FUCK_OFF_DILDO_STICK_HIT2 = registerSoundEvent("big_fuck_off_dildo_stick_hit2");
    public static final SoundEvent BIG_FUCK_OFF_DILDO_STICK_HIT3 = registerSoundEvent("big_fuck_off_dildo_stick_hit3");
    public static final SoundEvent BIG_FUCK_OFF_DILDO_STICK_HIT4 = registerSoundEvent("big_fuck_off_dildo_stick_hit4");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(KompistoServerMod.MOD_ID, name);  // Using Identifier.of instead
        SoundEvent soundEvent = SoundEvent.of(id);
        return Registry.register(Registries.SOUND_EVENT, id, soundEvent);
    }

    public static void registerSounds() {
        KompistoServerMod.LOGGER.info("Registering Sounds for " + KompistoServerMod.MOD_ID);
    }
}