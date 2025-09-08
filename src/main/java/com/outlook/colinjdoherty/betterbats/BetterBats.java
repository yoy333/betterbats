package com.outlook.colinjdoherty.betterbats;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.outlook.colinjdoherty.betterbats.item.Items;
import com.outlook.colinjdoherty.betterbats.loot.ModLootModifiers;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BetterBats.MOD_ID)
public class BetterBats{
    public static final String MOD_ID = "betterbats";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BetterBats(FMLJavaModLoadingContext context){
        IEventBus modEventBus = context.getModEventBus();

        Items.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event){

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == net.minecraft.world.item.CreativeModeTabs.INGREDIENTS){
            event.accept(Items.BAT_WING);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){
        
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){

        }
    }
}
