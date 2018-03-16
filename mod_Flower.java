package net.minecraft.src;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockOre;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class mod_Flower extends BaseMod {
	public static final StepSound soundStoneFootstep = new StepSound("stone", 1.0F, 1.0F);
	public static final String modid = "mod_Flower";
	public static final Block cabbage = (new Blockcabbage(204, 90).setHardness(0.0F).setUnlocalizedName("cabbage")
			.setStepSound(Block.soundGrassFootstep));
	public static final Item cutcabbage = (new ItemFood(17008, 2, true)).setUnlocalizedName("cutcabbage")
			.setTextureName("cutcabbage");
	public static final Item cabbagepie = (new ItemModFood(17009, 4, 6, true)).setAlwaysEdible()
			.setUnlocalizedName("cabbagepie").setTextureName("cabbagepie").setMaxStackSize(8);
	public static final Item fishpie = (new ItemModFood(17011, 4, 14, true)).setAlwaysEdible()
			.setUnlocalizedName("fishpie").setTextureName("fishpie").setMaxStackSize(8);
	public static final Item meatpie = (new ItemModFood(17012, 4, 11, true)).setAlwaysEdible()
			.setUnlocalizedName("meatpie").setTextureName("meatpie").setMaxStackSize(8);
	public static final Item applepie = (new ItemModFood(17013, 4, 8, true)).setAlwaysEdible()
			.setUnlocalizedName("applepie").setTextureName("applepie").setMaxStackSize(8);
	public static final Item beer = (new ItemModFood(17030, 1, 4, true)).setAlwaysEdible().setUnlocalizedName("beer")
			.setTextureName("beer");
	public static final Item cabbagepieuncooked = new Item(17014).setUnlocalizedName("cabbagepieuncooked")
			.setTextureName("cabbagepie");
	public static final Item meatpieuncooked = new Item(17015).setUnlocalizedName("meatuncooked")
			.setTextureName("meatpie");
	public static final Item applepieuncooked = new Item(17016).setUnlocalizedName("applepieuncooked")
			.setTextureName("applepie");
	public static final Item fishpieuncooked = new Item(17017).setUnlocalizedName("fishpieuncooked")
			.setTextureName("fishpie");
	public static final Item VeracKey = new Item(17018).setUnlocalizedName("VeracKey").setTextureName("key1");
	public static final Item ToragKey = new Item(17019).setUnlocalizedName("ToragKey").setTextureName("key1");
	public static final Item DharokKey = new Item(17020).setUnlocalizedName("DharokKey").setTextureName("key1");
	public static final Item KarilKey = new Item(17021).setUnlocalizedName("KarilKey").setTextureName("key1");
	public static final Item AhrimKey = new Item(17022).setUnlocalizedName("AhrimKey").setTextureName("key1");
	public static final Item GuthanKey = new Item(17023).setUnlocalizedName("GuthanKey").setTextureName("key1");
	public static final Item AkrisaeKey = new Item(17024).setUnlocalizedName("AkrisaeKey").setTextureName("key1");
	public static final Item TombKey = new ItemTombKey(17025).setUnlocalizedName("mod_Flower:TombKey");
	public static final Item DoorKey = new ItemDoorKey(17026).setUnlocalizedName("mod_Flower:DoorKey");
	public static final Item RewardChest = new ItemRewardChest(17027).setUnlocalizedName("mod_Flower:RewardChest");
	public static final Item Stats = new ItemStats(17028).setUnlocalizedName("mod_Flower:Stats");
	public static final Item Cracker = new ItemCracker(18000).setUnlocalizedName("mod_Flower:Cracker");

	public static final Block VeracSpawn = (new BlockVeracSpawn(232, 80).setHardness(200000.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("VeracSpawn"));
	public static final Block ToragSpawn = (new BlockToragSpawn(233, 80).setHardness(200000.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("ToragSpawn"));
	public static final Block DharokSpawn = (new BlockDharokSpawn(234, 80).setHardness(200000.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("DharokSpawn"));
	public static final Block KarilSpawn = (new BlockKarilSpawn(235, 80).setHardness(200000.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("KarilSpawn"));
	public static final Block AhrimSpawn = (new BlockAhrimSpawn(236, 80).setHardness(200000.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("AhrimSpawn"));
	public static final Block AkrisaeSpawn = (new BlockAkrisaeSpawn(237, 80).setHardness(200000.0F)
			.setResistance(5000.0F).setStepSound(soundStoneFootstep).setUnlocalizedName("AkrisaeSpawn"));
	public static final Block GuthanSpawn = (new BlockGuthanSpawn(238, 80).setHardness(200000.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("GuthanSpawn"));

	public static final Block MuggerSpawn = (new BlockMuggerSpawn(2710, 80).setHardness(200000.0F)
			.setResistance(5000.0F).setStepSound(soundStoneFootstep).setUnlocalizedName("MuggerSpawn"));
	public static final Block BanditSpawn = (new BlockBanditSpawn(2711, 80).setHardness(200000.0F)
			.setResistance(5000.0F).setStepSound(soundStoneFootstep).setUnlocalizedName("BanditSpawn"));

	public static final Block Mithores = (new BlockMithores(2700, 29).setHardness(30.0F).setResistance(5.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("Mithores"));
	public static final Block Addyores = (new BlockAddyores(2701, 41).setHardness(60.0F).setResistance(5.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("Addyores"));
	public static final Block Runeores = (new BlockRuneores(2702, 53).setHardness(80.0F).setResistance(50.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("Runeores"));
	public static final Block cobblestones = (new BlockCobblestones(2703, 10).setHardness(2.0F).setResistance(10.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("cobblestones"));
	public static final Block oreGolds = (new BlockoreGolds(2704, 10).setHardness(3.0F).setResistance(5.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("oreGolds"));
	public static final Block oreIrons = (new BlockoreIrons(2705, 10).setHardness(3.0F).setResistance(5.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("oreIrons"));
	public static final Block oreCoals = (new BlockCoals(2706, 10).setHardness(3.0F).setResistance(5.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("oreCoals"));

	public static final Block Fire = (new TileEntityFireBlock(2380).setHardness(2.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("Fire"));
	public static final Block Stall = (new TileEntityStallBlock(2381).setHardness(20.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("Stall"));
	public static final Block BlockStall = (new TileEntityBlockStallBlock(2382).setHardness(20.0F)
			.setResistance(5000.0F).setStepSound(soundStoneFootstep).setUnlocalizedName("BlockStall"));
	public static final Block Dragon = (new TileEntityDragon(2387).setHardness(20.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("Dragon"));

	public static final Block Shop1 = (new BlockShop1(2383, 80).setHardness(200000.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("Shop1"));
	public static final Block Shop2 = (new BlockShop2(2384, 80).setHardness(200000.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("Shop2"));
	public static final Block Shop3 = (new BlockShop3(2385, 80).setHardness(200000.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("Shop3"));
	public static final Block Shop4 = (new BlockShop4(2386, 80).setHardness(200000.0F).setResistance(5000.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("Shop4"));

	public static final Item GreenDhide = new Item(20000).setUnlocalizedName("GreenDhide").setTextureName("gdhide")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item GreenDleather = new Item(20001).setUnlocalizedName("GreenDleather")
			.setTextureName("gdleather").setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item RatTail = new Item(20002).setUnlocalizedName("RatTail").setTextureName("RatTail")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item Garlic = new ItemGarlic(20003).setUnlocalizedName("Garlic").setTextureName("garlic")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item BlackDhide = new Item(20005).setUnlocalizedName("BlackDhide").setTextureName("blackdhide")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item BlackDleather = new Item(20006).setUnlocalizedName("BlackDleather")
			.setTextureName("blackdleather").setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item InvincibilityPotion = new Item(20007).setUnlocalizedName("InvincibilityPotion")
			.setTextureName("potion_bottle_empty").setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item XPORB = new ItemXPORB(20008).setUnlocalizedName("XPORB")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item BXPORB = new ItemBXPORB(20009).setUnlocalizedName("BXPORB")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item HAXORB = new ItemHAXORB(20010).setUnlocalizedName("HAXORB")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item MXPORB = new ItemMXPORB(20030).setUnlocalizedName("MXPORB")
			.setCreativeTab(CreativeTabs.tabMaterials);

	public static final Item sarabrew = new ItemSaraBrew(20011).setUnlocalizedName("sarabrew")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item superrestore = new ItemSuperRestore(20012).setUnlocalizedName("superrestore")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item superstr = new ItemSuperStr(20013).setUnlocalizedName("superstr")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item superdef = new ItemSuperDef(20014).setUnlocalizedName("superdef")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item specpot = new ItemSpecPot(20015).setUnlocalizedName("specpot")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item antifire = new ItemAntifire(20100).setUnlocalizedName("antifire")
			.setCreativeTab(CreativeTabs.tabMaterials);

	public static final Item gloves = new ItemGloves(20101).setUnlocalizedName("gloves")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item gloves2 = new ItemGloves2(20102).setUnlocalizedName("gloves2")
			.setCreativeTab(CreativeTabs.tabMaterials);

	public static final Item QuestPoint = new Item(29999).setUnlocalizedName("QuestPoint").setTextureName("QuestPoint")
			.setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item QuestPoint1 = new Item(30000).setUnlocalizedName("QuestPoint1")
			.setTextureName("QuestPoint").setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item QuestPoint2 = new Item(30001).setUnlocalizedName("QuestPoint2")
			.setTextureName("QuestPoint").setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item QuestPoint3 = new Item(30002).setUnlocalizedName("QuestPoint3")
			.setTextureName("QuestPoint").setCreativeTab(CreativeTabs.tabMaterials);

	public static final Item Vtab = new ItemVtab(10000).setUnlocalizedName("mod_Flower:Vtab");
	public static final Item Ftab = new ItemFtab(10001).setUnlocalizedName("mod_Flower:Ftab");
	public static final Item Ltab = new ItemLtab(10002).setUnlocalizedName("mod_Flower:Ltab");
	public static final Item TDtab = new ItemTDtab(10003).setUnlocalizedName("mod_Flower:TDtab");
	public static final Item Bandostab = new ItemBandostab(10004).setUnlocalizedName("mod_Flower:Bandostab");
	public static final Item Htab = new ItemHtab(10005).setUnlocalizedName("mod_Flower:Htab");
	public static final Item Ctab = new ItemCtab(10006).setUnlocalizedName("mod_Flower:Ctab");
	public static final Item Btab = new ItemBtab(10007).setUnlocalizedName("mod_Flower:Btab");

	public static final Item LOL = new ItemLOL(11007).setUnlocalizedName("mod_Flower:LOL");

	public void registerRenderers() {
	}

	@EventHandler
	public void load() {

		ModLoader.registerBlock(cabbage);
		ModLoader.addName(cabbage, "Cabbage");
		ModLoader.addName(cutcabbage, "Cut cabbage");
		ModLoader.addName(cabbagepie, "Cabbage pie");
		ModLoader.addName(cabbagepieuncooked, "Uncooked cabbage pie");
		ModLoader.addName(fishpie, "Fish pie");
		ModLoader.addName(fishpieuncooked, "Uncooked fish pie");
		ModLoader.addName(meatpie, "Meat pie");
		ModLoader.addName(meatpieuncooked, "Uncooked meat pie");
		ModLoader.addName(applepie, "Apple pie");
		ModLoader.addName(applepieuncooked, "Uncooked apple pie");
		ModLoader.addName(beer, "Beer");
		ModLoader.addName(Cracker, "Christmas Cracker");
		ModLoader.addName(VeracKey, "Verac's Key Part");
		ModLoader.addName(DharokKey, "Dharok's Key Part");
		ModLoader.addName(ToragKey, "Torag's Key Part");
		ModLoader.addName(GuthanKey, "Guthan's Key Part");
		ModLoader.addName(AhrimKey, "Ahrim's Key Part");
		ModLoader.addName(KarilKey, "Karil's Key Part");
		ModLoader.addName(AkrisaeKey, "Akrisae's Key Part");
		ModLoader.addName(TombKey, "Barrows Tomb Key");
		ModLoader.addName(DoorKey, "Door Key");
		ModLoader.addName(Stats, "Stats Page");
		ModLoader.addName(RewardChest, "Reward Chest");
		ModLoader.addName(InvincibilityPotion, "Invincibility Potion");
		ModLoader.addName(XPORB, "Combat Xp Orb(scapecraft)");
		ModLoader.addName(BXPORB, "Boss Combat Xp Orb(scapecraft)");
		ModLoader.addName(HAXORB, "Cheat Combat Xp Orb(scapecraft)");
		ModLoader.addName(MXPORB, "Mining Xp Orb(scapecraft)");

		ModLoader.addName(Vtab, "Varrock Teletab");
		ModLoader.addName(Ftab, "Falador Teletab");
		ModLoader.addName(Ltab, "Lumbridge Teletab");
		ModLoader.addName(Ctab, "Cath Teletab");
		ModLoader.addName(Btab, "Barrows Teletab");
		ModLoader.addName(TDtab, "Tormentent Demons Teletab");
		ModLoader.addName(Bandostab, "Bandos Teletab");
		ModLoader.addName(Htab, "Hub Teletab");

		ModLoader.addName(GreenDhide, "Green dragon hide");
		ModLoader.addName(GreenDleather, "Green dragon leather");
		ModLoader.addName(BlackDhide, "Black dragon hide");
		ModLoader.addName(BlackDleather, "Black dragon leather");
		ModLoader.addName(RatTail, "Rat's Tail");
		ModLoader.addName(Garlic, "Garlic - Vampires hate this!");
		ModLoader.addName(QuestPoint, "Vampire Slayer Quest");
		ModLoader.addName(QuestPoint1, "Sheep Shearer Quest");
		ModLoader.addName(QuestPoint2, "Cook's Assistant Quest");
		ModLoader.addName(QuestPoint3, "Black Knight's Fortress Quest");
		ModLoader.addName(sarabrew, "Saradomin Brew");
		ModLoader.addName(superrestore, "Super Restore");
		ModLoader.addName(superstr, "Super Strength");
		ModLoader.addName(superdef, "Super Defence");
		ModLoader.addName(specpot, "Special Attack Potion");
		ModLoader.addName(antifire, "Anti-Fire Potion");

		ModLoader.addName(gloves, "Thieving Gloves");
		ModLoader.addName(gloves2, "Elite Thieving Gloves");

		ModLoader.addName(VeracSpawn, "Verac spawner");
		ModLoader.registerBlock(VeracSpawn);
		ModLoader.addName(DharokSpawn, "Dharok spawner");
		ModLoader.registerBlock(DharokSpawn);
		ModLoader.addName(GuthanSpawn, "Guthan spawner");
		ModLoader.registerBlock(GuthanSpawn);
		ModLoader.addName(ToragSpawn, "Torag spawner");
		ModLoader.registerBlock(ToragSpawn);
		ModLoader.addName(KarilSpawn, "Karil spawner");
		ModLoader.registerBlock(KarilSpawn);
		ModLoader.addName(AhrimSpawn, "Ahrim spawner");
		ModLoader.registerBlock(AhrimSpawn);
		ModLoader.addName(AkrisaeSpawn, "Akrisae spawner");
		ModLoader.registerBlock(AkrisaeSpawn);
		ModLoader.addName(Fire, "Fire");
		ModLoader.registerBlock(Fire);
		ModLoader.addName(Stall, "Market Stall");
		ModLoader.registerBlock(Stall);
		ModLoader.addName(BlockStall, "Market Block Stall");
		ModLoader.registerBlock(BlockStall);
		ModLoader.addName(Dragon, "Dragon hatchling");
		ModLoader.registerBlock(Dragon);

		ModLoader.addName(BanditSpawn, "Bandit boss spawner");
		ModLoader.registerBlock(BanditSpawn);
		ModLoader.addName(MuggerSpawn, "Mugger spawner");
		ModLoader.registerBlock(MuggerSpawn);

		ModLoader.addName(Runeores, "Rune Xp Ore");
		ModLoader.registerBlock(Runeores);
		ModLoader.addName(Addyores, "Addy Xp Ore");
		ModLoader.registerBlock(Addyores);
		ModLoader.addName(Mithores, "Mith Xp Ore");
		ModLoader.registerBlock(Mithores);
		ModLoader.addName(cobblestones, "Cobblestone Xp Ore");
		ModLoader.registerBlock(cobblestones);
		ModLoader.addName(oreIrons, "Iorn Xp Ore");
		ModLoader.registerBlock(oreIrons);
		ModLoader.addName(oreGolds, "Gold Xp Ore");
		ModLoader.registerBlock(oreGolds);
		ModLoader.addName(oreCoals, "Coal Xp Ore");
		ModLoader.registerBlock(oreCoals);

		ModLoader.addName(Shop1, "Login shop 1");
		ModLoader.registerBlock(Shop1);
		ModLoader.addName(Shop2, "Login shop 2");
		ModLoader.registerBlock(Shop2);
		ModLoader.addName(Shop3, "Login shop 3");
		ModLoader.registerBlock(Shop3);
		ModLoader.addName(Shop4, "Login shop 4");
		ModLoader.registerBlock(Shop4);

		ModLoader.addName(LOL, "LOL");

		ModLoader.addRecipe(new ItemStack(mod_Flower.cutcabbage, 1),
				new Object[] { "X", Character.valueOf('X'), mod_Flower.cabbage });

		ModLoader.addShapelessRecipe(new ItemStack(mod_Flower.cutcabbage, 1), new Object[] { mod_Flower.cabbage });
		ModLoader.addShapelessRecipe(new ItemStack(mod_Flower.cabbagepieuncooked, 1),
				new Object[] { mod_Flower.cutcabbage, Item.bread });
		ModLoader.addShapelessRecipe(new ItemStack(mod_Flower.fishpieuncooked, 1),
				new Object[] { Item.fishCooked, Item.bread });
		ModLoader.addShapelessRecipe(new ItemStack(mod_Flower.applepieuncooked, 1),
				new Object[] { Item.appleRed, Item.bread });
		ModLoader.addShapelessRecipe(new ItemStack(mod_Flower.meatpieuncooked, 1),
				new Object[] { Item.porkCooked, Item.bread });
		ModLoader.addShapelessRecipe(new ItemStack(mod_Flower.GreenDleather, 1),
				new Object[] { Item.goldNugget, mod_Flower.GreenDhide });
		ModLoader.addShapelessRecipe(new ItemStack(mod_Flower.BlackDleather, 1),
				new Object[] { Item.goldNugget, mod_Flower.BlackDhide });
		// REMEMBER TO DISABLE THESE
		// ModLoader.addRecipe (new ItemStack(mod_Flower.HAXORB, 1), new
		// Object[] {" X ", Character.valueOf('X'), Block.dirt});
		// ModLoader.addRecipe (new ItemStack(mod_Flower.LOL, 1), new Object[]
		// {" X ","XYX","XXY", Character.valueOf('X'), Block.dirt,
		// Character.valueOf('Y'), Block.wood});
		// ModLoader.addRecipe (new ItemStack(mod_Flower.Stats, 1), new Object[]
		// {"X", Character.valueOf('X'), Block.sand});

		// ModLoader.addRecipe (new ItemStack(mod_Flower.cabbagepieuncooked, 1),
		// new Object[] {" X ","XYX", Character.valueOf('X'),
		// Block.wood,Character.valueOf('Y'),Block.torchWood});

		GameRegistry.addShapelessRecipe(new ItemStack(mod_Flower.TombKey, 2),
				new Object[] {mod_Flower.AhrimKey, mod_Flower.AkrisaeKey, mod_Flower.DharokKey, mod_Flower.KarilKey,
						mod_Flower.GuthanKey, mod_Flower.ToragKey, mod_Flower.VeracKey });

		GameRegistry.addSmelting(cabbagepieuncooked.itemID, new ItemStack(cabbagepie), 1.0F);
		GameRegistry.addSmelting(meatpieuncooked.itemID, new ItemStack(meatpie), 1.0F);
		GameRegistry.addSmelting(fishpieuncooked.itemID, new ItemStack(fishpie), 1.0F);
		GameRegistry.addSmelting(applepieuncooked.itemID, new ItemStack(applepie), 1.0F);

		GameRegistry.registerTileEntity(TileEntityFireEntity.class, "tileEntityFire");
		GameRegistry.registerTileEntity(TileEntityDragonEntity.class, "tileEntityDragon");
	}

	public void generateSurface(World var1, Random var2, int var3, int var4) {
		int var5;
		int var6;
		int var7;
		int var8;
		for (var5 = 0; var5 < 0.0001; ++var5) {
			var6 = var3 + var2.nextInt(16) + 8;
			var7 = var2.nextInt(128);
			var8 = var4 + var2.nextInt(16) + 8;
			(new WorldGenFlowers(mod_Flower.cabbage.blockID)).generate(var1, var2, var6, var7, var8);
		}
	}

	public String getVersion() {
		return "1.6.4";
	}
}
