package com.cricketcraft.chisel.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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

import com.cricketcraft.chisel.init.ChiselTabs;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IBlockWithSubtypes;
import com.cricketcraft.chisel.util.PropertyVariant;

public class BlockCloud extends BlockCarvable implements IBlockWithSubtypes
{
	public static final BlockVariant
			NORMAL = new BlockVariant(0, "cloud_normal"),
			GRID = new BlockVariant(1, "cloud_grid"),
			LARGE = new BlockVariant(2, "cloud_large"),
			SMALL = new BlockVariant(3, "cloud_small"),
			VERTICAL = new BlockVariant(4, "cloud_vertical");

	public static final PropertyVariant VARIANTS = PropertyVariant.create("variant", NORMAL, GRID, LARGE, SMALL, VERTICAL);

	public BlockCloud()
	{
		super(Material.ice);
		setHardness(0.2F);
		setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
		setLightOpacity(3);
		setStepSound(Block.soundTypeCloth);
		useNeighborBrightness = true;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity)
	{
		entity.fallDistance = 0.0F;

		if (entity.motionY < 0.0D)
		{
			entity.motionY *= 0.0050000000000000001D;
		}
		else if (entity.motionY > 0)
		{
			entity.motionY += 0.0285;
		}
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isFullCube()
	{
		return false;
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.TRANSLUCENT;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, BlockPos pos, EnumFacing side)
	{
		Block block = world.getBlockState(pos).getBlock();
		if (block == this)
		{
			return false;
		}

		return super.shouldSideBeRendered(world, pos, side);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state)
	{
		return AxisAlignedBB.fromBounds(pos.getX() + 0.2, pos.getY(), pos.getZ() + 0.2, pos.getX() + 0.8, pos.getY() + 0.2, pos.getZ() + 0.8);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		for (BlockVariant variant : VARIANTS.getAllowedValues())
		{
			list.add(new ItemStack(itemIn, 1, variant.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANTS, VARIANTS.fromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockVariant) state.getValue(VARIANTS)).getMeta();
	}

	@Override
	public String getSubtypeUnlocalizedName(ItemStack stack)
	{
		return VARIANTS.fromMeta(stack.getMetadata()).getName();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, VARIANTS);
	}
}
