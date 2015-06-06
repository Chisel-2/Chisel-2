package com.cricketcraft.chisel;

import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.Feature;

public class Features {
    public static class CLOUD extends Feature {
        public static final BlockVariant
                NORMAL = new BlockVariant(0, "cloud_normal"),
                GRID = new BlockVariant(1, "cloud_grid"),
                LARGE = new BlockVariant(2, "cloud_small"),
                VERTICAL = new BlockVariant(3, "cloud_vertical");

        public CLOUD() {
            super(NORMAL, GRID, LARGE, VERTICAL);
        }
    }
}
