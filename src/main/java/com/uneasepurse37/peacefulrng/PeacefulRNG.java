package com.uneasepurse37.peacefulrng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class PeacefulRNG implements ModInitializer{

	public static final Logger LOGGER=LogManager.getFormatterLogger("PeacefulRNG");
	
	public static boolean toggledchicken = true;
	public static boolean toggledflesh = true;
	public static boolean toggledpotato = true;
	public static boolean isTASMODLoaded;

	@Override
	public void onInitialize() {
		LOGGER.info("PeacefulRNG is initialized!");
		
		isTASMODLoaded = FabricLoader.getInstance().isModLoaded("lotas") | FabricLoader.getInstance().isModLoaded("tasmod");
		
		if (FabricLoader.getInstance().isModLoaded("lotas")) {
			LOGGER.info("LoTAS is loaded with PeacefulRNG!");
		} else if (FabricLoader.getInstance().isModLoaded("tasmod")) {
			LOGGER.info("TASMod is loaded with PeacefulRNG!");
		}
	}
}
