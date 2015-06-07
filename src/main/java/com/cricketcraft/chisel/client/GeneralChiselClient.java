package com.cricketcraft.chisel.client;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

import com.cricketcraft.chisel.config.Configurations;
import com.cricketcraft.chisel.entity.fx.EntityBallOMossFX;

public class GeneralChiselClient
{
    public static Random rand = new Random();

    public static int tick = 0;

    public static void spawnBallOMossFX(World world, double x, double y, double z)
    {
        if (Configurations.particlesTickrate == 0 || tick++ % Configurations.particlesTickrate == 0 || Minecraft.getMinecraft().gameSettings.particleSetting != 0)
        {
            EntityBallOMossFX res = new EntityBallOMossFX(world, x, y, z);
            Minecraft.getMinecraft().effectRenderer.addEffect(res);
        }
    }

}
