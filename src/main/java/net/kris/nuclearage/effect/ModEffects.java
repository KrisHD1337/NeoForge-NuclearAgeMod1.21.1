package net.kris.nuclearage.effect;
import net.kris.nuclearage.NuclearAge;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, NuclearAge.MODID);
    public static final Holder<MobEffect> RADIATION_EFFECT = MOB_EFFECTS.register("radiation",
            () -> new RadiationEffect(MobEffectCategory.HARMFUL, 0x9BBA8C));
    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}