package com.cricketcraft.chisel.client;

import static com.cricketcraft.chisel.block.variant.BlockVariants.CLOUD_GRID;
import static com.cricketcraft.chisel.block.variant.BlockVariants.CLOUD_LARGE;
import static com.cricketcraft.chisel.block.variant.BlockVariants.CLOUD_NORMAL;
import static com.cricketcraft.chisel.block.variant.BlockVariants.CLOUD_SMALL;
import static com.cricketcraft.chisel.block.variant.BlockVariants.CLOUD_VERTICAL;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.init.ChiselBlocks;
import com.cricketcraft.chisel.init.ChiselItems;
import com.cricketcraft.chisel.util.IItemWithVariants;

@SideOnly(Side.CLIENT)
public class ModelsChisel {
	public static void prepareModels() {
		addVariantNames(ChiselBlocks.cloud, "cloud_normal", "cloud_grid", "cloud_large", "cloud_small", "cloud_vertical");

		addVariantNames(ChiselItems.upgrade, "upgrade_speed", "upgrade_automation", "upgrade_stack", "upgrade_reversion");
	}

	public static void registerModels() {
		registerBlockModel(ChiselBlocks.cloud, CLOUD_NORMAL.getMeta(), getResource("cloud_normal"));
		registerBlockModel(ChiselBlocks.cloud, CLOUD_GRID.getMeta(), getResource("cloud_grid"));
		registerBlockModel(ChiselBlocks.cloud, CLOUD_LARGE.getMeta(), getResource("cloud_large"));
		registerBlockModel(ChiselBlocks.cloud, CLOUD_SMALL.getMeta(), getResource("cloud_small"));
		registerBlockModel(ChiselBlocks.cloud, CLOUD_VERTICAL.getMeta(), getResource("cloud_vertical"));

		// ITEMS BELOW.

		registerItemModel(ChiselItems.cloudInABottle);
		registerItemModel(ChiselItems.smashing_rock);
		registerItemModel(ChiselItems.ballOMoss);
		registerItemModels(ChiselItems.upgrade);
		registerItemModel(ChiselItems.chisel);
		registerItemModel(ChiselItems.diamondChisel);
		registerItemModel(ChiselItems.obsidianChisel);
	}

	private static void addVariantNames(Block block, String... names)
	{
		for (int i = 0; i < names.length; i++)
		{
			names[i] = getResource(names[i]);
		}

		ModelBakery.addVariantName(Item.getItemFromBlock(block), names);
	}

	private static void addVariantNames(Item item, String... names)
	{
		for (int i = 0; i < names.length; i++)
		{
			names[i] = getResource(names[i]);
		}

		ModelBakery.addVariantName(item, names);
	}

	private static void registerBlockModel(Block block)
	{
		ResourceLocation resourceLocation = (ResourceLocation) Block.blockRegistry.getNameForObject(block);

		registerBlockModel(block, 0, resourceLocation.toString());
	}

	private static void registerItemModel(Item item)
	{
		ResourceLocation resourceLocation = (ResourceLocation) Item.itemRegistry.getNameForObject(item);

		registerItemModel(item, 0, resourceLocation.toString());
	}

	private static void registerBlockModel(Block block, int meta, String modelName)
	{
		registerItemModel(Item.getItemFromBlock(block), meta, modelName);
	}

	private static void registerItemModel(Item item, int meta, String resourcePath)
	{
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation(resourcePath, "inventory");

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, modelResourceLocation);
	}

	public static void registerItemModels(Item item) {
		for (int i = 0; i < ((IItemWithVariants) item).getVariantNames().length; i++) {
			String NAME = item.getUnlocalizedName().substring(5) + "_" + ((IItemWithVariants) item).getVariantNames()[i];
			registerItemModel(item, i, getResource(NAME));
		}
	}

	public static String getResource(String resource) {
		return (Chisel.MOD_ID + ":") + resource;
	}
}
