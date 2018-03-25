package net.minecraft.src;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

@SuppressWarnings("unchecked")
public class GuiTurael {

	public static Object instance;

	public static int GUIID = 1;

	public GuiTurael() {
	}

	public void load() {
		// NetworkRegistry.INSTANCE.registerGuiHandler(instance, new
		// GuiHandler());
	}

	public void registerRenderers() {
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}

	public static IInventory inherited;

	public static class GuiContainerMod extends Container {

		World world = null;
		EntityPlayer entity = null;
		int i, j, k;

		public GuiContainerMod(World world, int i, int j, int k, EntityPlayer player) {

			this.world = world;
			this.entity = player;
			this.i = i;
			this.j = j;
			this.k = k;

		}

		@Override
		public boolean canInteractWith(EntityPlayer player) {
			return true;
		}

		protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
			int i;
			int j;

			for (i = 0; i < 3; ++i) {
				for (j = 0; j < 9; ++j) {
					this.addSlotToContainer(new Slot(inventoryPlayer, j + (i + 1) * 9, 8 + j * 18, 84 + i * 18));
				}
			}

			for (i = 0; i < 9; ++i) {
				this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
			}
		}

		@Override
		public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
			ItemStack itemstack = null;
			Slot slot = (Slot) this.inventorySlots.get(index);

			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();

				if (index < 9) {
					if (!this.mergeItemStack(itemstack1, 9, (45 - 9), true)) {// fixes
																				// shiftclick
																				// error
						return null;
					}
				} else if (!this.mergeItemStack(itemstack1, 0, 9, false)) {
					return null;
				}

				if (itemstack1.stackSize == 0) {
					slot.putStack((ItemStack) null);
				} else {
					slot.onSlotChanged();
				}

				if (itemstack1.stackSize == itemstack.stackSize) {
					return null;
				}

				slot.onPickupFromSlot(playerIn, itemstack1);
			}

			return itemstack;
		}

		public void onContainerClosed(EntityPlayer playerIn) {
			super.onContainerClosed(playerIn);

		}
	}

	public static class GuiWindow extends GuiContainer {

		int i = 0;
		int j = 0;
		int k = 0;
		EntityPlayer entity = null;

		public GuiWindow(World world, int i, int j, int k, EntityPlayer entity) {
			super(new GuiContainerMod(world, i, j, k, entity));
			this.i = i;
			this.j = j;
			this.k = k;
			this.entity = entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		private static final ResourceLocation texture = new ResourceLocation("Test.png");

		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

			this.mc.renderEngine.bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

			zLevel = 100.0F;

		}

		protected void mouseClicked(int par1, int par2, int par3) {
			super.mouseClicked(par1, par2, par3);

		}

		public void updateScreen() {
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;

		}

		protected void keyTyped(char par1, int par2) {

			super.keyTyped(par1, par2);

		}

		protected void drawGuiContainerForegroundLayer(int par1, int par2) {
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;
			this.fontRenderer.drawString("Turael", (3), (2), 0x999999);
		}

		public void onGuiClosed() {
			Keyboard.enableRepeatEvents(false);
		}

		public void initGui() {
			super.initGui();
			this.guiLeft = (this.width - 176) / 2;
			this.guiTop = (this.height - 166) / 2;
			Keyboard.enableRepeatEvents(true);
			this.buttonList.clear();
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;
			this.buttonList.add(new GuiButton(0, this.guiLeft + 9, this.guiTop + 26, 86, 20, "New Task"));
			this.buttonList.add(new GuiButton(1, this.guiLeft + 8, this.guiTop + 58, 88, 20, "Skip Task"));
			this.buttonList.add(new GuiButton(2, this.guiLeft + 6, this.guiTop + 91, 112, 20, "Test Button"));

		}

		protected void actionPerformed(GuiButton button) {
			MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
			World world = server.worldServers[0];

			if (button.id == 0) {
				if(true) {
					//do this
				}
			}

			if (button.id == 1) {
				if(true) {
					//do this
				}
			}

			if (button.id == 2) {

				if (true) {
					// do this
				}

			}

		}

		public boolean doesGuiPauseGame() {
			return false;
		}

	}

}
