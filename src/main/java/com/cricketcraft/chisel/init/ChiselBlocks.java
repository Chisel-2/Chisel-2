package com.cricketcraft.chisel.init;

import com.cricketcraft.chisel.block.metal.*;
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
			pumpkin,
			jackolantern,
			marble,
			limestone;

	public static void preInit() {

		acacia = registerBlock("acacia_planks", ItemBlockCarvable.class, new BlockAcacia());
		aluminum = registerBlock("aluminumblock", ItemBlockCarvable.class, new BlockAluminum());
		andesite = registerBlock("andesite", ItemBlockCarvable.class, new BlockAndesite());
		antiblock = registerBlock("antiBlock", ItemBlockCarvable.class, new BlockAntiblock());
		birch = registerBlock("birch_planks", ItemBlockCarvable.class, new BlockBirch());
		bronze = registerBlock("bronzeblock", ItemBlockCarvable.class, new BlockBronze());
		bricks = registerBlock("brickCustom", ItemBlockCarvable.class, new BlockBricks());
		bookshelf = registerBlock("bookshelf", ItemBlockCarvable.class, new BlockBookshelf());

		cloud = registerBlock("cloud", ItemBlockCarvable.class, new BlockCloud());
		pumpkin = registerBlock("pumpkin", ItemCarvablePumpkin.class, new BlockCarvablePumpkin());
		jackolantern = registerBlock("litpumpkin", ItemCarvablePumpkin.class, new BlockJackolantern());
		marble = registerBlock("marble", ItemBlockCarvable.class, new BlockMarble());
		limestone = registerBlock("limestone", ItemBlockCarvable.class, new BlockLimestone());
	}

	private static Block registerBlock(String name, Block block) {
		return registerBlock(name, ItemBlock.class, block);
	}

	private static Block registerBlock(String name, Class<? extends ItemBlock> itemClass, Block block) {
		block.setUnlocalizedName("chisel." + name);
		GameRegistry.registerBlock(block, itemClass, name);

		return block;
	}
}
