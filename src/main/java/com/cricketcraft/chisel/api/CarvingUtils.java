package com.cricketcraft.chisel.api;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarvingUtils {

    public static int compare(ICarvingVariant variant, ICarvingVariant variant1) {
        return variant.getOrder() - variant1.getOrder();
    }

    public static ItemStack getStack(ICarvingVariant variant) {
        return new ItemStack(variant.getBlock(), 1, variant.getBlockMeta());
    }

    public static ICarvingRegistry chisel;

    public static ICarvingRegistry getRegistry() {
        return chisel;
    }

    public static ICarvingVariant getDefaultVariantFor(Block block, int meta, int order) {
        return new CarvingVariant(block, meta, order);
    }

    public static class CarvingVariant implements ICarvingVariant {
        private int order, meta;
        private Block block;

        public CarvingVariant(Block block, int meta, int order) {
            this.block = block;
            this.meta = meta;
            this.order = order;
        }

        @Override
        public Block getBlock() {
            return block;
        }

        @Override
        public int getBlockMeta() {
            return meta;
        }

        @Override
        public int getOrder() {
            return order;
        }
    }

    public static class CarvingGroup implements ICarvingGroup {

        private String name, sound, oreName;

        private List<ICarvingVariant> variants = Lists.newArrayList();

        public CarvingGroup(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getSound() {
            return sound;
        }

        @Override
        public String getOreName() {
            return oreName;
        }

        @Override
        public void setSound(String sound) {
            this.sound = sound;
        }

        @Override
        public void setOreName(String oreName) {
            this.oreName = oreName;
        }

        @Override
        public void addVariant(ICarvingVariant variant) {
            variants.add(variant);
            Collections.sort(variants, new Comparator<ICarvingVariant>() {
                @Override
                public int compare(ICarvingVariant o1, ICarvingVariant o2) {
                    return CarvingUtils.compare(o1, o2);
                }
            });
        }

        @Override
        public List<ICarvingVariant> getVariants() {
            return variants;
        }

        @Override
        public boolean removeVariant(ICarvingVariant variant) {
            ICarvingVariant remove = null;
            for(ICarvingVariant v : variants) {
                if(v.getBlock() == variant.getBlock() && v.getBlockMeta() == variant.getBlockMeta()) {
                    remove = v;
                }
            }
            return remove == null ? false : variants.remove(remove);
        }
    }
}
