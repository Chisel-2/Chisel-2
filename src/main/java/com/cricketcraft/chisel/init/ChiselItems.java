package com.cricketcraft.chisel.init;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.entity.EntityCloudInABottle;
import com.cricketcraft.chisel.item.ItemCloudInABottle;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(Chisel.MOD_ID)
public final class ChiselItems {
	public static final ItemCloudInABottle cloudInABottle = new ItemCloudInABottle();

	private ChiselItems() {

	}

	public static void init(){
		EntityRegistry.registerModEntity(EntityCloudInABottle.class, "CloudInABottle", 1, Chisel.instance, 40, 1, true);
		GameRegistry.registerItem(cloudInABottle, cloudInABottle.getUnlocalizedName());
	}
}
