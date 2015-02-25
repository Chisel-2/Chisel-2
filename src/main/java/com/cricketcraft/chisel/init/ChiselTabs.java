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

	public static final CustomCreativeTab tabChisel = new CustomCreativeTab("tabChisel", true);
	
	public static void postInit() {

		if(Features.CHISEL.enabled())
		tabChisel.setTabIconItemStack(new ItemStack(ChiselItems.chisel));
		else tabChisel.setTabIconItemStack(new ItemStack(Items.stick));

	}
}
