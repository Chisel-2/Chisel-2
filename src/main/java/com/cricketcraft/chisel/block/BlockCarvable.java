package com.cricketcraft.chisel.block;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.Features;
import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Collection;
import java.util.List;

public class BlockCarvable extends Block {

	public static final PropertyEnum VARIANTS = PropertyEnum.create("variant", Features.class);

	private boolean isAlpha;

	public BlockCarvable() {
		this(Material.rock);
	}

	public BlockCarvable(Material m) {
		super(m);
		if (m == Material.rock || m == Material.iron) {
			setHarvestLevel("pickaxe", 0);
		}
		setResistance(10.0F);
		setHardness(2.0F);
		setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANTS, Features.TESTING0));
	}

	public BlockCarvable setStained(boolean a) {
		this.isAlpha = a;
		return this;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return isAlpha ? 1 : 0;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((Features)state.getValue(VARIANTS)).getMetaFromState();
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		Features[] features = Features.values();

		for(int c = 0; c < features.length; c++){
			Features feature = features[c];
			list.add(new ItemStack(item, 1, feature.getMetaFromState()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta){
		return this.getDefaultState().withProperty(VARIANTS, Features.getStateFromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state){
		return ((Features)state.getValue(VARIANTS)).getMetaFromState();
	}

	public BlockState createBlockState(){
		return new BlockState(this, VARIANTS);
	}

	public static class SoundType extends Block.SoundType {

		public final String soundNameStep;
		public final String soundNameBreak;
		public final String soundNamePlace;

		/**
		 * Creates a SoundType with automatic names for step and break sounds. Sound names dig.soundName and step.soundName must be specified in the sounds.json
		 * 
		 * @param soundName
		 *            block of the sound. Will automatically be expanded to "mod:dig.soundName" and "mod:step.soundName" respectively)
		 * @param volume
		 *            default 1.0f
		 * @param frequency
		 *            default 1.0f
		 */
		public SoundType(String soundName, float volume, float frequency) {
			super(soundName, volume, frequency);
			this.soundNameStep = null;
			this.soundNameBreak = null;
			this.soundNamePlace = null;
		}

		/**
		 * Creates a SoundType with manual names for step and break sounds. Sound names must be specified in the sounds.json
		 * 
		 * @param soundNameBreak
		 *            block break sound
		 * @param soundNameStep
		 *            block step sound
		 * @param volume
		 *            default 1.0f
		 * @param frequency
		 *            default 1.0f
		 */
		public SoundType(String soundNameBreak, String soundNameStep, float volume, float frequency) {
			super(soundNameStep, volume, frequency);
			this.soundNameStep = soundNameStep;
			this.soundNameBreak = soundNameBreak;
			this.soundNamePlace = null;
		}

		/**
		 * Creates a SoundType with manual names for step, break and place sounds. Sound names must be specified in the sounds.json
		 * 
		 * @param soundNameBreak
		 *            block break sound
		 * @param soundNameStep
		 *            block step sound
		 * @param soundNamePlace
		 *            block place sound
		 * @param volume
		 *            default 1.0f
		 * @param frequency
		 *            default 1.0f
		 */
		public SoundType(String soundNameBreak, String soundNameStep, String soundNamePlace, float volume, float frequency) {
			super(soundNameStep, volume, frequency);
			this.soundNameStep = soundNameStep;
			this.soundNameBreak = soundNameBreak;
			this.soundNamePlace = soundNamePlace;
		}

		@Override
		public String getBreakSound() {
			if (soundNameBreak == null)
				return Chisel.MOD_ID + ":dig." + this.soundName;
			else
				return this.soundNameBreak;
		}

		@Override
		public String getStepSound() {
			if (soundNameStep == null)
				return Chisel.MOD_ID + ":step." + this.soundName;
			else
				return this.soundNameStep;
		}

		@Override
		public String getPlaceSound() {
			if (soundNamePlace == null)
				return getBreakSound();
			else
				return this.soundNamePlace;
		}
	}

}
