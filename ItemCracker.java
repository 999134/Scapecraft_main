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

public class ItemCracker extends Item {

	public ItemCracker(int i) {
		super(i);
	    this.setCreativeTab(CreativeTabs.tabMaterials);
	    this.maxStackSize = 1;
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer entityplayer){
		for (ItemStack stack : entityplayer.inventory.mainInventory) {
			if (stack != null&& stack.itemID == mod_Flower.Cracker.itemID){
				Random rand = new Random();
				   int var = rand.nextInt(300) + 1;
		
			    	
				if (var<=20) {stack.itemID = mod_Flower.cabbage.blockID;}
				if (var>20&&var<=40) {stack.itemID = mod_Flower.RatTail.itemID;}
				if (var>40&&var<=60) {stack.itemID = mod_Flower.applepie.itemID;}
				if (var>60&&var<=80) {stack.itemID = mod_Flower.BlackDleather.itemID;}
				if (var>80&&var<=100) {stack.itemID = mod_Flower.sarabrew.itemID;}
				if (var>100&&var<=110) {stack.itemID = mod_phat.runegHelmet.itemID;}
				if (var>110&&var<=120) {stack.itemID = mod_phat.runegChestplate.itemID;}
				if (var>120&&var<=130) {stack.itemID = mod_phat.runegLeggings.itemID;}
				if (var>130&&var<=140) {stack.itemID = mod_phat.runegBoots.itemID;}
				if (var>140&&var<=150) {stack.itemID = mod_phat.helmet.itemID;}
				if (var>150&&var<=160) {stack.itemID = mod_BlocksGalore.dlong.itemID;}
				if (var>160&&var<=170) {stack.itemID = mod_BlocksGalore.korasis.itemID;}
				if (var>170&&var<=180) {stack.itemID = mod_BlocksGalore.DBA.itemID;}
				if (var>180&&var<=190) {stack.itemID = mod_BlocksGalore.DD.itemID;}
				if (var>190&&var<=200) {stack.itemID = mod_BlocksGalore.DragonScimmy.itemID;}
				if (var>200&&var<=220) {stack.itemID = mod_BlocksGalore.Runesword.itemID;}
				if (var>220&&var<=240) {stack.itemID = mod_BlocksGalore.RuneHammer.itemID;}
				if (var>240&&var<=260) {stack.itemID = mod_BlocksGalore.VestaSword.itemID;}
				
				if (var>260&&var<=265) {stack.itemID = mod_BlocksGalore.keris.itemID;}
				if (var>265&&var<=270) {stack.itemID = mod_BlocksGalore.Whip.itemID;}
				if (var>270&&var<=275) {stack.itemID = mod_BlocksGalore.D2H.itemID;}
				if (var>275&&var<=280) {stack.itemID = mod_BlocksGalore.sarasword.itemID;}
				if (var>280&&var<=282) {stack.itemID = mod_BlocksGalore.Hilt.itemID;}
				if (var>282&&var<=290) {stack.itemID = mod_BlocksGalore.PitchFork.itemID;}
				
				if (var>290&&var<=292) {stack.itemID = mod_BlocksGalore.BGS.itemID;}
				if (var>292&&var<=294) {stack.itemID = mod_BlocksGalore.SGS.itemID;}
				if (var>294&&var<=296) {stack.itemID = mod_BlocksGalore.ZGS.itemID;}
				if (var>296&&var<=298) {stack.itemID = mod_BlocksGalore.AGS.itemID;}
				if (var==298||var==299) {stack.itemID = mod_phat.santaHelmet.itemID;}	
				if (var==300) {stack.itemID = mod_phat.pphatHelmet.itemID;}
				
			
			
			
			}}
		return itemstack;
		   }
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir)
    {
            {
            this.itemIcon = ir.registerIcon("cracker");
            }
    }

}