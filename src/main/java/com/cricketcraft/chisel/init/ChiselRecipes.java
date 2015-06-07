package com.cricketcraft.chisel.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ChiselRecipes
{
	public static void preInit()
	{
		registerShapedRecipe(new ItemStack(ChiselItems.cloudInABottle, 1), "X X", "XYX", " X ", 'X', Blocks.glass, 'Y', Items.quartz);
		registerShapedRecipe(new ItemStack(ChiselItems.ballOMoss, 1), "XYX", "YXY", "XYX", 'X', Blocks.vine, 'Y', Items.stick);

		registerShapelessRecipe(new ItemStack(ChiselItems.smashing_rock, 16), new ItemStack(Items.stone_pickaxe), new ItemStack(Items.glass_bottle, 1), new ItemStack(Items.stone_shovel));
	}

	private static void registerShapelessRecipe(ItemStack output, Object... stacks)
	{
		GameRegistry.addShapelessRecipe(output, stacks);
	}

	private static void registerShapedRecipe(ItemStack output, Object... params)
	{
		GameRegistry.addShapedRecipe(output, params);
	}
}
