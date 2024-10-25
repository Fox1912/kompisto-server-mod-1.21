package net.fox.kompistoservermod.item;

import net.fox.kompistoservermod.sound.ModSounds; // Import your sound class
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory; // Import for sound category
import net.minecraft.world.World; // Import for World

import java.util.Random; // Import for random selection

public class BigFuckOffDildoStick extends Item {

    private final Random random = new Random(); // Random instance for sound selection

    // Constructor with item settings
    public BigFuckOffDildoStick(Settings settings) {
        super(settings);
    }

    // Override postHit to add damage effect when hitting an entity
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity) {
            DamageSource damageSource = attacker.getDamageSources().playerAttack((PlayerEntity) attacker);
            target.damage(damageSource, 10.0F);

            World world = attacker.getWorld();
            playRandomHitSound(world, attacker); // Removed world.isClient check
        }
        return super.postHit(stack, target, attacker);
    }

    // Method to play a random hit sound
    private void playRandomHitSound(World world, LivingEntity attacker) {
        int soundIndex = random.nextInt(4); // Randomly select a sound index (0-3)

        // Play the selected sound based on the index
        switch (soundIndex) {
            case 0:
                world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                        ModSounds.BIG_FUCK_OFF_DILDO_STICK_HIT1, SoundCategory.PLAYERS, 2.0F, 1.0F);
                break;
            case 1:
                world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                        ModSounds.BIG_FUCK_OFF_DILDO_STICK_HIT2, SoundCategory.PLAYERS, 2.0F, 1.0F);
                break;
            case 2:
                world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                        ModSounds.BIG_FUCK_OFF_DILDO_STICK_HIT3, SoundCategory.PLAYERS, 2.0F, 1.0F);
                break;
            case 3:
                world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                        ModSounds.BIG_FUCK_OFF_DILDO_STICK_HIT4, SoundCategory.PLAYERS, 2.0F, 1.0F);
                break;
        }
    }
}