package net.minecraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderWizard extends RenderBiped {

	private static final ResourceLocation textureLocation = new ResourceLocation("textures/entity/wizard.png");

	public RenderWizard(ModelBiped par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	public void renderEntityWizard(EntityWizard par1Entity, double par2, double par4, double par6, float par8,
			float par9) {
		super.doRenderLiving(par1Entity, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8,
			float par9) {
		this.renderEntityWizard((EntityWizard) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderEntityWizard((EntityWizard) par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return textureLocation;
	}

}