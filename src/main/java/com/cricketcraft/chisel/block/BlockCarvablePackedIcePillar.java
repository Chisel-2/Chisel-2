package com.cricketcraft.chisel.block;

import net.minecraft.block.material.Material;

public class BlockCarvablePackedIcePillar extends BlockCarvablePillar {

	public BlockCarvablePackedIcePillar(Material m, int i) {
		super(m, i);
		this.slipperiness = 0.98F;
	}
}
