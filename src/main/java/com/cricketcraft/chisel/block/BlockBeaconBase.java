package com.cricketcraft.chisel.block;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

/**
 * Created by Pokefenn
 */
public class BlockBeaconBase extends BlockCarvable {

	public BlockBeaconBase(int i) {
		super(i);
	}

	public BlockBeaconBase(Material mat, int i) {
		super(mat, i);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return true;
	}
}
