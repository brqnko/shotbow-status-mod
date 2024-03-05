package dev.brqnko.handler.packet;

import dev.brqnko.status.ShotbowStatus;
import net.minecraft.network.packet.Packet;

public interface IPacketHandler {

    void handlePacket(Packet<?> packet, ShotbowStatus shotbowStatus);
}
