package net.minecraft.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class BlockRuneores extends Block
{
    public BlockRuneores(int i, int j)
    {
        super(i, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        MinecraftForge.setBlockHarvestLevel(mod_BlocksGalore.Runeore, 0, "pickaxe", 3);
    }
    int x;
    public int idDropped(int par1, Random par2Random, int par3)
    {
        if (x==0){x++;return mod_BlocksGalore.Runeore.blockID;}
        if (x==1){x++;return mod_Flower.MXPORB.itemID;}
        if (x==2){x++;return mod_Flower.MXPORB.itemID;}
        if (x==3){x++;return mod_Flower.MXPORB.itemID;}
        if (x==4){x++;return mod_Flower.MXPORB.itemID;}
        if (x==5){x++;return mod_Flower.MXPORB.itemID;}
        if (x==6){x++;return mod_Flower.MXPORB.itemID;}
        if (x==7){x++;return mod_Flower.MXPORB.itemID;}
        if (x==8){x++;return mod_Flower.MXPORB.itemID;}
        if (x==9){x++;return mod_Flower.MXPORB.itemID;}
        if (x==10){x++;return mod_Flower.MXPORB.itemID;}
        if (x==11){x++;return mod_Flower.MXPORB.itemID;}
        if (x==12){x++;return mod_Flower.MXPORB.itemID;}
        if (x==13){x++;return mod_Flower.MXPORB.itemID;}
        if (x==14){x++;return mod_Flower.MXPORB.itemID;}
        if (x==15){x++;return mod_Flower.MXPORB.itemID;}
        if (x==16){x++;return mod_Flower.MXPORB.itemID;}
        if (x==17){x++;return mod_Flower.MXPORB.itemID;}
        if (x==18){x++;return mod_Flower.MXPORB.itemID;}
        if (x==19){x++;return mod_Flower.MXPORB.itemID;}
        else{
        	x=0;
        return mod_Flower.MXPORB.itemID;
       }
    }
    
    public int quantityDropped(Random par1Random)
    {
        return 20;
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir)
    {
           
            {
            this.blockIcon = ir.registerIcon("Runeore");
            }
    }
}
