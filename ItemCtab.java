package net.minecraft.src;



import java.io.ByteArrayOutputStream;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.io.DataOutputStream;
import java.util.Random;

import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.Player;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCtab extends Item {

	public ItemCtab(int i) {
		super(i);
	    this.setCreativeTab(CreativeTabs.tabMaterials);
		
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer entityplayer){
		if (entityplayer.getHealth() >= entityplayer.getMaxHealth()-2.0F){
			   entityplayer.setPositionAndUpdate(-998, 70, 1435);
		   --itemstack.stackSize;
		   return itemstack;}
		entityplayer.addChatMessage("\u00a7EYou must be at a higher HP to use this item!");
		return itemstack;
		   
	}
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir)
    {
            {
            this.itemIcon = ir.registerIcon("ctab");
            }
    }

}