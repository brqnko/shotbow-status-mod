package dev.brqnko.handler.message.impl;

import dev.brqnko.handler.message.IMessageHandler;
import dev.brqnko.status.ShotbowStatus;
import net.minecraft.client.MinecraftClient;

public class KillMessageHandler implements IMessageHandler {

    @Override
    public void handleMessage(String text, ShotbowStatus shotbowStatus) {
        String[] splitedString = text.split(" ");

        if (splitedString.length < 3) {
            return;
        }

        if (!splitedString[0].startsWith(MinecraftClient.getInstance().player.getName().getString())) {
            return;
        }

        switch (splitedString[1]) {
            case "killed":
                shotbowStatus.killStatus().incrementSwordKillCount();
                break;
            case "shot":
                shotbowStatus.killStatus().incrementBowKillCount();
                break;
        }
    }
}
