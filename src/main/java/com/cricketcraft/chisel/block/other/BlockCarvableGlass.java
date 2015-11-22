package com.cricketcraft.chisel.block.other;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;

import java.util.Random;

public class BlockCarvableGlass extends BlockGlass{
    public BlockCarvableGlass() {
        super(Material.glass, true);
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }
}
