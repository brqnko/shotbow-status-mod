package dev.brqnko;

import com.mojang.brigadier.Command;
import dev.brqnko.hud.screen.ScreenPanelConfig;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShotbowStatusMod implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("shotbow-status-mod");

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing shotbow-status-mod");

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(CommandManager.literal("shotbowstatus")
					.executes(ctx -> {
						MinecraftClient.getInstance().setScreen(new ScreenPanelConfig());
						return Command.SINGLE_SUCCESS;
					}));
		});
	}
}