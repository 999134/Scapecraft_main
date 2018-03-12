package net.minecraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemDarkBow extends ItemBow
{
    public static final String[] bowPullIconNameArray = new String[] {"bow_pull_0", "bow_pull_1", "bow_pull_2"};
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    public ItemDarkBow(int par1)
    {
        super(par1);
        this.maxStackSize = 1;
        this.setMaxDamage(20000);
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setFull3D();
    }

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

        if (flag || par3EntityPlayer.inventory.hasItem(Item.arrow.itemID))
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }
            ExtendedPlayer props = ExtendedPlayer.get(par3EntityPlayer);		
        	
            float x;
            if (props.getEnergy() >  5500 && par3EntityPlayer.isSneaking()){
                x = 25.5F;
                props.addEnergy(-5500);
                par3EntityPlayer.addChatMessage("\u00a7ESpecial Attack Activated, Critcal Hit!");
        	}
            else{x=4.1F;}
            float mod;
            mod=1;
            ItemStack boots = par3EntityPlayer.getCurrentItemOrArmor(1);ItemStack legs = par3EntityPlayer.getCurrentItemOrArmor(2);ItemStack chest = par3EntityPlayer.getCurrentItemOrArmor(3);ItemStack helmet = par3EntityPlayer.getCurrentItemOrArmor(4);
            if(boots != null && legs != null && chest != null && helmet != null) {
            if(boots.getItem() == mod_phat.greendBoots && legs.getItem() == mod_phat.greendLeggings && chest.getItem() == mod_phat.greendChestplate && helmet.getItem() == mod_phat.greendHelmet)
            {mod = 1.5F;}
            if(boots.getItem() == mod_phat.blackdBoots && legs.getItem() == mod_phat.blackdLeggings && chest.getItem() == mod_phat.blackdChestplate && helmet.getItem() == mod_phat.blackdHelmet)
            {mod = 1.9F;}
            if(boots.getItem() == mod_phat.KarilBoots && legs.getItem() == mod_phat.KarilLeggings && chest.getItem() == mod_phat.KarilChestplate && helmet.getItem() == mod_phat.KarilHelmet)
            {mod = 2.3F;}
            }
            
            
			EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer, f * x* mod);
            EntityArrow entityarrow1 = new EntityArrow(par2World, par3EntityPlayer, f * 4.0F* mod);
            
            
            if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

            if (k > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

            if (l > 0)
            {
                entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
            {
                entityarrow.setFire(100);
            }

            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
                entityarrow.canBePickedUp = 2;
            }
            else
            {
                par3EntityPlayer.inventory.consumeInventoryItem(Item.arrow.itemID);
                par3EntityPlayer.inventory.consumeInventoryItem(Item.arrow.itemID);
            }

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(entityarrow);
                par2World.spawnEntityInWorld(entityarrow1);
            }
        }
    }

    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	
    	ExtendedPlayer props = ExtendedPlayer.get(par3EntityPlayer);
    	if (props.getCombatxp() > 500){
        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Item.arrow.itemID))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        return par1ItemStack;
        
    	}
    	else par3EntityPlayer.addChatMessage("\u00a7EYou must be at least level 20 to use this item");
		par3EntityPlayer.addChatMessage("You need "+String.valueOf(500-props.getCombatxp())+" more exp to use this item");
        return par1ItemStack;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir)
    {
         
            {
            this.itemIcon = ir.registerIcon("darkbow");
            }
    }
    
    
}
