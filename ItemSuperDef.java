package net.minecraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSuperDef extends Item {

	public ItemSuperDef(int i) {
		super(i);
		this.setCreativeTab(CreativeTabs.tabMaterials);

	}

	public boolean hasEffect(ItemStack itemstack) {
		return false;
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {

		ExtendedPlayer props = ExtendedPlayer.get(entityplayer);
		if (props.getTheifcd() >= 99) {
			props.addTcd(-40);
			entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 600, 1));
			--itemstack.stackSize;
			return itemstack;
		}
		return itemstack;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		{
			this.itemIcon = ir.registerIcon("superdef");
		}
	}

}
