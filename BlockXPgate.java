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

public class BlockXPgate extends Block
{
    public BlockXPgate(int i, int j)
    {
        super(i, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
		 MinecraftForge.setBlockHarvestLevel(mod_Flower.oreCoals, 0, "pickaxe", 1);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
    return Block.dirt.blockID;}
 
    public int quantityDropped(Random par1Random){return 3;}

    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	ExtendedPlayer propsa = ExtendedPlayer.get(par5EntityPlayer);	
    	if (propsa.getCombatxp() >= 226*2)
             {

                 par5EntityPlayer.setPositionAndUpdate(par2, par3+1, par4+4);
             }
     	 return true;
    }
    
    
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir)
    {
           
            {
            this.blockIcon = ir.registerIcon("XPGate");
            }
    }
}
