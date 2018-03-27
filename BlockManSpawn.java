package net.minecraft.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class BlockManSpawn extends Block {
	public BlockManSpawn(int i, int j) {
		super(i, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setTickRandomly(true);

	}

	public void updateTick(World world, int x, int y, int z, Random par5Random)

	{
		// world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
		EntityMan entity = new EntityMan(world);
		entity.setLocationAndAngles(x + 0.5, y + 1, z + 0.5, world.rand.nextFloat() * 360.0F, 0.0F);
		world.spawnEntityInWorld(entity);
		world.setBlock(x, y + 1, z, 0);
		world.setBlock(x, y + 2, z, 0);
		world.setBlock(x, y + 3, z, 0);
		// world.setBlockWithNotify(x, y, z, 0);

	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return stone.blockID;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {

		{
			this.blockIcon = ir.registerIcon("planks_oak");
		}
	}
}
