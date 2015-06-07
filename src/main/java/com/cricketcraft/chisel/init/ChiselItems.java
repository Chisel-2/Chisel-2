package com.cricketcraft.chisel.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.entity.EntityCloudInABottle;
import com.cricketcraft.chisel.item.ItemCloudInABottle;

@ObjectHolder(Chisel.MOD_ID)
public final class ChiselItems
{
	public static Item cloudInABottle;

	public static void preInit()
	{
		cloudInABottle = registerItem("cloudBottle", new ItemCloudInABottle());
	}

	public static void init()
	{
		EntityRegistry.registerModEntity(EntityCloudInABottle.class, "CloudInABottle", 1, Chisel.instance, 40, 1, true);
	}

	private static Item registerItem(String name, Item item)
	{
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name);

		return item;
	}
}
