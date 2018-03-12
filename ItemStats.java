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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStats extends Item {

public ItemStats(int i)
  {
   super(i);
   this.setCreativeTab(CreativeTabs.tabMaterials);
  
  }

  public boolean hasEffect(ItemStack itemstack)
  {
   return false;
  }


  
  public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer entityplayer){
	
	{
		ExtendedPlayer props = ExtendedPlayer.get(entityplayer);
		ExtendedPlayer propsa = ExtendedPlayer.get(entityplayer);
		if (world.isRemote){
		if (props.getCombatxp() >= 0*2 && props.getCombatxp() < 5*2) {entityplayer.addChatMessage("Your current Combat level is 1, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 5*2 && props.getCombatxp() < 15*2) {	entityplayer.addChatMessage("Your current Combat level is 2, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 15*2 && props.getCombatxp() < 30*2) {	entityplayer.addChatMessage("Your current Combat level is 3, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 30*2 && props.getCombatxp() < 50*2) {	entityplayer.addChatMessage("Your current Combat level is 4, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 50*2 && props.getCombatxp() < 75*2) {	entityplayer.addChatMessage("Your current Combat level is 5, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 75*2 && props.getCombatxp() < 90*2) {	entityplayer.addChatMessage("Your current Combat level is 6, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 90*2 && props.getCombatxp() < 112*2) {	entityplayer.addChatMessage("Your current Combat level is 7, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 112*2 && props.getCombatxp() < 124*2) {	entityplayer.addChatMessage("Your current Combat level is 8, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 124*2 && props.getCombatxp() < 138*2) {	entityplayer.addChatMessage("Your current Combat level is 9, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 138*2 && props.getCombatxp() < 151*2) {	entityplayer.addChatMessage("Your current Combat level is 10, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 151*2 && props.getCombatxp() < 168*2) {	entityplayer.addChatMessage("Your current Combat level is 11, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 168*2 && props.getCombatxp() < 185*2) {	entityplayer.addChatMessage("Your current Combat level is 12, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 185*2 && props.getCombatxp() < 204*2) {	entityplayer.addChatMessage("Your current Combat level is 13, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 204*2 && props.getCombatxp() < 226*2) {	entityplayer.addChatMessage("Your current Combat level is 14, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 226*2 && props.getCombatxp() < 249*2) {	entityplayer.addChatMessage("Your current Combat level is 15, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 498 && props.getCombatxp() < 600) {	entityplayer.addChatMessage("Your current Combat level is 16, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 600 && props.getCombatxp() < 720) {	entityplayer.addChatMessage("Your current Combat level is 17, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 720 && props.getCombatxp() < 850) {	entityplayer.addChatMessage("Your current Combat level is 18, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 850 && props.getCombatxp() < 950) {	entityplayer.addChatMessage("Your current Combat level is 19, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 950 && props.getCombatxp() < 1060) {	entityplayer.addChatMessage("Your current Combat level is 20, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 1060 && props.getCombatxp() < 1200) {	entityplayer.addChatMessage("Your current Combat level is 21, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 1200 && props.getCombatxp() < 1700) {	entityplayer.addChatMessage("Your current Combat level is 22, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 1700 && props.getCombatxp() < 2300) {	entityplayer.addChatMessage("Your current Combat level is 23, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 2300 && props.getCombatxp() < 3000) {	entityplayer.addChatMessage("Your current Combat level is 24, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 3000 && props.getCombatxp() < 3800) {	entityplayer.addChatMessage("Your current Combat level is 25, and your current xp is "+String.valueOf(props.getCombatxp()));}		
		else if (props.getCombatxp() >= 3800 && props.getCombatxp() < 4700) {	entityplayer.addChatMessage("Your current Combat level is 26, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 4700 && props.getCombatxp() < 6100) {	entityplayer.addChatMessage("Your current Combat level is 27, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 6100 && props.getCombatxp() < 7320) {	entityplayer.addChatMessage("Your current Combat level is 28, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 7320 && props.getCombatxp() < 8784) {	entityplayer.addChatMessage("Your current Combat level is 29, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 8784 && props.getCombatxp() < 10540) {  entityplayer.addChatMessage("Your current Combat level is 30, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 10540 && props.getCombatxp() < 12648) { entityplayer.addChatMessage("Your current Combat level is 31, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 12648 && props.getCombatxp() < 15178) {entityplayer.addChatMessage("Your current Combat level is 32, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 15178 && props.getCombatxp() < 18214) {entityplayer.addChatMessage("Your current Combat level is 33, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 18214 && props.getCombatxp() < 21857) {entityplayer.addChatMessage("Your current Combat level is 34, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 21857 && props.getCombatxp() < 26228) {entityplayer.addChatMessage("Your current Combat level is 35, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 26228 && props.getCombatxp() < 31474) {entityplayer.addChatMessage("Your current Combat level is 36, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 31474 && props.getCombatxp() < 37769) {entityplayer.addChatMessage("Your current Combat level is 37, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 37769 && props.getCombatxp() < 45323) {entityplayer.addChatMessage("Your current Combat level is 38, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 45323 && props.getCombatxp() < 54388) {entityplayer.addChatMessage("Your current Combat level is 39, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 54388 && props.getCombatxp() < 65265) {entityplayer.addChatMessage("Your current Combat level is 40, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 65265 && props.getCombatxp() < 78319) {entityplayer.addChatMessage("Your current Combat level is 41, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 78319 && props.getCombatxp() < 93982) {entityplayer.addChatMessage("Your current Combat level is 42, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 93982 && props.getCombatxp() < 112779) {entityplayer.addChatMessage("Your current Combat level is 43, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 112779 && props.getCombatxp() < 135335) {entityplayer.addChatMessage("Your current Combat level is 44, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 135335 && props.getCombatxp() < 162402) {entityplayer.addChatMessage("Your current Combat level is 45, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 162402 && props.getCombatxp() < 194822) {entityplayer.addChatMessage("Your current Combat level is 46, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 233859 && props.getCombatxp() < 233859) {entityplayer.addChatMessage("Your current Combat level is 47, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 280631 && props.getCombatxp() < 336757) {entityplayer.addChatMessage("Your current Combat level is 48, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 336757 && props.getCombatxp() < 404108) {entityplayer.addChatMessage("Your current Combat level is 49, and your current xp is "+String.valueOf(props.getCombatxp()));}
		else if (props.getCombatxp() >= 404108) {	entityplayer.addChatMessage("Your current Combat level is 50, and your current xp is "+String.valueOf(props.getCombatxp())+" You have maxed out this skill!");}		
		else if (props.getCombatxp() <= 0) {	entityplayer.addChatMessage("Your current Combat level is 0, and your current xp is "+String.valueOf(props.getCombatxp()));}
		
		
		if (propsa.getAgilityxp() >= 0*2 && propsa.getAgilityxp() < 5*2) {entityplayer.addChatMessage("Your current Agility  level is 1, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 5*2 && propsa.getAgilityxp() < 15*2) {	entityplayer.addChatMessage("Your current Agility  level is 2, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 15*2 && propsa.getAgilityxp() < 30*2) {	entityplayer.addChatMessage("Your current Agility  level is 3, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 30*2 && propsa.getAgilityxp() < 50*2) {	entityplayer.addChatMessage("Your current Agility  level is 4, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 50*2 && propsa.getAgilityxp() < 75*2) {	entityplayer.addChatMessage("Your current Agility  level is 5, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 75*2 && propsa.getAgilityxp() < 90*2) {	entityplayer.addChatMessage("Your current Agility  level is 6, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 90*2 && propsa.getAgilityxp() < 112*2) {	entityplayer.addChatMessage("Your current Agility  level is 7, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 112*2 && propsa.getAgilityxp() < 124*2) {	entityplayer.addChatMessage("Your current Agility  level is 8, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 124*2 && propsa.getAgilityxp() < 138*2) {	entityplayer.addChatMessage("Your current Agility  level is 9, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 138*2 && propsa.getAgilityxp() < 151*2) {	entityplayer.addChatMessage("Your current Agility  level is 10, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 151*2 && propsa.getAgilityxp() < 168*2) {	entityplayer.addChatMessage("Your current Agility  level is 11, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 168*2 && propsa.getAgilityxp() < 185*2) {	entityplayer.addChatMessage("Your current Agility  level is 12, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 185*2 && propsa.getAgilityxp() < 204*2) {	entityplayer.addChatMessage("Your current Agility  level is 13, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 204*2 && propsa.getAgilityxp() < 226*2) {	entityplayer.addChatMessage("Your current Agility  level is 14, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 226*2 && propsa.getAgilityxp() < 249*2) {	entityplayer.addChatMessage("Your current Agility  level is 15, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 498 && propsa.getAgilityxp() < 600) {	entityplayer.addChatMessage("Your current Agility  level is 16, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 600 && propsa.getAgilityxp() < 720) {	entityplayer.addChatMessage("Your current Agility  level is 17, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 720 && propsa.getAgilityxp() < 850) {	entityplayer.addChatMessage("Your current Agility  level is 18, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 850 && propsa.getAgilityxp() < 950) {	entityplayer.addChatMessage("Your current Agility  level is 19, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 950 && propsa.getAgilityxp() < 1060) {	entityplayer.addChatMessage("Your current Agility  level is 20, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 1060 && propsa.getAgilityxp() < 1200) {	entityplayer.addChatMessage("Your current Agility  level is 21, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 1200 && propsa.getAgilityxp() < 1700) {	entityplayer.addChatMessage("Your current Agility  level is 22, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 1700 && propsa.getAgilityxp() < 2300) {	entityplayer.addChatMessage("Your current Agility  level is 23, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 2300 && propsa.getAgilityxp() < 3000) {	entityplayer.addChatMessage("Your current Agility  level is 24, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 3000 && propsa.getAgilityxp() < 3800) {	entityplayer.addChatMessage("Your current Agility  level is 25, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}		
		else if (propsa.getAgilityxp() >= 3800 && propsa.getAgilityxp() < 4700) {	entityplayer.addChatMessage("Your current Agility  level is 26, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 4700 && propsa.getAgilityxp() < 6100) {	entityplayer.addChatMessage("Your current Agility  level is 27, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 6100 && propsa.getAgilityxp() < 7320) {	entityplayer.addChatMessage("Your current Agility  level is 28, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 7320 && propsa.getAgilityxp() < 8784) {	entityplayer.addChatMessage("Your current Agility  level is 29, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 8784 && propsa.getAgilityxp() < 10540) {  entityplayer.addChatMessage("Your current Agility  level is 30, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 10540 && propsa.getAgilityxp() < 12648) { entityplayer.addChatMessage("Your current Agility  level is 31, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 12648 && propsa.getAgilityxp() < 15178) {entityplayer.addChatMessage("Your current Agility  level is 32, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 15178 && propsa.getAgilityxp() < 18214) {entityplayer.addChatMessage("Your current Agility  level is 33, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 18214 && propsa.getAgilityxp() < 21857) {entityplayer.addChatMessage("Your current Agility  level is 34, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 21857 && propsa.getAgilityxp() < 26228) {entityplayer.addChatMessage("Your current Agility  level is 35, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 26228 && propsa.getAgilityxp() < 31474) {entityplayer.addChatMessage("Your current Agility  level is 36, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 31474 && propsa.getAgilityxp() < 37769) {entityplayer.addChatMessage("Your current Agility  level is 37, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 37769 && propsa.getAgilityxp() < 45323) {entityplayer.addChatMessage("Your current Agility  level is 38, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 45323 && propsa.getAgilityxp() < 54388) {entityplayer.addChatMessage("Your current Agility  level is 39, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 54388 && propsa.getAgilityxp() < 65265) {entityplayer.addChatMessage("Your current Agility  level is 40, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 65265 && propsa.getAgilityxp() < 78319) {entityplayer.addChatMessage("Your current Agility  level is 41, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 78319 && propsa.getAgilityxp() < 93982) {entityplayer.addChatMessage("Your current Agility  level is 42, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 93982 && propsa.getAgilityxp() < 112779) {entityplayer.addChatMessage("Your current Agility  level is 43, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 112779 && propsa.getAgilityxp() < 135335) {entityplayer.addChatMessage("Your current Agility  level is 44, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 135335 && propsa.getAgilityxp() < 162402) {entityplayer.addChatMessage("Your current Agility  level is 45, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 162402 && propsa.getAgilityxp() < 194822) {entityplayer.addChatMessage("Your current Agility  level is 46, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 233859 && propsa.getAgilityxp() < 233859) {entityplayer.addChatMessage("Your current Agility  level is 47, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 280631 && propsa.getAgilityxp() < 336757) {entityplayer.addChatMessage("Your current Agility  level is 48, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 336757 && propsa.getAgilityxp() < 404108) {entityplayer.addChatMessage("Your current Agility  level is 49, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		else if (propsa.getAgilityxp() >= 404108) {	entityplayer.addChatMessage("Your current Agility  level is 50, and your current xp is "+String.valueOf(propsa.getAgilityxp())+" You have maxed out this skill!");}		
		else if (propsa.getAgilityxp() <= 0) {	entityplayer.addChatMessage("Your current Agility  level is 0, and your current xp is "+String.valueOf(propsa.getAgilityxp()));}
		
		if (propsa.getTheifxp() >= 0*2 && propsa.getTheifxp() < 5*2) {entityplayer.addChatMessage("Your current Thieving level is 1, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 5*2 && propsa.getTheifxp() < 15*2) {	entityplayer.addChatMessage("Your current Thieving level is 2, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 15*2 && propsa.getTheifxp() < 30*2) {	entityplayer.addChatMessage("Your current Thieving level is 3, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 30*2 && propsa.getTheifxp() < 50*2) {	entityplayer.addChatMessage("Your current Thieving level is 4, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 50*2 && propsa.getTheifxp() < 75*2) {	entityplayer.addChatMessage("Your current Thieving level is 5, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 75*2 && propsa.getTheifxp() < 90*2) {	entityplayer.addChatMessage("Your current Thieving level is 6, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 90*2 && propsa.getTheifxp() < 112*2) {	entityplayer.addChatMessage("Your current Thieving level is 7, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 112*2 && propsa.getTheifxp() < 124*2) {	entityplayer.addChatMessage("Your current Thieving level is 8, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 124*2 && propsa.getTheifxp() < 138*2) {	entityplayer.addChatMessage("Your current Thieving level is 9, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 138*2 && propsa.getTheifxp() < 151*2) {	entityplayer.addChatMessage("Your current Thieving level is 10, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 151*2 && propsa.getTheifxp() < 168*2) {	entityplayer.addChatMessage("Your current Thieving level is 11, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 168*2 && propsa.getTheifxp() < 185*2) {	entityplayer.addChatMessage("Your current Thieving level is 12, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 185*2 && propsa.getTheifxp() < 204*2) {	entityplayer.addChatMessage("Your current Thieving level is 13, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 204*2 && propsa.getTheifxp() < 226*2) {	entityplayer.addChatMessage("Your current Thieving level is 14, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 226*2 && propsa.getTheifxp() < 249*2) {	entityplayer.addChatMessage("Your current Thieving level is 15, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 498 && propsa.getTheifxp() < 600) {	entityplayer.addChatMessage("Your current Thieving level is 16, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 600 && propsa.getTheifxp() < 720) {	entityplayer.addChatMessage("Your current Thieving level is 17, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 720 && propsa.getTheifxp() < 850) {	entityplayer.addChatMessage("Your current Thieving level is 18, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 850 && propsa.getTheifxp() < 950) {	entityplayer.addChatMessage("Your current Thieving level is 19, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 950 && propsa.getTheifxp() < 1060) {	entityplayer.addChatMessage("Your current Thieving level is 20, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 1060 && propsa.getTheifxp() < 1200) {	entityplayer.addChatMessage("Your current Thieving level is 21, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 1200 && propsa.getTheifxp() < 1700) {	entityplayer.addChatMessage("Your current Thieving level is 22, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 1700 && propsa.getTheifxp() < 2300) {	entityplayer.addChatMessage("Your current Thieving level is 23, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 2300 && propsa.getTheifxp() < 3000) {	entityplayer.addChatMessage("Your current Thieving level is 24, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 3000 && propsa.getTheifxp() < 3800) {	entityplayer.addChatMessage("Your current Thieving level is 25, and your current xp is "+String.valueOf(propsa.getTheifxp()));}		
		else if (propsa.getTheifxp() >= 3800 && propsa.getTheifxp() < 4700) {	entityplayer.addChatMessage("Your current Thieving level is 26, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 4700 && propsa.getTheifxp() < 6100) {	entityplayer.addChatMessage("Your current Thieving level is 27, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 6100 && propsa.getTheifxp() < 7320) {	entityplayer.addChatMessage("Your current Thieving level is 28, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 7320 && propsa.getTheifxp() < 8784) {	entityplayer.addChatMessage("Your current Thieving level is 29, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 8784 && propsa.getTheifxp() < 10540) {  entityplayer.addChatMessage("Your current Thieving level is 30, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 10540 && propsa.getTheifxp() < 12648) { entityplayer.addChatMessage("Your current Thieving level is 31, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 12648 && propsa.getTheifxp() < 15178) {entityplayer.addChatMessage("Your current Thieving level is 32, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 15178 && propsa.getTheifxp() < 18214) {entityplayer.addChatMessage("Your current Thieving level is 33, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 18214 && propsa.getTheifxp() < 21857) {entityplayer.addChatMessage("Your current Thieving level is 34, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 21857 && propsa.getTheifxp() < 26228) {entityplayer.addChatMessage("Your current Thieving level is 35, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 26228 && propsa.getTheifxp() < 31474) {entityplayer.addChatMessage("Your current Thieving level is 36, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 31474 && propsa.getTheifxp() < 37769) {entityplayer.addChatMessage("Your current Thieving level is 37, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 37769 && propsa.getTheifxp() < 45323) {entityplayer.addChatMessage("Your current Thieving level is 38, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 45323 && propsa.getTheifxp() < 54388) {entityplayer.addChatMessage("Your current Thieving level is 39, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 54388 && propsa.getTheifxp() < 65265) {entityplayer.addChatMessage("Your current Thieving level is 40, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 65265 && propsa.getTheifxp() < 78319) {entityplayer.addChatMessage("Your current Thieving level is 41, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 78319 && propsa.getTheifxp() < 93982) {entityplayer.addChatMessage("Your current Thieving level is 42, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 93982 && propsa.getTheifxp() < 112779) {entityplayer.addChatMessage("Your current Thieving level is 43, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 112779 && propsa.getTheifxp() < 135335) {entityplayer.addChatMessage("Your current Thieving level is 44, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 135335 && propsa.getTheifxp() < 162402) {entityplayer.addChatMessage("Your current Thieving level is 45, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 162402 && propsa.getTheifxp() < 194822) {entityplayer.addChatMessage("Your current Thieving level is 46, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 233859 && propsa.getTheifxp() < 233859) {entityplayer.addChatMessage("Your current Thieving level is 47, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 280631 && propsa.getTheifxp() < 336757) {entityplayer.addChatMessage("Your current Thieving level is 48, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 336757 && propsa.getTheifxp() < 404108) {entityplayer.addChatMessage("Your current Thieving level is 49, and your current xp is "+String.valueOf(propsa.getTheifxp()));}
		else if (propsa.getTheifxp() >= 404108) {	entityplayer.addChatMessage("Your current Thieving level is 50, and your current xp is "+String.valueOf(propsa.getTheifxp())+" You have maxed out this skill!");}		
		else if (propsa.getTheifxp() <= 0) {	entityplayer.addChatMessage("Your current Thieving level is 0, and your current xp is "+String.valueOf(propsa.getTheifxp()));}		
		
		if (propsa.getMiningxp() >= 0*2 && propsa.getMiningxp() < 5*2) {entityplayer.addChatMessage("Your current Mining level is 1, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 5*2 && propsa.getMiningxp() < 15*2) {	entityplayer.addChatMessage("Your current Mining level is 2, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 15*2 && propsa.getMiningxp() < 30*2) {	entityplayer.addChatMessage("Your current Mining level is 3, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 30*2 && propsa.getMiningxp() < 50*2) {	entityplayer.addChatMessage("Your current Mining level is 4, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 50*2 && propsa.getMiningxp() < 75*2) {	entityplayer.addChatMessage("Your current Mining level is 5, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 75*2 && propsa.getMiningxp() < 90*2) {	entityplayer.addChatMessage("Your current Mining level is 6, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 90*2 && propsa.getMiningxp() < 112*2) {	entityplayer.addChatMessage("Your current Mining level is 7, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 112*2 && propsa.getMiningxp() < 124*2) {	entityplayer.addChatMessage("Your current Mining level is 8, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 124*2 && propsa.getMiningxp() < 138*2) {	entityplayer.addChatMessage("Your current Mining level is 9, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 138*2 && propsa.getMiningxp() < 151*2) {	entityplayer.addChatMessage("Your current Mining level is 10, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 151*2 && propsa.getMiningxp() < 168*2) {	entityplayer.addChatMessage("Your current Mining level is 11, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 168*2 && propsa.getMiningxp() < 185*2) {	entityplayer.addChatMessage("Your current Mining level is 12, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 185*2 && propsa.getMiningxp() < 204*2) {	entityplayer.addChatMessage("Your current Mining level is 13, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 204*2 && propsa.getMiningxp() < 226*2) {	entityplayer.addChatMessage("Your current Mining level is 14, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 226*2 && propsa.getMiningxp() < 249*2) {	entityplayer.addChatMessage("Your current Mining level is 15, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 498 && propsa.getMiningxp() < 600) {	entityplayer.addChatMessage("Your current Mining level is 16, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 600 && propsa.getMiningxp() < 720) {	entityplayer.addChatMessage("Your current Mining level is 17, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 720 && propsa.getMiningxp() < 850) {	entityplayer.addChatMessage("Your current Mining level is 18, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 850 && propsa.getMiningxp() < 950) {	entityplayer.addChatMessage("Your current Mining level is 19, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 950 && propsa.getMiningxp() < 1060) {	entityplayer.addChatMessage("Your current Mining level is 20, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 1060 && propsa.getMiningxp() < 1200) {	entityplayer.addChatMessage("Your current Mining level is 21, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 1200 && propsa.getMiningxp() < 1700) {	entityplayer.addChatMessage("Your current Mining level is 22, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 1700 && propsa.getMiningxp() < 2300) {	entityplayer.addChatMessage("Your current Mining level is 23, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 2300 && propsa.getMiningxp() < 3000) {	entityplayer.addChatMessage("Your current Mining level is 24, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 3000 && propsa.getMiningxp() < 3800) {	entityplayer.addChatMessage("Your current Mining level is 25, and your current xp is "+String.valueOf(propsa.getMiningxp()));}		
		else if (propsa.getMiningxp() >= 3800 && propsa.getMiningxp() < 4700) {	entityplayer.addChatMessage("Your current Mining level is 26, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 4700 && propsa.getMiningxp() < 6100) {	entityplayer.addChatMessage("Your current Mining level is 27, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 6100 && propsa.getMiningxp() < 7320) {	entityplayer.addChatMessage("Your current Mining level is 28, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 7320 && propsa.getMiningxp() < 8784) {	entityplayer.addChatMessage("Your current Mining level is 29, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 8784 && propsa.getMiningxp() < 10540) {  entityplayer.addChatMessage("Your current Mining level is 30, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 10540 && propsa.getMiningxp() < 12648) { entityplayer.addChatMessage("Your current Mining level is 31, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 12648 && propsa.getMiningxp() < 15178) {entityplayer.addChatMessage("Your current Mining level is 32, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 15178 && propsa.getMiningxp() < 18214) {entityplayer.addChatMessage("Your current Mining level is 33, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 18214 && propsa.getMiningxp() < 21857) {entityplayer.addChatMessage("Your current Mining level is 34, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 21857 && propsa.getMiningxp() < 26228) {entityplayer.addChatMessage("Your current Mining level is 35, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 26228 && propsa.getMiningxp() < 31474) {entityplayer.addChatMessage("Your current Mining level is 36, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 31474 && propsa.getMiningxp() < 37769) {entityplayer.addChatMessage("Your current Mining level is 37, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 37769 && propsa.getMiningxp() < 45323) {entityplayer.addChatMessage("Your current Mining level is 38, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 45323 && propsa.getMiningxp() < 54388) {entityplayer.addChatMessage("Your current Mining level is 39, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 54388 && propsa.getMiningxp() < 65265) {entityplayer.addChatMessage("Your current Mining level is 40, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 65265 && propsa.getMiningxp() < 78319) {entityplayer.addChatMessage("Your current Mining level is 41, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 78319 && propsa.getMiningxp() < 93982) {entityplayer.addChatMessage("Your current Mining level is 42, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 93982 && propsa.getMiningxp() < 112779) {entityplayer.addChatMessage("Your current Mining level is 43, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 112779 && propsa.getMiningxp() < 135335) {entityplayer.addChatMessage("Your current Mining level is 44, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 135335 && propsa.getMiningxp() < 162402) {entityplayer.addChatMessage("Your current Mining level is 45, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 162402 && propsa.getMiningxp() < 194822) {entityplayer.addChatMessage("Your current Mining level is 46, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 233859 && propsa.getMiningxp() < 233859) {entityplayer.addChatMessage("Your current Mining level is 47, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 280631 && propsa.getMiningxp() < 336757) {entityplayer.addChatMessage("Your current Mining level is 48, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 336757 && propsa.getMiningxp() < 404108) {entityplayer.addChatMessage("Your current Mining level is 49, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		else if (propsa.getMiningxp() >= 404108) {	entityplayer.addChatMessage("Your current Mining level is 50, and your current xp is "+String.valueOf(propsa.getMiningxp())+" You have maxed out this skill!");}		
		else if (propsa.getMiningxp() <= 0) {	entityplayer.addChatMessage("Your current Mining level is 0, and your current xp is "+String.valueOf(propsa.getMiningxp()));}
		
	
		
		
		return itemstack;}
		
		return itemstack;}
	}
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister ir)
  {
          {
          this.itemIcon = ir.registerIcon("Stats");
          }
  }
	}
