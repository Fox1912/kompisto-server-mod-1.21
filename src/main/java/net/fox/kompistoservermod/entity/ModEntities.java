package net.fox.kompistoservermod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fox.kompistoservermod.KompistoServerMod;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.fox.kompistoservermod.KompistoServerMod.MOD_ID;

public class ModEntities {
    public static final EntityType<ChairEntity> CHAIR_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.tryParse(MOD_ID + ":chair_entity"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ChairEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());

    public static void registerEntities() {
        KompistoServerMod.LOGGER("Registering Entities for " + MOD_ID);
    }
}