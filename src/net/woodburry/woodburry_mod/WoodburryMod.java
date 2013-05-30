package net.woodburry.woodburry_mod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

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

        ItemStack redstoneStack = new ItemStack(Item.redstone);
        ItemStack goldDustStack = new ItemStack(Item.goldNugget);
        GameRegistry.addRecipe(new ItemStack(Item.lightStoneDust), "xyx", "yxy", "xyx",
                'x', redstoneStack, 'y', goldDustStack);
    }

    @Mod.PostInit
    public void postInit(FMLPostInitializationEvent event) {
    }
}
