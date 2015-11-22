package com.cricketcraft.chisel.block.wood;

import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCarvableWood extends Block {

	public BlockCarvableWood(){
		super(Material.wood);
		setCreativeTab(ChiselTabs.tabWoodChiselBlocks);
	}
}
