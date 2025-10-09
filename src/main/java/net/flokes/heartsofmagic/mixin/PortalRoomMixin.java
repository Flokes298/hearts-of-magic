package net.flokes.heartsofmagic.mixin;

import net.flokes.heartsofmagic.block.CustomEndPortalFrameBlock;
import net.flokes.heartsofmagic.block.ModBlocks;
import net.flokes.heartsofmagic.util.PortalFrameSlottable;
import net.minecraft.block.BlockState;
import net.minecraft.structure.StrongholdGenerator;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(StrongholdGenerator.PortalRoom.class)
public abstract class PortalRoomMixin extends StructurePiece {
    protected PortalRoomMixin(StructurePieceType type, int length, BlockBox boundingBox) {
        super(type, length, boundingBox);
    }

    @Inject(at = @At("TAIL"), method = "generate")
    private void replaceEndPortal(
            StructureWorldAccess world,
            StructureAccessor structureAccessor,
            ChunkGenerator chunkGenerator,
            Random random,
            BlockBox chunkBox,
            ChunkPos chunkPos,
            BlockPos pivot,
            CallbackInfo ci
    ) {
        BlockState frameBlockStateNorth = ModBlocks.CUSTOM_END_PORTAL_FRAME.getDefaultState().with(CustomEndPortalFrameBlock.FACING, Direction.NORTH);
        BlockState frameBlockStateSouth = ModBlocks.CUSTOM_END_PORTAL_FRAME.getDefaultState().with(CustomEndPortalFrameBlock.FACING, Direction.SOUTH);
        BlockState frameBlockStateEast = ModBlocks.CUSTOM_END_PORTAL_FRAME.getDefaultState().with(CustomEndPortalFrameBlock.FACING, Direction.EAST);
        BlockState frameBlockStateWest = ModBlocks.CUSTOM_END_PORTAL_FRAME.getDefaultState().with(CustomEndPortalFrameBlock.FACING, Direction.WEST);
        List<PortalFrameSlottable> hearts = new ArrayList<>(Arrays.asList(PortalFrameSlottable.values()));

        // random placement doesnt work, causes duplicates because generate() is called multiple times?
        /*List<PortalFrameSlottable> hearts = new ArrayList<>();
        int r = 0;
        for (int i = 0; i < 12; i++) {
            r = random.nextInt(hearts.size());
            hearts.add(hearts.get(r));
            hearts.remove(r);
        }*/

        this.addBlock(world, frameBlockStateNorth.with(CustomEndPortalFrameBlock.SLOT_TAKES, hearts.get(0)), 4, 3, 8, chunkBox);
        this.addBlock(world, frameBlockStateNorth.with(CustomEndPortalFrameBlock.SLOT_TAKES, hearts.get(1)), 5, 3, 8, chunkBox);
        this.addBlock(world, frameBlockStateNorth.with(CustomEndPortalFrameBlock.SLOT_TAKES, hearts.get(2)), 6, 3, 8, chunkBox);
        this.addBlock(world, frameBlockStateSouth.with(CustomEndPortalFrameBlock.SLOT_TAKES, hearts.get(3)), 4, 3, 12, chunkBox);
        this.addBlock(world, frameBlockStateSouth.with(CustomEndPortalFrameBlock.SLOT_TAKES, hearts.get(4)), 5, 3, 12, chunkBox);
        this.addBlock(world, frameBlockStateSouth.with(CustomEndPortalFrameBlock.SLOT_TAKES, hearts.get(5)), 6, 3, 12, chunkBox);
        this.addBlock(world, frameBlockStateEast.with(CustomEndPortalFrameBlock.SLOT_TAKES, hearts.get(6)), 3, 3, 9, chunkBox);
        this.addBlock(world, frameBlockStateEast.with(CustomEndPortalFrameBlock.SLOT_TAKES, hearts.get(7)), 3, 3, 10, chunkBox);
        this.addBlock(world, frameBlockStateEast.with(CustomEndPortalFrameBlock.SLOT_TAKES, hearts.get(8)), 3, 3, 11, chunkBox);
        this.addBlock(world, frameBlockStateWest.with(CustomEndPortalFrameBlock.SLOT_TAKES, hearts.get(9)), 7, 3, 9, chunkBox);
        this.addBlock(world, frameBlockStateWest.with(CustomEndPortalFrameBlock.SLOT_TAKES, hearts.get(10)), 7, 3, 10, chunkBox);
        this.addBlock(world, frameBlockStateWest.with(CustomEndPortalFrameBlock.SLOT_TAKES, hearts.get(11)), 7, 3, 11, chunkBox);
    }
}
