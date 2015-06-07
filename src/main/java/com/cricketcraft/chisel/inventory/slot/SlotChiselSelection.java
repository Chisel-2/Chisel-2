package com.cricketcraft.chisel.inventory.slot;

import com.cricketcraft.chisel.api.IChiselItem;
import com.cricketcraft.chisel.inventory.ContainerChisel;
import com.cricketcraft.chisel.inventory.InventoryChiselSelection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotChiselSelection extends Slot {
	private final ContainerChisel container;
	private final InventoryChiselSelection selection;

	public SlotChiselSelection(ContainerChisel container, InventoryChiselSelection selection, IInventory inventory, int index, int xPosition, int yPosition) {
		super(inventory, index, xPosition, yPosition);
		this.container = container;
		this.selection = selection;
	}

	@Override
	public boolean isItemValid(ItemStack stack){
		return false;
	}

	@Override
	public boolean canTakeStack(EntityPlayer player){
		if(container.finished){
			return false;
		}

		return player.inventory.getItemStack() == null;
	}

	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack stack){
		ItemStack heldStack = player.inventory.getItemStack();
		ItemStack crafted = selection.inventory[InventoryChiselSelection.normalSlots];

		if (heldStack == null) {
			selection.decrStackSize(InventoryChiselSelection.normalSlots, 1);
		} else {
			putStack(stack.copy());

			player.inventory.setItemStack(null);

			if (selection.inventory[InventoryChiselSelection.normalSlots] == null)
				return;

			player.inventory.setItemStack(new ItemStack(stack.getItem(), selection.inventory[InventoryChiselSelection.normalSlots].stackSize, stack.getItemDamage()));
			selection.setInventorySlotContents(InventoryChiselSelection.normalSlots, null);
		}

		selection.updateItems();
	}
}
