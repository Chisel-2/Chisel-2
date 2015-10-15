package com.cricketcraft.chisel.client.gui;

import codechicken.lib.gui.GuiDraw;
import com.cricketcraft.chisel.api.ICarvable;
import com.cricketcraft.chisel.api.rendering.TextureType;
import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.item.ItemCarvable;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import com.cricketcraft.chisel.api.IAdvancedChisel;
import com.cricketcraft.chisel.api.IChiselItem;
import com.cricketcraft.chisel.api.carving.IChiselMode;
import com.cricketcraft.chisel.inventory.ContainerChisel;
import com.cricketcraft.chisel.inventory.InventoryChiselSelection;
import com.cricketcraft.chisel.inventory.SlotChiselInput;
import com.cricketcraft.chisel.item.chisel.ChiselMode;
import com.cricketcraft.chisel.network.PacketHandler;
import com.cricketcraft.chisel.network.message.MessageChiselMode;
import com.cricketcraft.chisel.utils.General;
import com.cricketcraft.chisel.utils.GeneralClient;

import java.awt.*;

public class GuiChisel extends GuiContainer {

	public EntityPlayer player;
	public ContainerChisel container;
	private IChiselMode currentMode;
	private boolean dead = false;

	public GuiChisel(InventoryPlayer iinventory, InventoryChiselSelection menu) {
		super(new ContainerChisel(iinventory, menu));
		player = iinventory.player;
		xSize = 252;
		ySize = 202;

		container = (ContainerChisel) inventorySlots;
		
		if (player.getCurrentEquippedItem() == null) {
			player.closeScreen();
			dead = true;
		}		
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		inventorySlots.onContainerClosed(player);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		super.initGui();
		currentMode = General.getChiselMode(container.chisel);

		if (showMode()) {
			int x = this.width / 2 - 120;
			int y = this.height / 2 - 6;
			buttonList.add(new GuiButton(0, x, y, 53, 20, ""));
			setButtonText();
		}
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
		ItemStack held = player.getCurrentEquippedItem();
		if (held == null || !(held.getItem() instanceof IChiselItem)) {
			player.closeScreen();
		}

		boolean flag = false;
		/**
		for(int c = 0; c < container.inventory.activeVariations; c++) {
			ItemStack stack = container.inventory.getStackInSlot(c);
			if(stack.getItem() != null) {
				if (stack.getItem() instanceof ItemCarvable) {
					BlockCarvable block = (BlockCarvable) Block.getBlockFromItem(stack.getItem());
					if (block.carverHelper.getVariation(stack.getItemDamage()).getType().equals(TextureType.CTMH)
							|| block.carverHelper.getVariation(stack.getItemDamage()).getType().equals(TextureType.CTMX)
							|| block.carverHelper.getVariation(stack.getItemDamage()).getType().equals(TextureType.CTMV)) {
						flag = true;
					}
				} else if(stack.getItem() instanceof ICarvable) {
					ICarvable block = (ICarvable) Block.getBlockFromItem(stack.getItem());
					if (block.getManager(stack.getItemDamage()).getType().equals(TextureType.CTMH)
							|| block.getManager(stack.getItemDamage()).getType().equals(TextureType.CTMX)
							|| block.getManager(stack.getItemDamage()).getType().equals(TextureType.CTMV)) {
						flag = true;
					}
				}
				if (flag) {
					GuiDraw.drawTexturedModalRect(container.getSlot(c).xDisplayPosition, container.getSlot(c).yDisplayPosition, 48, 202, 18, 18);
				}
			}
		}
		*/
	}

	private void setButtonText() {
		((GuiButton) buttonList.get(0)).displayString = I18n.format(container.inventory.getInventoryName() + ".mode." + currentMode.name().toLowerCase());
	}

	private boolean showMode() {
		if (container.chisel != null && container.chisel.getItem() instanceof IChiselItem) {
			return ((IChiselItem) container.chisel.getItem()).hasModes(container.chisel);
		}
		return false;
	}
	
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		if (!dead) {
			super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int j, int i) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		String line = I18n.format(this.container.inventory.getInventoryName() + ".title");
		fontRendererObj.drawSplitString(line, 50 - fontRendererObj.getStringWidth(line) / 2, 60, 40, 0x404040);

		if (showMode()) {
			line = I18n.format(this.container.inventory.getInventoryName() + ".mode");
			fontRendererObj.drawString(line, fontRendererObj.getStringWidth(line) / 2 + 6, 85, 0x404040);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mx, int my) {
		drawDefaultBackground();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		int i = width - xSize >> 1;
		int j = height - ySize >> 1;

		String texture = "chisel:textures/chisel2Gui.png";

		GeneralClient.bind(texture);
		drawTexturedModalRect(i, j, 0, 0, xSize, ySize);

		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		Slot main = (Slot) container.inventorySlots.get(InventoryChiselSelection.normalSlots);
		if (main.getStack() == null) {
			GuiAutoChisel.drawSlotOverlay(this, x + 14, y + 14, main, 0, ySize, 60);
		}
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		if (button.id == 0) {
			if (container.chisel != null && container.chisel.getItem() instanceof IAdvancedChisel) {
				IAdvancedChisel item = (IAdvancedChisel) container.chisel.getItem();
				currentMode = item.getNextMode(container.chisel, currentMode);
				PacketHandler.INSTANCE.sendToServer(new MessageChiselMode(currentMode));
			} else {
				currentMode = ChiselMode.next(currentMode);
				PacketHandler.INSTANCE.sendToServer(new MessageChiselMode(currentMode));
				setButtonText();
			}
		}
		super.actionPerformed(button);
	}

	@Override
	protected void func_146977_a(Slot slot) {
		if (slot instanceof SlotChiselInput) {
			GL11.glPushMatrix();
			GL11.glScalef(2, 2, 2);
			slot.xDisplayPosition -= 16;
			slot.yDisplayPosition -= 16;
			super.func_146977_a(slot);
			slot.xDisplayPosition += 16;
			slot.yDisplayPosition += 16;
			GL11.glPopMatrix();
		} else {
			super.func_146977_a(slot);
		}
	}
}
