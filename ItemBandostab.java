package net.minecraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBandostab extends Item {

	public ItemBandostab(int i) {
		super(i);
		this.setCreativeTab(CreativeTabs.tabMaterials);

	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		ExtendedPlayer props = ExtendedPlayer.get(entityplayer);

		if (props.getCombatxp() > 138) {
			entityplayer.setPositionAndUpdate(-813, 7, -148);
			--itemstack.stackSize;
			return itemstack;
		} else
			entityplayer.addChatMessage("\u00a7EYou must be at least level 10 to use this item");

		entityplayer
				.addChatMessage("You need " + String.valueOf(138 - props.getCombatxp()) + " more exp to use this time");
		return itemstack;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		{
			this.itemIcon = ir.registerIcon("bandostele");
		}
	}

}