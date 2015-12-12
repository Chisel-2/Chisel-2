package com.cricketcraft.chisel.api;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

import java.util.List;

public interface ICarvingRegistry {

    ICarvingGroup getGroup(Block block, int meta);
    ICarvingGroup getGroup(String name);
    ICarvingGroup removeGroup(String groupName);

    ICarvingVariant getVariant(Block block, int meta);
    ICarvingVariant removeVariant(Block block, int meta, String group);

    List<ICarvingVariant> getVariantGroup(Block block, int meta);
    List<String> getSortedGroupNames();

    String getOreName(Block block, int meta);
    String getVariantSound(Block block, int metadata);

    void addVariant(String groupName, IBlockState state);
    void addGroup(ICarvingGroup group);
    void registerOre(String groupName, String oreName);
    void setVariantSound(String groupName, String sound);
}
