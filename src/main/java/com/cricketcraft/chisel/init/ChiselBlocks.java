package com.cricketcraft.chisel.init;

import com.cricketcraft.chisel.block.metal.*;
import com.cricketcraft.chisel.block.modded.*;
import com.cricketcraft.chisel.block.other.*;
import com.cricketcraft.chisel.block.other.stained.*;
import com.cricketcraft.chisel.block.other.stained.panes.*;
import com.cricketcraft.chisel.block.stone.*;
import com.cricketcraft.chisel.block.wood.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.item.itemblock.ItemBlockCarvable;
import com.cricketcraft.chisel.item.itemblock.ItemCarvablePumpkin;

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

		acacia = registerBlock("acacia_planks", new BlockAcacia());
		aluminum = registerBlock("aluminumblock", new BlockAluminum());
		andesite = registerBlock("andesite", new BlockAndesite());
		antiblock = registerBlock("antiBlock", new BlockAntiblock());
		birch = registerBlock("birch_planks", new BlockBirch());
		bronze = registerBlock("bronzeblock", new BlockBronze());
		bricks = registerBlock("brickCustom", new BlockBricks());
		bookshelf = registerBlock("bookshelf", new BlockBookshelf());
		carpet = registerBlock("carpet_block", new BlockCarpet());
		carpet_floor = registerBlock("carpet", BlockCarpetFloor());
		chest = registerBlock("chest", new BlockChest());
		cobblestone = registerBlock("cobblestone", new BlockCobblestone());
		concrete = registerBlock("concrete", new BlockConcrete());
		copper = registerBlock("copperblock", new BlockCopper());
		cloud = registerBlock("cloud", new BlockCloud());
		dark_oak = registerBlock("dark_oak_planks", new BlockDarkOak());
		diamond = registerBlock("diamond_block", new BlockDiamond());
		diorite = registerBlock("diorite", new BlockDiorite());
		dirt = registerBlock("dirt", new BlockDirt());
		emerald = registerBlock("emerald_block", new BlockEmerald());
		energised_voidstone = registerBlock("voidstone2", new BlockEnergisedVoidstone());
		energised_voidstone_pillar = registerBlock("voidstonePillar2", new BlockEnergisedVoidstonePillar());
		factory = registerBlock("factoryBlock", new BlockFactory());
		fantasy = registerBlock("fantasyblock2", new BlockFantasy());
		futura = registerBlock("futura", new BlockFutura());
		glass = registerBlock("glass", new BlockGlass());
		glass_pane = registerBlock("glass_pane", new BlockGlassPane());
		glowstone = registerBlock("glowstone", new BlockGlowstone());
		gold = registerBlock("gold_block", new BlockGold());
		granite = registerBlock("granite", new BlockGranite());
		grimstone = registerBlock("grimstone", new BlockGrimstone());
		hex_plating = registerBlock("hex_plating", new BlockHexPlating());
		holystone = registerBlock("holystone", new BlockHolystone());
		ice = registerBlock("ice", new BlockIce());
		ice_pillar = registerBlock("icePillar", new BlockIcePillar());
		imperial = registerBlock("imperial", new BlockImperial());
		industrial = registerBlock("industrial", new BlockIndustrial());
		iron = registerBlock("iron_block", new BlockIron());
		iron_bars = registerBlock("iron_bars", new BlockIronBars());
		jungle = registerBlock("jungle_planks", new BlockJungle());
		laboratory = registerBlock("laboratory", new BlockLaboratory());
		lapis = registerBlock("lapis_block", new BlockLapis());
		large_hex_plating = registerBlock("large_hex_plating", new BlockHexPlatingLarge());
		lavastone = registerBlock("lavastone", new BlockLavastone());
		lead = registerBlock("leadblock", new BlockLead());
		leaf = registerBlock("leaf", new BlockLeaves());
		limestone = registerBlock("limestone", new BlockLimestone());
		litpumpkin = registerBlock("litpumpkin", ItemCarvablePumpkin.class, new BlockJackolantern());
		marble = registerBlock("marble", new BlockMarble());
		mossy_cobblestone = registerBlock("mossy_cobblestone", new BlockMossyCobblestone());
		mossy_temple = registerBlock("mossy_temple", new BlockMossyTemple());
		netherbrick = registerBlock("netherbrick", new BlockNetherBrick());
		netherrack = registerBlock("netherrack", new BlockNetherrack());
		oak = registerBlock("oak_planks", new BlockOak());
		obsidian = registerBlock("obsidian", new BlockObsidian());
		packed_ice = registerBlock("packed_ice", new BlockPackedIce());
		packed_ice_pillar = registerBlock("packed_ice_pillar", new BlockPackedIcePillar());
		paperwall = registerBlock("paperwall", new BlockPaperWallPane());
		paperwall_block = registerBlock("paperwall_block", new BlockPaperWall());
		pumpkin = registerBlock("pumpkin", ItemCarvablePumpkin.class, new BlockPumpkin());
		purple_fantasy = registerBlock("fantasy", new BlockFantasyPurple());
		rebel = registerBlock("rebel", new BlockRebel());
		redstone = registerBlock("redstone_block", new BlockRedstone());
		road_line = registerBlock("road_line", new BlockRoadline());
		runic_voidstone = registerBlock("runic_voidstone", new BlockRunicVoidstone());
		sandstone = registerBlock("sandstone", new BlockSandstone());
		sandstone_scribbles = registerBlock("sandstone_scribbles", new BlockSandstoneScribbles());
		silver = registerBlock("silverblock", new BlockSilver());
		snakestone_sand = registerBlock("snakestone_sand", new BlockSnakestoneSand());
		snakestone_stone = registerBlock("snakestone_stone", new BlockSnakestoneStone());
		spruce = registerBlock("spruce_planks", new BlockSpruce());
		stained_glass_black = registerBlock("stained_glass_black", new BlockStainedGlassBlack());
		stained_glass_red = registerBlock("stained_glass_red", new BlockStainedGlassRed());
		stained_glass_green = registerBlock("stained_glass_green", new BlockStainedGlassGreen());
		stained_glass_brown = registerBlock("stained_glass_brown", new BlockStainedGlassBrown());
		stained_glass_blue = registerBlock("stained_glass_blue", new BlockStainedGlassBlue());
		stained_glass_purple = registerBlock("stained_glass_purple", new BlockStainedGlassPurple());
		stained_glass_cyan = registerBlock("stained_glass_cyan", new BlockStainedGlassCyan());
		stained_glass_light_gray = registerBlock("stained_glass_light_gray", new BlockStainedGlassLightGray());
		stained_glass_gray = registerBlock("stained_glass_gray", new BlockStainedGlassGray());
		stained_glass_pink = registerBlock("stained_glass_pink", new BlockStainedGlassPink());
		stained_glass_lime = registerBlock("stained_glass_lime", new BlockStainedGlassLime());
		stained_glass_yellow = registerBlock("stained_glass_yellow", new BlockStainedGlassYellow());
		stained_glass_light_blue = registerBlock("stained_glass_light_blue", new BlockStainedGlassLightBlue());
		stained_glass_magenta = registerBlock("stained_glass_magenta", new BlockStainedGlassMagenta());
		stained_glass_orange = registerBlock("stained_glass_orange", new BlockStainedGlassOrange());
		stained_glass_white = registerBlock("stained_glass_white", new BlockStainedGlassWhite());
		stained_glass_pane_black = registerBlock("stained_glass_pane_black", new BlockStainedGlassPaneBlack());
		stained_glass_pane_red = registerBlock("stained_glass_pane_red", new BlockStainedGlassPaneRed());
		stained_glass_pane_green = registerBlock("stained_glass_pane_green", new BlockStainedGlassPaneGreen());
		stained_glass_pane_brown = registerBlock("stained_glass_pane_brown", new BlockStainedGlassPaneBrown());
		stained_glass_pane_blue = registerBlock("stained_glass_pane_blue", new BlockStainedGlassPaneBlue());
		stained_glass_pane_purple = registerBlock("stained_glass_pane_purple", new BlockStainedGlassPanePurple());
		stained_glass_pane_cyan = registerBlock("stained_glass_pane_cyan", new BlockStainedGlassPaneCyan());
		stained_glass_pane_light_gray = registerBlock("stained_glass_pane_light_gray", new BlockStainedGlassPaneLightGray());
		stained_glass_pane_gray = registerBlock("stained_glass_pane_gray", new BlockStainedGlassPaneGray());
		stained_glass_pane_pink = registerBlock("stained_glass_pane_pink", new BlockStainedGlassPanePink());
		stained_glass_pane_lime = registerBlock("stained_glass_pane_lime", new BlockStainedGlassPaneLime());
		stained_glass_pane_yellow = registerBlock("stained_glass_pane_yellow", new BlockStainedGlassPaneYellow());
		stained_glass_pane_light_blue = registerBlock("stained_glass_pane_light_blue", new BlockStainedGlassPaneLightBlue());
		stained_glass_pane_magenta = registerBlock("stained_glass_pane_magenta", new BlockStainedGlassPaneMagenta());
		stained_glass_pane_orange = registerBlock("stained_glass_pane_orange", new BlockStainedGlassPaneOrange());
		stained_glass_pane_white = registerBlock("stained_glass_pane_white", new BlockStainedGlassPaneWhite());
		steel = registerBlock("steelblock", new BlockSteel());
		stone_bricks = registerBlock("stone_bricks", new BlockStoneBricks());
		technical = registerBlock("technical", new BlockTechnical());
		temple = registerBlock("temple", new BlockTemple());
		tin = registerBlock("tinblock", new BlockTin());
		torch = registerBlock("torch", new BlockTorch());
		transparent_technical = registerBlock("technical2", new BlockTransparentTechnical());
		tyrian = registerBlock("tyrian", new BlockTyrian());
		uranium = registerBlock("uraniumblock", new BlockUranium());
		valentines = registerBlock("valentines", new BlockValentines());
		warning = registerBlock("warning", new BlockWarning());
		woolen_clay = registerBlock("woolen_clay", new BlockWoolenClay());
	}

	private static Block registerBlock(String name, Block block) {
		return registerBlock(name, ItemBlockCarvable.class, block);
	}

	private static Block registerBlock(String name, Class<? extends ItemBlock> itemClass, Block block) {
		block.setUnlocalizedName("chisel." + name);
		GameRegistry.registerBlock(block, itemClass, name);

		return block;
	}
}
