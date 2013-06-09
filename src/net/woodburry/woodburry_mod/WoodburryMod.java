package net.woodburry.woodburry_mod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created with IntelliJ IDEA.
 * User: gamma_000
 * Date: 5/5/13
 * Time: 11:02 AM
 */
@Mod(modid="WoodburryMod", name="WoodburryMod", version="1.0.0-SNAPSHOT")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class WoodburryMod {

    @Mod.Instance("WoodburryMod")
    public static WoodburryMod instance;

    @SidedProxy(clientSide = "net.woodburry.woodburry_mod.client.ClientProxy",
        serverSide="net.woodburry.woodburry_mod.CommonProxy")
    public static CommonProxy proxy;

    @Mod.PreInit
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.Init
    public void load(FMLInitializationEvent event) {
        proxy.registerRenderers();

        ItemStack redstone = new ItemStack(Item.redstone);
        ItemStack goldNugget = new ItemStack(Item.goldNugget);
        ItemStack cobble = new ItemStack(Block.cobblestone);
        ItemStack sand = new ItemStack(Block.sand);
        ItemStack rottenFlesh = new ItemStack(Item.rottenFlesh);
        ItemStack waterBucket = new ItemStack(Item.bucketWater);
        ItemStack glowstoneDust = new ItemStack(Item.lightStoneDust);
        ItemStack netherBrick = new ItemStack(Block.netherBrick);
        ItemStack redMushroom = new ItemStack(Block.mushroomRed);
        ItemStack goldIngot = new ItemStack(Item.ingotGold);
        ItemStack enderPearl = new ItemStack(Item.enderPearl);
        ItemStack cauldron = new ItemStack(Item.cauldron);
        ItemStack tnt = new ItemStack(Block.tnt);
        ItemStack ghastTear = new ItemStack(Item.ghastTear);
        ItemStack diamondBlock = new ItemStack(Block.blockDiamond);
        ItemStack blazeRod = new ItemStack(Item.blazeRod);

        // 26 Glow Stone Dust recipe
        GameRegistry.addRecipe(new ItemStack(Item.lightStoneDust, 26),
                "rgr",
                "grg",
                "rgr",  'r', redstone, 'g', goldNugget);

        // 8 Netherrack Blocks Recipe
        GameRegistry.addRecipe(new ItemStack(Block.netherrack, 8),
                "ccc",
                "crc",
                "ccc", 'c', cobble, 'r', redstone);

        // 6 Soul Sand Recipe
        GameRegistry.addRecipe(new ItemStack(Block.slowSand, 6),
                "sss",
                "fwf",
                "sss", 's', sand, 'f', rottenFlesh,
                       'w', waterBucket);

        // 1 Netherwart seed
        GameRegistry.addRecipe(new ItemStack(Item.netherStalkSeeds),
                "dnd",
                "nmn",
                "dnd", 'd', glowstoneDust, 'n', netherBrick,
                        'm', redMushroom);

        // 1 Blaze Rod
        GameRegistry.addRecipe(new ItemStack(Item.blazeRod),
                "drd",
                "rir",
                "drd", 'd', glowstoneDust, 'r', redstone,
                       'i', goldIngot);

        // 1 Ghast Tear
        GameRegistry.addRecipe(new ItemStack(Item.ghastTear),
                "e e",
                " L ",
                "e e", 'e', enderPearl, 'L', cauldron);

        // 1 Nether Quartz
        GameRegistry.addRecipe(new ItemStack(Item.netherQuartz),
                "nnn",
                "ntn",
                "nnn", 'n', netherBrick, 't', tnt);

        // 1 Nether Star
        GameRegistry.addRecipe(new ItemStack(Item.netherStar),
                "hbh",
                "bXb",
                "hbh", 'h', ghastTear, 'b', blazeRod,
                        'X', diamondBlock);
    }

    @Mod.PostInit
    public void postInit(FMLPostInitializationEvent event) {
    }
}
