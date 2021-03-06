package ganymedes01.ganyssurface.core.proxy;

import ganymedes01.ganyssurface.GanysSurface;
import ganymedes01.ganyssurface.client.gui.inventory.GuiAutoEncaser;
import ganymedes01.ganyssurface.client.gui.inventory.GuiBlockDetector;
import ganymedes01.ganyssurface.client.gui.inventory.GuiCraftingTable;
import ganymedes01.ganyssurface.client.gui.inventory.GuiDualWorkTable;
import ganymedes01.ganyssurface.client.gui.inventory.GuiEncasingBench;
import ganymedes01.ganyssurface.client.gui.inventory.GuiEnchantment;
import ganymedes01.ganyssurface.client.gui.inventory.GuiFarmManager;
import ganymedes01.ganyssurface.client.gui.inventory.GuiGearalyser;
import ganymedes01.ganyssurface.client.gui.inventory.GuiInkHarvester;
import ganymedes01.ganyssurface.client.gui.inventory.GuiMarket;
import ganymedes01.ganyssurface.client.gui.inventory.GuiOrganicMatterCompressor;
import ganymedes01.ganyssurface.client.gui.inventory.GuiPlanter;
import ganymedes01.ganyssurface.client.gui.inventory.GuiPortableDualWorkTable;
import ganymedes01.ganyssurface.client.gui.inventory.GuiWoodSign;
import ganymedes01.ganyssurface.client.gui.inventory.GuiWorkTable;
import ganymedes01.ganyssurface.configuration.ConfigurationHandler;
import ganymedes01.ganyssurface.core.handlers.EntityEvents;
import ganymedes01.ganyssurface.core.handlers.MiscEventHandler;
import ganymedes01.ganyssurface.core.handlers.OpenContainerHandler;
import ganymedes01.ganyssurface.core.handlers.PoopHandler;
import ganymedes01.ganyssurface.core.handlers.SnowTickHandler;
import ganymedes01.ganyssurface.core.utils.Utils;
import ganymedes01.ganyssurface.entities.EntityBatPoop;
import ganymedes01.ganyssurface.entities.EntityPoop;
import ganymedes01.ganyssurface.entities.EntityVillageFinder;
import ganymedes01.ganyssurface.inventory.ContainerAutoEncaser;
import ganymedes01.ganyssurface.inventory.ContainerBlockDetector;
import ganymedes01.ganyssurface.inventory.ContainerCraftingTable;
import ganymedes01.ganyssurface.inventory.ContainerDualWorkTable;
import ganymedes01.ganyssurface.inventory.ContainerEncasingBench;
import ganymedes01.ganyssurface.inventory.ContainerEnchantment;
import ganymedes01.ganyssurface.inventory.ContainerFarmManager;
import ganymedes01.ganyssurface.inventory.ContainerGearalyser;
import ganymedes01.ganyssurface.inventory.ContainerInkHarvester;
import ganymedes01.ganyssurface.inventory.ContainerMarket;
import ganymedes01.ganyssurface.inventory.ContainerOrganicMatterCompressor;
import ganymedes01.ganyssurface.inventory.ContainerPlanter;
import ganymedes01.ganyssurface.inventory.ContainerPortableDualWorkTable;
import ganymedes01.ganyssurface.inventory.ContainerWorkTable;
import ganymedes01.ganyssurface.lib.GUIsID;
import ganymedes01.ganyssurface.lib.ModIDs;
import ganymedes01.ganyssurface.lib.Strings;
import ganymedes01.ganyssurface.tileentities.TileEntityAutoEncaser;
import ganymedes01.ganyssurface.tileentities.TileEntityBanner;
import ganymedes01.ganyssurface.tileentities.TileEntityBlockDetector;
import ganymedes01.ganyssurface.tileentities.TileEntityChestPropellant;
import ganymedes01.ganyssurface.tileentities.TileEntityCubicSensoringDislocator;
import ganymedes01.ganyssurface.tileentities.TileEntityDislocator;
import ganymedes01.ganyssurface.tileentities.TileEntityDualWorkTable;
import ganymedes01.ganyssurface.tileentities.TileEntityFarmManager;
import ganymedes01.ganyssurface.tileentities.TileEntityInkHarvester;
import ganymedes01.ganyssurface.tileentities.TileEntityItemDisplay;
import ganymedes01.ganyssurface.tileentities.TileEntityMarket;
import ganymedes01.ganyssurface.tileentities.TileEntityOrganicMatterCompressor;
import ganymedes01.ganyssurface.tileentities.TileEntityPlanter;
import ganymedes01.ganyssurface.tileentities.TileEntityRainDetector;
import ganymedes01.ganyssurface.tileentities.TileEntitySensoringDislocator;
import ganymedes01.ganyssurface.tileentities.TileEntityWoodChest;
import ganymedes01.ganyssurface.tileentities.TileEntityWoodSign;
import ganymedes01.ganyssurface.tileentities.TileEntityWorkTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Gany's Surface
 *
 * @author ganymedes01
 *
 */

public class CommonProxy implements IGuiHandler {

	public void registerEvents() {
		FMLCommonHandler.instance().bus().register(ConfigurationHandler.INSTANCE);
		if (GanysSurface.enableDynamicSnow)
			FMLCommonHandler.instance().bus().register(new SnowTickHandler());
		if (GanysSurface.enableMutton)
			MinecraftForge.EVENT_BUS.register(new EntityEvents());
		if (GanysSurface.enablePoop)
			MinecraftForge.EVENT_BUS.register(new PoopHandler());

		MinecraftForge.EVENT_BUS.register(new MiscEventHandler());
		MinecraftForge.EVENT_BUS.register(new OpenContainerHandler());
	}

	public void registerTileEntities() {
		if (GanysSurface.enableRainDetector)
			GameRegistry.registerTileEntity(TileEntityRainDetector.class, Utils.getUnlocalisedName(Strings.RAIN_DETECTOR_NAME));
		if (GanysSurface.enableDislocators) {
			GameRegistry.registerTileEntity(TileEntityBlockDetector.class, Utils.getUnlocalisedName(Strings.BLOCK_DETECTOR_NAME));
			GameRegistry.registerTileEntity(TileEntityDislocator.class, Utils.getUnlocalisedName(Strings.DISLOCATOR_NAME));
			GameRegistry.registerTileEntity(TileEntitySensoringDislocator.class, Utils.getUnlocalisedName(Strings.SENSORING_DISLOCATOR_NAME));
			GameRegistry.registerTileEntity(TileEntityCubicSensoringDislocator.class, Utils.getUnlocalisedName(Strings.CUBIC_SENSORING_DISLOCATOR_NAME));
		}
		if (GanysSurface.enableWorkTables) {
			GameRegistry.registerTileEntity(TileEntityWorkTable.class, Utils.getUnlocalisedName(Strings.WORK_TABLE_NAME));
			GameRegistry.registerTileEntity(TileEntityDualWorkTable.class, Utils.getUnlocalisedName(Strings.DUAL_WORK_TABLE_NAME));
		}
		if (GanysSurface.enableOMC)
			GameRegistry.registerTileEntity(TileEntityOrganicMatterCompressor.class, Utils.getUnlocalisedName(Strings.ORGANIC_MATTER_COMPRESSOR_NAME));
		if (GanysSurface.enableItemDisplay)
			GameRegistry.registerTileEntity(TileEntityItemDisplay.class, Utils.getUnlocalisedName(Strings.ITEM_DISPLAY_NAME));
		if (GanysSurface.enableChestPropellant)
			GameRegistry.registerTileEntity(TileEntityChestPropellant.class, Utils.getUnlocalisedName(Strings.CHEST_PROPELLANT_NAME));
		if (GanysSurface.enablePlanter) {
			GameRegistry.registerTileEntity(TileEntityPlanter.class, Utils.getUnlocalisedName(Strings.PLANTER_NAME));
			GameRegistry.registerTileEntity(TileEntityFarmManager.class, Utils.getUnlocalisedName(Strings.FARM_MANAGER_NAME));
		}
		if (GanysSurface.enableInkHarvester)
			GameRegistry.registerTileEntity(TileEntityInkHarvester.class, Utils.getUnlocalisedName(Strings.INK_HARVESTER_NAME));
		if (GanysSurface.enableEncasers)
			GameRegistry.registerTileEntity(TileEntityAutoEncaser.class, Utils.getUnlocalisedName(Strings.AUTO_ENCASER_NAME));
		if (GanysSurface.enableChests)
			GameRegistry.registerTileEntity(TileEntityWoodChest.class, Utils.getUnlocalisedName("wood_chest"));
		if (GanysSurface.enableWoodenSigns)
			GameRegistry.registerTileEntity(TileEntityWoodSign.class, Utils.getUnlocalisedName("wood_sign"));
		if (GanysSurface.enableBanners)
			GameRegistry.registerTileEntity(TileEntityBanner.class, Utils.getUnlocalisedName("banner"));
		if (GanysSurface.enableMarket)
			GameRegistry.registerTileEntity(TileEntityMarket.class, Utils.getUnlocalisedName(Strings.MARKET));
	}

	public void registerEntities() {
		if (GanysSurface.enableFlingablePoop) {
			EntityRegistry.registerModEntity(EntityPoop.class, Strings.ENTITY_POOP_NAME, ModIDs.ENTITY_POOP_ID, GanysSurface.instance, 64, 1, true);
			EntityRegistry.registerModEntity(EntityBatPoop.class, Strings.ENTITY_BAT_POOP_NAME, ModIDs.ENTITY_BAT_POOP_ID, GanysSurface.instance, 64, 1, true);
		}
		if (GanysSurface.enableVillageFinder)
			EntityRegistry.registerModEntity(EntityVillageFinder.class, Strings.VILLAGE_FINDER, ModIDs.ENTITY_VILLAGE_FINDER_ID, GanysSurface.instance, 64, 1, true);
	}

	public void registerRenderers() {
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		GUIsID guiID = GUIsID.values()[ID];
		switch (guiID) {
			case BLOCK_DETECTOR:
				return new ContainerBlockDetector(player.inventory, (TileEntityBlockDetector) tile);
			case WORK_TABLE:
				return new ContainerWorkTable(player.inventory, (TileEntityWorkTable) tile);
			case ORGANIC_MATTER_COMPRESSOR:
				return new ContainerOrganicMatterCompressor(player.inventory, (TileEntityOrganicMatterCompressor) tile);
			case PLANTER:
				return new ContainerPlanter(player.inventory, (TileEntityPlanter) tile);
			case INK_HARVESTER:
				return new ContainerInkHarvester(player.inventory, (TileEntityInkHarvester) tile);
			case DUAL_WORK_TABLE:
				return new ContainerDualWorkTable(player.inventory, (TileEntityDualWorkTable) tile);
			case FARM_MANAGER:
				return new ContainerFarmManager(player.inventory, (TileEntityFarmManager) tile);
			case PORTABLE_DUAL_WORK_TABLE:
				return new ContainerPortableDualWorkTable(player, x);
			case ENCASING_BENCH:
				return new ContainerEncasingBench(player.inventory);
			case AUTO_ENCASER:
				return new ContainerAutoEncaser(player.inventory, (TileEntityAutoEncaser) tile);
			case GEARALYSER:
				return new ContainerGearalyser(player.inventory);
			case ENCHANTING_TABLE:
				return new ContainerEnchantment(player.inventory, world, x, y, z);
			case WOOD_SIGN:
				return null;
			case CRAFTING_TABLE_NO_CONFLICT:
				return new ContainerCraftingTable(player.inventory, world, x, y, z);
			case MARKET:
				return new ContainerMarket(player.inventory, (TileEntityMarket) tile);
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		GUIsID guiID = GUIsID.values()[ID];
		switch (guiID) {
			case BLOCK_DETECTOR:
				return new GuiBlockDetector(player.inventory, (TileEntityBlockDetector) tile);
			case WORK_TABLE:
				return new GuiWorkTable(player.inventory, (TileEntityWorkTable) tile);
			case ORGANIC_MATTER_COMPRESSOR:
				return new GuiOrganicMatterCompressor(player.inventory, (TileEntityOrganicMatterCompressor) tile);
			case PLANTER:
				return new GuiPlanter(player.inventory, (TileEntityPlanter) tile);
			case INK_HARVESTER:
				return new GuiInkHarvester(player.inventory, (TileEntityInkHarvester) tile);
			case DUAL_WORK_TABLE:
				return new GuiDualWorkTable(player.inventory, (TileEntityDualWorkTable) tile);
			case FARM_MANAGER:
				return new GuiFarmManager(player.inventory, (TileEntityFarmManager) tile);
			case PORTABLE_DUAL_WORK_TABLE:
				return new GuiPortableDualWorkTable(player, x);
			case ENCASING_BENCH:
				return new GuiEncasingBench(player.inventory);
			case AUTO_ENCASER:
				return new GuiAutoEncaser(player.inventory, (TileEntityAutoEncaser) tile);
			case GEARALYSER:
				return new GuiGearalyser(player.inventory);
			case ENCHANTING_TABLE:
				return new GuiEnchantment(player.inventory, world, null);
			case WOOD_SIGN:
				return new GuiWoodSign((TileEntityWoodSign) tile);
			case CRAFTING_TABLE_NO_CONFLICT:
				return new GuiCraftingTable(player.inventory, world, x, y, z);
			case MARKET:
				return new GuiMarket(player.inventory, (TileEntityMarket) tile);
			default:
				return null;
		}
	}
}