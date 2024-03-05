package dev.brqnko.handler.message.impl;

import dev.brqnko.handler.message.IMessageHandler;
import dev.brqnko.status.ShotbowStatus;

public class RankPointMessageHandler implements IMessageHandler {

    private static final String PREFIX = "Current points: ";

    @Override
    public void handleMessage(String text, ShotbowStatus shotbowStatus) {
        if (!text.startsWith(PREFIX)) {
            return;
        }

        String pointString = text.substring(PREFIX.length());

        shotbowStatus.rankStatus().setCurrentPoint(Integer.parseInt(pointString));
    }
}
