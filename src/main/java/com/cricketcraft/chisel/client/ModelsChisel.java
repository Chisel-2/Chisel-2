package com.cricketcraft.chisel.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.block.BlockCloud;
import com.cricketcraft.chisel.init.ChiselBlocks;
import com.cricketcraft.chisel.init.ChiselItems;

@SideOnly(Side.CLIENT)
public class ModelsChisel
{

	public static void registerModels()
	{
		registerBlockModels();
		registerItemModels();
	}

	private static void registerBlockModels()
	{
		registerBlockModelVariant(ChiselBlocks.cloud, BlockCloud.NORMAL.getMeta(), "cloud_normal");
		registerBlockModelVariant(ChiselBlocks.cloud, BlockCloud.GRID.getMeta(), "cloud_grid");
		registerBlockModelVariant(ChiselBlocks.cloud, BlockCloud.LARGE.getMeta(), "cloud_large");
		registerBlockModelVariant(ChiselBlocks.cloud, BlockCloud.SMALL.getMeta(), "cloud_small");
		registerBlockModelVariant(ChiselBlocks.cloud, BlockCloud.VERTICAL.getMeta(), "cloud_vertical");
	}

	private static void registerItemModels()
	{
		registerItemModel(ChiselItems.cloudInABottle);
		registerItemModel(ChiselItems.smashing_rock);
		registerItemModel(ChiselItems.ballOMoss);
	}

	private static void registerBlockModel(Block block)
	{
		ResourceLocation resourceLocation = (ResourceLocation) Block.blockRegistry.getNameForObject(block);

		registerBlockModel(block, 0, resourceLocation.getResourcePath());
	}

	private static void registerItemModel(Item item)
	{
		ResourceLocation resourceLocation = (ResourceLocation) Item.itemRegistry.getNameForObject(item);

		registerItemModel(item, 0, resourceLocation.getResourcePath());
	}

	private static void registerBlockModel(Block block, int meta, String modelName)
	{
		registerItemModel(Item.getItemFromBlock(block), meta, modelName);
	}

	private static void registerItemModel(Item item, int meta, String resourcePath)
	{
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation(getResource(resourcePath), "inventory");

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, modelResourceLocation);
	}

	private static void registerBlockModelVariant(Block block, int meta, String resourcePath)
	{
		Item item = Item.getItemFromBlock(block);

		registerItemModel(item, meta, resourcePath);

		ModelBakery.addVariantName(item, getResource(resourcePath));
	}

	public static String getResource(String resource)
	{
		return (Chisel.MOD_ID + ":") + resource;
	}
}
