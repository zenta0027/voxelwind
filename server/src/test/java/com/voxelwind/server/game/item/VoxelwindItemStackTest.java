package com.voxelwind.server.game.item;

import com.voxelwind.api.game.level.block.BlockTypes;
import com.voxelwind.api.game.item.ItemStack;

import org.junit.Test;

import static org.junit.Assert.*;

public class VoxelwindItemStackTest {
    @Test
    public void isSimiliarToIsEqual() throws Exception {
        VoxelwindItemStack stack1 = new VoxelwindItemStack(BlockTypes.DIRT, 1, null);
        VoxelwindItemStack stack2 = new VoxelwindItemStack(BlockTypes.DIRT, 1, null);

        assertEquals("Items with identical data are not equal", stack1, stack2);
        assertTrue("Items with identical data are not similar", stack1.isSimiliarTo(stack2));
    }

    @Test
    public void isSimiliarToSkipAmount() throws Exception {
        VoxelwindItemStack stack1 = new VoxelwindItemStack(BlockTypes.DIRT, 1, null);
        VoxelwindItemStack stack2 = new VoxelwindItemStack(BlockTypes.DIRT, 42, null);

        assertNotEquals("Items with differing amounts are equal", stack1, stack2);
        assertTrue("Items with differing amounts but same other data are not similar", stack1.isSimiliarTo(stack2));
    }

    @Test
    public void isSimiliarToIsReallyEqual() throws Exception {
        VoxelwindItemStack stack1 = new VoxelwindItemStack(BlockTypes.DIRT, 1, null);

        assertEquals("Items with fuck", stack1, stack1);
        assertTrue("Items with fuck fuck", stack1.isSimiliarTo(stack1));
    }

    @Test
    public void isSimiliarNotSameBlockType() throws Exception {
        VoxelwindItemStack stack1 = new VoxelwindItemStack(BlockTypes.DIRT, 1, null);
        VoxelwindItemStack stack2 = new VoxelwindItemStack(BlockTypes.AIR, 1, null);

        assertNotEquals("Items with fuck", stack1, stack2);
        assertFalse("Items with fuck fuck", stack1.isSimiliarTo(stack2));
    }
}