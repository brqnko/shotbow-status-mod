package dev.brqnko.handler.packet.impl;

import dev.brqnko.handler.packet.IPacketHandler;
import dev.brqnko.status.ShotbowStatus;;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.*;

public class ClassPacketHandler implements IPacketHandler {

    private static final String READY = "READY";

    @Override
    public void handlePacket(Packet<?> packet, ShotbowStatus shotbowStatus) {
        if (!(packet instanceof ScreenHandlerSlotUpdateS2CPacket screenHandlerSlotUpdateS2CPacket)) {
            return;
        }

        ItemStack itemStack = screenHandlerSlotUpdateS2CPacket.getItemStack();
        String itemName = itemStack.getName().getString();

        String[] splited = itemName.split(" ");
        if (splited.length < 2) {
            return;
        }

        String ctString = splited[splited.length - 1];

        if (ctString.equals(READY)) {
            shotbowStatus.classStatus().setReady(itemStack.getItem());
        } else {
            int cooldown;
            // parse cooldown from ctString
            try {
                cooldown = Integer.parseInt(ctString);
            } catch (NumberFormatException e) {
                return;
            }

            shotbowStatus.classStatus().setCooldown(itemStack.getItem(), cooldown);
        }
    }
}
