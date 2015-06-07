package com.cricketcraft.chisel.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.entity.EntityBallOMoss;
import com.cricketcraft.chisel.entity.EntityCloudInABottle;
import com.cricketcraft.chisel.entity.EntitySmashingRock;
import com.cricketcraft.chisel.item.ItemBallOMoss;
import com.cricketcraft.chisel.item.ItemCloudInABottle;
import com.cricketcraft.chisel.item.ItemSmashingRock;
import com.cricketcraft.chisel.item.ItemUpgrade;
import com.cricketcraft.chisel.item.chisel.ItemChisel;

@ObjectHolder(Chisel.MOD_ID)
public final class ChiselItems {
	public static Item cloudInABottle, smashing_rock, ballOMoss, upgrade;

	public static ItemChisel chisel, diamondChisel, obsidianChisel;

	public static void preInit() {
		cloudInABottle = registerItem("cloudBottle", new ItemCloudInABottle());
		smashing_rock = registerItem("smashingRock", new ItemSmashingRock());
		ballOMoss = registerItem("ballMoss", new ItemBallOMoss());
		upgrade = registerItem("upgrade", new ItemUpgrade());

		chisel = new ItemChisel(ItemChisel.ChiselType.IRON);
		diamondChisel = new ItemChisel(ItemChisel.ChiselType.DIAMOND);
		obsidianChisel = new ItemChisel(ItemChisel.ChiselType.OBSIDIAN);
		GameRegistry.registerItem(chisel, "chisel");
		GameRegistry.registerItem(diamondChisel, "diamondChisel");
		GameRegistry.registerItem(obsidianChisel, "obsidianChisel");
	}

	public static void init() {
		EntityRegistry.registerModEntity(EntityCloudInABottle.class, "CloudInABottle", 1, Chisel.instance, 40, 1, true);
		EntityRegistry.registerModEntity(EntitySmashingRock.class, "SmashingRock", 3, Chisel.instance, 40, 1, true);
		EntityRegistry.registerModEntity(EntityBallOMoss.class, "BallOMoss", 2, Chisel.instance, 40, 1, true);
	}

	private static Item registerItem(String name, Item item) {
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name);

		return item;
	}
}
