package com.cricketcraft.chisel.block;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.api.carving.IVariationInfo;
import com.cricketcraft.chisel.init.ChiselBlocks;
import com.cricketcraft.chisel.init.ChiselTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCarvableGrass extends BlockCarvable implements IGrowable{

    @SideOnly(Side.CLIENT)
    private IIcon sideSnow;
    @SideOnly(Side.CLIENT)
    private IIcon sideOverlay;

    public BlockCarvableGrass() {
        super(Material.grass);
        setTickRandomly(true);
        setCreativeTab(ChiselTabs.tabOtherChiselBlocks);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if(!world.isRemote) {
            if(world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
                world.setBlock(x, y, z, Blocks.dirt);
            } else if(world.getBlockLightValue(x, y + 1, z) >= 9) {
                for(int c = 0; c < 4; c++) {
                    int xx = x + random.nextInt(3) - 1;
                    int yy = y + random.nextInt(5) - 3;
                    int zz = z + random.nextInt(3) - 1;
                    Block block = world.getBlock(xx, yy + 1, zz);

                    if(world.getBlock(xx, yy, zz) == Blocks.dirt && world.getBlockMetadata(xx, yy, zz) == 0 && world.getBlockLightValue(xx, yy + 1, zz) >= 4 && world.getBlockLightOpacity(xx, yy + 1, zz) <= 2) {
                        world.setBlock(xx, yy, zz, this, world.getBlockMetadata(x, y, z), 1);
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        if(side == 1) {
            return carverHelper.getIcon(world, x, y, z, side);
        } else if(side == 0) {
            return Blocks.dirt.getBlockTextureFromSide(side);
        } else {
            Material material = world.getBlock(x, y + 1, z).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.sideSnow;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        return side == 1 ? carverHelper.getIcon(side, meta) : (side == 0 ? Blocks.dirt.getBlockTextureFromSide(side) : this.blockIcon);
    }

    @Override
    public void registerBlockIcons(IIconRegister icon) {
        carverHelper.registerBlockIcons(Chisel.MOD_ID, this, icon);
        this.blockIcon = icon.registerIcon("grass_side");
        this.sideSnow = icon.registerIcon("grass_side_snowed");
        this.sideOverlay = icon.registerIcon("grass_side_overlay");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getBlockColor() {
        return ColorizerGrass.getGrassColor(0.5D, 1.0D);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderColor(int colot) {
        return this.getBlockColor();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int colorMultiplier(IBlockAccess world, int x, int y, int z) {
        int r = 0, g = 0, b = 0;

        for(int c = -1; c <= 1; ++c) {
            for(int d = -1; d <= 1; d++) {
                int g1 = world.getBiomeGenForCoords(x + d, z + c).getBiomeGrassColor(x + d, y, z + c);
                r += (g1 & 16711680) >> 16;
                g += (g1 & 65280) >> 8;
                b += g1 & 255;
            }
        }

        return (r / 9 & 255) << 16 | (g / 9 & 255) << 8 | b / 9 & 255;
    }

    @SideOnly(Side.CLIENT)
    public static IIcon getIconSideOverlay() {
        return ChiselBlocks.grass.sideOverlay;
    }

    @Override
    public IVariationInfo getVariation(IBlockAccess world, int x, int y, int z, int metadata) {
        return null;
    }

    @Override
    public IVariationInfo getVariation(ItemStack stack) {
        return null;
    }

    @Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean isClient) {
        return this.canFertilize(world, x, y, z, isClient);
    }

    @Override
    public boolean func_149852_a(World world, Random random, int x, int y, int z) {
        return this.shouldFertilize(world, random, x, y, z);
    }

    @Override
    public void func_149853_b(World world, Random random, int x, int y, int z) {
        this.fertilize(world, random, x, y, z);
    }

    public boolean canFertilize(World world, int x, int y, int z, boolean isClient) {
        return true;
    }

    public boolean shouldFertilize(World world, Random random, int x, int y, int z) {
        return true;
    }

    public void fertilize(World world, Random random, int x, int y, int z) {
        int c = 0;

        while (c < 128) {
            int x1 = x;
            int y1 = y + 1;
            int z1 = z;
            int l1 = 0;

            while (true) {
                if (l1 < c / 16) {
                    x1 += random.nextInt(3) - 1;
                    y1 += (random.nextInt(3) - 1) * random.nextInt(3) / 2;
                    z1 += random.nextInt(3) - 1;

                    if (world.getBlock(x1, y1 - 1, z1) == Blocks.grass && !world.getBlock(x1, y1, z1).isNormalCube()) {
                        ++l1;
                        continue;
                    }
                } else if (world.getBlock(x1, y1, z1).getMaterial() == Material.air) {
                    if (random.nextInt(8) != 0) {
                        if (Blocks.tallgrass.canBlockStay(world, x1, y1, z1)) {
                            world.setBlock(x1, y1, z1, Blocks.tallgrass, 1, 3);
                        }
                    } else {
                        world.getBiomeGenForCoords(x1, z1).plantFlower(world, random, x1, y1, z1);
                    }
                }

                ++c;
                break;
            }
        }
    }
}
