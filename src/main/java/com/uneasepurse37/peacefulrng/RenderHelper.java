package com.uneasepurse37.peacefulrng;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class RenderHelper {
	public static void render(PoseStack stack, float tickDelta, Gui gui) {
 		Minecraft mc=Minecraft.getInstance();
 		
 		int width = mc.getWindow().getGuiScaledWidth();
 		
 		int height = mc.getWindow().getGuiScaledHeight();
 		
 		if (!mc.options.renderDebug) {
 			
 			if (!PeacefulRNG.isTASMODLoaded) {
 				
 				if (PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
 					
 					gui.drawCenteredString(stack, mc.font, "PeacefulRNG is toggled on!", width / 2, height - 50, 0x336AD1);
 					
 				} else if (!PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
 					
 					gui.drawCenteredString(stack, mc.font, "PeacefulRNG is toggled off!", width / 2, height - 50, 0x55FFFF);
 							
 				}
 				
 				if (PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) { // Checks if only poisonous potatoes are turned off
					gui.drawCenteredString(stack, mc.font, "Only poisonous potatoes are off!", width / 2, height - 50, 0x55FF55); // Green
 				} else if (PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) { // Checks if only rotten flesh is turned off
 					gui.drawCenteredString(stack, mc.font, "Only rotten flesh is off!", width / 2, height - 50, 0xFFFF55); // Yellow
				} else if (!PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) { // Checks if only raw chicken is turned off
					gui.drawCenteredString(stack, mc.font, "Only raw chicken is off!", width / 2, height - 50, 0xFF55FF); // Light Purple
				}
 				
				if (!PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) { // Checks if both raw chicken and rotten flesh are turned off
					gui.drawCenteredString(stack, mc.font, "Only poisonous potatoes are on!", width / 2, height - 50, 0x00AA00); // Dark Green
				} else if (!PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) { // Checks if both raw chicken and potatoes are turned off
					gui.drawCenteredString(stack, mc.font, "Only rotten flesh is on!", width / 2, height - 50, 0xFFAA00); // Gold
				} else if (PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) { // Checks if both rotten flesh and poisonous potatoes are turned off
					gui.drawCenteredString(stack, mc.font, "Only raw chicken is on!", width / 2, height - 50, 0xAA00AA); // Dark Purple
				}
				
 				
 			}
 			
 		}
 		
	}
}
