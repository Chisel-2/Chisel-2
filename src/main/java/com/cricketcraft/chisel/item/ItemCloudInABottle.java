package com.cricketcraft.chisel.item;

import com.cricketcraft.chisel.entity.EntityCloudInABottle;
import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCloudInABottle extends BaseItem{
    public ItemCloudInABottle(){
        super();
        setCreativeTab(ChiselTabs.tabChisel);
        setUnlocalizedName("cloudBottle");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
        if(!player.capabilities.isCreativeMode){
            --stack.stackSize;
        }

        if(world.isRemote){
            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        }

        if(!world.isRemote){
            world.spawnEntityInWorld(new EntityCloudInABottle(world, player));
        }

        return stack;
    }
}
