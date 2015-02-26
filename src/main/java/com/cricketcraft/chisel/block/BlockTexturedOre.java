package com.cricketcraft.chisel.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.cricketcraft.chisel.client.render.BlockTexturedOreRenderer;
import com.cricketcraft.chisel.config.Configurations;
import com.cricketcraft.chisel.init.ChiselTabs;

public class BlockTexturedOre extends Block {

	public int currentPass;
	public Block base;
	public IIcon icon;
	String iconFile;

	public BlockTexturedOre(Material mat, Block base, int i) {
		super(mat);
		if(Configurations.tabMod == true && i == 2) {
			setCreativeTab(ChiselTabs.tabModdedChiselBlocks);
		} else if((Configurations.tabBlocks == true && i == 1) || Configurations.tabMod == false) {
			setCreativeTab(ChiselTabs.tabChiselBlocks);
		} else {
			setCreativeTab(ChiselTabs.tabChisel);		
		}

		this.base = base;
	}

	public BlockTexturedOre(Material mat, String iconFile, int i) {
		super(mat);

		this.iconFile = iconFile;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return BlockTexturedOreRenderer.id;
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public boolean canRenderInPass(int pass) {
		currentPass = pass;

		return pass == 1 || pass == 0;
	}

	@Override
	public void registerBlockIcons(IIconRegister register) {
		if (iconFile != null)
			icon = register.registerIcon(iconFile);
	}

}
