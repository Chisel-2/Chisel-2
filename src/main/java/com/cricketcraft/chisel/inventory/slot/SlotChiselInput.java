package com.cricketcraft.chisel.inventory.slot;

import com.cricketcraft.chisel.inventory.ContainerChisel;
import com.cricketcraft.chisel.inventory.InventoryChiselSelection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotChiselInput extends Slot {

	private final ContainerChisel container;
	private final InventoryChiselSelection selection;

	public SlotChiselInput(ContainerChisel container, InventoryChiselSelection selection, int index, int xPos, int yPos){
		super(selection, index, xPos, yPos);
		this.container = container;
		this.selection = selection;
	}

	@Override
	public boolean isItemValid(ItemStack stack){
		if(container.finished){
			return true;
		}

		return super.isItemValid(stack);
	}

	@Override
	public boolean canTakeStack(EntityPlayer player){
		return !container.finished && super.canTakeStack(player);
	}

	@Override
	public void onSlotChanged(){
		if(container.finished){
			return;
		}

		super.onSlotChanged();
		selection.updateItems();
	}
}
