package com.cricketcraft.chisel.block.other;

import java.util.List;

import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.block.variant.BlockVariants;
import com.cricketcraft.chisel.init.ChiselProperties;
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

public class BlockCloud extends BlockCarvable implements IBlockWithSubtypes {

	public BlockCloud() {
		super(Material.ice);
		this.setHardness(0.2F);
		this.setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
		this.setLightOpacity(3);
		this.setStepSound(Block.soundTypeCloth);
		this.useNeighborBrightness = true;
		this.setDefaultState(this.getBlockState().getBaseState().withProperty(ChiselProperties.CLOUD_VARIANTS, BlockVariants.CLOUD_NORMAL));
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity) {
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

	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, BlockPos pos, EnumFacing side) {
		Block block = world.getBlockState(pos).getBlock();
		if (block == this) {
			return false;
		}

		return super.shouldSideBeRendered(world, pos, side);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state) {
		return AxisAlignedBB.fromBounds(pos.getX() + 0.2, pos.getY(), pos.getZ() + 0.2, pos.getX() + 0.8, pos.getY() + 0.2, pos.getZ() + 0.8);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		for (BlockVariant variant : ChiselProperties.CLOUD_VARIANTS.getAllowedValues()) {
			list.add(new ItemStack(itemIn, 1, variant.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(ChiselProperties.CLOUD_VARIANTS, ChiselProperties.CLOUD_VARIANTS.fromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockVariant) state.getValue(ChiselProperties.CLOUD_VARIANTS)).getMeta();
	}

	@Override
	public String getSubtypeUnlocalizedName(ItemStack stack) {
		return ChiselProperties.CLOUD_VARIANTS.fromMeta(stack.getMetadata()).getName();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, ChiselProperties.CLOUD_VARIANTS);
	}
}
