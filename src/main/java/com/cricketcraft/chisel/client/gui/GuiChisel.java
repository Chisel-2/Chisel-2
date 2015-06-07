package com.cricketcraft.chisel.client.gui;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.api.IChiselItem;
import com.cricketcraft.chisel.inventory.InventoryChiselSelection;
import com.cricketcraft.chisel.inventory.slot.SlotChiselInput;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

import com.cricketcraft.chisel.inventory.ContainerChisel;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiChisel extends GuiContainer {
	public EntityPlayer player;

	public ContainerChisel chisel;

	public GuiChisel(InventoryPlayer inventoryPlayer, InventoryChiselSelection selection) {
		super(new ContainerChisel(inventoryPlayer, selection));
		player = inventoryPlayer.player;
		xSize = 252;
		ySize = 202;

		chisel = (ContainerChisel)inventorySlots;
	}

	@Override
	public void onGuiClosed(){
		super.onGuiClosed();
		inventorySlots.onContainerClosed(player);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui(){
		super.initGui();

		if(showMode()){
			int x = this.width / 2 - 120;
			int y = this.height / 2 - 6;
			buttonList.add(new GuiButton(0, x, y, 53, 20, ""));
			setButtonText();
		}
	}

	@Override
	public void updateScreen(){
		super.updateScreen();
		ItemStack held = player.getCurrentEquippedItem();
		if (held == null || !(held.getItem() instanceof IChiselItem)) {
			mc.displayGuiScreen(null);
		}
	}

	private void setButtonText(){
		((GuiButton)buttonList.get(0)).displayString = I18n.format(chisel.inventory.getCommandSenderName()+ ".mode.");// + currentMode.name().toLowerCase();
	}

	private boolean showMode(){
		if(chisel.chisel != null && chisel.chisel.getItem() instanceof IChiselItem){
			return ((IChiselItem)chisel.chisel.getItem()).hasModes(chisel.chisel);
		}
		return false;
	}

	@Override
	protected void actionPerformed(GuiButton button) {

	}

	@Override
	protected void drawSlot(Slot slot) {
		if (slot instanceof SlotChiselInput) {
			GL11.glPushMatrix();
			GL11.glScalef(2, 2, 2);
			slot.xDisplayPosition -= 16;
			slot.yDisplayPosition -= 16;
			super.drawSlot(slot);
			slot.xDisplayPosition += 16;
			slot.yDisplayPosition += 16;
			GL11.glPopMatrix();
		} else {
			super.drawSlot(slot);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		drawDefaultBackground();
		int x = xSize >> 1;
		int y = ySize >> 1;

		this.mc.renderEngine.bindTexture(new ResourceLocation(Chisel.MOD_ID, "textures/chisel2Gui.png"));
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

		int x1 = (width - xSize) / 2;
		int y1 = (height - ySize) / 2;

		Slot main = (Slot)chisel.inventorySlots.get(InventoryChiselSelection.normalSlots);
		if(main.getStack() == null){
			//TODO: Will draw an overlay later on
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y){
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		String line = I18n.format(chisel.inventory.getCommandSenderName() + ".title");
		fontRendererObj.drawSplitString(line, 50 - fontRendererObj.getStringWidth(line) / 2, 60, 40, 0x404040);

		if(showMode()){
			line = I18n.format(chisel.inventory.getCommandSenderName() + ".mode");
			fontRendererObj.drawString(line, fontRendererObj.getStringWidth(line) / 2 + 6, 85, 0x404040);
		}
	}
}
