package net.minecraft.src;
 
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
 
public class RenderKK extends RenderLiving
{
    private static final ResourceLocation textureLocation = new ResourceLocation("textures/entity/KK.png");
    
    protected ResourceLocation func_110779_a(EntityKK par1EntityAbbyDemon)
    {
             return textureLocation;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
    return textureLocation;
    }
	
	 protected void preRenderScale(EntityKK par1EntityNameHere , float par2)
     {
                     // These values are x,y,z scale. Where 1.0F = 100% (original size)
		 GL11.glScalef(3.5F, 3.5F, 3.5F);
		  GL11.glTranslatef( 0.0F, 0.7F, -1.0F);
     }
     
	  protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	    {
	        this.preRenderScale((EntityKK)par1EntityLivingBase, par2);
	    }
	  
    public RenderKK(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }
 
    public void renderKK(EntityKK par1EntityKK, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityKK, par2, par4, par6, par8, par9);
    }
 
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderKK((EntityKK)par1EntityLiving, par2, par4, par6, par8, par9);
    }
   
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderKK((EntityKK)par1Entity, par2, par4, par6, par8, par9);
    }
    
    
}