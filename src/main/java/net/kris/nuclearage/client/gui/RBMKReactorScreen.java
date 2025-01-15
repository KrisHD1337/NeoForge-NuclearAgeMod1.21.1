
package net.kris.nuclearage.client.gui;
/*
import net.kris.nuclearage.NuclearAge;
import net.kris.nuclearage.client.gui.RBMKReactorMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class RBMKReactorScreen extends AbstractContainerScreen<RBMKReactorMenu> {

    private static final String TEXTURE = "textures/gui/rbmkreactor.png"; // Your texture path


    public RBMKReactorScreen(RBMKReactorMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.titleLabelX = 10;
        this.inventoryLabelX = 10;
    }

    @Override
    protected void containerTick() {
        super.containerTick();

        // Tick things here
    }


    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics, mouseX, mouseY, partialTick);
        super.render(graphics, mouseX, mouseY, partialTick);

        /*
         * This method is added by the container screen to render
         * the tooltip of the hovered slot.
         *
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    private static final ResourceLocation BACKGROUND_LOCATION = ResourceLocation.fromNamespaceAndPath(NuclearAge.MODID, "textures/gui/container/my_container_screen.png");

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        /*
         * Renders the background texture to the screen. 'leftPos' and
         * 'topPos' should already represent the top left corner of where
         * the texture should be rendered as it was precomputed from the
         * 'imageWidth' and 'imageHeight'. The two zeros represent the
         * integer u/v coordinates inside the PNG file, whose size is
         * represented by the last two integers (typically 256 x 256).

        graphics.blit(
                RenderType::guiTextured,
        BACKGROUND_LOCATION,
        this.leftPos, this.topPos,
        0, 0,
        this.imageWidth, this.imageHeight,
        256, 256
        );

    }

    @Override
    protected void renderLabels(int mouseX, int mouseY) {
        // Render the title and player inventory label
        this.font.draw(this.title, 8, 6);
        this.font.draw(this.playerInventoryTitle, 8, this.imageHeight - 94);
    }
}
*/