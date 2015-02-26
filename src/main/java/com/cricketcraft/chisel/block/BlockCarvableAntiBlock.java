package com.cricketcraft.chisel.block;

import net.minecraft.block.material.Material;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.api.ICarvable;
import com.cricketcraft.chisel.carving.CarvableHelper;
import com.cricketcraft.chisel.config.Configurations;
import com.cricketcraft.chisel.init.ChiselTabs;

public class BlockCarvableAntiBlock extends BlockCarvableColor implements ICarvable {

	public CarvableHelper carverHelper;

	public BlockCarvableAntiBlock(int i) {
		super(Material.rock, i);
		carverHelper = new CarvableHelper();
	}

	@Override
	public int getRenderType() {
		return Chisel.renderCTMNoLightId;
	}

	/*
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	*/
}
