package dev.brqnko.handler.message;

import dev.brqnko.status.ShotbowStatus;

public interface IMessageHandler {

    void handleMessage(String text, ShotbowStatus shotbowStatus);
}
