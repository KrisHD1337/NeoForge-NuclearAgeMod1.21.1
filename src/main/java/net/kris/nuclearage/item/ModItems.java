package net.kris.nuclearage.item;

import net.kris.nuclearage.NuclearAge;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NuclearAge.MODID);

    public static final DeferredItem<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PLUTONIUM_INGOT = ITEMS.register("plutonium_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_URANIUM = ITEMS.register("raw_uranium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_CADMIUM = ITEMS.register("raw_cadmium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_ZIRCONIUM = ITEMS.register("raw_zirconium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CADMIUM = ITEMS.register("cadmium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INDIUM_DUST = ITEMS.register("indium_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NUCLEAR_WASTE = ITEMS.register("nuclear_waste",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GRAPHITE = ITEMS.register("graphite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLACK_DIAMOND = ITEMS.register("black_diamond",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BORIC_ACID = ITEMS.register("boric_acid",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BORAX = ITEMS.register("borax",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
