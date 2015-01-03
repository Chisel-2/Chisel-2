package com.cricketcraft.chisel.item;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.api.ChiselMode;
import com.cricketcraft.chisel.api.IChiselMode;
import com.cricketcraft.chisel.carving.Carving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemChisel extends Item implements IChiselMode {
    public static Carving carving = Carving.chisel;

    public ItemChisel() {
        super();
        setMaxStackSize(1);
        setUnlocalizedName("chisel");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        entityplayer.openGui(Chisel.instance, 0, world, 0, 0, 0);

        return itemstack;
    }

    @Override
    public ChiselMode getChiselMode(ItemStack itemStack) {
        return ChiselMode.SINGLE;
    }

    @Override
      public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4){
        StatCollector.translateToLocal("item.chisel.desc");
    }
}
