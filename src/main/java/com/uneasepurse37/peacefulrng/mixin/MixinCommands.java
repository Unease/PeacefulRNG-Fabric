package com.uneasepurse37.peacefulrng.mixin;

import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.mojang.brigadier.AmbiguityConsumer;
import com.mojang.brigadier.CommandDispatcher;
import com.uneasepurse37.peacefulrng.CommandHelper;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

@Mixin(Commands.class)
public class MixinCommands {
    
    @Shadow @Final
    private static Logger LOGGER;
    
    @Redirect(at = @At(value = "INVOKE", target = "Lcom/mojang/brigadier/CommandDispatcher;findAmbiguities(Lcom/mojang/brigadier/AmbiguityConsumer;)V"), method = "<init>")
    public void inject_init(CommandDispatcher<CommandSourceStack> dispatcher, AmbiguityConsumer<CommandSourceStack> ambiguityConsumer) {
        CommandHelper.register(dispatcher);
        dispatcher.findAmbiguities((parent, child, sibling, inputs) -> LOGGER.warn("Ambiguity between arguments {} and {} with inputs: {}", (Object)dispatcher.getPath(child), (Object)dispatcher.getPath(sibling), (Object)inputs));
    }
}
