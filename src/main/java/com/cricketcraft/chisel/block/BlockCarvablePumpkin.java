package com.cricketcraft.chisel.block;

import java.util.List;

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

import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IBlockWithSubtypes;
import com.cricketcraft.chisel.util.PropertyVariant;

public class BlockCarvablePumpkin extends BlockDirectional implements IBlockWithSubtypes {
	public static final BlockVariant
			NORMAL = new BlockVariant(0, "cloud_normal"),
			GRID = new BlockVariant(1, "cloud_grid"),
			LARGE = new BlockVariant(2, "cloud_large"),
			SMALL = new BlockVariant(3, "cloud_small"),
			VERTICAL = new BlockVariant(4, "cloud_vertical");

	public static final PropertyVariant PROPERTY_VARIANT = PropertyVariant.create("variant", NORMAL, GRID, LARGE, SMALL, VERTICAL);

	public BlockCarvablePumpkin(boolean isOn) {
		super(Material.gourd);
		this.setTickRandomly(true);
		this.setStepSound(Block.soundTypeWood);
		if (isOn)
			setLightLevel(10.0F);
		this.setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(PROPERTY_VARIANT, NORMAL));
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		/**if (worldIn.getBlock(x, y - 1, z) == Blocks.snow && worldIn.getBlock(x, y - 2, z) == Blocks.snow)
		{
			if (!worldIn.isRemote)
			{
				//Let's grab the pumpkin before we start
				ItemStack pumpkin = new ItemStack(worldIn.getBlock(x, y, z), worldIn.getBlockMetadata(x, y, z));

				worldIn.setBlock(x, y, z, Blocks.air, 0, 2);
				worldIn.setBlock(x, y - 1, z, Blocks.air, 0, 2);
				worldIn.setBlock(x, y - 2, z, Blocks.air, 0, 2);
				EntityChiselSnowman snowman = new EntityChiselSnowman(worldIn);
				snowman.setCurrentItemOrArmor(2, pumpkin);
				snowman.setLocationAndAngles(x + 0.5D, y - 1.95D, z + 0.5D, 0.0F, 0.0F);
				worldIn.spawnEntityInWorld(snowman);
				worldIn.notifyBlockChange(x, y, z, Blocks.air);
				worldIn.notifyBlockChange(x, y - 1, z, Blocks.air);
				worldIn.notifyBlockChange(x, y - 2, z, Blocks.air);
			}

			//Spawn some lovely particles
			for (int c = 0; c < 120; ++c)
			{
				worldIn.spawnParticle("snowshovel", x + worldIn.rand.nextDouble(), y - 2 + worldIn.rand.nextDouble() * 2.5D, z + worldIn.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
			}
		}
		else if (worldIn.getBlock(x, y - 1, z) == Blocks.iron_block || worldIn.getBlock(x, y - 2, z) == Blocks.iron_block)
		{
			boolean flag = worldIn.getBlock(x - 1, y - 1, z) == Blocks.iron_block && worldIn.getBlock(x + 1, y - 1, z) == Blocks.iron_block;
			boolean flag1 = worldIn.getBlock(x, y - 1, z - 1) == Blocks.iron_block && worldIn.getBlock(x, y - 1, z + 1) == Blocks.iron_block;

			if (flag || flag1)
			{
				worldIn.setBlock(x, y, z, Blocks.air, 0, 2);
				worldIn.setBlock(x, y - 1, z, Blocks.air, 0, 2);
				worldIn.setBlock(x, y - 2, z, Blocks.air, 0, 2);

				if (flag)
				{
					worldIn.setBlock(x - 1, y - 1, z, Blocks.air, 0, 2);
					world.setBlock(x + 1, y - 1, z, Blocks.air, 0, 2);
				}
				else
				{
					world.setBlock(x, y - 1, z - 1, Blocks.air, 0, 2);
					world.setBlock(x, y - 1, z + 1, Blocks.air, 0, 2);
				}

				EntityIronGolem ironGolem = new EntityIronGolem(world);
				ironGolem.setPlayerCreated(true);
				ironGolem.setLocationAndAngles(x + 0.5D, y - 1.95D, z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(ironGolem);

				world.notifyBlockChange(x, y, z, Blocks.air);
				world.notifyBlockChange(x, y - 1, z, Blocks.air);
				world.notifyBlockChange(x, y - 2, z, Blocks.air);

				if (flag)
				{
					world.notifyBlockChange(x - 1, y - 1, z, Blocks.air);
					world.notifyBlockChange(x + 1, y - 1, z, Blocks.air);
				}
				else
				{
					world.notifyBlockChange(x, y - 1, z - 1, Blocks.air);
					world.notifyBlockChange(x, y - 1, z + 1, Blocks.air);
				}
			}
		}*/
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		for (BlockVariant variant : PROPERTY_VARIANT.getAllowedValues()) {
			list.add(new ItemStack(itemIn, 1, variant.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(PROPERTY_VARIANT, PROPERTY_VARIANT.fromMeta(meta)).withProperty(FACING, EnumFacing.getFront(meta - PROPERTY_VARIANT.fromMeta(meta).getMeta()));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockVariant) state.getValue(PROPERTY_VARIANT)).getMeta() + ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((BlockVariant) state.getValue(PROPERTY_VARIANT)).getMeta();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, PROPERTY_VARIANT, FACING);
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getStateFromMeta(meta).withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, ((BlockVariant) state.getValue(PROPERTY_VARIANT)).getMeta());
	}

	@Override
	public String getSubtypeUnlocalizedName(ItemStack stack) {
		return PROPERTY_VARIANT.fromMeta(stack.getMetadata()).getName();
	}
}
