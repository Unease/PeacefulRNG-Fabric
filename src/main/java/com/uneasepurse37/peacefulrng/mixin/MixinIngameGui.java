package com.uneasepurse37.peacefulrng.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.uneasepurse37.peacefulrng.RenderHelper;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;

@Mixin(Gui.class)
public class MixinIngameGui extends GuiComponent{

 	@Inject(at = @At(value = "INVOKE", shift = At.Shift.AFTER, target = "Lnet/minecraft/client/gui/Gui;renderEffects(Lcom/mojang/blaze3d/vertex/PoseStack;)V"), method = "render")
 	public void injectrender(com.mojang.blaze3d.vertex.PoseStack stack, float tickDelta, CallbackInfo ci) {
 		RenderHelper.render(stack, tickDelta, (Gui)(Object)this);
	}
}
