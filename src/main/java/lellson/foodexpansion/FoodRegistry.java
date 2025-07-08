package lellson.foodexpansion;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class FoodRegistry {

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		
		IForgeRegistry<Item> registry = event.getRegistry();
		for (Item object : FoodItems.ITEM_LIST)
		{
			registry.register(object);
		}
	}
}
