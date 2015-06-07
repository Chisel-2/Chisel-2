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
import com.cricketcraft.chisel.init.ChiselBlocks;
import com.cricketcraft.chisel.init.ChiselItems;
import com.cricketcraft.chisel.util.IItemWithVariants;

import static com.cricketcraft.chisel.block.variant.BlockVariants.*;

@SideOnly(Side.CLIENT)
public class ModelsChisel {
	public static void prepareModels() {
		addVariantNames(ChiselBlocks.cloud, CLOUD_NORMAL.getName(), CLOUD_GRID.getName(), CLOUD_LARGE.getName(), CLOUD_SMALL.getName(), CLOUD_VERTICAL.getName());
		addVariantNames(ChiselBlocks.marble, MARBLE_RAW.getName(), MARBLE_BRICK.getName(), MARBLE_PANEL_CLASSIC.getName(), MARBLE_PANEL_ORNATE.getName(), MARBLE_PANEL.getName(), MARBLE_BLOCK.getName(), MARBLE_CREEPER_DARK.getName(), MARBLE_CREEPER_LIGHT.getName(), MARBLE_CARVED.getName(), MARBLE_CARVED_RADIAL.getName(), MARBLE_DENT.getName(), MARBLE_DENT_LARGE.getName(), MARBLE_TILES.getName(), MARBLE_TILES_ARRANGED.getName(), MARBLE_TILES_FANCY.getName(), MARBLE_BLOCKS.getName());
		addVariantNames(ChiselBlocks.limestone, LIMESTONE_RAW.getName(), LIMESTONE_TILES.getName(), LIMESTONE_TILES_FRENCH.getName(), LIMESTONE_TILES_FRENCH_LIGHT.getName(), LIMESTONE_TILES_CREEPER.getName(), LIMESTONE_TILES_LARGE.getName(), LIMESTONE_BRICKS.getName(), LIMESTONE_SMOOTH.getName(), LIMESTONE_PANEL_ORNATE.getName(), LIMESTONE_PANEL_ENGRAVED.getName(), LIMESTONE_PANEL_CREEPER.getName(), LIMESTONE_PANEL_LIGHT.getName(), LIMESTONE_PANEL_DARK.getName(), LIMESTONE_PANEL.getName(), LIMESTONE_DENT.getName());

		addVariantNames(ChiselItems.upgrade, "upgrade_speed", "upgrade_automation", "upgrade_stack", "upgrade_reversion");
	}

	public static void registerModels() {
		registerBlockModel(ChiselBlocks.cloud, CLOUD_NORMAL.getMeta(), getResource(CLOUD_NORMAL.getName()));
		registerBlockModel(ChiselBlocks.cloud, CLOUD_GRID.getMeta(), getResource(CLOUD_GRID.getName()));
		registerBlockModel(ChiselBlocks.cloud, CLOUD_LARGE.getMeta(), getResource(CLOUD_LARGE.getName()));
		registerBlockModel(ChiselBlocks.cloud, CLOUD_SMALL.getMeta(), getResource(CLOUD_SMALL.getName()));
		registerBlockModel(ChiselBlocks.cloud, CLOUD_VERTICAL.getMeta(), getResource(CLOUD_VERTICAL.getName()));

		registerBlockModel(ChiselBlocks.marble, MARBLE_RAW.getMeta(), getResource(MARBLE_RAW.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_BRICK.getMeta(), getResource(MARBLE_BRICK.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_PANEL_CLASSIC.getMeta(), getResource(MARBLE_PANEL_CLASSIC.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_PANEL_ORNATE.getMeta(), getResource(MARBLE_PANEL_ORNATE.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_PANEL.getMeta(), getResource(MARBLE_PANEL.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_BLOCK.getMeta(), getResource(MARBLE_BLOCK.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_CREEPER_DARK.getMeta(), getResource(MARBLE_CREEPER_DARK.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_CREEPER_LIGHT.getMeta(), getResource(MARBLE_CREEPER_LIGHT.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_CARVED.getMeta(), getResource(MARBLE_CARVED.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_CARVED_RADIAL.getMeta(), getResource(MARBLE_CARVED_RADIAL.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_DENT.getMeta(), getResource(MARBLE_DENT.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_DENT_LARGE.getMeta(), getResource(MARBLE_DENT_LARGE.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_TILES.getMeta(), getResource(MARBLE_TILES.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_TILES_ARRANGED.getMeta(), getResource(MARBLE_TILES_ARRANGED.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_TILES_FANCY.getMeta(), getResource(MARBLE_TILES_FANCY.getName()));
		registerBlockModel(ChiselBlocks.marble, MARBLE_BLOCKS.getMeta(), getResource(MARBLE_BLOCKS.getName()));

		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_RAW.getMeta(), getResource(LIMESTONE_RAW.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_TILES.getMeta(), getResource(LIMESTONE_TILES.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_TILES_FRENCH.getMeta(), getResource(LIMESTONE_TILES_FRENCH.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_TILES_FRENCH_LIGHT.getMeta(), getResource(LIMESTONE_TILES_FRENCH_LIGHT.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_TILES_CREEPER.getMeta(), getResource(LIMESTONE_TILES_CREEPER.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_TILES_DAMAGED.getMeta(), getResource(LIMESTONE_TILES_DAMAGED.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_TILES_LARGE.getMeta(), getResource(LIMESTONE_TILES_LARGE.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_BRICKS.getMeta(), getResource(LIMESTONE_BRICKS.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_SMOOTH.getMeta(), getResource(LIMESTONE_SMOOTH.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_PANEL_ORNATE.getMeta(), getResource(LIMESTONE_PANEL_ORNATE.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_PANEL_ENGRAVED.getMeta(), getResource(LIMESTONE_PANEL_ENGRAVED.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_PANEL_CREEPER.getMeta(), getResource(LIMESTONE_PANEL_CREEPER.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_PANEL_LIGHT.getMeta(), getResource(LIMESTONE_PANEL_LIGHT.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_PANEL_DARK.getMeta(), getResource(LIMESTONE_PANEL_DARK.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_PANEL.getMeta(), getResource(LIMESTONE_PANEL.getName()));
		registerBlockModel(ChiselBlocks.limestone, LIMESTONE_DENT.getMeta(), getResource(LIMESTONE_DENT.getName()));

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
