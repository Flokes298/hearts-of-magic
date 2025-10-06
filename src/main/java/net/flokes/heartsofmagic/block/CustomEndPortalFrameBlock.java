package net.flokes.heartsofmagic.block;

import com.google.common.base.Predicates;
import net.flokes.heartsofmagic.component.ModComponents;
import net.flokes.heartsofmagic.util.PortalFrameSlottable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

public class CustomEndPortalFrameBlock extends EndPortalFrameBlock {
    public static final EnumProperty<PortalFrameSlottable> SLOT_TAKES = EnumProperty.of("slot_takes", PortalFrameSlottable.class);
    private static BlockPattern CUSTOM_COMPLETED_FRAME;


    public CustomEndPortalFrameBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(SLOT_TAKES, PortalFrameSlottable.HEART_OF_THE_SEA));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(EYE);
        builder.add(SLOT_TAKES);
    }

    public static BlockPattern getCustomCompletedFramePattern() {
        if (CUSTOM_COMPLETED_FRAME == null) {
            CUSTOM_COMPLETED_FRAME = BlockPatternBuilder.start()
                    .aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?")
                    .where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY))
                    .where(
                            '^',
                            CachedBlockPosition.matchesBlockState(
                                    BlockStatePredicate.forBlock(ModBlocks.CUSTOM_END_PORTAL_FRAME).with(EYE, Predicates.equalTo(true)).with(FACING, Predicates.equalTo(Direction.SOUTH))
                            )
                    )
                    .where(
                            '>',
                            CachedBlockPosition.matchesBlockState(
                                    BlockStatePredicate.forBlock(ModBlocks.CUSTOM_END_PORTAL_FRAME).with(EYE, Predicates.equalTo(true)).with(FACING, Predicates.equalTo(Direction.WEST))
                            )
                    )
                    .where(
                            'v',
                            CachedBlockPosition.matchesBlockState(
                                    BlockStatePredicate.forBlock(ModBlocks.CUSTOM_END_PORTAL_FRAME).with(EYE, Predicates.equalTo(true)).with(FACING, Predicates.equalTo(Direction.NORTH))
                            )
                    )
                    .where(
                            '<',
                            CachedBlockPosition.matchesBlockState(
                                    BlockStatePredicate.forBlock(ModBlocks.CUSTOM_END_PORTAL_FRAME).with(EYE, Predicates.equalTo(true)).with(FACING, Predicates.equalTo(Direction.EAST))
                            )
                    )
                    .build();
        }

        return CUSTOM_COMPLETED_FRAME;
    }

    @Override
    public ActionResult onUseWithItem(ItemStack stack, BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!blockState.isOf(ModBlocks.CUSTOM_END_PORTAL_FRAME)
                || blockState.get(CustomEndPortalFrameBlock.EYE)
                // Check if Item's SLOTTABLE Component matches CustomPortalFrameBlock's SLOT_TAKES Property
                || blockState.get(CustomEndPortalFrameBlock.SLOT_TAKES) != stack.get(ModComponents.PORTAL_FRAME_SLOTTABLE_COMPONENT)) {
            return ActionResult.PASS;
        } else if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            BlockState blockState2 = blockState.with(CustomEndPortalFrameBlock.EYE, true);
            Block.pushEntitiesUpBeforeBlockChange(blockState, blockState2, world, blockPos);
            world.setBlockState(blockPos, blockState2, Block.NOTIFY_LISTENERS);
            world.updateComparators(blockPos, ModBlocks.CUSTOM_END_PORTAL_FRAME);
            stack.decrement(1);
            world.syncWorldEvent(WorldEvents.END_PORTAL_FRAME_FILLED, blockPos, 0);
            BlockPattern.Result result = CustomEndPortalFrameBlock.getCustomCompletedFramePattern().searchAround(world, blockPos);
            if (result != null) {
                BlockPos blockPos2 = result.getFrontTopLeft().add(-3, 0, -3);

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        BlockPos blockPos3 = blockPos2.add(i, 0, j);
                        world.breakBlock(blockPos3, true, null);
                        world.setBlockState(blockPos3, Blocks.END_PORTAL.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                }

                world.syncGlobalEvent(WorldEvents.END_PORTAL_OPENED, blockPos2.add(1, 0, 1), 0);
            }

            return ActionResult.SUCCESS;
        }
    }
}
