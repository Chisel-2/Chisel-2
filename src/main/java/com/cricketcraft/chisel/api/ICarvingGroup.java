package com.cricketcraft.chisel.api;

import java.util.List;

public interface ICarvingGroup {
    String getName();
    String getSound();
    String getOreName();

    void setSound(String sound);
    void setOreName(String oreName);
    void addVariant(ICarvingVariant variant);

    List<ICarvingVariant> getVariants();

    boolean removeVariant(ICarvingVariant variant);
}
