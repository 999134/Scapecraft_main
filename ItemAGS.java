package net.minecraft.src;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemAGS extends ItemSword {
	private float weaponDamage;
	private final EnumToolMaterial toolMaterial;
	private int special = 0;
	public static int activespecialags;

	public ItemAGS(int par1, EnumToolMaterial par2EnumToolMaterial) {

		super(par1, par2EnumToolMaterial);
		this.weaponDamage = 12.0F + par2EnumToolMaterial.getDamageVsEntity();
		this.toolMaterial = par2EnumToolMaterial;
		this.maxStackSize = 1;
		this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
		this.setCreativeTab(CreativeTabs.tabCombat);

	}

	public float func_82803_g() {
		return this.toolMaterial.getDamageVsEntity();
	}

	/**
	 * Returns the strength of the stack against a given block. 1.0F base,
	 * (Quality+1)*2 if correct blocktype, 1.5F if sword
	 */
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		if (par2Block.blockID == Block.web.blockID) {
			return 15.0F;
		} else {
			Material material = par2Block.blockMaterial;
			return material != Material.plants && material != Material.vine && material != Material.coral
					&& material != Material.leaves && material != Material.pumpkin ? 1.0F : 1.5F;
		}
	}

	/**
	 * Current implementations of this method in child classes do not use the entry
	 * argument beside ev. They just raise the damage on the stack.
	 */
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase) {
		if (special == 1) {
			par1ItemStack.damageItem(1, par3EntityLivingBase);
			par3EntityLivingBase.motionY = 1.30D;
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX + 1,
					par3EntityLivingBase.posY, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX - 1,
					par3EntityLivingBase.posY, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY, par3EntityLivingBase.posZ + 1, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY, par3EntityLivingBase.posZ - 1, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 1, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX + 1,
					par3EntityLivingBase.posY + 1, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX - 1,
					par3EntityLivingBase.posY + 1, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 1, par3EntityLivingBase.posZ + 1, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 1, par3EntityLivingBase.posZ - 1, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY - 1, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX + 1,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX - 1,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ + 1, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ - 1, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 3, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX + 1,
					par3EntityLivingBase.posY + 3, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX - 1,
					par3EntityLivingBase.posY + 3, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 3, par3EntityLivingBase.posZ + 1, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 3, par3EntityLivingBase.posZ - 1, 0.0D, 0.0D, 1.0D);

			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX + 2,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX - 2,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ + 2, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ - 2, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX + 1,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ + 1, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX - 1,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ - 1, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX + 2,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ + 1, 0.0D, 0.0D, 1.0D);
			par3EntityLivingBase.worldObj.spawnParticle("magicCrit", par3EntityLivingBase.posX - 2,
					par3EntityLivingBase.posY + 2, par3EntityLivingBase.posZ - 1, 0.0D, 0.0D, 1.0D);
			special = 0;

			return true;
		} else {
			par1ItemStack.damageItem(1, par3EntityLivingBase);
			return true;
		}
	}

	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6,
			EntityLivingBase par7EntityLivingBase) {
		if ((double) Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D) {
			par1ItemStack.damageItem(2, par7EntityLivingBase);
		}

		return true;
	}

	@SideOnly(Side.CLIENT)

	/**
	 * Returns True is the item is renderer in full 3D when hold.
	 */
	public boolean isFull3D() {
		return true;
	}

	/**
	 * returns the action that specifies what animation to play when the items is
	 * being used
	 */
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed.
	 * Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));

		ExtendedPlayer props = ExtendedPlayer.get(par3EntityPlayer);
		if (props.getEnergy() > 5000) {
			special = 1;
			props.addEnergy(-5000);
			activespecialags = 1;
			if (par2World.isRemote) {
				par3EntityPlayer.addChatMessage("\u00a7ESpecial Activated");
			}
		}

		else {
			if (par2World.isRemote) {
				par3EntityPlayer.addChatMessage("\u00a7EYou have " + String.valueOf(props.getEnergy() / 100)
						+ "%% Special Attack Energy, 50%% is needed");
			}
		}

		return par1ItemStack;
	}

	/**
	 * Returns if the item (tool) can harvest results from the block type.
	 */
	public boolean canHarvestBlock(Block par1Block) {
		return par1Block.blockID == Block.web.blockID;
	}

	/**
	 * Return the enchantability factor of the item, most of the time is based on
	 * material.
	 */
	public int getItemEnchantability() {
		return this.toolMaterial.getEnchantability();
	}

	/**
	 * Return the name for this tool's material.
	 */
	public String getToolMaterialName() {
		return this.toolMaterial.toString();
	}

	/**
	 * Return whether this item is repairable in an anvil.
	 */
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true
				: super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(),
				new AttributeModifier(field_111210_e, "Weapon modifier", (double) this.weaponDamage, 0));
		return multimap;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		{
			this.itemIcon = ir.registerIcon("ArmadylGodsword");
		}
	}
}
