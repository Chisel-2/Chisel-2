package com.cricketcraft.chisel.network;

import com.cricketcraft.chisel.client.gui.GuiChisel;
import com.cricketcraft.chisel.inventory.ContainerChisel;
import com.cricketcraft.chisel.inventory.InventoryChiselSelection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ChiselGuiHandler implements IGuiHandler{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID){
		case 0:
			return new ContainerChisel(player.inventory, new InventoryChiselSelection(player.getCurrentEquippedItem()));
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID){
		case 0:
			return new GuiChisel(player.inventory, new InventoryChiselSelection(player.getCurrentEquippedItem()));
		default:
			return null;
		}
	}
}
