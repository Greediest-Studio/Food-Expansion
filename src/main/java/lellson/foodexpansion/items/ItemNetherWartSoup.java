package lellson.foodexpansion.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemNetherWartSoup extends ItemFoodBasic {

	public ItemNetherWartSoup() {
		super("itemNetherWartSoup", 4, 0.4F, false, new ItemStack(Items.BOWL));
		this.setAlwaysEdible();
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack item, World world, EntityLivingBase player) {
		if (!world.isRemote) {
			player.setFire(5);
			player.getActivePotionEffects().removeIf(effect -> !effect.getPotion().isBeneficial());
		}
		return super.onItemUseFinish(item, world, player);
	}
}
