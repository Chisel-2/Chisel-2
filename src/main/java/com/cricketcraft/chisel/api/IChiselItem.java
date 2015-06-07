package com.cricketcraft.chisel.api;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * Implement this on items which can be used to chisel blocks
 */
public interface IChiselItem
{

	/**
	 * Checks whether the chisel can have its GUI opened
	 *
	 * @param world
	 * 			{@link World} object
	 * @param player
	 * 			{@link EntityPlayer} The player holding the chisel. it can always be assumed that the player's current item will be this.
	 * @param chisel
	 * 			The {@link ItemStack} representing the chisel
	 * @return True if the GUI should open, False otherwises
	 */
	boolean canOpenGui(World world, EntityPlayer player, ItemStack chisel);

	/**
	 * Allows you to control if your item has chiseling modes.
	 *
	 * @param chisel
	 *            The {@link ItemStack} representing the chisel.
	 * @return True if the chisel supports modes. False otherwise.
	 */
	boolean hasModes(ItemStack chisel);

	/**
	 * Allows you to control if your item can chisel this block in the world.
	 *
	 * @param world
	 *            World object
	 * @param player
	 *            {@link EntityPlayer The player} holding the chisel.
	 * @param pos
	 * 			  The position the block is at.
	 * @param block
	 *            The {@link Block} being chiseled
	 * @param metadata
	 *            The blocks' metadata
	 * @return True if the chiseling should take place. False otherwise.
	 */
	boolean canChiselBlock(World world, EntityPlayer player, BlockPos pos, Block block, int metadata);
}
