package com.cricketcraft.chisel.block.other;

import com.cricketcraft.chisel.block.variant.BlockVariants;
import com.cricketcraft.chisel.init.ChiselProperties;
import com.cricketcraft.chisel.init.ChiselTabs;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IChiselBlock;
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

import java.util.List;

public class ChiselBlockJackolantern extends BlockDirectional implements IChiselBlock {
	public ChiselBlockJackolantern() {
		super(Material.gourd);
		this.setTickRandomly(true);
		this.setStepSound(Block.soundTypeWood);
		setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
		setLightLevel(10.0F);
		this.setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ChiselProperties.LITPUMPKIN_VARIANTS, BlockVariants.LITPUMPKIN_0));
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		for (BlockVariant variant : ChiselProperties.LITPUMPKIN_VARIANTS.getAllowedValues()) {
			list.add(new ItemStack(itemIn, 1, variant.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(ChiselProperties.LITPUMPKIN_VARIANTS, ChiselProperties.LITPUMPKIN_VARIANTS.fromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockVariant) state.getValue(ChiselProperties.LITPUMPKIN_VARIANTS)).getMeta() + ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((BlockVariant) state.getValue(ChiselProperties.LITPUMPKIN_VARIANTS)).getMeta();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, ChiselProperties.LITPUMPKIN_VARIANTS, FACING);
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getStateFromMeta(meta).withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, ((BlockVariant) state.getValue(ChiselProperties.LITPUMPKIN_VARIANTS)).getMeta());
	}

	@Override
	public String getSubtypeUnlocalizedName(ItemStack stack) {
		return ChiselProperties.LITPUMPKIN_VARIANTS.fromMeta(stack.getMetadata()).getName();
	}
}
