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

@ObjectHolder(Chisel.MOD_ID)
public final class ChiselItems {
	public static Item cloudInABottle, smashing_rock, ballOMoss;

	public static void preInit() {
		cloudInABottle = registerItem("cloudBottle", new ItemCloudInABottle());
		smashing_rock = registerItem("smashingRock", new ItemSmashingRock());
		ballOMoss = registerItem("ballMoss", new ItemBallOMoss());
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
