package dev.brqnko.handler.message;


import dev.brqnko.handler.message.impl.ClassChangeMessageHandler;
import dev.brqnko.handler.message.impl.KillMessageHandler;
import dev.brqnko.handler.message.impl.RankMessageHandler;
import dev.brqnko.handler.message.impl.RankPointMessageHandler;
import dev.brqnko.status.ShotbowStatus;
import net.minecraft.text.Text;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageHandlerManager {

    private static final Pattern COLOR_PATTERN = Pattern.compile("§.");

    /**
     * Define a singleton instance of MessageHandlerManager
     */
    private static final MessageHandlerManager SINGLETON = new MessageHandlerManager();

    /**
     * Do not let make instance from other classes
     */
    private MessageHandlerManager() { }

    /**
     * Returns the singleton instance
     *
     * @return singleton instance
     */
    public static MessageHandlerManager getInstance() {
        return SINGLETON;
    }

    /**
     * Define a list of all message handler
     */
    private final List<IMessageHandler> handlers = Arrays.asList(
            new RankMessageHandler(),
            new RankPointMessageHandler(),
            new KillMessageHandler(),
            new ClassChangeMessageHandler()
    );

    public void handleMessage(Text message) {
        // Format the message
        String string = message
                .getString()
                .replaceAll("\r", "\\\\r")
                .replaceAll("\n", "\\\\n");
        Matcher matcher = COLOR_PATTERN.matcher(string);
        String replacedStr = matcher.replaceAll("");

        // Handle the message
        handlers.forEach(handler -> handler.handleMessage(replacedStr, ShotbowStatus.getInstance()));
    }
}
