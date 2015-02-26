package com.cricketcraft.chisel.block;

import com.cricketcraft.chisel.config.Configurations;
import com.cricketcraft.chisel.init.ChiselTabs;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockCarvableColor extends BlockCarvable {

    public BlockCarvableColor(int i) {
        this(Material.rock, i);
    }

    public BlockCarvableColor(Material m, int i) {
        super(m, i);
    }

    @Override
    public boolean recolourBlock(World world, int x, int y, int z, ForgeDirection side, int color) {
        int newColor = 15 - color;
        if (world.getBlockMetadata(x, y, z) != newColor) {
            world.setBlockMetadataWithNotify(x, y, z, newColor, 3);
            return true;
        }
        return false;
    }
}
