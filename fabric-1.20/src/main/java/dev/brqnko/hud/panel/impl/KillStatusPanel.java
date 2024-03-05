package dev.brqnko.hud.panel.impl;

import dev.brqnko.hud.panel.StatusPanel;
import dev.brqnko.hud.panel.StatusPanelShape;
import dev.brqnko.status.ShotbowStatus;
import net.minecraft.client.gui.DrawContext;

public class KillStatusPanel extends StatusPanel {

    private final String SWORD_PREF = "Sword kills: ";

    private final String BOW_PREF = "Bow kills: ";

    private final String NEXUS_PREF = "Nexus damages: ";

    private final int SWORD_PREF_WIDTH = client.textRenderer.getWidth(SWORD_PREF);

    private final int BOW_PREF_WIDTH = client.textRenderer.getWidth(BOW_PREF);

    private final int NEXUS_PREF_WIDTH = client.textRenderer.getWidth(NEXUS_PREF);

    public KillStatusPanel() {
        super(new StatusPanelShape(0, 50, 1));
    }

    @Override
    public void render(DrawContext context, float delta, ShotbowStatus status) {
        String sword = String.valueOf(status.killStatus().getSwordKillCount());
        String bow = String.valueOf(status.killStatus().getBowKillCount());
        String nexus = String.valueOf(status.killStatus().getNexusCount());

        int panelWidth = Math.max(
                client.textRenderer.getWidth(sword),
                Math.max(
                        client.textRenderer.getWidth(bow),
                        client.textRenderer.getWidth(nexus)
                )
        ) + NEXUS_PREF_WIDTH;

        context.fill(shape.getPosX() - 2, shape.getPosY() - 2, shape.getPosX() + panelWidth + 2, shape.getPosY() + 10 * 3, 0xa0000000);

        context.drawText(client.textRenderer, SWORD_PREF, shape.getPosX(), shape.getPosY(), -1, true);
        context.drawText(client.textRenderer, sword, shape.getPosX() + SWORD_PREF_WIDTH, shape.getPosY(), -1, true);

        context.drawText(client.textRenderer, BOW_PREF, shape.getPosX(), shape.getPosY() + 10, -1, true);
        context.drawText(client.textRenderer, bow, shape.getPosX() + BOW_PREF_WIDTH, shape.getPosY() + 10, -1, true);

        context.drawText(client.textRenderer, NEXUS_PREF, shape.getPosX(), shape.getPosY() + 10 * 2, -1, true);
        context.drawText(client.textRenderer, nexus, shape.getPosX() + NEXUS_PREF_WIDTH, shape.getPosY() + 10 * 2, -1, true);
    }

    @Override
    public boolean isHovering(double mouseX, double mouseY, ShotbowStatus status) {
        String sword = String.valueOf(status.killStatus().getSwordKillCount());
        String bow = String.valueOf(status.killStatus().getBowKillCount());
        String nexus = String.valueOf(status.killStatus().getNexusCount());

        int panelWidth = Math.max(
                client.textRenderer.getWidth(sword),
                Math.max(
                        client.textRenderer.getWidth(bow),
                        client.textRenderer.getWidth(nexus)
                )
        ) + NEXUS_PREF_WIDTH;

        return isHovering(shape.getPosX() - 2, shape.getPosY() - 2, shape.getPosX() + panelWidth + 2, shape.getPosY() + 10 * 3, mouseX, mouseY);
    }
}
