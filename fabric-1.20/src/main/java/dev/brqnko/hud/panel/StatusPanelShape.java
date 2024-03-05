package dev.brqnko.hud.panel;

public class StatusPanelShape {

    private int posX, posY;

    private double scale;

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public StatusPanelShape(int posX, int posY, double scale) {
        this.posX = posX;
        this.posY = posY;
        this.scale = scale;
    }

    public StatusPanelShape copy() {
        return new StatusPanelShape(this.posX, this.posY, this.scale);
    }

    public static StatusPanelShape zero() {
        return new StatusPanelShape(0, 0, 1d);
    }
}
