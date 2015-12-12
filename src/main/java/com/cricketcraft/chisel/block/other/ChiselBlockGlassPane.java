package com.cricketcraft.chisel.block.other;

import com.cricketcraft.chisel.init.ChiselProperties;
import com.cricketcraft.chisel.init.ChiselTabs;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IChiselBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ChiselBlockGlassPane extends Block implements IChiselBlock {

    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");

    public ChiselBlockGlassPane() {
        super(Material.glass);
        setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
        setDefaultState(this.getBlockState().getBaseState().withProperty(ChiselProperties.GLASS_PANE_VARIANTS, ChiselProperties.GLASS_PANE_VARIANTS.fromMeta(0)));
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @Override
    public void addCollisionBoxesToList(World world, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity) {
        boolean connectingNorth = this.canPaneConnectTo(world, pos, EnumFacing.NORTH);
        boolean connectingSouth = this.canPaneConnectTo(world, pos, EnumFacing.SOUTH);
        boolean connectingWest = this.canPaneConnectTo(world, pos, EnumFacing.WEST);
        boolean connectingEast = this.canPaneConnectTo(world, pos, EnumFacing.EAST);

        if((!connectingWest || !connectingEast) && (connectingWest || connectingEast || connectingNorth || connectingSouth)) {
            if(connectingWest) {
                setBlockBounds(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
                super.addCollisionBoxesToList(world, pos, state, mask, list, collidingEntity);
            } else if(connectingEast) {
                setBlockBounds(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
                super.addCollisionBoxesToList(world, pos, state, mask, list, collidingEntity);
            }
        } else {
            setBlockBounds(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.addCollisionBoxesToList(world, pos, state, mask, list, collidingEntity);
        }

        if((!connectingNorth || !connectingSouth) && (connectingWest || connectingEast || connectingNorth || connectingSouth)) {
            if(connectingNorth) {
                setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
                super.addCollisionBoxesToList(world, pos, state, mask, list, collidingEntity);
            } else if(connectingSouth) {
                setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
                super.addCollisionBoxesToList(world, pos, state, mask, list, collidingEntity);
            }
        } else {
            setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
            super.addCollisionBoxesToList(world, pos, state, mask, list, collidingEntity);
        }
    }

    @Override
    public void setBlockBoundsForItemRender() {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos) {
        float magicNumber = 0.4375F;
        float magicNumber1 = 0.5625F;
        float magicNumber2 = 0.4375F;
        float magicNumber3 = 0.5625F;

        boolean connectsNorth = canPaneConnectToBlock(world.getBlockState(pos.north()).getBlock());
        boolean connectsSouth = canPaneConnectToBlock(world.getBlockState(pos.south()).getBlock());
        boolean connectsWest = canPaneConnectToBlock(world.getBlockState(pos.west()).getBlock());
        boolean connectsEast = canPaneConnectToBlock(world.getBlockState(pos.east()).getBlock());

        if((!connectsWest || !connectsEast) && (connectsWest || connectsEast || connectsNorth || connectsSouth)) {
            if(connectsWest) {
                magicNumber = 0.0F;
            } else if(connectsEast) {
                magicNumber1 = 1.0F;
            }
        } else {
            magicNumber = 0.0F;
            magicNumber1 = 1.0F;
        }

        if((!connectsNorth || !connectsSouth) && (connectsWest || connectsEast || connectsNorth || connectsSouth)) {
            if(connectsNorth) {
                magicNumber2 = 0.0F;
            } else if(connectsSouth) {
                magicNumber3 = 1.0F;
            }
        } else {
            magicNumber2 = 0.0F;
            magicNumber3 = 1.0F;
        }

        setBlockBounds(magicNumber, 0.0F, magicNumber2, magicNumber1, 1.0F, magicNumber3);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, BlockPos pos, EnumFacing dir) {
        return world.getBlockState(pos).getBlock() == this ? false : super.shouldSideBeRendered(world, pos, dir);
    }

    public final boolean canPaneConnectToBlock(Block block) {
        return block.isFullBlock() || block == this;
    }

    public boolean canPaneConnectTo(IBlockAccess world, BlockPos pos, EnumFacing dir) {
        BlockPos off = pos.offset(dir);
        Block block = world.getBlockState(off).getBlock();
        return canPaneConnectToBlock(block) || block.isSideSolid(world, pos, dir.getOpposite());
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
        for (BlockVariant variant : ChiselProperties.GLASS_PANE_VARIANTS.getAllowedValues()) {
            list.add(new ItemStack(itemIn, 1, variant.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(ChiselProperties.GLASS_PANE_VARIANTS, ChiselProperties.GLASS_PANE_VARIANTS.fromMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((BlockVariant) state.getValue(ChiselProperties.GLASS_PANE_VARIANTS)).getMeta();
    }

    @Override
    public String getSubtypeUnlocalizedName(ItemStack stack) {
        return ChiselProperties.GLASS_PANE_VARIANTS.fromMeta(stack.getMetadata()).getName();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, ChiselProperties.GLASS_PANE_VARIANTS, NORTH, SOUTH, EAST, WEST);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
        return state.withProperty(ChiselProperties.GLASS_PANE_VARIANTS, ChiselProperties.GLASS_PANE_VARIANTS.fromMeta(world.getBlockState(pos).getBlock().getMetaFromState(state)))
                .withProperty(NORTH, canPaneConnectTo(world, pos, EnumFacing.NORTH))
                .withProperty(SOUTH, canPaneConnectTo(world, pos, EnumFacing.SOUTH))
                .withProperty(EAST, canPaneConnectTo(world, pos, EnumFacing.EAST))
                .withProperty(WEST, canPaneConnectTo(world, pos, EnumFacing.WEST));
    }
}
