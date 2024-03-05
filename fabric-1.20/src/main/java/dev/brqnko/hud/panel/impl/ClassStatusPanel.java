package dev.brqnko.hud.panel.impl;

import dev.brqnko.hud.panel.StatusPanel;
import dev.brqnko.hud.panel.StatusPanelShape;
import dev.brqnko.status.ShotbowStatus;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.item.Item;
import net.minecraft.util.math.ColorHelper;
import org.joml.Matrix4f;

public class ClassStatusPanel extends StatusPanel {

    public ClassStatusPanel() {
        super(new StatusPanelShape(0, 0, 1));
    }

    @Override
    public void render(DrawContext context, float delta, ShotbowStatus status) {
        for (Item item : status.classStatus().getCurrentClass().items()) {
            boolean ready = status.classStatus().getCTPercentage(item) != 1;

            drawCircle(context, shape.getPosX() + 10 + 8, shape.getPosY() + 10 + 8, 13,
                    (int) (status.classStatus().getCTPercentage(item) * 360),
                    ready ? -1 : 0xff00ff00);
            context.drawItem(item.getDefaultStack(), shape.getPosX() + 10, shape.getPosY() + 10);


            if (!ready) {
                status.classStatus().setReady(item);
            }
        }
    }

    private void drawCircle(DrawContext context, int x, int y, int radius, int degrees, int color) {
        Matrix4f matrix4f = context.getMatrices().peek().getPositionMatrix();

        float rad2 = radius - 2;

        float f = (float) ColorHelper.Argb.getAlpha(color) / 255.0F;
        float g = (float) ColorHelper.Argb.getRed(color) / 255.0F;
        float h = (float) ColorHelper.Argb.getGreen(color) / 255.0F;
        float j = (float) ColorHelper.Argb.getBlue(color) / 255.0F;
        VertexConsumer vertexConsumer = context.getVertexConsumers().getBuffer(RenderLayer.getGui());

        for (int i = 0; i <= degrees; i += 5) {
            float sin1 = (float) Math.sin(Math.toRadians(i));
            float cos1 = (float) Math.cos(Math.toRadians(i));
            float sin2 = (float) Math.sin(Math.toRadians(i + 10));
            float cos2 = (float) Math.cos(Math.toRadians(i + 10));

            vertexConsumer.vertex(matrix4f,
                    x + sin1 * rad2,
                    y + cos1 * rad2,
                    0).color(g, h, j, f).next();
            vertexConsumer.vertex(matrix4f,
                    x + sin1 * radius,
                    y + cos1 * radius,
                    0).color(g, h, j, f).next();

            vertexConsumer.vertex(matrix4f,
                    x + sin2 * radius,
                    y + cos2 * radius,
                    0).color(g, h, j, f).next();
            vertexConsumer.vertex(matrix4f,
                    x + sin2 * rad2,
                    y + cos2 * rad2,
                    0).color(g, h, j, f).next();
        }

        context.draw();
    }

    @Override
    public boolean isHovering(double mouseX, double mouseY, ShotbowStatus status) {
        return isHovering(shape.getPosX(), shape.getPosY(), shape.getPosX() + 20 * status.classStatus().getCurrentClass().items().length, shape.getPosY() + 20, mouseX, mouseY);
    }
}
