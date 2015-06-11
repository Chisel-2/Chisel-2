package com.cricketcraft.chisel.client;

import java.util.HashMap;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.cricketcraft.chisel.config.Configurations;
import com.cricketcraft.chisel.entity.fx.EntityBallOMossFX;

public class GeneralChiselClient {

	public static Random rand = new Random();

	public static int tick = 0;

	public static void playChiselSound(World world, int x, int y, int z, String sound) {
		Minecraft.getMinecraft().theWorld.playSound(x + 0.5, y + 0.5, z + 0.5, sound, 0.3f + 0.7f * rand.nextFloat(), 0.6f + 0.4f * rand.nextFloat(), true);
	}

	public static void spawnBallOMossFX(World world, double x, double y, double z) {
		if (Configurations.particlesTickrate == 0 || tick++ % Configurations.particlesTickrate == 0 || Minecraft.getMinecraft().gameSettings.particleSetting != 0) {
			EntityBallOMossFX res = new EntityBallOMossFX(world, x, y, z);
			Minecraft.getMinecraft().effectRenderer.addEffect(res);
		}
	}

	static HashMap<String, ResourceLocation> resources = new HashMap<String, ResourceLocation>();

	public static void bind(String textureName) {
		ResourceLocation res = resources.get(textureName);

		if (res == null) {
			res = new ResourceLocation(textureName);
			resources.put(textureName, res);
		}

		Minecraft.getMinecraft().getTextureManager().bindTexture(res);
	}

}
