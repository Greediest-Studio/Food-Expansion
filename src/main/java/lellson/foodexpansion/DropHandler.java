package lellson.foodexpansion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class DropHandler {

	private static final Map<Class<? extends EntityLivingBase>, DropData> DROP_MAP = new HashMap<>();

	static {
		add(EntitySquid.class,FoodItems.itemSquid,FoodItems.itemCookedSquid,2);
		add(EntityHorse.class,FoodItems.itemHorseMeat,FoodItems.itemCookedHorseMeat,3);
		add(EntityBat.class,FoodItems.itemBatWing,FoodItems.itemCookedBatWing,1);
		add(EntityWolf.class,FoodItems.itemWolfMeat,FoodItems.itemCookedWolfMeat,2);
		add(EntityOcelot.class,FoodItems.itemOcelotMeat,FoodItems.itemCookedOcelotMeat,1);
		add(EntityParrot.class,FoodItems.itemParrotMeat,FoodItems.itemCookedParrotMeat,1);
		add(EntityLlama.class,FoodItems.itemLlamaMeat, FoodItems.itemCookedLlamaMeat,2);
		add(EntityPolarBear.class,FoodItems.itemPolarBearMeat, FoodItems.itemCookedPolarBearMeat,3);
	}

	private static void add(Class<? extends EntityLivingBase> entityClass, Item raw, Item cooked, int maxAmount) {
		DROP_MAP.put(entityClass, new DropData(raw, cooked, maxAmount));
	}

	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		if (entity.isChild()) return;
		DropData data = DROP_MAP.get(entity.getClass());
		if (data != null) {
			Item dropItem = entity.isBurning() ? data.cooked : data.raw;
			int amount = entity.world.rand.nextInt(data.maxAmount) + 1;
			entity.entityDropItem(new ItemStack(dropItem, amount), 0.5F);
		}
	}

	private static class DropData {
		final Item raw;
		final Item cooked;
		final int maxAmount;

		DropData(Item raw, Item cooked, int maxAmount) {
			this.raw = raw;
			this.cooked = cooked;
			this.maxAmount = maxAmount;
		}
	}
}