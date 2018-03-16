package net.minecraft.src;
 
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
 
public class EntityKK extends EntityMob 
{
    private float moveSpeed;

 
	public EntityKK(World par1World)
    {
	    super(par1World);

        this.moveSpeed = 0.65F;
     
       
        this.setSize(this.width * 4.5F, this.height * 5.0F);
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBlackDragon.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityBlackDragon.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos1.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos1.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos2.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos2.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos3.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos3.class, this.moveSpeed, false));
     
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTD.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityTD.class, this.moveSpeed, false));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWolf.class, this.moveSpeed, false));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityOcelot.class, this.moveSpeed, false));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityHellhound.class, this.moveSpeed, false));
  
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWhiteKnight.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWhiteKnight.class, this.moveSpeed, false));

        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHeroKnight.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityHeroKnight.class, this.moveSpeed, false));
        
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityEliteBlackKnight.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityEliteBlackKnight.class, this.moveSpeed, false));
        
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGuard.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityGuard.class, this.moveSpeed, false));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        
        
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWither.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWither.class, this.moveSpeed, false));
        
        
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKing.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKing.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKingsGuard.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKingsGuard.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBlackKnight.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityBlackKnight.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTheif.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityTheif.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCreeper.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityCreeper.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntitySkeleton.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityZombie.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySpider.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntitySpider.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWizard.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWizard.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGoblin.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityGoblin.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityScorpion.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityScorpion.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityFarmer.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityFarmer.class, this.moveSpeed, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBarbarian.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityBarbarian.class, this.moveSpeed, false));
 
   
    }
	
	
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10000.0D);
    this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(32.0D);   
    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.50D);
    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(40.0D);
    this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setAttribute(0.5D);
	    }
    public int getTotalArmorValue()
    {
        return 12;
    }
	
    public String getEntityName()
    {
      return "Kalphite King";
    }
    
    public boolean isAIEnabled()
    {
        return true;
    }
    
   
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
	public void onUpdate() {
		this.setSize(4.5F, 6F);
		super.onUpdate();
        if (!this.worldObj.isRemote)
        {
            this.setBesideClimbableBlock(this.isCollidedHorizontally);
        }
    }

    
    
    
    public boolean isBesideClimbableBlock()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    /**
     * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
     * false.
     */
    public boolean isOnLadder()
    {
        return this.isBesideClimbableBlock();
    }

    public void setBesideClimbableBlock(boolean par1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (par1)
        {
            var2 = (byte)(var2 | 1);
        }
        else
        {
            var2 &= -2;
        }

        this.dataWatcher.updateObject(16, Byte.valueOf(var2));
    }
    
    protected Entity findPlayerToAttack()
    {
        float var1 = this.getBrightness(1.0F);

        if (var1 < 100F)
        {
            double var2 = 16.0D;
            return this.worldObj.getClosestVulnerablePlayerToEntity(this, var2);
        }
        else
        {
            return null;
        }
    }
    

 

  
   
 
 
    protected String getLivingSound()
    {
        return "mob.spider.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.spider.say";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.spider.death";
    }

 
    protected float getSoundVolume()
    {
        return 0.4F;
    }
 

 
    protected void dropFewItems(boolean par1, int par2){
        
        int quickvar = rand.nextInt(50) + 1;
        int quickvar1 = rand.nextInt(100) + 1;
        int quickvar2 = rand.nextInt(1) + 1;
        int quickvar3 = rand.nextInt(150) + 1;
        int quickvar4 = rand.nextInt(4) + 1;
        int quickvar5 = rand.nextInt(4) + 1;
        int quickvar6 = rand.nextInt(4) + 1;
        int quickvar7 = rand.nextInt(4) + 1;
        int quickvar8 = rand.nextInt(30) + 1;
        int quickvar9 = rand.nextInt(20) + 1;
        int quickvar10 = rand.nextInt(15) + 1;
        int quickvar11 = rand.nextInt(15) + 1;
                 
        if(quickvar  <= 1){entityDropItem(new ItemStack(mod_BlocksGalore.DryMace), 1);
        MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatMessageComponent().addText("The Kalphite King has dropped a Drygore mace!")));}
        if(quickvar1 <= 1){entityDropItem(new ItemStack(mod_BlocksGalore.DryRapier), 1);
        MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatMessageComponent().addText("The Kalphite King has dropped a Drygore rapier!")));}
        if(quickvar2 <= 1){          
        	entityDropItem(new ItemStack(mod_BlocksGalore.Addyore), 2);
        	entityDropItem(new ItemStack(Item.ingotGold), 2);
        	MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatMessageComponent().addText("The Kalphite King has been slain, impressive!")));}
		if(quickvar3 <= 1){entityDropItem(new ItemStack(mod_BlocksGalore.DryLong), 1);
		MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatMessageComponent().addText("The Kalphite King has dropped a Drygore Long!")));}
		if(quickvar4 <= 1){entityDropItem(new ItemStack(mod_phat.runeLeggings), 1);}
		if(quickvar5 <= 1){entityDropItem(new ItemStack(mod_phat.runeChestplate), 1);}
		if(quickvar7 <= 1){entityDropItem(new ItemStack(mod_phat.runeHelmet), 1);}
		if(quickvar6 <= 1){entityDropItem(new ItemStack(mod_phat.runeBoots), 1);}
		if(quickvar8 <= 1){entityDropItem(new ItemStack(mod_BlocksGalore.DDS), 1);
		MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatMessageComponent().addText("The Kalphite King has dropped a dragon dagger!")));}
		if(quickvar9 <= 1){entityDropItem(new ItemStack(mod_BlocksGalore.SandSpawn), 1);
		MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatMessageComponent().addText("The Kalphite King has dropped a sand spawner!")));}    
		if(quickvar10 <= 1){entityDropItem(new ItemStack(mod_BlocksGalore.Dragonaxe), 1);
		MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatMessageComponent().addText("The Kalphite King has dropped a Dragon axe!")));}
        
		if(quickvar11 <= 1){entityDropItem(new ItemStack(mod_phat.dragonBoots), 1);
		MinecraftServer.getServer().getConfigurationManager().sendChatMsg((new ChatMessageComponent().addText("The Kalphite King has dropped some Dragon boots!")));}
        
		

int XP = rand.nextInt(1) + 1;if(XP <= 1){entityDropItem(new ItemStack(mod_Flower.BXPORB), 1);}
int XP1 = rand.nextInt(1) + 1;if(XP <= 1){entityDropItem(new ItemStack(mod_Flower.BXPORB), 1);}
int XP2 = rand.nextInt(1) + 1;if(XP <= 1){entityDropItem(new ItemStack(mod_Flower.BXPORB), 1);}
int XP3 = rand.nextInt(1) + 1;if(XP <= 1){entityDropItem(new ItemStack(mod_Flower.BXPORB), 1);}
int XP4 = rand.nextInt(1) + 1;if(XP <= 1){entityDropItem(new ItemStack(mod_Flower.BXPORB), 1);}
        }
    
    

    
    
    @Override
    protected boolean canDespawn()
    {
            return true;
    }


    
    protected EntityKKspawn createInstance()
    {
        return new EntityKKspawn(this.worldObj);
    }

    
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
    	  Entity entity;
    	  entity = par1DamageSource.getSourceOfDamage();
    	  if (entity instanceof EntityArrow)
          {
              return false;
          }
    	
    	
    	if(!worldObj.isRemote)
    	{ 
    	  int j = 1;

          for (int k = 0; k < j; ++k)
          {
              float f = ((float)(k % 2) - 0.5F) * (float)1 / 4.0F;
              float f1 = ((float)(k / 2) - 0.5F) * (float)1 / 4.0F;
              EntityKKspawn entityKKspawn = this.createInstance();
              
              entityKKspawn.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D, this.posZ + (double)f1, this.rand.nextFloat() * 360.0F, 0.0F);
              this.worldObj.spawnEntityInWorld(entityKKspawn);    
          }}
    	
    	   return super.attackEntityFrom(par1DamageSource, par2);
    }
	
    public void onLivingUpdate()
    {
      	if(ticksExisted > 1200 * 20) setDead(); 
        	super.onLivingUpdate();
        }
        
	
	 
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
    }
 
   
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    
    }
	  
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }
	
}
