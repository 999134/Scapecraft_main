package net.minecraft.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityRatSmall extends EntityMob
{
    private float moveSpeed;
	public EntityRatSmall(World par1World)
    {
        super(par1World);

        this.moveSpeed = 0.8F;
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos1.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos1.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos2.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos2.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos3.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos3.class, this.moveSpeed, false));
        this.setSize(this.width * 0.4F, this.height * 0.4F);
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTD.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityTD.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityFarmer.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityFarmer.class, this.moveSpeed, false));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWolf.class, this.moveSpeed, false));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityOcelot.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGreenDragon.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));

    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
    // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(4.0D);
    // Follow Range - default 32.0D - min 0.0D - max 2048.0D
    this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(32.0D);
    // Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.8D);
    // Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(1.0D);
	    }
	
    public String getEntityName()
    {
      return "Rat";
    }
    
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }

    
    public boolean isAIEnabled()
    {
        return true;
    }
    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

      
    }

  

    /**
     * Returns the sound this mob makes while it's alive.
protected String getLivingSound()
    {
        return "mob.villager.default";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.villager.defaulthurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.villager.defaultdeath";
    }
    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int var1, int var2, int var3, int var4)
    {
        this.worldObj.playSoundAtEntity(this, "mob.villager.default", 0.15F, 1.0F);
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity par1Entity, float par2)
    {
        float var3 = this.getBrightness(1.0F);

        if (var3 > 0.5F && this.rand.nextInt(100) == 0)
        {
            this.entityToAttack = null;
        }
        else
        {
            if (par2 > 2.0F && par2 < 6.0F && this.rand.nextInt(10) == 0)
            {
                if (this.onGround)
                {
                    double var4 = par1Entity.posX - this.posX;
                    double var6 = par1Entity.posZ - this.posZ;
                    float var8 = MathHelper.sqrt_double(var4 * var4 + var6 * var6);
                    this.motionX = var4 / (double)var8 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
                    this.motionZ = var6 / (double)var8 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
                    this.motionY = 0.4000000059604645D;
                }
            }
            else
            {
                super.attackEntity(par1Entity, par2);
            }
        }
    }

    
    protected void dropFewItems(boolean par1, int par2){
        
        int quickvar = rand.nextInt(10) + 1;
        int quickvar1 = rand.nextInt(4) + 1;
        int quickvar4 = rand.nextInt(100) + 1;
        int quickvar5 = rand.nextInt(40) + 1;
        int quickvar6 = rand.nextInt(15) + 1;
         
        if(quickvar <= 1){
         
        	entityDropItem(new ItemStack(Item.swordStone), 1);
         
        }
        if(quickvar1 <= 1){
            
        	entityDropItem(new ItemStack(mod_Flower.RatTail), 1);
}
if(quickvar4 <= 1){
    
	entityDropItem(new ItemStack(mod_phat.guardHelmet), 1);
 
}
if(quickvar5 <= 1){
    
	entityDropItem(new ItemStack(Item.goldNugget), 1);
 
}


        }
    
    
      
   
    protected int getDropItemId()
    {
        return Item.silk.itemID;
    }



    public boolean isPotionApplicable(PotionEffect par1PotionEffect)
    {
        return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
    }

    
    public void onLivingUpdate()
    {
      	if(ticksExisted > 60 * 20) setDead(); 
        	super.onLivingUpdate();
        }
        

    

    
 @SideOnly(Side.CLIENT)	
 public boolean interact(EntityPlayer par1EntityPlayer)
 {
 	ModLoader.getMinecraftInstance().thePlayer.addChatMessage("\u00a7ESmall Rat: Squeek!");
     return super.interact(par1EntityPlayer);
 }

}
