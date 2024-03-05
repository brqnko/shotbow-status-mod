package dev.brqnko.hud.panel.impl;

import dev.brqnko.hud.panel.StatusPanel;
import dev.brqnko.hud.panel.StatusPanelShape;
import dev.brqnko.status.ShotbowStatus;
import net.minecraft.client.gui.DrawContext;

public class RankStatusPanel extends StatusPanel {

    private final String RANK_PREF = "Rank: ";

    private final String POINT_PREF = "Point: ";

    private final int RANK_PREF_WIDTH = client.textRenderer.getWidth(RANK_PREF);

    private final int POINT_PREF_WIDTH = client.textRenderer.getWidth(POINT_PREF);

    public RankStatusPanel() {
        super(new StatusPanelShape(0, 100, 1));
    }

    @Override
    public void render(DrawContext context, float delta, ShotbowStatus status) {
        String rank = status.rankStatus().getRank().tag();
        String point = String.valueOf(status.rankStatus().getCurrentPoint());

        int rankWidth = client.textRenderer.getWidth(rank);
        int pointWidth = client.textRenderer.getWidth(point);

        int panelWidth = Math.max(rankWidth, pointWidth) + POINT_PREF_WIDTH;

        context.fill(shape.getPosX() - 2, shape.getPosY() - 2, shape.getPosX() + panelWidth + 2, shape.getPosY() + 10 * 2, 0xa0000000);

        context.drawText(client.textRenderer, RANK_PREF, shape.getPosX(), shape.getPosY(), -1, true);
        context.drawText(client.textRenderer, rank, shape.getPosX() + RANK_PREF_WIDTH, shape.getPosY(), status.rankStatus().getRank().color(), true);

        context.drawText(client.textRenderer, POINT_PREF, shape.getPosX(), shape.getPosY() + 10, -1, true);
        context.drawText(client.textRenderer, point, shape.getPosX() + POINT_PREF_WIDTH, shape.getPosY() + 10, -1, true);
    }

    @Override
    public boolean isHovering(double mouseX, double mouseY, ShotbowStatus status) {
        String rank = status.rankStatus().getRank().tag();
        String point = String.valueOf(status.rankStatus().getCurrentPoint());

        int rankWidth = client.textRenderer.getWidth(rank);
        int pointWidth = client.textRenderer.getWidth(point);

        int panelWidth = Math.max(rankWidth, pointWidth) + POINT_PREF_WIDTH;

        return isHovering(shape.getPosX() - 2, shape.getPosY() - 2, shape.getPosX() + panelWidth + 2, shape.getPosY() + 10 * 2, mouseX, mouseY);
    }
}
