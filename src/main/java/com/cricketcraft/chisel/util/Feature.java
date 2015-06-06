package com.cricketcraft.chisel.util;

public class Feature {
    private BlockVariant[] variants;

    public Feature(BlockVariant... variants){
        this.variants = variants;
    }

    public BlockVariant[] getVariants(){
        return variants;
    }
}
