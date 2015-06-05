package com.cricketcraft.chisel;

import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.config.Configurations;
import com.cricketcraft.chisel.init.ChiselBlocks;
import com.cricketcraft.chisel.init.ChiselTabs;
import com.cricketcraft.chisel.proxy.CommonProxy;
import com.cricketcraft.chisel.world.GeneratorChisel;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCMessage;
import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent.MissingMapping;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.Type;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = Chisel.MOD_ID, name = Chisel.MOD_NAME, version = Chisel.VERSION, guiFactory = "com.cricketcraft.chisel.client.gui.GuiFactory", dependencies = "after:ForgeMultipart;after:Thaumcraft;after:appliedenergistics2;after:Railcraft;after:AWWayofTime;after:TwilightForest")
public class Chisel {

	public static final String MOD_ID = "chisel";
	public static final BlockCarvable.SoundType soundTempleFootstep = new BlockCarvable.SoundType("dig.stone", MOD_ID + ":step.templeblock", 1.0f, 1.0f);
	public static final String MOD_NAME = "Chisel 2";
	public static final String VERSION = "@VERSION@";
	public static final BlockCarvable.SoundType soundHolystoneFootstep = new BlockCarvable.SoundType("holystone", 1.0f, 1.0f);
	public static final BlockCarvable.SoundType soundMetalFootstep = new BlockCarvable.SoundType("metal", 1.0f, 1.0f);
	public static boolean multipartLoaded = false;
	public static int renderEldritchId;
	public static int renderAutoChiselId;
	public static int renderGlowId;
	public static int renderLayeredId;
	public static int roadLineId;

	public static final Logger logger = LogManager.getLogger(MOD_NAME);

	@Instance(MOD_ID)
	public static Chisel instance;
	
	public Chisel() {

	}

	@SidedProxy(clientSide = "com.cricketcraft.chisel.proxy.ClientProxy", serverSide = "com.cricketcraft.chisel.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void missingMapping(FMLMissingMappingsEvent event) {
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		File configFile = event.getSuggestedConfigurationFile();
		Configurations.configExists = configFile.exists();
		Configurations.config = new Configuration(configFile);
		Configurations.config.load();
		Configurations.refreshConfig();
		ChiselBlocks.init();
		ChiselTabs.preInit();
		proxy.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
	}

	private void addWorldgen(Features feature, IBlockState state, double... data) {
		if (feature.enabled()) {
			if (data.length == 1) {
				GeneratorChisel.INSTANCE.addFeature(state, 32, (int) data[0]);
			} else if (data.length > 1 && data.length < 4) {
				GeneratorChisel.INSTANCE.addFeature(state, 32, (int) data[0], (int) data[1], (int) data[2]);
			} else if (data.length == 4) {
				GeneratorChisel.INSTANCE.addFeature(state, 32, (int) data[0], (int) data[1], (int) data[2], data[3]);
			}
		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ChiselTabs.postInit();
//		Compatibility.init(event);
	}

	@EventHandler
	public void onIMC(IMCEvent event) {
		for (IMCMessage msg : event.getMessages()) {
			//IMCHandler.INSTANCE.handleMessage(msg);
		}
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equals("chisel")) {
			Configurations.refreshConfig();
		}
	}
}
