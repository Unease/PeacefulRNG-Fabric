package com.uneasepurse37.peacefulrng;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;

public class CommandHelper {
	
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		
		LiteralArgumentBuilder<CommandSourceStack> rawchicken = Commands.literal("rawchicken").executes(context -> rawchicken(context));
		
		LiteralArgumentBuilder<CommandSourceStack> rottenflesh = Commands.literal("rottenflesh").executes(context -> rottenflesh(context));
		
		LiteralArgumentBuilder<CommandSourceStack> poisonouspotato = Commands.literal("poisonouspotato").executes(context -> poisonouspotato(context));
		
		LiteralArgumentBuilder<CommandSourceStack> toggleprng = Commands.literal("toggleprng").executes(context -> toggleprng(context)).then(rawchicken).then(rottenflesh).then(poisonouspotato);
		
		dispatcher.register(toggleprng);
		
		
	}
	
	private static int rawchicken(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
		PeacefulRNG.toggledchicken = !PeacefulRNG.toggledchicken;
		
		if (PeacefulRNG.isTASMODLoaded) {
			if (!PeacefulRNG.toggledchicken && PeacefulRNG.toggledpotato && PeacefulRNG.toggledflesh) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Only raw chicken is"+ ChatFormatting.LIGHT_PURPLE + " off!"), false);
			} else if (PeacefulRNG.toggledchicken && !PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Only raw chicken is" + ChatFormatting.DARK_PURPLE + " on!"), false);
			} 
			
			if (PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
				context.getSource().sendSuccess(
						new TextComponent(ChatFormatting.GRAY + "Everything is toggled" + ChatFormatting.RED + " on!"),false);
			} else if (!PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Everything is toggled" + ChatFormatting.BLUE + " off!"), false);
			}
		}

		return 0;
	}
	
	private static int rottenflesh(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
		PeacefulRNG.toggledflesh = !PeacefulRNG.toggledflesh;
		
		if (PeacefulRNG.isTASMODLoaded) {
			if(!PeacefulRNG.toggledflesh && PeacefulRNG.toggledchicken && PeacefulRNG.toggledpotato) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Only rotten flesh is"+ ChatFormatting.YELLOW + " off!"), false);
			} else if (PeacefulRNG.toggledflesh && !PeacefulRNG.toggledchicken && !PeacefulRNG.toggledpotato) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Only rotten flesh is"+ ChatFormatting.GOLD + " on!"), false);
			}
			
			if (PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Everything is toggled"+ ChatFormatting.RED + " on!"), false);
			} else if (!PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Everything is toggled"+ ChatFormatting.BLUE + " off!"), false);
			}
		}
		
		
		return 0;
	}
	
	private static int poisonouspotato(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
		PeacefulRNG.toggledpotato = !PeacefulRNG.toggledpotato;
		
		if (FabricLoader.getInstance().isModLoaded("lotas") || FabricLoader.getInstance().isModLoaded("tasmod")) {
			if (!PeacefulRNG.toggledpotato && PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Only poisonous potatoes are"+ ChatFormatting.GREEN + " off!"), false);
			} else if (PeacefulRNG.toggledpotato && !PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Only poisonous potatoes are"+ ChatFormatting.DARK_GREEN + " on!"), false);
			} 
				
			if (PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Everything is toggled"+ ChatFormatting.RED + " on!"), false);
			} else if (!PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Everything is toggled"+ ChatFormatting.BLUE + " off!"), false);
			}
		}

		
		return 0;
	}
	
	private static int toggleprng(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
		
		
		boolean flag = PeacefulRNG.toggledchicken || PeacefulRNG.toggledflesh || PeacefulRNG.toggledpotato;
		
		PeacefulRNG.toggledchicken = !flag;
		PeacefulRNG.toggledflesh = !flag;
		PeacefulRNG.toggledpotato = !flag;
		
		if (PeacefulRNG.isTASMODLoaded) {
			if (PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Everything is toggled"+ ChatFormatting.RED + " on!"), false);
			} else if (!PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
				context.getSource().sendSuccess(new TextComponent(ChatFormatting.GRAY + "Everything is toggled"+ ChatFormatting.BLUE + " off!"), false);
			}
		}
		
		return 0;
	}
}
