package dev.brqnko.handler.message.impl;

import dev.brqnko.handler.message.IMessageHandler;
import dev.brqnko.status.ShotbowClass;
import dev.brqnko.status.ShotbowStatus;

public class ClassChangeMessageHandler implements IMessageHandler {

    private static final String PREFIX = "[Class] ";

    @Override
    public void handleMessage(String text, ShotbowStatus shotbowStatus) {
        if (!text.startsWith(PREFIX)) {
            return;
        }

        String[] splited = text.substring(PREFIX.length()).split(" ");
        if (splited.length != 2) {
            return;
        }

        String className = splited[0];

        ShotbowClass matchedClass = ShotbowClass.getClasses().stream()
                .filter(shotbowClass -> shotbowClass.name().equalsIgnoreCase(className))
                .findAny()
                .orElse(null);
        if (matchedClass == null) {
            return;
        }

        shotbowStatus.classStatus().setCurrentClass(matchedClass);
    }
}
