package net.minecraft.src;
 
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
 
public class RenderCaveCrawlerBoss extends RenderLiving
{
    private static final ResourceLocation textureLocation = new ResourceLocation("textures/entity/CaveCrawlerBoss.png");
    
    protected ResourceLocation func_110779_a(EntityCaveCrawler2Boss par1EntityAbbyDemon)
    {
             return textureLocation;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
    return textureLocation;
    }
    protected void preRenderScale(EntityCaveCrawler2Boss par1EntityNameHere , float par2)
    {
            GL11.glScalef(2.4F, 2.4F, 2.4F);
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderScale((EntityCaveCrawler2Boss)par1EntityLivingBase, par2);
    }
    public RenderCaveCrawlerBoss(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }
 
    public void renderCaveCrawler(EntityCaveCrawler2Boss par1EntityCaveCrawler2Boss, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityCaveCrawler2Boss, par2, par4, par6, par8, par9);
    }
 
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderCaveCrawler((EntityCaveCrawler2Boss)par1EntityLiving, par2, par4, par6, par8, par9);
    }
   
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderCaveCrawler((EntityCaveCrawler2Boss)par1Entity, par2, par4, par6, par8, par9);
    }
}