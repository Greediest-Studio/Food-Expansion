package lellson.foodexpansion.crafting;

import java.util.ArrayList;
import java.util.List;

import lellson.foodexpansion.FoodItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FoodRecipes {
		
	public static void initShapelessRecipes(){

		addShapeless(new ItemStack(FoodItems.itemJelly), new ItemStack(Items.SLIME_BALL), new ItemStack(Items.SLIME_BALL), new ItemStack(Items.SLIME_BALL), new ItemStack(Items.SLIME_BALL), new ItemStack(Items.SUGAR));
		addShapeless(new ItemStack(FoodItems.itemBacon, 2), new ItemStack(Items.PORKCHOP));
		addShapeless(new ItemStack(FoodItems.itemBaconAndEgg), new ItemStack(FoodItems.itemFriedEgg), new ItemStack(FoodItems.itemCookedBacon));
		addShapeless(new ItemStack(FoodItems.itemCarrotSeedSoup), new ItemStack(Items.CARROT), new ItemStack(Items.CARROT), new ItemStack(Items.BOWL));
		addShapeless(new ItemStack(FoodItems.itemChocolateBar), new ItemStack(Items.DYE, 1, 3), new ItemStack(Items.DYE, 1, 3), new ItemStack(Items.SUGAR), new ItemStack(Items.SUGAR), new ItemStack(Items.MILK_BUCKET));
		addShapeless(new ItemStack(FoodItems.itemSpiderSoup), new ItemStack(Items.FERMENTED_SPIDER_EYE), new ItemStack(Items.SPIDER_EYE), new ItemStack(Items.BOWL));
		addShapeless(new ItemStack(FoodItems.itemNetherWartSoup), new ItemStack(Items.NETHER_WART), new ItemStack(Items.NETHER_WART), new ItemStack(Items.SUGAR), new ItemStack(Items.BOWL));
		addShapeless(new ItemStack(FoodItems.itemCarrotPie), new ItemStack(Items.CARROT), new ItemStack(Items.WHEAT), new ItemStack(Items.EGG));
		addShapeless(new ItemStack(FoodItems.itemCactusFruit), new ItemStack(Blocks.CACTUS));
		addShapeless(new ItemStack(FoodItems.itemCompressedFlesh), new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.SUGAR));
		addShapeless(new ItemStack(Items.LEATHER), new ItemStack(FoodItems.itemBatWing), new ItemStack(FoodItems.itemBatWing), new ItemStack(FoodItems.itemBatWing), new ItemStack(FoodItems.itemBatWing), new ItemStack(Items.DYE, 1, 15));
		addShapeless(new ItemStack(FoodItems.itemBlazeCream), new ItemStack(Items.BOWL), new ItemStack(Items.BLAZE_POWDER), new ItemStack(Items.BLAZE_POWDER), new ItemStack(Items.MILK_BUCKET));
		addShapeless(new ItemStack(FoodItems.itemMelonSalad), new ItemStack(Items.BOWL), new ItemStack(Items.MELON), new ItemStack(Items.MELON), new ItemStack(Items.MELON));
		addShapeless(new ItemStack(FoodItems.itemBeetrootNoodles), new ItemStack(Items.BOWL), new ItemStack(Items.BEETROOT), new ItemStack(Items.BEETROOT), new ItemStack(Items.WHEAT), new ItemStack(Items.WATER_BUCKET));

	}

	public static void initSmeltingRecipes(){

		GameRegistry.addSmelting(new ItemStack(Items.EGG), new ItemStack(FoodItems.itemFriedEgg), 0.35F);
		GameRegistry.addSmelting(new ItemStack(FoodItems.itemBacon), new ItemStack(FoodItems.itemCookedBacon), 0.35F);
		GameRegistry.addSmelting(new ItemStack(FoodItems.itemSquid), new ItemStack(FoodItems.itemCookedSquid), 0.35F);
		GameRegistry.addSmelting(new ItemStack(FoodItems.itemCompressedFlesh), new ItemStack(Items.LEATHER), 0.35F);
		GameRegistry.addSmelting(new ItemStack(FoodItems.itemHorseMeat), new ItemStack(FoodItems.itemCookedHorseMeat), 0.35F);
		GameRegistry.addSmelting(new ItemStack(Blocks.BROWN_MUSHROOM), new ItemStack(FoodItems.itemCookedMushroom), 0.35F);
		GameRegistry.addSmelting(new ItemStack(Blocks.RED_MUSHROOM), new ItemStack(FoodItems.itemCookedMushroom), 0.35F);
		GameRegistry.addSmelting(new ItemStack(FoodItems.itemBatWing), new ItemStack(FoodItems.itemCookedBatWing), 0.35F);
		GameRegistry.addSmelting(new ItemStack(FoodItems.itemWolfMeat), new ItemStack(FoodItems.itemCookedWolfMeat), 0.35F);
		GameRegistry.addSmelting(new ItemStack(FoodItems.itemOcelotMeat), new ItemStack(FoodItems.itemCookedOcelotMeat), 0.35F);
		GameRegistry.addSmelting(new ItemStack(FoodItems.itemParrotMeat), new ItemStack(FoodItems.itemCookedParrotMeat), 0.35F);
		GameRegistry.addSmelting(new ItemStack(FoodItems.itemLlamaMeat), new ItemStack(FoodItems.itemCookedLlamaMeat), 0.35F);
		GameRegistry.addSmelting(new ItemStack(FoodItems.itemPolarBearMeat), new ItemStack(FoodItems.itemCookedPolarBearMeat), 0.35F);
		GameRegistry.addSmelting(new ItemStack(Items.WHEAT_SEEDS), new ItemStack(FoodItems.itemRoastedSeed), 0.35F);
		GameRegistry.addSmelting(new ItemStack(Items.MELON_SEEDS), new ItemStack(FoodItems.itemRoastedSeed), 0.35F);
		GameRegistry.addSmelting(new ItemStack(Items.PUMPKIN_SEEDS), new ItemStack(FoodItems.itemRoastedSeed), 0.35F);
		GameRegistry.addSmelting(new ItemStack(Items.BEETROOT_SEEDS), new ItemStack(FoodItems.itemRoastedSeed), 0.35F);

	}
	
	public static void addShapeless(ItemStack output, ItemStack... input) {
		
		List<Ingredient> ingredients = new ArrayList<>();
		for (ItemStack stack : input)
			ingredients.add(Ingredient.fromStacks(stack));

		GameRegistry.addShapelessRecipe(output.getItem().getRegistryName(), null, output, ingredients.toArray(new Ingredient[ingredients.size()]));
	}
}
	
	

