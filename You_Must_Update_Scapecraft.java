package net.minecraft.src;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class You_Must_Update_Scapecraft extends BaseMod {
	public static final String modid = "mod_lightning";
	public static final StepSound soundStoneFootstep = new StepSound("stone", 1.0F, 1.0F);
	public static final Block LightningRod = (new BlockLightningRod(177, 0).setHardness(3.0F).setResistance(5.0F)
			.setStepSound(soundStoneFootstep).setUnlocalizedName("LightningRod"));
	// public static final Item iphone = new
	// ItemIphone(11111).setUnlocalizedName("mod_lightning:boomstick");
	// public static final Item potato = new
	// Itempotato(11112).setUnlocalizedName("mod_lightning:rocket");
	// public static final Item boomstick = new
	// ItemBoomstick(1337).setUnlocalizedName("mod_lightning:pwnstick");

	public void registerRenderers() {

	}

	public void load()

	{

		ModLoader.registerBlock(LightningRod);
		ModLoader.addName(LightningRod, "Lightning Rod");

		// ModLoader.addName(iphone, "Boomstick");
		// ModLoader.addName(boomstick, "Pwnstick");
		// ModLoader.addName(potato, "Rocket Pack");

		GameRegistry.addRecipe(new ItemStack(You_Must_Update_Scapecraft.LightningRod, 1), new Object[] { "XXX", "XYX",
				"XXX", Character.valueOf('X'), Item.ingotIron, Character.valueOf('Y'), Item.ingotGold });
		// GameRegistry.addRecipe(new ItemStack(mod_lightning.iphone, 1),new Object[] {
		// "XXX", "XYX", "XXX", Character.valueOf('X'),Block.bedrock,
		// Character.valueOf('Y'), Item.blazeRod });
		// GameRegistry.addRecipe(new ItemStack(mod_lightning.boomstick, 1),new Object[]
		// { "X", Character.valueOf('X'), Block.bedrock });
		// GameRegistry.addRecipe(new ItemStack(mod_lightning.potato),new Object[] {
		// "XX", 'X', Block.bedrock });
	}

	public String getVersion() {
		return ("1.6.4 Scapecraft 4.4");
	}
}