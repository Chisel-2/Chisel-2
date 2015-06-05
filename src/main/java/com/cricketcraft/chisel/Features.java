package com.cricketcraft.chisel;

import net.minecraft.util.IStringSerializable;

public enum Features implements IStringSerializable {
    TESTING0(0, "0"),
    TESTING1(1, "1"),
    TESTING2(2, "2"),
    TESTING3(3, "3"),
    TESTING4(4, "4"),
    TESTING5(5, "5"),
    TESTING6(6, "6"),
    TESTING7(7, "7");


    private static Features[] BLOCK_STATES = new Features[values().length];

    private final int metadata;
    private final String name;
    private final String unlocalizedName;

    private static final String[] dyeOres = { "dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple", "dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow",
            "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite"};

    Features(int meta, String name){
        this(meta, name, name);
    }

    Features(int meta, String name, String unlocalizedName){
        this.metadata = meta;
        this.name = name;
        this.unlocalizedName = unlocalizedName;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getMetaFromState(){
        return this.metadata;
    }

    public static Features getStateFromMeta(int statePosition){
        if(statePosition < 0 || statePosition >= BLOCK_STATES.length){
            statePosition = 0;
        }
        return BLOCK_STATES[statePosition];
    }

    public String toString(){
        return this.name;
    }

    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    public boolean enabled(){
        return true;
    }

    static {
        Features[] features = values();

        for(int c = 0; c < features.length; c++){
            Features feature = features[c];
            BLOCK_STATES[feature.getMetaFromState()] = feature;
        }
    }
}
