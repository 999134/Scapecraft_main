package net.minecraft.src;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (id == GuiTurael.GUIID)
			return new GuiTurael.GuiContainerMod(world, x, y, z, player);
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (id == GuiTurael.GUIID)
			return new GuiTurael.GuiWindow(world, x, y, z, player);
		return null;
	}
}
