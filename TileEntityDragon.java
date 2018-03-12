package net.minecraft.src;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;



public class TileEntityDragon extends BlockContainer {

        //Treat it like a normal block here. The Block Bounds are a good idea - the first three are X Y and Z of the botton-left corner,
        //And the second three are the top-right corner.
        public TileEntityDragon(int id) {
                super(id, Material.rock);
                this.setCreativeTab(CreativeTabs.tabBlock);
               // this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F, 0.5F, 0.6F);
        }

        //Make sure you set this as your TileEntity class relevant for the block!
        @Override
        public TileEntity createNewTileEntity(World world) {
                return new TileEntityDragonEntity();
        }
   

        //You don't want the normal render type, or it wont render properly.
        @Override
        public int getRenderType() {
                return -1;
        }
        public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
        {
            if (par1World.isRemote)
            {
            	ModLoader.getMinecraftInstance().thePlayer.addChatMessage("\u00a7EBaby Dragon: Roar!");
                return true;
            }
            else
            {
        //        TileEntityEnchantmentTable tileentityenchantmenttable = (TileEntityEnchantmentTable)par1World.getBlockTileEntity(par2, par3, par4);
        //        par5EntityPlayer.displayGUIEnchantment(par2, par3, par4, tileentityenchantmenttable.func_94135_b() ? tileentityenchantmenttable.func_94133_a() : null);
       		 
                return true;
            }
        }

        //It's not an opaque cube, so you need this.
        @Override
        public boolean isOpaqueCube() {
                return false;
        }
        
        //It's not a normal block, so you need this too.
        public boolean renderAsNormalBlock() {
                return false;
        }
      
        //This is the icon to use for showing the block in your hand.
        public void registerIcons(IconRegister icon) {
                this.blockIcon = icon.registerIcon("GreenDragon");
        }

        public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
        {
            par5Entity.motionY = 0.55D;
            par5Entity.motionZ = 0.4D;
        }
        
}