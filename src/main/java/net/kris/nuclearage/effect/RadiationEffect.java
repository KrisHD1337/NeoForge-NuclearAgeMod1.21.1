package net.kris.nuclearage.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.NeoForgeMod;

public class RadiationEffect extends MobEffect {
    protected RadiationEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Registry<DamageType> dTypeReg = livingEntity.damageSources().damageTypes;
            Holder.Reference<DamageType> dType = (Holder.Reference)dTypeReg.getHolder(NeoForgeMod.POISON_DAMAGE).orElse(dTypeReg.getHolderOrThrow(DamageTypes.GENERIC));
            livingEntity.hurt(new DamageSource(dType), 1.0F);
        if (livingEntity instanceof Player player) {
            player.causeFoodExhaustion(0.005F * (float)(amplifier + 1));
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
