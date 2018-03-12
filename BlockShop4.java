package net.minecraft.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockShop4 extends Block
{
    public BlockShop4(int i, int j)
    {
    	  super(i, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
		setTickRandomly(true);
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
   	 ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
   	 
   	if (itemstack != null && itemstack.itemID == (mod_BlocksGalore.note1.itemID))
    {
        if (itemstack.stackSize == 32)
        {
            par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(mod_BlocksGalore.GoldHammer));
            par5EntityPlayer.addChatMessage("\u00a7ELogin Reward Shop: Thank you for your custom!");        	
        }
        }
   	else
		par5EntityPlayer.addChatMessage("\u00a7ELogin Reward Shop: Exchange 32 daily login tokens for a golden warhammer!");	
        return true;
    }
    
    
    public int idDropped(int par1, Random par2Random, int par3)
    {return stone.blockID;}
    
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir)
    {{this.blockIcon = ir.registerIcon("Shop4");}}
}
