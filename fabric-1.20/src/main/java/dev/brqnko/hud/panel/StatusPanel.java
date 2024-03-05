package dev.brqnko.hud.panel;

import dev.brqnko.status.ShotbowStatus;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public abstract class StatusPanel {

    protected final MinecraftClient client = MinecraftClient.getInstance();

    private final StatusPanelShape defaultShape;

    protected StatusPanelShape shape;

    protected boolean enabled;

    private double lastMouseX, lastMouseY;

    private boolean dragging;

    public StatusPanel(StatusPanelShape defaultShape) {
        this.defaultShape = defaultShape;
        this.shape = defaultShape.copy();
        this.enabled = true;
    }

    public void setShape(StatusPanelShape shape) {
        this.shape = shape;
    }

    public final void resetShape() {
        this.shape = defaultShape.copy();
    }

    public abstract void render(DrawContext context, float delta, ShotbowStatus status);

    public final void updatePosition(double mouseX, double mouseY) {
        if (!this.dragging) {
            return;
        }

        this.shape.setPos((int) (mouseX + lastMouseY), (int) (mouseY + lastMouseY));
    }

    public boolean isEnabled() {
        return enabled;
    }

    public final void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    protected abstract boolean isHovering(double mouseX, double mouseY, ShotbowStatus status);

    protected static boolean isHovering(double x, double y, double x2, double y2, double mouseX, double mouseY) {
        return mouseX >= x && mouseY >= y && mouseX <= x2 && mouseY <= y2;
    }

    public final void clickMouse(double mouseX, double mouseY, int button, ShotbowStatus status) {
        if (isHovering(mouseX, mouseY, status)) {
            this.lastMouseX = this.shape.getPosX() - mouseX;
            this.lastMouseY = this.shape.getPosY() - mouseY;
            dragging = true;
        }
    }

    public final void release() {
        dragging = false;
    }
}
