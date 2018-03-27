package net.minecraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBtab extends Item {

	public ItemBtab(int i) {
		super(i);
		this.setCreativeTab(CreativeTabs.tabMaterials);

	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (entityplayer.getHealth() >= entityplayer.getMaxHealth() - 2.0F) {
			entityplayer.setPositionAndUpdate(-971, 70, -87);
			--itemstack.stackSize;
			return itemstack;
		}
		entityplayer.addChatMessage("\u00a7EYou must be at a higher HP to use this item!");
		return itemstack;

	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		{
			this.itemIcon = ir.registerIcon("btab");
		}
	}

}