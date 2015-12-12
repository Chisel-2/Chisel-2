package com.cricketcraft.chisel.inventory;

import com.cricketcraft.chisel.item.chisel.ItemChisel;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IChatComponent;

public class InventoryChiselSelection implements IInventory {

	ItemStack chisel = null;
	public static final int normalSlots = 60;
	public int activeVariations;
	ContainerChisel container;
	public ItemStack[] inventory;

	public InventoryChiselSelection(ItemStack stack){
		super();
		inventory = new ItemStack[normalSlots + 1];
		chisel = stack;
	}

	public void updateItems(){
		ItemStack chiseledItem = inventory[normalSlots];
		clear();
		if(chiseledItem == null){
			container.onChiselSlotChanged();
			return;
		}
	}

	public void onInventoryUpdate(int slot){

	}

	@Override
	public int getSizeInventory() {
		return normalSlots + 1;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if(this.inventory[index] != null){
			ItemStack stack;
			if(this.inventory[index].stackSize <= count){
				stack = this.inventory[index];
				this.inventory[index] = null;
				onInventoryUpdate(index);
				return stack;
			} else {
				stack = this.inventory[index].splitStack(count);

				if(this.inventory[index].stackSize == 0)
					this.inventory[index] = null;

				onInventoryUpdate(index);
				return stack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return null;
	}

	public ItemStack getStackInSlotOnClosing(int index) {
		ItemStack stack = getStackInSlot(index);

		if (stack == null)
			return null;
		inventory[index] = null;

		onInventoryUpdate(index);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		inventory[index] = stack;
		onInventoryUpdate(index);
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {

	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {

	}

	@Override
	public void closeInventory(EntityPlayer player) {

	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if(stack.getItem() instanceof ItemTool){
			return false;
		}

		return !(stack != null && (stack.getItem() instanceof ItemChisel)) && index == normalSlots;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {

	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		activeVariations = 0;
		for(int index = 0; index < normalSlots; index++){
			inventory[index] = null;
		}
	}

	public String getCommandSenderName() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public IChatComponent getDisplayName() {
		return null;
	}
}
