package com.uneasepurse37.peacefulrng.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.uneasepurse37.peacefulrng.PeacefulRNG;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@Mixin(LivingEntity.class)

public class MixinFood {

	@Redirect(method = "addEatEffect", at = @At(value = "INVOKE", target = "Ljava/lang/Float;floatValue()F"))
	public float redirectEatValue(Float prev, ItemStack itemStack, Level level, LivingEntity livingEntity) {

		if (itemStack.getItem().getDescriptionId().equals("item.minecraft.rotten_flesh")) {
			if (PeacefulRNG.toggledflesh == true)
			return 0;
		} else if (itemStack.getItem().getDescriptionId().equals("item.minecraft.chicken")) {
			if (PeacefulRNG.toggledchicken == true)
			return 0;
		} else if (itemStack.getItem().getDescriptionId().equals("item.minecraft.poisonous_potato")) {
			if (PeacefulRNG.toggledpotato == true)
			return 0;
		}
		
			return prev;
		}
}
