package net.minecraft.src;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityIronDragon extends EntityMob {
	private int field_40152_d;
	private float moveSpeed;

	public EntityIronDragon(World par1World) {
		super(par1World);

		this.moveSpeed = 0.4F;
		this.isImmuneToFire = true;

		this.setSize(this.width * 6.0F, this.height * 2.0F);

	}

	public String getEntityName() {
		return "Iron Dragon";
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(150.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.550D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(10.0D);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 0));
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		super.onUpdate();

	}

	protected String getLivingSound() {
		return "mob.enderdragon.growl";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "mob.enderdragon.hit";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "mob.enderdragon.hit";
	}

	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by
	 * each mob to define their attack.
	 */
	protected void attackEntity(Entity par1Entity, float par2) {
		if (attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > boundingBox.minY
				&& par1Entity.boundingBox.minY < boundingBox.maxY) {
			attackTime = 5;
			attackEntityAsMob(par1Entity);
		} else if (par2 < 30F) {
			double d = par1Entity.posX - posX;
			double d1 = (par1Entity.boundingBox.minY + (double) (par1Entity.height / 2.0F))
					- (posY + (double) (height / 2.0F));
			double d2 = par1Entity.posZ - posZ;

			if (attackTime == 0) {
				field_40152_d++;

				if (field_40152_d == 1) {
					attackTime = 20;
					// func_40148_a(true); /* THIS METHOD MAY DIFFER. CHECK NEAR BOTTOM OF CLASS */
				} else if (field_40152_d <= 4) {
					attackTime = 2;
				} else {
					attackTime = 33;
					field_40152_d = 0;
					// func_40148_a(false);
				}

				if (field_40152_d > 1) {
					float f = MathHelper.sqrt_float(par2) * 0.5F;
					worldObj.playAuxSFXAtEntity(null, 1009, (int) posX, (int) posY, (int) posZ, 0);

					for (int i = 0; i < 1; i++) {
						EntityLargeFireball entitylargefireball = new EntityLargeFireball(worldObj, this,
								d + rand.nextGaussian() * (double) f, d1, d2 + rand.nextGaussian() * (double) f);
						entitylargefireball.posY = posY + (double) (height / 2.0F) + 0.5D;
						worldObj.spawnEntityInWorld(entitylargefireball);
					}
				}
			}

			rotationYaw = (float) ((Math.atan2(d2, d) * 180D) / Math.PI) - 90F;
			hasAttacked = true;
		}
	}

	protected void dropFewItems(boolean par1, int par2) {

		int quickvar = rand.nextInt(500) + 1;
		int quickvar1 = rand.nextInt(200) + 1;
		int quickvar2 = rand.nextInt(5) + 1;
		int quickvar3 = rand.nextInt(50) + 1;
		int quickvar4 = rand.nextInt(5) + 1;
		int quickvar5 = rand.nextInt(2000) + 1;
		int quickvar6 = rand.nextInt(15) + 1;
		int quickvar7 = rand.nextInt(3) + 1;
		int quickvar8 = rand.nextInt(10) + 1;
		int quickvar9 = rand.nextInt(4) + 1;

		if (quickvar <= 1) {

			entityDropItem(new ItemStack(mod_phat.dragonLeggings), 1);
			MinecraftServer.getServer().getConfigurationManager().sendChatMsg(
					(new ChatMessageComponent().addText("an Iron Dragon has dropped some dragon platelegs")));
		}
		if (quickvar1 <= 1) {

			entityDropItem(new ItemStack(mod_BlocksGalore.DD), 1);
			MinecraftServer.getServer().getConfigurationManager()
					.sendChatMsg((new ChatMessageComponent().addText("an Iron Dragon has dropped a dragon dagger")));
		}
		if (quickvar2 <= 1) {

			entityDropItem(new ItemStack(Item.swordIron), 2);

		}
		if (quickvar3 <= 1) {

			entityDropItem(new ItemStack(mod_phat.runeChestplate), 1);

		}

		if (quickvar4 <= 1) {

			entityDropItem(new ItemStack(Item.plateIron), 1);

		}
		if (quickvar5 <= 1) {

			entityDropItem(new ItemStack(mod_BlocksGalore.shard2), 1);
			MinecraftServer.getServer().getConfigurationManager()
					.sendChatMsg((new ChatMessageComponent().addText("an Iron Dragon has dropped a godsword shard 2")));
		}
		if (quickvar6 <= 1) {

			entityDropItem(new ItemStack(Item.ingotGold), 1);

		}
		if (quickvar7 <= 1) {
			entityDropItem(new ItemStack(Item.ingotIron), 1);
		}
		if (quickvar8 <= 1) {
			entityDropItem(new ItemStack(Item.pickaxeIron), 1);
		}
		if (quickvar9 <= 1) {
			entityDropItem(new ItemStack(mod_Flower.antifire), 1);
		}
		int XP = rand.nextInt(1) + 1;
		if (XP <= 1) {
			entityDropItem(new ItemStack(mod_Flower.XPORB), 1);
		}
		int XP1 = rand.nextInt(1) + 1;
		if (XP <= 1) {
			entityDropItem(new ItemStack(mod_Flower.XPORB), 1);
		}

	}

	public int getAttackStrength(Entity par1Entity) {
		return 20;
	}

	public boolean isBurning() {
		return false;
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
	}

	public void onLivingUpdate() {
		if (ticksExisted > 200 * 20)
			setDead();
		super.onLivingUpdate();
	}

}
