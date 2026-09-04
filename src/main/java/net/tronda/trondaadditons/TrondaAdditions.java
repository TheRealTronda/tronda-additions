package net.tronda.trondaadditons;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.util.Identifier;

import net.tronda.trondaadditons.block.ModBlocks;
import net.tronda.trondaadditons.component.ModDataComponentTypes;
import net.tronda.trondaadditons.item.ModItemGroups;
import net.tronda.trondaadditons.item.ModItems;
import net.tronda.trondaadditons.util.HammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrondaAdditions implements ModInitializer {
	public static final String MOD_ID = "tronda-additions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistry.INSTANCE.add(ModItems.COKE, 6400);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
