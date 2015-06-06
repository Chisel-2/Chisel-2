package com.cricketcraft.chisel.proxy;

import com.cricketcraft.chisel.client.ModelChisel;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {

	private ModelChisel modelChisel = new ModelChisel();

	@Override
	public void preInit() {
	}

	@Override
	public void init() {
		modelChisel.registerModels();
	}

	@Override
	public EntityPlayer getClientPlayer() {
		return Minecraft.getMinecraft().thePlayer;
	}

	@Override
	public World getClientWorld() {
		return Minecraft.getMinecraft().theWorld;
	}
}
