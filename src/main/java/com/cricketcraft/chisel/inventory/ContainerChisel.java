package com.cricketcraft.chisel.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerChisel extends Container {
	public final InventoryChiselSelection inventory = null;

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return false;
	}
}
