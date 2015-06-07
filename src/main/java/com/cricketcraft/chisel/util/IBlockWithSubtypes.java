package com.cricketcraft.chisel.util;

import net.minecraft.item.ItemStack;

public interface IBlockWithSubtypes
{
	String getSubtypeUnlocalizedName(ItemStack stack);
}
