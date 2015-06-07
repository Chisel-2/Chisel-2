package com.cricketcraft.chisel.config;

import net.minecraft.item.ItemDye;
import net.minecraftforge.common.config.Configuration;

import com.cricketcraft.chisel.Chisel;

public class Configurations {
	public static Configuration config;

	public static boolean configExists, ghostCloud, allowMossy, allowSmoothStone, chiselRecipe, enableFMP, chiselStoneToCobbleBricks, chiselBackToVanillaLeaves, oldPillars, disableCTM, connectInsideCTM, blockDescriptions, allowChiselDamage, ironChiselCanLeftClick, ironChiselHasModes, allowChiselCrossColors, useRoadLineTool, fullBlockConcrete;

	public static int factoryBlockAmount, marbleAmount, limestoneAmount, particlesTickrate, ironChiselMaxDamage, diamondChiselMaxDamage, obsidianChiselMaxDamage, ironChiselAttackDamage, diamondChiselAttackDamage, obsidianChiselAttackDamage, roadLineToolLevel;

	public static String getRoadLineTool;

	public static double concreteVelocity;

	public static int[] configColors = new int[ItemDye.dyeColors.length];

	public static boolean refreshConfig() {
		String category;
		/* general */
		category = "general";
		concreteVelocity = config.get(category, "concreteVelocity", 0.45, "Traversing concrete roads, players will acceleration to this velocity. For reference, normal running speed is about 0.28. Set to 0 to disable acceleration.").getDouble(0.45);
		fullBlockConcrete = config.get(category, "fullBlockConcrete", false, "Should concrete be a full block. This will also unavoidably disable speed increase if set to true.").getBoolean(false);
		ghostCloud = config.get(category, "doesCloudRenderLikeGhost", true).getBoolean(true);
		factoryBlockAmount = config.get(category, "amountYouGetFromFactoryBlockCrafting", 32).getInt(32);
		allowMossy = config.get(category, "allowBrickToMossyInChisel", true, "If true, you can chisel stone brick to mossy stone brick.").getBoolean(true);
		allowSmoothStone = config.get(category, "allowSmoothStoneToStoneBricksAndBack", true).getBoolean(true);
		chiselRecipe = config.get(category, "chiselAlternateRecipe", false, "Use alternative crafting recipe for the chisel").getBoolean(false);
		enableFMP = config.get(category, "enableFMP", true, "Do you want to enable FMP").getBoolean(true);
		chiselStoneToCobbleBricks = config.get(category, "chiselStoneToCobbleBricks", true, "Chisel stone to cobblestone and bricks by left clicking.").getBoolean(false);
		chiselBackToVanillaLeaves = config.get(category, "chiselBackToVanillaLeaves", false, "If this is true, you can chisel from the chisel leaves back to vanilla ones. If it is false, you cannot.").getBoolean(false);

		/* worldgen */
		category = "worldgen";
		marbleAmount = config.get(category, "marbleAmount", 7, "Amount of marble to generate in the world; use 0 for none").getInt(7);
		limestoneAmount = config.get(category, "limestoneAmount", 8, "Amount of limestone to generate in the world; use 0 for none").getInt(8);

		/* client */
		category = "client";
		particlesTickrate = config.get(category, "particleTickrate", 1, "Particle tick rate. Greater value = less particles.").getInt(1);
		oldPillars = config.get(category, "pillarOldGraphics", false, "Use old pillar textures").getBoolean(false);
		disableCTM = !config.get(category, "connectedTextures", true, "Enable connected textures").getBoolean(true);
		//CTM.disableObscuredFaceCheckConfig = connectInsideCTM = config.get(category, "connectInsideCTM", false,
		//		"Choose whether the inside corner is disconnected on a CTM block - http://imgur.com/eUywLZ4").getBoolean(false);
		blockDescriptions = config.get(category, "tooltipsUseBlockDescriptions", true, "Make variations of blocks have the same name, and use the description in tooltip to distinguish them.").getBoolean(true);

		/* chisel */
		category = "chisel";
		allowChiselDamage = config.get(category, "allowChiselDamage", true, "Should the chisel be damageable and take damage when it chisels something.").getBoolean();
		ironChiselMaxDamage = config.getInt("ironChiselMaxDamage", category, 500, 1, Short.MAX_VALUE, "The max damage of the standard iron chisel.");
		diamondChiselMaxDamage = config.getInt("diamondChiselMaxDamage", category, 5000, 1, Short.MAX_VALUE, "The max damage of the diamond chisel.");
		obsidianChiselMaxDamage = config.getInt("obsidianChiselMaxDamage", category, 2500, 1, Short.MAX_VALUE, "The max damage of the obsidian chisel.");
		ironChiselCanLeftClick = config.get(category, "ironChiselCanLeftClick", true, "If this is true, the iron chisel can left click chisel blocks. If false, it cannot.").getBoolean();
		ironChiselHasModes = config.get(category, "ironChiselHasModes", false, "If this is true, the iron chisel can change its chisel mode just as the diamond chisel can.").getBoolean();
		allowChiselCrossColors = config.get(category, "allowChiselCrossColors", true, "Should someone be able to chisel something into a different color.").getBoolean();

		ironChiselAttackDamage = config.get(category, "ironChiselAttackDamage", 2, "The extra attack damage points (in half hearts) that the iron chisel inflicts when it is used to attack an entity.").getInt();
		diamondChiselAttackDamage = config.get(category, "diamondChiselAttackDamage", 2, "The extra attack damage points (in half hearts) that the diamond chisel inflicts when it is used to attack an entity.").getInt();
		obsidianChiselAttackDamage = config.get(category, "obsidianChiselAttackDamage", 4, "The extra attack damage points (in half hearts) that the obsidian chisel inflicts when it is used to attack an entity.").getInt();

		/* block */
		category = "block";
		useRoadLineTool = config.get(category, "useRoadLineTool", false, "Should the road line require a tool to break (If false, road lines can be broken in Adventure)").getBoolean();
		getRoadLineTool = config.get(category, "getRoadLineTool", "pickaxe", "The tool that is able to break roadLines (requires useRoadLineTool to be true to take effect)").getString();
		roadLineToolLevel = config.get(category, "roadLineToolLevel", 0, "The lowest harvest level of the tool able to break the road lines (requires useRoadLineTool to be true to take effect) (0 = Wood/Gold, 1 = Stone, 2 = Iron, 3 = Diamond) Default: 0").getInt();

		/* hexColors */
		category = "hexColors";

		for (int i = 0; i < ItemDye.dyeColors.length; i++) {
			String temp = config.get(category, "hex" + ItemDye.dyeColors[i], "#" + Integer.toHexString(ItemDye.dyeColors[i]), Character.toUpperCase(ItemDye.dyeColors[i]) + ItemDye.dyeColors[i] + " color for hex block overlay #RRGGBB").getString();
			try {
				configColors[i] = Integer.decode(temp);
			}
			catch (NumberFormatException e) {
				Chisel.logger.warn("Configuration error, " + temp + " was not recognized as a color.  Using default: #" + Integer.toHexString(ItemDye.dyeColors[i]));
				configColors[i] = ItemDye.dyeColors[i];
			}
		}

		if (config.hasChanged()) {
			config.save();
		}
		return true;
	}

	@Deprecated
	public static boolean featureEnabled(String feature) {
		return false;
	}
}
