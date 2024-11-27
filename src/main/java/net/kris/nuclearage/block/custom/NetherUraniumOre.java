package net.kris.nuclearage.block.custom;

import net.kris.nuclearage.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class NetherUraniumOre extends Block {

    private static final double RADIUS = 5.0; // Effect radius in blocks
    private static final int RADIATION_DURATION = 600; // 30 seconds (in ticks)
    private static final int SCHEDULE_INTERVAL = 20; // 1 second (in ticks)

    public NetherUraniumOre(Properties properties) {
        super(properties.randomTicks());
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);

        if (!level.isClientSide) {
            level.scheduleTick(pos, this, SCHEDULE_INTERVAL);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);

        // Apply poison effect to nearby players
        applyPoisonEffect(level, pos);

        // Reschedule the tick
        level.scheduleTick(pos, this, SCHEDULE_INTERVAL);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);

        // Optionally apply poison on random ticks
        applyPoisonEffect(level, pos);
    }

    private void applyPoisonEffect(ServerLevel level, BlockPos pos) {
        // Create an axis-aligned bounding box around the block to find nearby players
        AABB effectArea = new AABB(pos).inflate(RADIUS);

        for (Player player : level.getEntitiesOfClass(Player.class, effectArea)) {
            if (player.isCreative() || player.isSpectator()) {
                continue; // Ignore creative and spectator players
            }

            // Calculate the squared distance from the player to the block's center
            double distanceSqr = player.position().distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
            int radiationLevel = calculatePoisonLevel(distanceSqr);

            if (radiationLevel > 0) {
                // Apply or refresh the radiation effect
                player.addEffect(new MobEffectInstance(ModEffects.RADIATION_EFFECT, RADIATION_DURATION, radiationLevel - 1, true, true));
            }
        }
    }

    private int calculatePoisonLevel(double distanceSqr) {
        // Check distances using squared values for better performance
        if (distanceSqr < 25) {             // Within 20 blocks (20^2 = 400)
            if (distanceSqr < 4) {           // Strong radiation within 5 blocks (5^2 = 25)
                return 2;
            }                      // Weak radiation between 10–20 blocks
                return 1;
        }
        return 0; // No effect beyond 20 blocks
    }
}
