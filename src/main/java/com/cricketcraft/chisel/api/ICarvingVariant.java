package com.cricketcraft.chisel.api;

import net.minecraft.block.Block;

public interface ICarvingVariant {

    Block getBlock();

    int getBlockMeta();
    int getOrder();
}
