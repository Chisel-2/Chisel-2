package com.cricketcraft.chisel.init;

import com.cricketcraft.chisel.block.modded.BlockAluminum;
import com.cricketcraft.chisel.block.modded.BlockBronze;
import com.cricketcraft.chisel.block.other.*;
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

		cloud = registerBlock("cloud", new BlockCloud());
		pumpkin = registerBlock("pumpkin", ItemCarvablePumpkin.class, new BlockPumpkin());
		litpumpkin = registerBlock("litpumpkin", ItemCarvablePumpkin.class, new BlockJackolantern());
		marble = registerBlock("marble", new BlockMarble());
		limestone = registerBlock("limestone", new BlockLimestone());
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
