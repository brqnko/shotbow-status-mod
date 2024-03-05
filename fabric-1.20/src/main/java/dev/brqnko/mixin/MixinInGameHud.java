package dev.brqnko.mixin;

import dev.brqnko.hud.panel.StatusPanelManager;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {

    @Inject(
            method = "render",
            at = @At("TAIL")
    )
    public void onRender(DrawContext context, float delta, CallbackInfo ci) {
        StatusPanelManager.getInstance().render(context, delta);
    }
}
