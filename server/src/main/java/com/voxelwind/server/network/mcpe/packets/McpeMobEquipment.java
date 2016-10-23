package com.voxelwind.server.network.mcpe.packets;

import com.voxelwind.api.game.item.ItemStack;
import com.voxelwind.nbt.util.Varints;
import com.voxelwind.server.network.mcpe.McpeUtil;
import com.voxelwind.server.network.NetworkPackage;
import io.netty.buffer.ByteBuf;
import lombok.Data;

@Data
public class McpeMobEquipment implements NetworkPackage {
    private long entityId;
    private ItemStack stack;
    private byte inventorySlot;
    private byte hotbarSlot;

    @Override
    public void decode(ByteBuf buffer) {
        entityId = Varints.decodeSignedLong(buffer);
        stack = McpeUtil.readItemStack(buffer);
        inventorySlot = buffer.readByte();
        hotbarSlot = buffer.readByte();
    }

    @Override
    public void encode(ByteBuf buffer) {
        Varints.encodeSignedLong(buffer, entityId);
        McpeUtil.writeItemStack(buffer, stack);
        buffer.writeInt(inventorySlot);
        buffer.writeInt(hotbarSlot);
    }
}
