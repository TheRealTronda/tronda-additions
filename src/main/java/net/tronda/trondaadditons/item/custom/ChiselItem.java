package net.tronda.trondaadditons.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.tronda.trondaadditons.block.ModBlocks;
import net.tronda.trondaadditons.component.ModDataComponentTypes;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP = Map.of(
            Blocks.STONE, Blocks.STONE_BRICKS,
            Blocks.END_STONE, Blocks.END_STONE_BRICKS,
            Blocks.IRON_ORE, ModBlocks.TIN_ORE_BLOCK
    );

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.tronda-additions.tin_chisel.shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.tronda-additions.expand"));
        }

        if (stack.get(ModDataComponentTypes.COORDINATES) != null) {
            tooltip.add(Text.literal("Last changed at " + stack.get(ModDataComponentTypes.COORDINATES)));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }

    public ChiselItem(Settings settings) {
        super(settings);
    }
}
