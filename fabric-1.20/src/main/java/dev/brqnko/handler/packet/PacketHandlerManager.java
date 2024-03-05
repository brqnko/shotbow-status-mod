package dev.brqnko.handler.packet;

import dev.brqnko.handler.packet.impl.AcrobatPacketHandler;
import dev.brqnko.handler.packet.impl.ClassPacketHandler;
import dev.brqnko.status.ShotbowStatus;
import net.minecraft.network.packet.Packet;

import java.util.Arrays;
import java.util.List;

public class PacketHandlerManager {

    /**
     * Define a singleton instance of PacketHandlerManager
     */
    private static final PacketHandlerManager SINGLETON = new PacketHandlerManager();

    /**
     * DO not let make instance from other classes
     */
    private PacketHandlerManager() {}

    /**
     * Return the singleton instance
     *
     * @return singleton instance
     */
    public static PacketHandlerManager getInstance() {
        return SINGLETON;
    }

    /**
     * Define a list of all packet handler
     */
    private final List<IPacketHandler> handlers = Arrays.asList(
            new AcrobatPacketHandler(),
            new ClassPacketHandler()
    );

    public void handlePacket(Packet<?> packet) {
        handlers.forEach(handler -> handler.handlePacket(packet, ShotbowStatus.getInstance()));
    }
}
