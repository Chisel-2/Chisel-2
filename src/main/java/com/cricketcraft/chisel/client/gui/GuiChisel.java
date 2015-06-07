package com.cricketcraft.chisel.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class GuiChisel extends GuiContainer{
	public EntityPlayer player;
	public ContainerChisel chisel;

	public GuiChisel(Container container) {
		super(container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

	}
}
