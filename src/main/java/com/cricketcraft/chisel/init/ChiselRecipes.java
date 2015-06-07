package com.cricketcraft.chisel.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.cricketcraft.chisel.config.Configurations;

public class ChiselRecipes {
	public static void preInit() {
		registerShapedRecipe(new ItemStack(ChiselItems.cloudInABottle, 1), "X X", "XYX", " X ", 'X', Blocks.glass, 'Y', Items.quartz);
		registerShapedRecipe(new ItemStack(ChiselItems.ballOMoss, 1), "XYX", "YXY", "XYX", 'X', Blocks.vine, 'Y', Items.stick);

		registerShapedOreRecipe(new ItemStack(ChiselItems.upgrade, 1, 0), "IEI", "EUE", "RRR", 'I', "ingotIron", 'E', Items.emerald, 'R', Items.redstone, 'U', Items.sugar);
		registerShapedOreRecipe(new ItemStack(ChiselItems.upgrade, 1, 1), "IEI", "EUE", "RRR", 'I', "ingotIron", 'E', Items.emerald, 'R', Items.redstone, 'U', Blocks.hopper);
		registerShapedOreRecipe(new ItemStack(ChiselItems.upgrade, 1, 2), "IEI", "EUE", "RRR", 'I', "ingotIron", 'E', Items.emerald, 'R', Items.redstone, 'U', Blocks.crafting_table);

		if (Configurations.chiselRecipe) {
			registerShapedOreRecipe(new ItemStack(ChiselItems.chisel), " YY", " YY", "X  ", 'X', "stickWood", 'Y', "ingotIron");
			registerShapedOreRecipe(new ItemStack(ChiselItems.diamondChisel), " YY", " YY", "x  ", 'x', "stickWood", 'Y', "gemDiamond");
			registerShapedOreRecipe(new ItemStack(ChiselItems.obsidianChisel), " YY", " YY", "x  ", 'x', "stickWood", 'Y', Blocks.obsidian);
		}
		else {
			registerShapedOreRecipe(new ItemStack(ChiselItems.chisel), " Y", "X ", 'X', "stickWood", 'Y', "ingotIron");
			registerShapedOreRecipe(new ItemStack(ChiselItems.diamondChisel), " Y", "X ", 'X', "stickWood", 'Y', "gemDiamond");
			registerShapedOreRecipe(new ItemStack(ChiselItems.obsidianChisel), " Y", "X ", 'X', "stickWood", 'Y', Blocks.obsidian);
		}

		registerShapelessRecipe(new ItemStack(ChiselItems.smashing_rock, 16), new ItemStack(Items.stone_pickaxe), new ItemStack(Items.glass_bottle, 1), new ItemStack(Items.stone_shovel));
	}

	private static void registerShapelessRecipe(ItemStack output, Object... stacks) {
		GameRegistry.addShapelessRecipe(output, stacks);
	}

	private static void registerShapedRecipe(ItemStack output, Object... params) {
		GameRegistry.addShapedRecipe(output, params);
	}

	private static void registerShapedOreRecipe(ItemStack output, Object... params) {
		GameRegistry.addRecipe(new ShapedOreRecipe(output, params));
	}
}
