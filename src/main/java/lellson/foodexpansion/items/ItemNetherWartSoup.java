package lellson.foodexpansion.items;

import java.util.Iterator;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemNetherWartSoup extends ItemFoodBasic {

	public ItemNetherWartSoup() {
		super("itemNetherWartSoup", 4, 0.4F, false, new ItemStack(Items.BOWL));
		this.setAlwaysEdible();
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack item, World world, EntityLivingBase player) {
		
		player.setFire(5);
		
		Iterator<PotionEffect> it = player.getActivePotionEffects().iterator();
		while(it.hasNext()) 
		{
			PotionEffect effect = it.next();
			if (!effect.getPotion().isBeneficial())
				it.remove();
		}

        return super.onItemUseFinish(item, world, player);
    }

}
