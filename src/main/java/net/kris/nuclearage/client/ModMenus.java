package net.kris.nuclearage.client;
/*
import net.kris.nuclearage.client.gui.RBMKReactorScreen;
import net.kris.nuclearage.client.gui.RBMKReactorMenu;
import net.kris.nuclearage.multiblock.RBMKReactorInventory;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.client.event.RegisterMenuTypesEvent;

public class ModMenus {
    // Register the menu type for RBMK Reactor
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "nuclearage");

    public static final RegistryObject<MenuType<RBMKReactorMenu>> RBMK_REACTOR_MENU = MENUS.register("rbmk_reactor_menu", () -> new MenuType<>(RBMKReactorMenu::new));

    @OnlyIn(Dist.CLIENT)
    public static void registerScreens() {
        // Register the screen for the RBMK Reactor menu
        ScreenManager.register(RBMK_REACTOR_MENU.get(), RBMKReactorScreen::new);
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);  // Register the menu types
    }
}
*/