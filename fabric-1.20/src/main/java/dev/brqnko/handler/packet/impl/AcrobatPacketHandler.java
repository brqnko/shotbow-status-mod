package dev.brqnko.handler.packet.impl;

import dev.brqnko.handler.packet.IPacketHandler;
import dev.brqnko.status.ShotbowStatus;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.PlayerAbilitiesS2CPacket;

public class AcrobatPacketHandler implements IPacketHandler {

    @Override
    public void handlePacket(Packet<?> packet, ShotbowStatus shotbowStatus) {
        if (!(packet instanceof PlayerAbilitiesS2CPacket playerAbilitiesS2CPacket)) {
            return;
        }

        if (playerAbilitiesS2CPacket.allowFlying()) {
            return;
        }

        if (!shotbowStatus.classStatus().getCurrentClass().informal().equalsIgnoreCase("ACR")) {
            return;
        }

        shotbowStatus.classStatus().setCooldown(Items.FEATHER, 10);
    }
}
