package com.cricketcraft.chisel.block;

import com.cricketcraft.chisel.init.ChiselTabs;
import com.cricketcraft.chisel.util.Feature;
import com.cricketcraft.chisel.util.IBlockWithSubtypes;
import com.cricketcraft.chisel.util.PropertyVariant;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCloud extends BlockCarvable implements IBlockWithSubtypes {

    public BlockCloud(Feature feature) {
        super(Material.ice, feature);
        setHardness(0.2F);
        setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
        setLightOpacity(3);
        setStepSound(Block.soundTypeCloth);
        useNeighborBrightness = true;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity){
        entity.fallDistance = 0.0F;

        if (entity.motionY < 0.0D) {
            entity.motionY *= 0.0050000000000000001D;
        } else if (entity.motionY > 0) {
            entity.motionY += 0.0285;
        }
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

    @Override
    public boolean isFullCube(){
        return false;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer(){
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, BlockPos pos, EnumFacing side){
        Block block = world.getBlockState(pos).getBlock();
        if(block == this){
            return false;
        }

        return super.shouldSideBeRendered(world, pos, side);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state){
        return AxisAlignedBB.fromBounds(pos.getX() + 0.2, pos.getY(), pos.getZ() + 0.2, pos.getX() + 0.8, pos.getY() + 0.2, pos.getZ() + 0.8);
    }
}
