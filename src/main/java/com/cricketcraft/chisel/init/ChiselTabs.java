package com.cricketcraft.chisel.init;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.cricketcraft.chisel.Features;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChiselTabs {

	private static class CustomCreativeTab extends CreativeTabs {
		
		private boolean search;

		private ItemStack stack;		

		public CustomCreativeTab(String label, boolean searchbar) {
			super(label);
			this.search = searchbar;
		}

		@Override
		public Item getTabIconItem() {
			return stack.getItem();
		}

		public void setTabIconItemStack(ItemStack stack) {
			this.stack = stack;
		}

		@Override
		public ItemStack getIconItemStack() {
			return stack;
		}
		
		@Override
	    @SideOnly(Side.CLIENT)
	    public String getBackgroundImageName() {

	        return search ? "item_search.png" : super.getBackgroundImageName();
	    }

	    @Override
	    public int getSearchbarWidth() {

	        return 89;
	    }
	    
	    @Override
	    public boolean hasSearchBar() {

	        return search;
	    }
	}

	public static final CustomCreativeTab tabChisel = new CustomCreativeTab("tabChisel", false);
	public static final CustomCreativeTab tabChiselBlocks = new CustomCreativeTab("tabChiselBlocks", true);	
	
	public static void postInit() {
		
		boolean bool0 = Loader.isModLoaded("Thaumcraft");
		boolean bool1 = Loader.isModLoaded("AWayOfTime");

		if(Features.CHISEL.enabled())
		tabChisel.setTabIconItemStack(new ItemStack(ChiselItems.chisel));
		else tabChisel.setTabIconItemStack(new ItemStack(Items.stick));
		if(Features.HOLYSTONE.enabled())
		tabChiselBlocks.setTabIconItemStack(new ItemStack(ChiselBlocks.holystone));
		else if(Features.WOOD.enabled())
		tabChiselBlocks.setTabIconItemStack(new ItemStack(ChiselBlocks.planks[0], 1, 1));
		else if(Features.TECHNICAL.enabled())
		tabChiselBlocks.setTabIconItemStack(new ItemStack(ChiselBlocks.technical));
		else if(Features.JACKOLANTERN.enabled())
		tabChiselBlocks.setTabIconItemStack(new ItemStack(ChiselBlocks.jackolantern[0]));
		else if(Features.ARCANE.enabled() && bool0 == true)
			tabChiselBlocks.setTabIconItemStack(new ItemStack(ChiselBlocks.arcane));
		else if(Features.BLOOD_RUNE.enabled() && bool1 == true)
			tabChiselBlocks.setTabIconItemStack(new ItemStack(ChiselBlocks.bloodRune));
		else if(ChiselBlocks.voidstone != null)
			tabChiselBlocks.setTabIconItemStack(new ItemStack(ChiselBlocks.voidstone));
		else 
			tabChiselBlocks.setTabIconItemStack(new ItemStack(Blocks.lit_pumpkin));
			//tabChiselBlocks.setTabIconItemStack(new ItemStack(Blocks.stonebrick));

	}
}
