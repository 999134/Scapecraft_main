package net.minecraft.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class BlockIceGiantSpawn extends Block
{
    public BlockIceGiantSpawn(int i, int j)
    {
        super(i, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    

		setTickRandomly(true);
    }
    

    
    

    public void updateTick(World world, int x, int y, int z, Random par5Random)

	{
    	
    	
   // 	world.addWeatherEffect(new EntityLightningBolt(world, x, y+1, z));
    	//world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
    	
		EntityIceGiant entity = new EntityIceGiant(world);
		entity.setLocationAndAngles(x, y + 1, z,
				world.rand.nextFloat() * 360.0F, 0.0F);
		world.spawnEntityInWorld(entity);
		 world.setBlock(x, y+1, z, 0);
		  world.setBlock(x, y+2, z, 0);
		  world.setBlock(x, y+3, z, 0);
		//world.setBlockWithNotify(x, y, z, 0);

	}
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return snow.blockID;
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir)
    {
           
            {
            this.blockIcon = ir.registerIcon("IceGiantSpawn");
            }
    }
}
