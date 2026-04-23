package lellson.foodexpansion;

import lellson.foodexpansion.crafting.FoodRecipes;
import lellson.foodexpansion.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class FoodExpansion {

	public static final String CLIENT_PROXY = "lellson.foodexpansion.proxy.ClientProxy";
	public static final String SERVER_PROXY = "lellson.foodexpansion.proxy.CommonProxy";

	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		FoodItems.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		FoodRecipes.initShapelessRecipes();	
		FoodRecipes.initSmeltingRecipes();
		MinecraftForge.EVENT_BUS.register(new DropHandler());
	}

	public static CreativeTabs tabFoodExpansion = new CreativeTabs("tabFoodExpansion") {

		@Override
		public ItemStack createIcon() {
			return new ItemStack(FoodItems.itemChocolateBar);
		}
	};
}
