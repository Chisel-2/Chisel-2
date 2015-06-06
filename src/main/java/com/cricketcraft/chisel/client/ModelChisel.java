package com.cricketcraft.chisel.client;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.init.ChiselBlocks;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IItemWithVariants;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Collection;

@SideOnly(Side.CLIENT)
public class ModelChisel {

    private Minecraft mc;

    public ModelChisel() {
        this.mc = Minecraft.getMinecraft();
    }

    public void registerModels(){
        this.registerBlockModels();
        this.registerItemModels();
        this.registerItemVariantModels();
    }

    private void registerBlockModels(){
        this.registerBlockModelVariants(ChiselBlocks.cloud, ChiselBlocks.cloud.getVariants().getAllowedValues());
    }

    private void registerItemModels(){

    }

    private void registerItemVariantModels(){

    }

    public void registerBlockModelVariants(Block block, Collection<BlockVariant> variants) {
        for (BlockVariant variant : variants) {
            Item item = Item.getItemFromBlock(block);

            this.registerItemModel(item, variant.getName(), variant.getMeta());
            ModelBakery.addVariantName(item, (Chisel.MOD_ID + ":") + variant.getName());
        }
    }

    public void registerBlockModel(Block block) {
        this.registerBlockModel(block, block.getUnlocalizedName().substring(5), 0);
    }

    public void registerBlockModel(Block block, String name, int meta) {
        this.registerItemModel(Item.getItemFromBlock(block), name, meta);
    }

    public void registerItemModel(Item item) {
        this.registerItemModel(item, item.getUnlocalizedName().substring(5), 0);
    }

    public void registerItemModel(Item item, String name, int meta) {
        this.mc.getRenderItem().getItemModelMesher().register(item, meta, this.getModelResource(name, "inventory"));
    }

    public void registerItemModelVariants(Item item) {
        for (int i = 0; i < ((IItemWithVariants) item).getVariantNames().length; i++) {
            String NAME = item.getUnlocalizedName().substring(5) + "_" + ((IItemWithVariants) item).getVariantNames()[i];
            ModelBakery.addVariantName(item, (Chisel.MOD_ID + ":") + NAME);
            this.registerItemModel(item, NAME, i);
        }
    }

    public void registerItemSubTypesModel(Item item, CreativeTabs tab) {
        ArrayList<ItemStack> list = new ArrayList<ItemStack>();
        item.getSubItems(item, tab, list);
        for (ItemStack i : list) {
            this.registerItemModel(item, item.getUnlocalizedName().substring(5), i.getItemDamage());
        }
    }

    private ModelResourceLocation getModelResource(String name, String type) {
        return new ModelResourceLocation((Chisel.MOD_ID + ":") + name, type);
    }
}
