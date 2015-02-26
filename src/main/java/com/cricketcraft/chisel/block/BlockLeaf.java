package com.cricketcraft.chisel.block;

import net.minecraft.block.material.Material;

public class BlockLeaf extends BlockCarvable {

	public BlockLeaf(Material material, int i) {
		super(material, i);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}
