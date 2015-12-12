package com.cricketcraft.chisel.block.other;

import java.util.List;

import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.cricketcraft.chisel.block.variant.BlockVariants;
import com.cricketcraft.chisel.init.ChiselProperties;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IChiselBlock;

public class ChiselBlockPumpkin extends BlockDirectional implements IChiselBlock {

	public ChiselBlockPumpkin() {
		super(Material.gourd);
		this.setTickRandomly(true);
		this.setStepSound(Block.soundTypeWood);
		setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
		this.setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ChiselProperties.PUMPKINS_VARIANTS, BlockVariants.PUMPKIN_0));
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {

	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		for (BlockVariant variant : ChiselProperties.PUMPKINS_VARIANTS.getAllowedValues()) {
			list.add(new ItemStack(itemIn, 1, variant.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(ChiselProperties.PUMPKINS_VARIANTS, ChiselProperties.PUMPKINS_VARIANTS.fromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockVariant) state.getValue(ChiselProperties.PUMPKINS_VARIANTS)).getMeta() + ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((BlockVariant) state.getValue(ChiselProperties.PUMPKINS_VARIANTS)).getMeta();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, ChiselProperties.PUMPKINS_VARIANTS, FACING);
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getStateFromMeta(meta).withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, ((BlockVariant) state.getValue(ChiselProperties.PUMPKINS_VARIANTS)).getMeta());
	}

	@Override
	public String getSubtypeUnlocalizedName(ItemStack stack) {
		return ChiselProperties.PUMPKINS_VARIANTS.fromMeta(stack.getMetadata()).getName();
	}
}
