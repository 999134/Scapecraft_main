package net.minecraft.src;
import java.util.Random;

import static net.minecraft.src.ExtendedPlayer.getLevel;
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


  
 public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
	{
			ExtendedPlayer props = ExtendedPlayer.get(entityplayer);
			if (world.isRemote) {
				entityplayer.addChatMessage("Your current Combat level is " + getLevel(props.getCombatxp())
						+ ", and your current xp is " + String.valueOf(props.getCombatxp()));
				entityplayer.addChatMessage("Your current Agility  level is " + getLevel(props.getAgilityxp())
						+ ", and your current xp is " + String.valueOf(props.getAgilityxp()));
				entityplayer.addChatMessage("Your current Thieving level is " + getLevel(props.getTheifxp())
						+ ", and your current xp is " + String.valueOf(props.getTheifxp()));
				entityplayer.addChatMessage("Your current Mining level is " + getLevel(props.getMiningxp())
						+ ", and your current xp is " + String.valueOf(props.getMiningxp()));
				return itemstack;
			}
			return itemstack;
		}
	}
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister ir)
  {
          {
          this.itemIcon = ir.registerIcon("Stats");
          }
  }
	}
