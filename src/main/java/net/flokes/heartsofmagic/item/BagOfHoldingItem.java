package net.flokes.heartsofmagic.item;

import net.flokes.heartsofmagic.screen.BagOfHoldingScreenHandler;
import net.flokes.heartsofmagic.util.BagOfHoldingInventory;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BagOfHoldingItem extends Item {
    private static final Text CONTAINER_NAME = Text.translatable("container.bag_of_holding");


    public BagOfHoldingItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }
        ItemStack bagOfHoldingStack = player.getStackInHand(hand);
        BagOfHoldingInventory bagOfHoldingInventory = new BagOfHoldingInventory(27, bagOfHoldingStack, player);
        ContainerComponent bagOfHoldingContentsComponent = bagOfHoldingStack.getComponents().get(DataComponentTypes.CONTAINER);
        if (bagOfHoldingContentsComponent != null) {
            bagOfHoldingContentsComponent.copyTo(bagOfHoldingInventory.heldStacks);
            player.openHandledScreen(
                    // TODO Custom Screen Handler
                    new SimpleNamedScreenHandlerFactory(
                            (syncId, playerInventory, playerx) -> new BagOfHoldingScreenHandler(syncId, playerInventory, bagOfHoldingInventory), CONTAINER_NAME
                    )
            );
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }

    }
}
