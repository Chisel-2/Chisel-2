package com.cricketcraft.chisel.item;

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemBlockCarvable extends ItemBlock
{
	public ItemBlockCarvable(Block block)
	{
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		getWrappedDesc(list, stack);
	}

	public static void getWrappedDesc(List<String> list, ItemStack stack)
	{
		String[] wrappedDesc;
		wrappedDesc = wrap(StatCollector.translateToLocal(stack.getUnlocalizedName().replace("chisel.", "") + "." + stack.getItemDamage() + ".desc"), 35);
		for (String element : wrappedDesc)
		{
			list.add(element.trim());
		}
	}

	public static String[] wrap(String input, int length)
	{
		// If there is no string return null
		if (input == null)
		{
			return new String[] {};
		}

		// If there is nothing there to read return input
		if (length <= 0)
		{
			return new String[] { input };
		}

		// If the input is less then the length to return then return the input
		if (input.length() <= length)
		{
			return new String[] { input };
		}

		char[] chars = input.toCharArray();
		Vector<String> lines = new Vector<String>();
		StringBuffer line = new StringBuffer();
		StringBuffer word = new StringBuffer();

		for (char c : chars)
		{
			word.append(c);

			if (c == ' ')
			{
				if ((line.length() + word.length()) > length)
				{
					lines.add(line.toString());
					line.delete(0, line.length());
				}

				line.append(word);
				word.delete(0, word.length());
			}
		}

		// if there is any extra chars
		if (word.length() > 0)
		{
			if ((line.length() + word.length() > length))
			{
				lines.add(line.toString());
				line.delete(0, line.length());
			}

			line.append(word);
		}

		// handle an extra line
		if (line.length() > 0)
		{
			lines.add(line.toString());
		}

		String[] ret = new String[lines.size()];
		int c = 0;

		for (Enumeration<String> e = lines.elements(); e.hasMoreElements(); c++)
		{
			ret[c] = e.nextElement();
		}

		return ret;
	}
}
