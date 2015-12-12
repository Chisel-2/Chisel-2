package com.cricketcraft.chisel.init;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.api.CarvingUtils;
import com.cricketcraft.chisel.api.ICarvingGroup;
import com.cricketcraft.chisel.api.ICarvingVariant;
import com.cricketcraft.chisel.block.metal.*;
import com.cricketcraft.chisel.block.modded.*;
import com.cricketcraft.chisel.block.other.*;
import com.cricketcraft.chisel.block.other.stained.*;
import com.cricketcraft.chisel.block.other.stained.panes.*;
import com.cricketcraft.chisel.block.stone.*;
import com.cricketcraft.chisel.block.variant.BlockVariants;
import com.cricketcraft.chisel.block.wood.*;
import com.cricketcraft.chisel.item.itemblock.ItemBlockCarvable;
import com.cricketcraft.chisel.item.itemblock.ItemCarvablePumpkin;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.PropertyVariant;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import java.util.Collection;
import java.util.List;

@ObjectHolder(Chisel.MOD_ID)
public final class ChiselBlocks {
	public static Block
			acacia,
			aluminum,
			andesite,
			antiblock,
			birch,
			bronze,
			bricks,
			bookshelf,
			carpet,
			carpet_floor,
			chest,
			cobblestone,
			concrete,
			copper,
			cloud,
			dark_oak,
			diamond,
			diorite,
			dirt,
			emerald,
			energised_voidstone,
			energised_voidstone_pillar,
			factory,
			fantasy,
			futura,
			glass,
			glass_pane,
			glowstone,
			gold,
			gold2,
			granite,
			grimstone,
			hex_plating,
			holystone,
			ice,
			ice_pillar,
			imperial,
			industrial,
			iron,
			iron_bars,
			jungle,
			laboratory,
			lapis,
			large_hex_plating,
			lavastone,
			lead,
			leaf,
			limestone,
			litpumpkin,
			marble,
			mossy_cobblestone,
			mossy_temple,
			netherbrick,
			netherrack,
			oak,
			obsidian,
			packed_ice,
			packed_ice_pillar,
			paperwall,
			paperwall_block,
			pumpkin,
			purple_fantasy,
			rebel,
			redstone,
			road_line,
			runic_voidstone,
			sandstone,
			sandstone_scribbles,
			silver,
			snakestone_sand,
			snakestone_stone,
			spruce,
			stained_glass_black,
			stained_glass_red,
			stained_glass_green,
			stained_glass_brown,
			stained_glass_blue,
			stained_glass_purple,
			stained_glass_cyan,
			stained_glass_light_gray,
			stained_glass_gray,
			stained_glass_pink,
			stained_glass_lime,
			stained_glass_yellow,
			stained_glass_light_blue,
			stained_glass_magenta,
			stained_glass_orange,
			stained_glass_white,
			stained_glass_pane_black,
			stained_glass_pane_red,
			stained_glass_pane_green,
			stained_glass_pane_brown,
			stained_glass_pane_blue,
			stained_glass_pane_purple,
			stained_glass_pane_cyan,
			stained_glass_pane_light_gray,
			stained_glass_pane_gray,
			stained_glass_pane_pink,
			stained_glass_pane_lime,
			stained_glass_pane_yellow,
			stained_glass_pane_light_blue,
			stained_glass_pane_magenta,
			stained_glass_pane_orange,
			stained_glass_pane_white,
			steel,
			stone_bricks,
			technical,
			temple,
			tin,
			torch,
			transparent_technical,
			tyrian,
			uranium,
			valentines,
			voidstone,
			warning,
			waterstone,
			woolen_clay;

	public static void preInit() {
		//acacia = createChiselGroup("acacia_planks", new ChiselBlockAcacia(), ChiselProperties.ACACIA_VARIANTS, "acacia", Chisel.MOD_ID + ":chisel.wood", "wood");
		acacia = registerBlock("acacia_planks", new ChiselBlockAcacia());
		aluminum = registerBlock("aluminumblock", new ChiselBlockAluminum());
		andesite = registerBlock("andesite", new ChiselBlockAndesite());
		antiblock = registerBlock("antiBlock", new ChiselBlockAntiblock());
		birch = registerBlock("birch_planks", new ChiselBlockBirch());
		bronze = registerBlock("bronzeblock", new ChiselBlockBronze());
		bricks = registerBlock("brickCustom", new ChiselBlockBricks());
		bookshelf = registerBlock("bookshelf", new ChiselBlockBookshelf());
		carpet = registerBlock("carpet_block", new ChiselBlockCarvableCarpet());
		carpet_floor = registerBlock("carpet_floor", new ChiselBlockCarpetFloor());
		chest = registerBlock("chest", new ChiselBlockCarvableChest());
		cobblestone = registerBlock("cobblestone", new ChiselBlockCobblestone());
		concrete = registerBlock("concrete", new ChiselBlockConcrete());
		copper = registerBlock("copperblock", new ChiselBlockCopper());
		cloud = registerBlock("cloud", new ChiselBlockCloud());
		dark_oak = registerBlock("dark_oak_planks", new ChiselBlockDarkOak());
		diamond = registerBlock("diamond_block", new ChiselBlockDiamond());
		diorite = registerBlock("diorite", new ChiselBlockDiorite());
		dirt = registerBlock("dirt", new ChiselBlockDirt());
		emerald = registerBlock("emerald_block", new ChiselBlockEmerald());
		energised_voidstone = registerBlock("voidstone2", new ChiselBlockEnergisedVoidstone());
		energised_voidstone_pillar = registerBlock("voidstonePillar2", new ChiselBlockEnergisedVoidstonePillar());
		factory = registerBlock("factoryBlock", new ChiselBlockFactory());
		fantasy = registerBlock("fantasyblock2", new ChiselBlockFantasy());
		futura = registerBlock("futura", new ChiselBlockFutura());
		glass = registerBlock("glass", new ChiselBlockCarvableGlass());
		glass_pane = registerBlock("glass_pane", new ChiselBlockGlassPane());
		glowstone = registerBlock("glowstone", new ChiselBlockGlowstone());
		gold = registerBlock("gold_block", new ChiselBlockGold());
		gold2 = registerBlock("gold2_block", new ChiselBlockGold2());
		granite = registerBlock("granite", new ChiselBlockGranite());
		grimstone = registerBlock("grimstone", new ChiselBlockGrimstone());
		hex_plating = registerBlock("hex_plating", new ChiselBlockHexPlating());
		holystone = registerBlock("holystone", new ChiselBlockHolystone());
		ice = registerBlock("ice", new ChiselBlockIce());
		ice_pillar = registerBlock("icePillar", new ChiselBlockIcePillar());
		imperial = registerBlock("imperial", new ChiselBlockImperial());
		industrial = registerBlock("industrial", new ChiselBlockIndustrial());
		iron = registerBlock("iron_block", new ChiselBlockIron());
		iron_bars = registerBlock("iron_bars", new ChiselBlockIronBars());
		jungle = registerBlock("jungle_planks", new ChiselBlockJungle());
		laboratory = registerBlock("laboratory", new ChiselBlockLaboratory());
		lapis = registerBlock("lapis_block", new ChiselBlockLapis());
		large_hex_plating = registerBlock("large_hex_plating", new ChiselBlockHexPlatingLarge());
		lavastone = registerBlock("lavastone", new ChiselBlockLavastone());
		lead = registerBlock("leadblock", new ChiselBlockLead());
		leaf = registerBlock("leaf", new ChiselBlockLeaves());
		limestone = registerBlock("limestone", new ChiselBlockLimestone());
		litpumpkin = registerBlock("litpumpkin", ItemCarvablePumpkin.class, new ChiselBlockJackolantern());
		marble = registerBlock("marble", new ChiselBlockMarble());
		mossy_cobblestone = registerBlock("mossy_cobblestone", new ChiselBlockMossyCobblestone());
		mossy_temple = registerBlock("mossy_temple", new ChiselBlockMossyTemple());
		netherbrick = registerBlock("netherbrick", new ChiselBlockNetherBrick());
		//netherrack = registerBlock("netherrack", new BlockNetherrack());
		oak = registerBlock("oak_planks", new ChiselBlockOak());
		obsidian = registerBlock("obsidian", new ChiselBlockObsidian());
		packed_ice = registerBlock("packed_ice", new ChiselBlockPackedIce());
		packed_ice_pillar = registerBlock("packed_ice_pillar", new ChiselBlockPackedIcePillar());
		paperwall = registerBlock("paperwall", new ChiselBlockPaperWallPane());
		paperwall_block = registerBlock("paperwall_block", new ChiselBlockPaperWall());
		pumpkin = registerBlock("pumpkin", ItemCarvablePumpkin.class, new ChiselBlockPumpkin());
		purple_fantasy = registerBlock("fantasy", new ChiselBlockFantasyPurple());
		rebel = registerBlock("rebel", new ChiselBlockRebel());
		redstone = registerBlock("redstone_block", new ChiselBlockRedstone());
		road_line = registerBlock("road_line", new ChiselBlockRoadline());
		runic_voidstone = registerBlock("runic_voidstone", new ChiselBlockRunicVoidstone());
		sandstone = registerBlock("sandstone", new ChiselBlockSandstone());
		sandstone_scribbles = registerBlock("sandstone_scribbles", new ChiselBlockSandstoneScribbles());
		silver = registerBlock("silverblock", new ChiselBlockSilver());
		snakestone_sand = registerBlock("snakestone_sand", new ChiselBlockSnakestoneSand());
		snakestone_stone = registerBlock("snakestone_stone", new ChiselBlockSnakestone());
		spruce = registerBlock("spruce_planks", new ChiselBlockSpruce());
		stained_glass_black = registerBlock("stained_glass_black", new ChiselBlockStainedGlassBlack());
		stained_glass_red = registerBlock("stained_glass_red", new ChiselBlockStainedGlassRed());
		stained_glass_green = registerBlock("stained_glass_green", new ChiselBlockStainedGlassGreen());
		stained_glass_brown = registerBlock("stained_glass_brown", new ChiselBlockStainedGlassBrown());
		stained_glass_blue = registerBlock("stained_glass_blue", new ChiselBlockStainedGlassBlue());
		stained_glass_purple = registerBlock("stained_glass_purple", new ChiselBlockStainedGlassPurple());
		stained_glass_cyan = registerBlock("stained_glass_cyan", new ChiselBlockStainedGlassCyan());
		stained_glass_light_gray = registerBlock("stained_glass_light_gray", new ChiselBlockStainedGlassLightGray());
		stained_glass_gray = registerBlock("stained_glass_gray", new ChiselBlockStainedGlassGray());
		stained_glass_pink = registerBlock("stained_glass_pink", new ChiselBlockStainedGlassPink());
		stained_glass_lime = registerBlock("stained_glass_lime", new ChiselBlockStainedGlassLime());
		stained_glass_yellow = registerBlock("stained_glass_yellow", new ChiselBlockStainedGlassYellow());
		stained_glass_light_blue = registerBlock("stained_glass_light_blue", new ChiselBlockStainedGlassLightBlue());
		stained_glass_magenta = registerBlock("stained_glass_magenta", new ChiselBlockStainedGlassMagenta());
		stained_glass_orange = registerBlock("stained_glass_orange", new ChiselBlockStainedGlassOrange());
		stained_glass_white = registerBlock("stained_glass_white", new ChiselBlockStainedGlassWhite());
		stained_glass_pane_black = registerBlock("stained_glass_pane_black", new ChiselBlockStainedGlassPaneBlack());
		stained_glass_pane_red = registerBlock("stained_glass_pane_red", new ChiselBlockStainedGlassPaneRed());
		stained_glass_pane_green = registerBlock("stained_glass_pane_green", new ChiselBlockStainedGlassPaneGreen());
		stained_glass_pane_brown = registerBlock("stained_glass_pane_brown", new ChiselBlockStainedGlassPaneBrown());
		stained_glass_pane_blue = registerBlock("stained_glass_pane_blue", new ChiselBlockStainedGlassPaneBlue());
		stained_glass_pane_purple = registerBlock("stained_glass_pane_purple", new ChiselBlockStainedGlassPanePurple());
		stained_glass_pane_cyan = registerBlock("stained_glass_pane_cyan", new ChiselBlockStainedGlassPaneCyan());
		stained_glass_pane_light_gray = registerBlock("stained_glass_pane_light_gray", new ChiselBlockStainedGlassPaneLightGray());
		stained_glass_pane_gray = registerBlock("stained_glass_pane_gray", new ChiselBlockStainedGlassPaneGray());
		stained_glass_pane_pink = registerBlock("stained_glass_pane_pink", new ChiselBlockStainedGlassPanePink());
		stained_glass_pane_lime = registerBlock("stained_glass_pane_lime", new ChiselBlockStainedGlassPaneLime());
		stained_glass_pane_yellow = registerBlock("stained_glass_pane_yellow", new ChiselBlockStainedGlassPaneYellow());
		stained_glass_pane_light_blue = registerBlock("stained_glass_pane_light_blue", new ChiselBlockStainedGlassPaneLightBlue());
		stained_glass_pane_magenta = registerBlock("stained_glass_pane_magenta", new ChiselBlockStainedGlassPaneMagenta());
		stained_glass_pane_orange = registerBlock("stained_glass_pane_orange", new ChiselBlockStainedGlassPaneOrange());
		stained_glass_pane_white = registerBlock("stained_glass_pane_white", new ChiselBlockStainedGlassPaneWhite());
		steel = registerBlock("steelblock", new ChiselBlockSteel());
		stone_bricks = registerBlock("stone_bricks", new ChiselBlockStoneBricks());
		technical = registerBlock("technical", new ChiselBlockTechnical());
		temple = registerBlock("temple", new ChiselBlockTemple());
		tin = registerBlock("tinblock", new ChiselBlockTin());
		torch = registerBlock("torch", new ChiselBlockCarvableTorch());
		transparent_technical = registerBlock("technical2", new ChiselBlockTransparentTechnical());
		tyrian = registerBlock("tyrian", new ChiselBlockTyrian());
		uranium = registerBlock("uraniumblock", new ChiselBlockUranium());
		valentines = registerBlock("valentines", new ChiselBlockValentines());
		warning = registerBlock("warning", new ChiselBlockWarning());
		woolen_clay = registerBlock("woolen_clay", new ChiselBlockWoolenClay());
	}

	private static Block registerBlock(String name, Block block) {
		return registerBlock(name, ItemBlockCarvable.class, block);
	}

	private static Block registerBlock(String name, Class<? extends ItemBlock> itemClass, Block block) {
		block.setUnlocalizedName("chisel." + name);
		GameRegistry.registerBlock(block, itemClass, name);

		return block;
	}

	private void addVariant(IBlockState state, String groupName) {
		CarvingUtils.chisel.addVariant(groupName, state);
	}

	private static Block createChiselGroup(String unlocalizedName, Block block, Class<? extends ItemBlock> clazz, PropertyVariant propVariant, String groupName, String sound, String oreName) {
		int order = 0;

		Collection<BlockVariant> variants = propVariant.getAllowedValues();
		ICarvingGroup group = new CarvingUtils.CarvingGroup(groupName);
		group.setSound(sound);
		group.setOreName(oreName);

		CarvingUtils.chisel.addGroup(group);
		for(BlockVariant v : variants) {
			order++;
			group.addVariant(new CarvingUtils.CarvingVariant(block, v.getMeta(), order));
		}

		block.setUnlocalizedName(unlocalizedName);
		GameRegistry.registerBlock(block, clazz, unlocalizedName);

		return block;
	}

	private static Block createChiselGroup(String unlocalizedName, Block block, PropertyVariant propVariant, String groupName, String sound, String oreName) {
		return createChiselGroup(unlocalizedName, block, ItemBlockCarvable.class, propVariant, groupName, sound, oreName);
	}
}
