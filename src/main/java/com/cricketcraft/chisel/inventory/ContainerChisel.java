package com.cricketcraft.chisel.inventory;

import com.cricketcraft.chisel.inventory.slot.SlotChiselInput;
import com.cricketcraft.chisel.inventory.slot.SlotChiselSelection;
import com.cricketcraft.chisel.item.chisel.ItemChisel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerChisel extends Container {
	public final InventoryChiselSelection inventory;
	public InventoryPlayer playerInventory;
	int chiselSlot;
	public ItemStack chisel;
	public boolean finished;

	public ContainerChisel(InventoryPlayer invPlayer, InventoryChiselSelection inventory){
		this.playerInventory = invPlayer;
		this.inventory = inventory;
		chiselSlot = playerInventory.currentItem;
		inventory.container = this;

		int top = 8, left = 62;

		for(int c = 0; c < InventoryChiselSelection.normalSlots; c++){
			addSlotToContainer(new SlotChiselSelection(this, inventory, inventory, c, left + ((c % 10) * 18), top + ((c / 10) * 18)));
		}

		addSlotToContainer(new SlotChiselInput(this, inventory, InventoryChiselSelection.normalSlots, 24, 24));

		top += 112;
		left += 9;
		for (int i = 0; i < 27; i++) {
			addSlotToContainer(new Slot(invPlayer, i + 9, left + ((i % 9) * 18), top + (i / 9) * 18));
		}

		top += 58;
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(invPlayer, i, left + ((i % 9) * 18), top + (i / 9) * 18));
		}

		chisel = invPlayer.getCurrentItem();
		if (chisel != null && chisel.getTagCompound() != null) {
			ItemStack stack = ItemStack.loadItemStackFromNBT(chisel.getTagCompound().getCompoundTag("chiselTarget"));
			inventory.setInventorySlotContents(InventoryChiselSelection.normalSlots, stack);
		}

		inventory.updateItems();
	}

	@Override
	public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer par4EntityPlayer) {
		// we need to subtract away all the other slots
		int clickedSlot = par1 - inventory.getSizeInventory() - 27;

		// if the player has clicked on the chisel or is trying to use a number key to force an itemstack into the slot the chisel is in
		if (clickedSlot == chiselSlot || (par3 == 2 && par2 == chiselSlot))
			return null;

		return super.slotClick(par1, par2, par3, par4EntityPlayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entity, int slotIdx) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotIdx);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (slotIdx > InventoryChiselSelection.normalSlots) {
				if (!this.mergeItemStack(itemstack1, InventoryChiselSelection.normalSlots, InventoryChiselSelection.normalSlots + 1, false)) {
					return null;
				}
			} else {
				if (slotIdx < InventoryChiselSelection.normalSlots + 1 && itemstack1 != null) {
					entity.inventory.setItemStack(itemstack1.copy());
					slot.onPickupFromSlot(entity, itemstack1);
					itemstack1 = entity.inventory.getItemStack();
					entity.inventory.setItemStack(null);
				}

				if (!this.mergeItemStack(itemstack1, InventoryChiselSelection.normalSlots + 1, InventoryChiselSelection.normalSlots + 1 + 36, false)) {
					return null;
				}
			}
			slot.onSlotChange(itemstack1, itemstack);

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}
			if (slotIdx >= InventoryChiselSelection.normalSlots) {
				slot.onPickupFromSlot(entity, itemstack1);
			}
			if (itemstack1.stackSize == 0) {
				slot.putStack(null);
				return null;
			}
		}
		return itemstack;
	}

	@Override
	public void onContainerClosed(EntityPlayer entityplayer) {
		inventory.clear();
		super.onContainerClosed(entityplayer);
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return inventory.isUseableByPlayer(entityplayer);
	}

	public void onChiselSlotChanged() {
		ItemStack stack = playerInventory.mainInventory[chiselSlot];
		if (stack == null || !stack.isItemEqual(chisel))
			finished = true;

		if (finished)
			return;

		playerInventory.mainInventory[chiselSlot] = chisel;
	}
}
