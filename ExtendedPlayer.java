package net.minecraft.src;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import potato.TestCommonProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties
{
/*
Here I create a constant EXT_PROP_NAME for this class of properties. You need a unique name for every instance of IExtendedEntityProperties you make, and doing it at the top of each class as a constant makes
it very easy to organize and avoid typos. It's easiest to keep the same constant name in every class, as it will be distinguished by the class name: ExtendedPlayer.EXT_PROP_NAME vs. ExtendedEntity.EXT_PROP_NAME

Note that a single entity can have multiple extended properties, so each property should have a unique name. Try to come up with something more unique than the tutorial example.
*/
public final static String EXT_PROP_NAME = "ExtendedPlayer";
//public static final byte COMBAT = 0, AGILITY = 1;
// I always include the entity to which the properties belong for easy access
// It's final because we won't be changing which player it is
private final EntityPlayer player;

// Declare other variables you want to add here

// We're adding mana to the player, so we'll need current and max mana
private int combatxp;
private int agilityxp;
private int energy;
private int miningxp;
private int theifxp;
private int theifcd;

/*
The default constructor takes no arguments, but I put in the Entity so I can initialize the above variable 'player'

Also, it's best to initialize any other variables you may have added, just like in any constructor.
*/
public ExtendedPlayer(EntityPlayer player)
{
this.player = player;
// Start with 0 xp. Every player starts with the same amount.
this.combatxp = 0;
this.agilityxp = 0;
this.energy = 0;
this.miningxp = 0;
this.theifxp = 0;
this.theifcd = 0;
}

/**
* Used to register these extended properties for the player during EntityConstructing event
* This method is for convenience only; it will make your code look nicer
*/
public static final void register(EntityPlayer player)
{
player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
}

/**
* Returns ExtendedPlayer properties for player
* This method is for convenience only; it will make your code look nicer
*/
public static final ExtendedPlayer get(EntityPlayer player)
{
return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
}


// Save any custom data that needs saving here
@Override
public void saveNBTData(NBTTagCompound compound)
{
// We need to create a new tag compound that will save everything for our Extended Properties
NBTTagCompound properties = new NBTTagCompound();

// We only have 2 variables currently; save them both to the new tag
properties.setInteger("combatxp", this.combatxp);
properties.setInteger("agilityxp", this.agilityxp);
properties.setInteger("energy", this.energy);
properties.setInteger("mining", this.miningxp);
properties.setInteger("theif", this.theifxp);
properties.setInteger("theifcd", this.theifcd);
/*
Now add our custom tag to the player's tag with a unique name (our property's name). This will allow you to save multiple types of properties and distinguish between them. If you only have one type, it isn't as important, but it will still avoid conflicts between your tag names and vanilla tag names. For instance, if you add some "Items" tag, that will conflict with vanilla. Not good. So just use a unique tag name.
*/
compound.setTag(EXT_PROP_NAME, properties);
}


private static String getSaveKey(EntityPlayer player) {
return player.username + ":" + EXT_PROP_NAME;
}
public static void saveProxyData(EntityPlayer player) {
ExtendedPlayer playerData = ExtendedPlayer.get(player);
NBTTagCompound savedData = new NBTTagCompound();

playerData.saveNBTData(savedData);
// Note that we made the CommonProxy method storeEntityData static,
// so now we don't need an instance of CommonProxy to use it! Great!
TestCommonProxy.storeEntityData(getSaveKey(player), savedData);
}
public static void loadProxyData(EntityPlayer player) {
ExtendedPlayer playerData = ExtendedPlayer.get(player);
NBTTagCompound savedData = TestCommonProxy.getEntityData(getSaveKey(player));

if(savedData != null) {
playerData.loadNBTData(savedData);
}
playerData.sync();
}

// Load whatever data you saved
@Override
public void loadNBTData(NBTTagCompound compound)
{
NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);

this.combatxp = properties.getInteger("combatxp");
this.agilityxp = properties.getInteger("agilityxp");
this.energy = properties.getInteger("energy");
this.miningxp = properties.getInteger("mining");
this.theifxp = properties.getInteger("theif");
this.theifcd = properties.getInteger("theifcd");
}

@Override
public void init(Entity entity, World world)
{
}


public boolean checkcombatxp(int amount)
{
boolean sufficient = amount <= this.combatxp;
this.combatxp -= (amount < this.combatxp? amount : this.combatxp);
return sufficient;
}


public boolean checkagilityxp(int amount)
{
boolean sufficient = amount <= this.agilityxp;
this.agilityxp -= (amount < this.agilityxp? amount : this.agilityxp);
return sufficient;
}

public boolean checkenergy(int amount)
{
boolean sufficient = amount <= this.energy;
this.energy -= (amount < this.energy? amount : this.energy);
return sufficient;
}

public boolean checkminingxp(int amount)
{
boolean sufficient = amount <= this.miningxp;
this.miningxp -= (amount < this.miningxp? amount : this.miningxp);
return sufficient;
}

public boolean checktheifxp(int amount)
{
boolean sufficient = amount <= this.theifxp;
this.theifxp -= (amount < this.theifxp? amount : this.theifxp);
return sufficient;
}
public boolean checktheifcd(int amount)
{
boolean sufficient = amount <= this.theifcd;
this.theifcd -= (amount < this.theifcd? amount : this.theifcd);
return sufficient;
}




public void addXp(int amount) { 
	this.combatxp += amount;
System.out.println(this.combatxp);
}

public void addAXp(int amount) { 
	this.agilityxp += amount;
System.out.println(this.agilityxp);
}
public void addMXp(int amount) { 
	this.miningxp += amount;
System.out.println(this.miningxp);
}
public void addTXp(int amount) { 
	this.theifxp += amount;
System.out.println(this.theifxp);
}
public void addTcd(int amount) { 
	this.theifcd += amount;

}

public void addEnergy(int amount) { 
	this.energy += amount;
}


public int getAgilityxp(){

	return agilityxp;
}


public int getCombatxp(){

	return combatxp;
}

public int getEnergy(){

	return energy;
}
public int getMiningxp(){

	return miningxp;
}

public int getTheifxp(){

	return theifxp;
}
public int getTheifcd(){return theifcd;}
public static int getLevel(int exp) {
		int level;
		if (exp >= 0 && exp < 10) { return 1; }
		else if (exp >= 10 && exp < 30) { return 2; }
		else if (exp >= 30 && exp < 60) { return 3; }
		else if (exp >= 60 && exp < 100) { return 4; }
		else if (exp >= 100 && exp < 150) { return 5; }
		else if (exp >= 150 && exp < 180) { return 6; }
		else if (exp >= 180 && exp < 224) { return 7; }
		else if (exp >= 224 && exp < 248) { return 8; }
		else if (exp >= 248 && exp < 276) { return 9; }
		else if (exp >= 276 && exp < 302) { return 10; }
		else if (exp >= 302 && exp < 336) { return 11; }
		else if (exp >= 336 && exp < 370) { return 12; }
		else if (exp >= 370 && exp < 408) { return 13; }
		else if (exp >= 408 && exp < 452) { return 14; }
		else if (exp >= 452 && exp < 498) { return 15; }
		else if (exp >= 498 && exp < 600) { return 16; }
		else if (exp >= 600 && exp < 720) { return 17; }
		else if (exp >= 720 && exp < 850) { return 18; }
		else if (exp >= 850 && exp < 950) { return 19; }
		else if (exp >= 950 && exp < 1060) { return 20; }
		else if (exp >= 1060 && exp < 1200) { return 21; }
		else if (exp >= 1200 && exp < 1700) { return 22; }
		else if (exp >= 1700 && exp < 2300) { return 23; }
		else if (exp >= 2300 && exp < 3000) { return 24; }
		else if (exp >= 3000 && exp < 3800) { return 25; }
		else if (exp >= 3800 && exp < 4700) { return 26; }
		else if (exp >= 4700 && exp < 6100) { return 27; }
		else if (exp >= 6100 && exp < 7320) { return 28; }
		else if (exp >= 7320 && exp < 8784) { return 29; }
		else if (exp >= 8784 && exp < 10540) { return 30; }
		else if (exp >= 10540 && exp < 12648) { return 31; }
		else if (exp >= 12648 && exp < 15178) { return 32; }
		else if (exp >= 15178 && exp < 18214) { return 33; }
		else if (exp >= 18214 && exp < 21857) { return 34; }
		else if (exp >= 21857 && exp < 26228) { return 35; }
		else if (exp >= 26228 && exp < 31474) { return 36; }
		else if (exp >= 31474 && exp < 37769) { return 37; }
		else if (exp >= 37769 && exp < 45323) { return 38; }
		else if (exp >= 45323 && exp < 54388) { return 39; }
		else if (exp >= 54388 && exp < 65265) { return 40; }
		else if (exp >= 65265 && exp < 78319) { return 41; }
		else if (exp >= 78319 && exp < 93982) { return 42; }
		else if (exp >= 93982 && exp < 112779) { return 43; }
		else if (exp >= 112779 && exp < 135335) { return 44; }
		else if (exp >= 135335 && exp < 162402) { return 45; }
		else if (exp >= 162402 && exp < 233859) { return 46; }
		else if (exp >= 233859 && exp < 280631) { return 47; }
		else if (exp >= 280631 && exp < 336757) { return 48; }
		else if (exp >= 336757 && exp < 404108) { return 49; }
		else if (exp >= 404108) { return 50; }
		else { return -1; }
	}
public final void sync()
{
ByteArrayOutputStream bos = new ByteArrayOutputStream(24);
DataOutputStream outputStream = new DataOutputStream(bos);

try {
//	outputStream.writeByte(COMBAT);
//	outputStream.writeByte(AGILITY);
outputStream.writeInt(this.combatxp);
outputStream.writeInt(this.agilityxp);
outputStream.writeInt(this.energy);
outputStream.writeInt(this.miningxp);
outputStream.writeInt(this.theifxp);
outputStream.writeInt(this.theifcd);
} 
catch (Exception ex) {ex.printStackTrace();}


Packet250CustomPayload packet = new Packet250CustomPayload("tutchannel", bos.toByteArray());
if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
	EntityPlayerMP player1 = (EntityPlayerMP) player;
	PacketDispatcher.sendPacketToPlayer(packet, (Player)player1);
	}
}



public void setcombatxp(int amount)
{
this.combatxp = amount;	
this.sync();
}

public void setagilityxp(int amount)
{
this.agilityxp = amount;	
this.sync();
}

public void setenergy(int amount)
{
this.energy = amount;	
this.sync();
}
public void setminingxp(int amount)
{
this.miningxp = amount;	
this.sync();
}
public void settheifxp(int amount)
{
this.theifxp = amount;	
this.sync();
}
public void settheifcd(int amount)
{
this.theifcd = amount;	
this.sync();
}
}
