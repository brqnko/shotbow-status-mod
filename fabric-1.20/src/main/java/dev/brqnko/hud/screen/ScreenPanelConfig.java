package dev.brqnko.hud.screen;

import dev.brqnko.hud.panel.StatusPanelManager;
import dev.brqnko.status.ShotbowStatus;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ScreenPanelConfig extends Screen {

    public ScreenPanelConfig() {
        super(Text.literal("screen-panel-configure"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        StatusPanelManager.getInstance().updatePosition(mouseX, mouseY);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        StatusPanelManager.getInstance().click(mouseX, mouseY, button, ShotbowStatus.getInstance());
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        StatusPanelManager.getInstance().release();
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public void close() {
        StatusPanelManager.getInstance().release();
        super.close();
    }
}
