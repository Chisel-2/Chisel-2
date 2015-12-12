package com.cricketcraft.chisel.block.wood;

import com.cricketcraft.chisel.init.ChiselProperties;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IChiselBlock;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ChiselBlockBookshelf extends BlockCarvableWood implements IChiselBlock {

	public ChiselBlockBookshelf(){
		super();
		setDefaultState(this.getBlockState().getBaseState().withProperty(ChiselProperties.BOOKSHELF_VARIANTS, ChiselProperties.BOOKSHELF_VARIANTS.fromMeta(0)));
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		for (BlockVariant variant : ChiselProperties.BOOKSHELF_VARIANTS.getAllowedValues()) {
			list.add(new ItemStack(itemIn, 1, variant.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(ChiselProperties.BOOKSHELF_VARIANTS, ChiselProperties.BOOKSHELF_VARIANTS.fromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockVariant) state.getValue(ChiselProperties.BOOKSHELF_VARIANTS)).getMeta();
	}

	@Override
	public String getSubtypeUnlocalizedName(ItemStack stack) {
		return ChiselProperties.BOOKSHELF_VARIANTS.fromMeta(stack.getMetadata()).getName();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, ChiselProperties.BOOKSHELF_VARIANTS);
	}
}
