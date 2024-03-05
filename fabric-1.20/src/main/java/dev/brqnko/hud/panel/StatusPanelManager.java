package dev.brqnko.hud.panel;

import dev.brqnko.hud.panel.impl.ClassStatusPanel;
import dev.brqnko.hud.panel.impl.KillStatusPanel;
import dev.brqnko.hud.panel.impl.RankStatusPanel;
import dev.brqnko.status.ShotbowStatus;
import net.minecraft.client.gui.DrawContext;

import java.util.Arrays;
import java.util.List;

public class StatusPanelManager {

    private static final StatusPanelManager SINGLETON = new StatusPanelManager();

    private StatusPanelManager() {}

    public static StatusPanelManager getInstance() {
        return SINGLETON;
    }

    private final List<StatusPanel> panels = Arrays.asList(
            new ClassStatusPanel(),
            new RankStatusPanel(),
            new KillStatusPanel()
    );

    public void render(DrawContext context, float delta) {
        this.panels.stream().filter(StatusPanel::isEnabled).forEach(panel -> panel.render(context, delta, ShotbowStatus.getInstance()));
    }

    public void click(double mouseX, double mouseY, int button, ShotbowStatus status) {
        this.panels.forEach(panel -> panel.clickMouse(mouseX, mouseY, button, status));
    }

    public void release() {
        this.panels.forEach(StatusPanel::release);
    }

    public void updatePosition(double mouseX, double mouseY) {
        this.panels.forEach(panel -> panel.updatePosition(mouseX, mouseY));
    }
}
