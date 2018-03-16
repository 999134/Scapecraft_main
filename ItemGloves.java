package net.minecraft.src;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemGloves extends Item {

public ItemGloves(int i)
  {
   super(i);
   this.setCreativeTab(CreativeTabs.tabMaterials);
  
  }

  public boolean hasEffect(ItemStack itemstack)
  {
   return false;
  }

 
  public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
  
  public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityPlayer EntityPlayer, EntityLivingBase par3EntityLivingBase )
  {
      if (par3EntityLivingBase instanceof EntityMan)
      {	  if(!EntityPlayer.worldObj.isRemote) {
    	  ExtendedPlayer props = ExtendedPlayer.get(EntityPlayer);		
  		if (props.getTheifcd() >=  99){
  			props.addTcd(-100);
    	 int rate = randInt(1,100);
    	 int loot = randInt(1,1000);
    	 if (EntityPlayer.inventory.getFirstEmptyStack() == -1) {
						EntityPlayer.addChatMessage("\u00a7EYour inventory is full.");
					} else if (rate > 30) {
    	 ExtendedPlayer.get(EntityPlayer).addTXp(1);
    	  EntityPlayer.addChatMessage("\u00a7ESuccessful thieving attempt");
    	  
    	  if (loot>1 && loot<60) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.goldNugget,1));} 
      	  if (loot>60 && loot<300) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.wheat,1));} 
      	  if (loot>300 && loot<500) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.cabbage,1));} 
      	  if (loot>500 && loot<550) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.fishRaw,1));} 
      	  if (loot>560 && loot<990) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.seeds,1));} 
      	  if (loot>989 && loot<1000) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.ingotIron,1));} 
      	  if (loot==1000) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.ingotGold,2));} 
    	 }
 else {EntityPlayer.attackEntityFrom(DamageSource.cactus, 2.0F); }}}return true;}
      
      
      if (par3EntityLivingBase instanceof EntityShopKeeper)
      {	  if(!EntityPlayer.worldObj.isRemote) {
    	  ExtendedPlayer props = ExtendedPlayer.get(EntityPlayer);		
  		if (props.getTheifxp() >  138*2){{
    	  if (props.getTheifcd() >=  99){
  			props.addTcd(-160);
    	 int rate = randInt(1,100);
    	 int loot = randInt(1,1000);
    	if (EntityPlayer.inventory.getFirstEmptyStack() == -1) {
						EntityPlayer.addChatMessage("\u00a7EYour inventory is full.");
					} else if (rate > 50) {
    	 ExtendedPlayer.get(EntityPlayer).addTXp(1);
    	  EntityPlayer.addChatMessage("\u00a7ESuccessful thieving attempt");
    	  
    	  if (loot>1 && loot<80) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.goldNugget,2));} 
      	  if (loot>80 && loot<300) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bread,1));} 
      	  if (loot>300 && loot<310) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.sarabrew,1));} 
      	  if (loot>560 && loot<970) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.wheat,1));} 
      	  if (loot>970 && loot<1000) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.ingotIron,1));} 
      	  if (loot==1000 && rate>75) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.gloves2,1));} 
    	 }
    	else {EntityPlayer.attackEntityFrom(DamageSource.cactus, 3.0F); }}}}
  		else {EntityPlayer.addChatMessage("\u00a7EYou need level 10 Thieving to attempt to pickpocket from this NPC");}
  		}return true;}
      
      if (EntityPlayer.inventory.getFirstEmptyStack() == -1) {
						EntityPlayer.addChatMessage("\u00a7EYour inventory is full.");
					} else if (par3EntityLivingBase instanceof EntityGuard)
      {	  if(!EntityPlayer.worldObj.isRemote) {
    	  ExtendedPlayer props = ExtendedPlayer.get(EntityPlayer);		
  		if (props.getTheifxp() > 950){{
    	  if (props.getTheifcd() >=  99){
  			props.addTcd(-160);
    	 int rate = randInt(1,100);
    	 int loot = randInt(1,1000);
    	 
    	 if (rate > 50) {
    	 ExtendedPlayer.get(EntityPlayer).addTXp(2);
    	  EntityPlayer.addChatMessage("\u00a7ESuccessful thieving attempt");
    	  
    	  if (loot>1 && loot<100) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.goldNugget,2));} 
      	  if (loot>60 && loot<300) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bread,1));} 
      	  if (loot>300 && loot<500) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.cabbage,1));} 
      	  if (loot>500 && loot<530) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_phat.guardChestplate));} 
      	  if (loot>530 && loot<560) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_phat.guardHelmet));} 
      	  if (loot>560 && loot<970) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.wheat,1));} 
      	  if (loot>970 && loot<1000) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.ingotIron,1));} 
      	  if (loot==1000 && rate>75) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.gloves2,1));} 
    	 }
    	else {EntityPlayer.attackEntityFrom(DamageSource.cactus, 4.0F); }}}}
  		else {EntityPlayer.addChatMessage("\u00a7EYou need level 20 Thieving to attempt to pickpocket from this NPC");}
  		}return true;}
      
      
      if (par3EntityLivingBase instanceof EntityFarmer)
      {	  if(!EntityPlayer.worldObj.isRemote) {
    	  ExtendedPlayer props = ExtendedPlayer.get(EntityPlayer);		
  		if (props.getTheifxp() > 950){{
    	  if (props.getTheifcd() >=  99){
  			props.addTcd(-160);
    	 int rate = randInt(1,100);
    	 int loot = randInt(1,1000);
    	 if (EntityPlayer.inventory.getFirstEmptyStack() == -1) {
						EntityPlayer.addChatMessage("\u00a7EYour inventory is full.");
					} else if (rate > 55) {
    	 ExtendedPlayer.get(EntityPlayer).addTXp(2);
    	  EntityPlayer.addChatMessage("\u00a7ESuccessful thieving attempt");
    	  
    	  if (loot>1 && loot<100) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.goldNugget,1));} 
      	  if (loot>60 && loot<300) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bread,2));} 
      	  if (loot>300 && loot<500) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.cabbage,1));} 
      	  if (loot>500 && loot<530) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.feather));} 
      	  if (loot>530 && loot<560) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.sugar));} 
      	  if (loot>560 && loot<900) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.wheat,2));} 
      	  if (loot>900 && loot<1000) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.appleRed,1));} 
      	  if (loot==1000 && rate>75) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.gloves2,1));} 
    	 }
    	else {EntityPlayer.attackEntityFrom(DamageSource.cactus, 3.0F); }}}}
  		else {EntityPlayer.addChatMessage("\u00a7EYou need level 20 Thieving to attempt to pickpocket from this NPC");}
  		}return true;}
      
      if (par3EntityLivingBase instanceof EntityWhiteKnight)
      {	  if(!EntityPlayer.worldObj.isRemote) {
    	  ExtendedPlayer props = ExtendedPlayer.get(EntityPlayer);		
  		if (props.getTheifxp() > 3000){{
    	  if (props.getTheifcd() >=  99){
  			props.addTcd(-250);
    	 int rate = randInt(1,100);
    	 int loot = randInt(1,1000);
    	if (EntityPlayer.inventory.getFirstEmptyStack() == -1) {
						EntityPlayer.addChatMessage("\u00a7EYour inventory is full.");
					} else  if (rate > 60) {
    	 ExtendedPlayer.get(EntityPlayer).addTXp(3);
    	  EntityPlayer.addChatMessage("\u00a7ESuccessful thieving attempt");
    	  
    	  if (loot>1 && loot<100) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.goldNugget,3));} 
      	  if (loot>60 && loot<300) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.meatpie,1));} 
      	  if (loot>300 && loot<500) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.cutcabbage,1));} 
      	  if (loot>500 && loot<530) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_phat.whiteChestplate));} 
      	  if (loot>530 && loot<560) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_phat.whiteHelmet));} 
     	  if (loot>560 && loot<580) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_phat.whiteLeggings));} 
     	  if (loot>580 && loot<600) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_phat.whiteBoots));} 
      	  if (loot>560 && loot<960) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.coal,1));} 
      	  if (loot>960 && loot<1000) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_BlocksGalore.Mithore,1));} 
      	  if (loot==1000 && rate>75) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.gloves2,1));} 
    	 }
    	else {EntityPlayer.attackEntityFrom(DamageSource.cactus, 6.0F); }}}}
  		else {EntityPlayer.addChatMessage("\u00a7EYou need level 25 Thieving to attempt to pickpocket from this NPC");}
  		}return true;}
      
      
      if (par3EntityLivingBase instanceof EntityWizard)
      {	  if(!EntityPlayer.worldObj.isRemote) {
    	  ExtendedPlayer props = ExtendedPlayer.get(EntityPlayer);		
  		if (props.getTheifxp() > 3000){{
    	  if (props.getTheifcd() >=  99){
  			props.addTcd(-250);
    	 int rate = randInt(1,100);
    	 int loot = randInt(1,1000);
    	 if (EntityPlayer.inventory.getFirstEmptyStack() == -1) {
						EntityPlayer.addChatMessage("\u00a7EYour inventory is full.");
					} else if (rate > 65) {
    	 ExtendedPlayer.get(EntityPlayer).addTXp(3);
    	  EntityPlayer.addChatMessage("\u00a7ESuccessful thieving attempt");
    	  
    	  if (loot>1 && loot<100) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.goldNugget,5));} 
      	  if (loot>60 && loot<300) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.cabbagepie,1));} 
      	  if (loot>300 && loot<450) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.cutcabbage,1));} 
      	  if (loot>450 && loot<500) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.sarabrew,1));}
      	  if (loot>500 && loot<530) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.Vtab));} 
      	  if (loot>530 && loot<560) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.Ftab));} 
     	  if (loot>560 && loot<580) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.Htab));} 
     	  if (loot>580 && loot<600) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.Ltab));} 
      	  if (loot>560 && loot<975) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.flint,1));} 
      	  if (loot>975 && loot<1000) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_BlocksGalore.Addyore,1));} 
      	  if (loot==1000 && rate>75) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.gloves2,1));} 
    	 }
    	else {EntityPlayer.attackEntityFrom(DamageSource.cactus, 13.0F); }}}}
  		else {EntityPlayer.addChatMessage("\u00a7EYou need level 25 Thieving to attempt to pickpocket from this NPC");}
  		}return true;}
      
      
      if (par3EntityLivingBase instanceof EntityHeroKnight)
      {	  if(!EntityPlayer.worldObj.isRemote) {
    	  ExtendedPlayer props = ExtendedPlayer.get(EntityPlayer);		
  		if (props.getTheifxp() >  8784){{
    	  if (props.getTheifcd() >=  99){
  			props.addTcd(-250);
    	 int rate = randInt(1,100);
    	 int loot = randInt(1,1000);
    	 if (EntityPlayer.inventory.getFirstEmptyStack() == -1) {
						EntityPlayer.addChatMessage("\u00a7EYour inventory is full.");
					} else if (rate > 85) {
    	 ExtendedPlayer.get(EntityPlayer).addTXp(10);
    	  EntityPlayer.addChatMessage("\u00a7ESuccessful thieving attempt");
    	  
    	  if (loot>1 && loot<100) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.goldNugget,9));} 
      	  if (loot>60 && loot<300) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.fishpie,4));} 
      	  if (loot>300 && loot<500) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_Flower.cutcabbage,10));} 
      	  if (loot>500 && loot<530) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_phat.whiteChestplate));} 
      	  if (loot>530 && loot<560) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_phat.whiteHelmet));} 
     	  if (loot>560 && loot<580) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_phat.whiteLeggings));} 
     	  if (loot>580 && loot<600) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_phat.whiteBoots));} 
      	  if (loot>560 && loot<930) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.coal,4));} 
      	  if (loot>990 && loot<1000) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_phat.dragonBoots));
      	MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatMessageComponent().addText("Someone has stolen a pair of dragon boots")));} 
      	  if (loot==1000 && rate>90) {EntityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_BlocksGalore.Gmaul));
        	MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatMessageComponent().addText("Someone has stolen a Granite Maul!!")));} 
    	 }
    	else {EntityPlayer.attackEntityFrom(DamageSource.cactus, 16.0F); }}}}
  		else {EntityPlayer.addChatMessage("\u00a7EYou need level 30 Thieving to attempt to pickpocket from this NPC");}
  		}return true;}
      
      
      
      else
      {
          return false;
      }}
  
  
  public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer entityplayer){
	
	{
	
		return itemstack;}
	}
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister ir)
  {
          {
          this.itemIcon = ir.registerIcon("gloves");
          }
  }
	}
