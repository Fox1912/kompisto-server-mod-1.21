package net.fox.kompistoservermod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fox.kompistoservermod.KompistoServerMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // Register custom items
    public static final Item BIG_FUCK_OFF_DILDO_STICK = registerItem(
            "big_fuck_off_dildo_stick",
            new BigFuckOffDildoStick(new Item.Settings())
    );

    public static final Item PINK_SILICONE_RUBBER = registerItem(
            "pink_silicone_rubber",
            new Item(new Item.Settings()) // Customize Item.Settings as needed
    );

    // Method to handle item registration
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(KompistoServerMod.MOD_ID, name), item);
    }

    // Method to register all mod items and add to an item group
    public static void registerModItems() {
        KompistoServerMod.LOGGER.info("Registering Mod Items for " + KompistoServerMod.MOD_ID);

        // Add items to the combat item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(BIG_FUCK_OFF_DILDO_STICK);
        });

        // Optionally, add pink_silicone_rubber to a different group (e.g., MISC)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_SILICONE_RUBBER);
        });
    }
}