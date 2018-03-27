package net.minecraft.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockGuthanSpawn extends Block {
	int intspawn = 0;

	public BlockGuthanSpawn(int i, int j) {
		super(i, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		if (intspawn <= 0) {
			setTickRandomly(true);
		}
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer,
			int par6, float par7, float par8, float par9) {
		{
			par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
			return true;
		}
	}

	// @Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
	}

	public int tickRate(World par1World) {
		return 20 * 300;
	}

	public void updateTick(World world, int x, int y, int z, Random par5Random)

	{
		world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
		EntityGuthan entity = new EntityGuthan(world);
		entity.setLocationAndAngles(x + 0.5, y + 1, z + 0.5, world.rand.nextFloat() * 360.0F, 0.0F);
		world.spawnEntityInWorld(entity);
		world.setBlock(x, y + 1, z, 0);
		world.setBlock(x, y + 2, z, 0);
		if (intspawn < 50) {
			intspawn += 1;
			setTickRandomly(false);
		} else {
			intspawn = 0;
			setTickRandomly(true);
		}
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return stone.blockID;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {

		{
			this.blockIcon = ir.registerIcon("BarrowSpawn");
		}
	}
}
