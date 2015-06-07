package com.cricketcraft.chisel.item.chisel;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.api.IChiselItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class ChiselController {
	public static final ChiselController INSTANCE = new ChiselController();

	private long lastTickClick = 0;

	private ChiselController(){

	}

	public void preInit(){
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onInteract(PlayerInteractEvent event){
		ItemStack held = event.entityPlayer.getCurrentEquippedItem();
		int slot = event.entityPlayer.inventory.currentItem;

		if(held == null || !(held.getItem() instanceof IChiselItem)){
			return;
		}

		IChiselItem chisel = (IChiselItem) held.getItem();

		switch (event.action){
		case LEFT_CLICK_BLOCK:
			;
		case RIGHT_CLICK_AIR:
			// Make sure we have not responded this tick
			if (event.world.getTotalWorldTime() == lastTickClick) {
				break;
			} else {
				lastTickClick = event.world.getTotalWorldTime();
			}

			if(!event.world.isRemote && chisel.canOpenGui(event.world, event.entityPlayer, held)){
				event.entityPlayer.openGui(Chisel.instance, 0, event.world, 0, 0, 0);
			}
			break;
		case RIGHT_CLICK_BLOCK:
			// Make sure we have not responded this tick
			if (event.world.getTotalWorldTime() == lastTickClick) {
				break;
			} else {
				lastTickClick = event.world.getTotalWorldTime();
			}

			if(!event.world.isRemote && chisel.canOpenGui(event.world, event.entityPlayer, held)){
				event.entityPlayer.openGui(Chisel.instance, 0, event.world, 0, 0, 0);
			}
			break;
		}
	}
}
