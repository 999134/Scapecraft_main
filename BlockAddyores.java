package net.minecraft.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

public class BlockAddyores extends Block
{
    public BlockAddyores(int i, int j)
    {
    	  super(i, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
		 MinecraftForge.setBlockHarvestLevel(mod_BlocksGalore.Addyore, 0, "pickaxe", 2);
    }
    int x;
    public int idDropped(int par1, Random par2Random, int par3)
    {
        if (x==0){x++;return mod_BlocksGalore.Addyore.blockID;}
        if (x==1){x++;return mod_Flower.MXPORB.itemID;}
        if (x==2){x++;return mod_Flower.MXPORB.itemID;}
        if (x==3){x++;return mod_Flower.MXPORB.itemID;}
        if (x==4){x++;return mod_Flower.MXPORB.itemID;}
        if (x==5){x++;return mod_Flower.MXPORB.itemID;}
        if (x==6){x++;return mod_Flower.MXPORB.itemID;}
        if (x==7){x++;return mod_Flower.MXPORB.itemID;}
        if (x==8){x++;return mod_Flower.MXPORB.itemID;}
        if (x==9){x++;return mod_Flower.MXPORB.itemID;}
        else{
        	x=0;
        return mod_Flower.MXPORB.itemID;
       }
    }
    
    public int quantityDropped(Random par1Random)
    {
        return 10;
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir)
    {
           
            {
            this.blockIcon = ir.registerIcon("Addyore");
            }
    }
}
