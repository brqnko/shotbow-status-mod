package dev.brqnko.handler.message.impl;

import dev.brqnko.handler.message.IMessageHandler;
import dev.brqnko.status.ShotbowRank;
import dev.brqnko.status.ShotbowStatus;

public class RankMessageHandler implements IMessageHandler {

    private static final String PREFIX = "Current rank: ";

    @Override
    public void handleMessage(String text, ShotbowStatus shotbowStatus) {
        if (!text.startsWith(PREFIX)) {
            return;
        }

        String rankString = text.substring(PREFIX.length());

        shotbowStatus.rankStatus().setRank(ShotbowRank.fromTag(rankString));
    }
}
