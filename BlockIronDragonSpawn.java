package net.minecraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockIronDragonSpawn extends BlockBreakable
{
    public BlockIronDragonSpawn(int par1)
    {
        super(par1, "ice", Material.ice, false);
        this.slipperiness = 0.98F;
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }


    
    @SideOnly(Side.CLIENT)

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        par2EntityPlayer.addStat(StatList.mineBlockStatArray[this.blockID], 1);
        par2EntityPlayer.addExhaustion(0.025F);

        if (this.canSilkHarvest() && EnchantmentHelper.getSilkTouchModifier(par2EntityPlayer))
        {
            ItemStack itemstack = this.createStackedBlock(par6);

            if (itemstack != null)
            {
                this.dropBlockAsItem_do(par1World, par3, par4, par5, itemstack);
            }
        }
        else
        {
            if (par1World.provider.isHellWorld)
            {
                par1World.setBlockToAir(par3, par4, par5);
                return;
            }

            int i1 = EnchantmentHelper.getFortuneModifier(par2EntityPlayer);
            this.dropBlockAsItem(par1World, par3, par4, par5, par6, i1);
            Material material = par1World.getBlockMaterial(par3, par4 - 1, par5);

            if (material.blocksMovement() || material.isLiquid())
            {
                par1World.setBlock(par3, par4, par5, Block.waterMoving.blockID);
            }
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    //	par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    	EntityIronDragon entity = new EntityIronDragon(par1World);
		entity.setLocationAndAngles(par2, par3 + 1, par4,
				par1World.rand.nextFloat() * 360.0F, 0.0F);
		par1World.spawnEntityInWorld(entity);
		 par1World.setBlock(par2, par3+1, par4, 0);
		  par1World.setBlock(par2, par3+2, par4, 0);
		  par1World.setBlock(par2, par3+3, par4, 0);
		  par1World.setBlock(par2, par3+4, par4, 0);
		  par1World.setBlock(par2, par3+5, par4, 0);
		  
		  par1World.setBlock(par2+1, par3+5, par4, 0);
		  par1World.setBlock(par2-2, par3+5, par4, 0);
		  par1World.setBlock(par2+2, par3+5, par4, 0);
		  par1World.setBlock(par2-2, par3+5, par4, 0);
		  par1World.setBlock(par2, par3+5, par4+1, 0);
		  par1World.setBlock(par2, par3+5, par4-1, 0);
		  par1World.setBlock(par2, par3+5, par4+2, 0);
		  par1World.setBlock(par2, par3+5, par4-2, 0);
		  par1World.setBlock(par2+1, par3+5, par4+1, 0);
		  par1World.setBlock(par2+1, par3+5, par4-1, 0);
		  par1World.setBlock(par2-1, par3+5, par4+1, 0);
		  par1World.setBlock(par2-1, par3+5, par4-1, 0);
		  
			  
			  par1World.setBlock(par2+1, par3+4, par4, 0);
			  par1World.setBlock(par2-2, par3+4, par4, 0);
			  par1World.setBlock(par2+2, par3+4, par4, 0);
			  par1World.setBlock(par2-2, par3+4, par4, 0);
			  par1World.setBlock(par2, par3+4, par4+1, 0);
			  par1World.setBlock(par2, par3+4, par4-1, 0);
			  par1World.setBlock(par2, par3+4, par4+2, 0);
			  par1World.setBlock(par2, par3+4, par4-2, 0);
			  par1World.setBlock(par2+1, par3+4, par4+1, 0);
			  par1World.setBlock(par2+1, par3+4, par4-1, 0);
			  par1World.setBlock(par2-1, par3+4, par4+1, 0);
			  par1World.setBlock(par2-1, par3+4, par4-1, 0);
		
    }

    /**
     * Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
     * and stop pistons
     */
    public int getMobilityFlag()
    {
        return 0;
    }
}
