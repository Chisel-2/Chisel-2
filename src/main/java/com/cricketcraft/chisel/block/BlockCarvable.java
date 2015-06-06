package com.cricketcraft.chisel.block;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.Features;
import com.cricketcraft.chisel.init.ChiselTabs;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.Feature;
import com.cricketcraft.chisel.util.IBlockWithSubtypes;
import com.cricketcraft.chisel.util.PropertyVariant;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BlockCarvable extends Block implements IBlockWithSubtypes{

	public static PropertyVariant VARIANTS = null;

	private boolean isAlpha;

	public BlockCarvable(Feature feature) {
		this(Material.rock, feature);
	}

	public BlockCarvable(Material m, Feature feature) {
		super(m);
		if (m == Material.rock || m == Material.iron) {
			setHarvestLevel("pickaxe", 0);
		}
		VARIANTS = PropertyVariant.create("variant", feature.getVariants());
		setResistance(10.0F);
		setHardness(2.0F);
		setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
	}

	public BlockCarvable setStained(boolean a) {
		this.isAlpha = a;
		return this;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list){
		for(Object variant : VARIANTS.getAllowedValues()){
			list.add(new ItemStack(item, 1, ((BlockVariant) variant).getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta){
		return this.getDefaultState().withProperty(VARIANTS, VARIANTS.getVariantFromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state){
		return ((BlockVariant) state.getValue(VARIANTS)).getMeta();
	}

	@Override
	public int damageDropped(IBlockState state){
		return ((BlockVariant) state.getValue(VARIANTS)).getMeta();
	}

	@Override
	public String getSubtypeUnlocalizedName(ItemStack stack) {
		return VARIANTS.getVariantFromMeta(stack.getMetadata()).getName();
	}

	public PropertyVariant getVariants(){
		return this.VARIANTS;
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
