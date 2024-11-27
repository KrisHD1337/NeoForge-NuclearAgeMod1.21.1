package net.kris.nuclearage.item;

import net.kris.nuclearage.NuclearAge;
import net.kris.nuclearage.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NuclearAge.MODID);

    public static final Supplier<CreativeModeTab> NUCLEAR_AGE_TAB = CREATIVE_MODE_TAB.register("nuclear_age_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.URANIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.nuclearage.nuclear_age"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_URANIUM);
                        output.accept(ModItems.URANIUM_INGOT);
                        output.accept(ModBlocks.URANIUM_BLOCK);
                        output.accept(ModItems.PLUTONIUM_INGOT);
                        output.accept(ModBlocks.PLUTONIUM_BLOCK);
                        output.accept(ModBlocks.END_URANIUM_ORE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
