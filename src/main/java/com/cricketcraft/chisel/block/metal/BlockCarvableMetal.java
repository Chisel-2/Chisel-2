package com.cricketcraft.chisel.block.metal;

import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCarvableMetal extends Block {

	public BlockCarvableMetal(){
		super(Material.iron);
		setCreativeTab(ChiselTabs.tabMetalChiselBlocks);
	}
}
