package net.fox.kompistoservermod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fox.kompistoservermod.KompistoServerMod;
import net.fox.kompistoservermod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup KOMPISTO_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(KompistoServerMod.MOD_ID, "kompisto_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.BIG_FUCK_OFF_DILDO))
                    .displayName(Text.translatable("itemgroup.kompisto-server-mod.kompisto_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_SILICONE_RUBBER);
                        entries.add(ModBlocks.BIG_FUCK_OFF_DILDO);
                        entries.add(ModItems.BIG_FUCK_OFF_DILDO_STICK);
                        entries.add(ModBlocks.WALL_TRIMMING_BAMBOO);
                        entries.add(ModBlocks.WALL_TRIMMING_WOOD);
                        entries.add(ModBlocks.TABLE_WOODEN);
                        entries.add(ModBlocks.TABLE_STONE);
                        entries.add(ModBlocks.CHAIR_WOODEN);
                        entries.add(ModBlocks.CHAIR_STONE);
                    }).build());



    public static void registerItemGroups() {
        KompistoServerMod.LOGGER.info("Registering Item Groups for " + KompistoServerMod.MOD_ID);
    }
}