package com.cricketcraft.chisel.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.cricketcraft.chisel.client.ModelsChisel;
import com.cricketcraft.chisel.entity.EntityBallOMoss;
import com.cricketcraft.chisel.entity.EntityCloudInABottle;
import com.cricketcraft.chisel.entity.EntitySmashingRock;
import com.cricketcraft.chisel.init.ChiselItems;

public class ClientProxy extends CommonProxy
{

    @Override
    public void preInit()
    {
    }

    @Override
    public void init()
    {
        ModelsChisel.registerModels();

        RenderingRegistry.registerEntityRenderingHandler(EntityCloudInABottle.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ChiselItems.cloudInABottle, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySmashingRock.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ChiselItems.smashing_rock, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBallOMoss.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ChiselItems.ballOMoss, Minecraft.getMinecraft().getRenderItem()));
    }

    @Override
    public EntityPlayer getClientPlayer()
    {
        return Minecraft.getMinecraft().thePlayer;
    }

    @Override
    public World getClientWorld()
    {
        return Minecraft.getMinecraft().theWorld;
    }
}
