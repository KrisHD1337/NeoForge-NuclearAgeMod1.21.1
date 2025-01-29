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
                        output.accept(ModBlocks.URANIUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_URANIUM_ORE);
                        output.accept(ModBlocks.NETHER_URANIUM_ORE);
                        output.accept(ModBlocks.END_URANIUM_ORE);
                        output.accept(ModItems.RAW_URANIUM);
                        output.accept(ModBlocks.RAW_URANIUM_BLOCK);
                        output.accept(ModItems.URANIUM_INGOT);
                        output.accept(ModBlocks.URANIUM_BLOCK);
                        output.accept(ModItems.PLUTONIUM_INGOT);
                        output.accept(ModBlocks.PLUTONIUM_BLOCK);
                        output.accept(ModBlocks.ZIRCONIUM_ORE);
                        output.accept(ModItems.RAW_ZIRCONIUM);
                        output.accept(ModBlocks.RAW_ZIRCONIUM_BLOCK);
                        output.accept(ModItems.ZIRCONIUM_INGOT);
                        output.accept(ModBlocks.ZIRCONIUM_BLOCK);
                        output.accept(ModItems.CLADDING);
                        output.accept(ModBlocks.CADMIUM_ORE);
                        output.accept(ModItems.RAW_CADMIUM);
                        output.accept(ModItems.CADMIUM);
                        output.accept(ModBlocks.SILVER_ORE);
                        output.accept(ModItems.RAW_SILVER);
                        output.accept(ModBlocks.RAW_SILVER_BLOCK);
                        output.accept(ModItems.SILVER_INGOT);
                        output.accept(ModBlocks.SILVER_BLOCK);
                        output.accept(ModBlocks.INDIUM_ORE);
                        output.accept(ModItems.INDIUM_DUST);
                        output.accept(ModBlocks.INDIUM_BLOCK);
                        output.accept(ModItems.NUCLEAR_WASTE);
                        output.accept(ModBlocks.NUCLEAR_WASTE_BLOCK);
                        output.accept(ModItems.GRAPHITE);
                        output.accept(ModBlocks.GRAPHITE_BLOCK);
                        output.accept(ModItems.STEEL_INGOT);
                        output.accept(ModBlocks.STEEL_BLOCK);
                        output.accept(ModItems.SILVER_INDIUM_CADMIUM_ALLOY_INGOT);
                        output.accept(ModBlocks.SILVER_INDIUM_CADMIUM_ALLOY_BLOCK);
                        output.accept(ModItems.CONTORL_ROD);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
