package com.cricketcraft.chisel.client;

import static com.cricketcraft.chisel.block.variant.BlockVariants.*;
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
		addVariantNames(ChiselBlocks.acacia, ACACIA_PLANKS_SMOOTH.getName(), ACACIA_PLANKS_SHORT.getName(), ACACIA_PLANKS_FANCY.getName(), ACACIA_PLANKS_PANEL.getName(), ACACIA_PLANKS_DOUBLE_SLAB.getName(), ACACIA_PLANKS_CRATE.getName(), ACACIA_PLANKS_CRATE_FANCY.getName(), ACACIA_PLANKS_LONG.getName(), ACACIA_PLANKS_VERTICAL.getName(), ACACIA_PLANKS_VERTICAL_UNEVEN.getName(), ACACIA_PLANKS_PARQUET.getName(), ACACIA_PLANKS_BLINDS.getName(), ACACIA_PLANKS_SCAFFOLD.getName(), ACACIA_PLANKS_DISARRAY.getName(), ACACIA_PLANKS_DISARRAY_VERTICAL.getName());
		addVariantNames(ChiselBlocks.aluminum, ALUMINUM_CAUTION.getName(), ALUMINUM_SHIPPING.getName(), ALUMINUM_THERMAL.getName(), ALUMINUM_125.getName(), ALUMINUM_BORDERED.getName(), ALUMINUM_BOLTED.getName());
		addVariantNames(ChiselBlocks.andesite, ANDESITE_PILLAR.getName(), ANDESITE_BRICKS.getName(), ANDESITE_ORNATE.getName(), ANDESITE_PRISMATIC.getName(), ANDESITE_TILES_SMALL.getName());
		addVariantNames(ChiselBlocks.antiblock, ANTIBLOCK_0.getName(), ANTIBLOCK_1.getName(), ANTIBLOCK_2.getName(), ANTIBLOCK_3.getName(), ANTIBLOCK_4.getName(), ANTIBLOCK_5.getName(), ANTIBLOCK_6.getName(), ANTIBLOCK_7.getName(), ANTIBLOCK_8.getName(), ANTIBLOCK_9.getName(), ANTIBLOCK_10.getName(), ANTIBLOCK_11.getName(), ANTIBLOCK_12.getName(), ANTIBLOCK_13.getName(), ANTIBLOCK_14.getName(), ANTIBLOCK_15.getName());
		addVariantNames(ChiselBlocks.birch, BIRCH_PLANKS_SMOOTH.getName(), BIRCH_PLANKS_SHORT.getName(), BIRCH_PLANKS_FANCY.getName(), BIRCH_PLANKS_PANEL.getName(), BIRCH_PLANKS_DOUBLE_SLAB.getName(), BIRCH_PLANKS_CRATE.getName(), BIRCH_PLANKS_CRATE_FANCY.getName(), BIRCH_PLANKS_LONG.getName(), BIRCH_PLANKS_VERTICAL.getName(), BIRCH_PLANKS_VERTICAL_UNEVEN.getName(), BIRCH_PLANKS_PARQUET.getName(), BIRCH_PLANKS_BLINDS.getName(), BIRCH_PLANKS_SCAFFOLD.getName(), BIRCH_PLANKS_DISARRAY.getName(), BIRCH_PLANKS_DISARRAY_VERTICAL.getName());
		addVariantNames(ChiselBlocks.bookshelf, BOOKSHELF_RAINBOW.getName(), BOOKSHELF_NECROMANCER_APPRENTICE.getName(), BOOKSHELF_NECROMANCER.getName(), BOOKSHELF_TOMES.getName(), BOOKSHELF_ABANDONED.getName(), BOOKSHELF_HOARDERS.getName(), BOOKSHELF_PASTEL.getName(), BOOKSHELF_HISTORIAN.getName());
		addVariantNames(ChiselBlocks.bricks, BRICKS_LARGE.getName(), BRICKS_MORTARLESS.getName(), BRICKS_VARIED.getName(), BRICKS_AGED.getName(), BRICKS_YELLOW.getName());
		addVariantNames(ChiselBlocks.bronze, BRONZE_CAUTION.getName(), BRONZE_SHIPPING.getName(), BRONZE_THERMAL.getName(), BRONZE_125.getName(), BRONZE_BORDERED.getName(), BRONZE_BOLTED.getName());

		addVariantNames(ChiselBlocks.cloud, CLOUD_NORMAL.getName(), CLOUD_GRID.getName(), CLOUD_LARGE.getName(), CLOUD_SMALL.getName(), CLOUD_VERTICAL.getName());
		addVariantNames(ChiselBlocks.marble, MARBLE_RAW.getName(), MARBLE_BRICK.getName(), MARBLE_PANEL_CLASSIC.getName(), MARBLE_PANEL_ORNATE.getName(), MARBLE_PANEL.getName(), MARBLE_BLOCK.getName(), MARBLE_CREEPER_DARK.getName(), MARBLE_CREEPER_LIGHT.getName(), MARBLE_CARVED.getName(), MARBLE_CARVED_RADIAL.getName(), MARBLE_DENT.getName(), MARBLE_DENT_LARGE.getName(), MARBLE_TILES.getName(), MARBLE_TILES_ARRANGED.getName(), MARBLE_TILES_FANCY.getName(), MARBLE_BLOCKS.getName());
		addVariantNames(ChiselBlocks.limestone, LIMESTONE_RAW.getName(), LIMESTONE_TILES.getName(), LIMESTONE_TILES_FRENCH.getName(), LIMESTONE_TILES_FRENCH_LIGHT.getName(), LIMESTONE_TILES_CREEPER.getName(), LIMESTONE_TILES_LARGE.getName(), LIMESTONE_BRICKS.getName(), LIMESTONE_SMOOTH.getName(), LIMESTONE_PANEL_ORNATE.getName(), LIMESTONE_PANEL_ENGRAVED.getName(), LIMESTONE_PANEL_CREEPER.getName(), LIMESTONE_PANEL_LIGHT.getName(), LIMESTONE_PANEL_DARK.getName(), LIMESTONE_PANEL.getName(), LIMESTONE_DENT.getName());
		addVariantNames(ChiselBlocks.pumpkin, PUMPKIN_0.getName(), PUMPKIN_1.getName(), PUMPKIN_2.getName(), PUMPKIN_3.getName(), PUMPKIN_4.getName(), PUMPKIN_5.getName(), PUMPKIN_6.getName(), PUMPKIN_7.getName(), PUMPKIN_8.getName(), PUMPKIN_9.getName(), PUMPKIN_10.getName(), PUMPKIN_11.getName(), PUMPKIN_12.getName(), PUMPKIN_13.getName(), PUMPKIN_14.getName(), PUMPKIN_15.getName(), PUMPKIN_16.getName());
		addVariantNames(ChiselBlocks.jackolantern, LITPUMPKIN_0.getName(), LITPUMPKIN_1.getName(), LITPUMPKIN_2.getName(), LITPUMPKIN_3.getName(), LITPUMPKIN_4.getName(), LITPUMPKIN_5.getName(), LITPUMPKIN_6.getName(), LITPUMPKIN_7.getName(), LITPUMPKIN_8.getName(), LITPUMPKIN_9.getName(), LITPUMPKIN_10.getName(), LITPUMPKIN_11.getName(), LITPUMPKIN_12.getName(), LITPUMPKIN_13.getName(), LITPUMPKIN_14.getName(), LITPUMPKIN_15.getName(), LITPUMPKIN_16.getName());

		addVariantNames(ChiselItems.upgrade, "upgrade_speed", "upgrade_automation", "upgrade_stack", "upgrade_reversion");
	}

	public static void registerModels() {
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_SMOOTH.getMeta(), getResource(ACACIA_PLANKS_SMOOTH.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_SHORT.getMeta(), getResource(ACACIA_PLANKS_SHORT.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_FANCY.getMeta(), getResource(ACACIA_PLANKS_FANCY.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_PANEL.getMeta(), getResource(ACACIA_PLANKS_PANEL.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_DOUBLE_SLAB.getMeta(), getResource(ACACIA_PLANKS_DOUBLE_SLAB.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_CRATE.getMeta(), getResource(ACACIA_PLANKS_CRATE.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_CRATE_FANCY.getMeta(), getResource(ACACIA_PLANKS_CRATE_FANCY.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_LONG.getMeta(), getResource(ACACIA_PLANKS_LONG.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_VERTICAL.getMeta(), getResource(ACACIA_PLANKS_VERTICAL.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_VERTICAL_UNEVEN.getMeta(), getResource(ACACIA_PLANKS_VERTICAL_UNEVEN.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_PARQUET.getMeta(), getResource(ACACIA_PLANKS_PARQUET.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_BLINDS.getMeta(), getResource(ACACIA_PLANKS_BLINDS.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_SCAFFOLD.getMeta(), getResource(ACACIA_PLANKS_SCAFFOLD.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_DISARRAY.getMeta(), getResource(ACACIA_PLANKS_DISARRAY.getName()));
		registerBlockModel(ChiselBlocks.acacia, ACACIA_PLANKS_DISARRAY_VERTICAL.getMeta(), getResource(ACACIA_PLANKS_DISARRAY_VERTICAL.getName()));

		registerBlockModel(ChiselBlocks.aluminum, ALUMINUM_CAUTION.getMeta(), getResource(ALUMINUM_CAUTION.getName()));
		registerBlockModel(ChiselBlocks.aluminum, ALUMINUM_SHIPPING.getMeta(), getResource(ALUMINUM_SHIPPING.getName()));
		registerBlockModel(ChiselBlocks.aluminum, ALUMINUM_THERMAL.getMeta(), getResource(ALUMINUM_THERMAL.getName()));
		registerBlockModel(ChiselBlocks.aluminum, ALUMINUM_125.getMeta(), getResource(ALUMINUM_125.getName()));
		registerBlockModel(ChiselBlocks.aluminum, ALUMINUM_BORDERED.getMeta(), getResource(ALUMINUM_BORDERED.getName()));
		registerBlockModel(ChiselBlocks.aluminum, ALUMINUM_BOLTED.getMeta(), getResource(ALUMINUM_BOLTED.getName()));


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

		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_0.getMeta(), getResource(PUMPKIN_0.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_1.getMeta(), getResource(PUMPKIN_1.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_2.getMeta(), getResource(PUMPKIN_2.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_3.getMeta(), getResource(PUMPKIN_3.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_4.getMeta(), getResource(PUMPKIN_4.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_5.getMeta(), getResource(PUMPKIN_5.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_6.getMeta(), getResource(PUMPKIN_6.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_7.getMeta(), getResource(PUMPKIN_7.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_8.getMeta(), getResource(PUMPKIN_8.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_9.getMeta(), getResource(PUMPKIN_9.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_10.getMeta(), getResource(PUMPKIN_10.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_11.getMeta(), getResource(PUMPKIN_11.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_12.getMeta(), getResource(PUMPKIN_12.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_13.getMeta(), getResource(PUMPKIN_13.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_14.getMeta(), getResource(PUMPKIN_14.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_15.getMeta(), getResource(PUMPKIN_15.getName()));
		registerBlockModel(ChiselBlocks.pumpkin, PUMPKIN_16.getMeta(), getResource(PUMPKIN_16.getName()));

		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_0.getMeta(), getResource(LITPUMPKIN_0.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_1.getMeta(), getResource(LITPUMPKIN_1.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_2.getMeta(), getResource(LITPUMPKIN_2.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_3.getMeta(), getResource(LITPUMPKIN_3.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_4.getMeta(), getResource(LITPUMPKIN_4.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_5.getMeta(), getResource(LITPUMPKIN_5.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_6.getMeta(), getResource(LITPUMPKIN_6.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_7.getMeta(), getResource(LITPUMPKIN_7.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_8.getMeta(), getResource(LITPUMPKIN_8.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_9.getMeta(), getResource(LITPUMPKIN_9.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_10.getMeta(), getResource(LITPUMPKIN_10.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_11.getMeta(), getResource(LITPUMPKIN_11.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_12.getMeta(), getResource(LITPUMPKIN_12.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_13.getMeta(), getResource(LITPUMPKIN_13.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_14.getMeta(), getResource(LITPUMPKIN_14.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_15.getMeta(), getResource(LITPUMPKIN_15.getName()));
		registerBlockModel(ChiselBlocks.jackolantern, LITPUMPKIN_16.getMeta(), getResource(LITPUMPKIN_16.getName()));

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
