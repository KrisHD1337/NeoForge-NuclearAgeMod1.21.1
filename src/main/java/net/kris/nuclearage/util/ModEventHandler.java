package net.kris.nuclearage.util;

import net.kris.nuclearage.item.ModItems;
import net.kris.nuclearage.multiblock.RBMKReactorMultiblock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class ModEventHandler {

    @SubscribeEvent
    public void onBlockPlaced(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos clickedPos = event.getPos();
        Player player = event.getEntity();

        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            if (player.getMainHandItem().getItem() == ModItems.INDIUM_DUST.get()) {
                BlockPos origin = RBMKReactorMultiblock.findOrigin(serverLevel, clickedPos);
                if (origin != null && RBMKReactorMultiblock.validateStructure(serverLevel, origin)) {
                    player.sendSystemMessage(Component.literal("Multiblock successfully activated!"));
                } else {
                    player.sendSystemMessage(Component.literal("Multiblock structure is incomplete or incorrect."));
                }
            }
        }
    }
}
