package net.kris.nuclearage.effect;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.common.NeoForgeMod;
public class RadiationEffect extends MobEffect {
    protected RadiationEffect(MobEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
            livingEntity.hurt(livingEntity.damageSources().outOfBorder(), 1f * (amplifier + 1));
        return true;
    }
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}