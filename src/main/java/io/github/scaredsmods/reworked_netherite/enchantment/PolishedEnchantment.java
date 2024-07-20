package io.github.scaredsmods.reworked_netherite.enchantment;


import io.github.scaredsmods.reworked_netherite.item.custom.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class PolishedEnchantment extends Enchantment {

    public static final int ALL = 0;
    public static final int UNDEAD = 1;
    public static final int ARTHROPODS = 2;
    private static final String[] NAMES = new String[]{"all", "undead", "arthropods"};
    private static final int[] MIN_COST = new int[]{1, 5, 5};
    private static final int[] LEVEL_COST = new int[]{11, 8, 8};
    private static final int[] LEVEL_COST_SPAN = new int[]{20, 20, 20};
    private final int type;






    public PolishedEnchantment(Enchantment.Rarity rarity, int type, EquipmentSlot ... applicableSlots) {
        super(rarity, EnchantmentCategory.WEAPON, applicableSlots);
        this.type = type;

    }

    @Override
    public int getMinCost(int level) {
        return MIN_COST[this.type] + (level - 1) * LEVEL_COST[this.type];
    }

    @Override
    public int getMaxCost(int level) {
        return this.getMinCost(level) + LEVEL_COST_SPAN[this.type];
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public float getDamageBonus(int level, MobType type) {
        if (this.type == 0) {
            return 1.0f + (float)Math.max(0, level - 1) * 0.5f;
        }
        if (this.type == 1 && type == MobType.UNDEAD) {
            return (float)level * 2.5f;
        }
        if (this.type == 2 && type == MobType.ARTHROPOD) {
            return (float)level * 2.5f;
        }
        return 0.0f;
    }

    @Override
    public boolean checkCompatibility(Enchantment other) {



        return !(other instanceof PolishedEnchantment) && !(other instanceof DamageEnchantment);



    }


    @Override
    public boolean canEnchant(ItemStack stack) {
        if (stack.getItem() instanceof AxeItem) {
            return true;
        }


        return stack.getItem() instanceof HammerItem;
    }

    @Override
    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
        if (target instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)target;
            if (this.type == 2 && level > 0 && livingEntity.getMobType() == MobType.ARTHROPOD) {
                int i = 20 + attacker.getRandom().nextInt(10 * level);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, i, 3));
            }
        }
        if(!attacker.level().isClientSide()) {
            ServerLevel world = ((ServerLevel) attacker.level());
            BlockPos position = target.blockPosition();

            if(level == 1) {
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
            }

            if(level == 2) {
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
            }

            if (level == 3) {
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
            }
            if (level == 4) {
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
            }
            if (level == 5) {
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
                EntityType.LIGHTNING_BOLT.spawn(world, position, MobSpawnType.TRIGGERED).setSecondsOnFire(0);
            }


        }

    }

}



