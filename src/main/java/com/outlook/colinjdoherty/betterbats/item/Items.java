package com.outlook.colinjdoherty.betterbats.item;

import com.outlook.colinjdoherty.betterbats.BetterBats;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, BetterBats.MOD_ID);

    public static final RegistryObject<Item> BAT_WING = ITEMS.register("bat_wing",
        () -> new Item(new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
