package com.outlook.colinjdoherty.betterbats.loot;

import com.mojang.serialization.Codec;
import com.outlook.colinjdoherty.betterbats.BetterBats;

import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS_SERIALIZERS =
        DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, BetterBats.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM =
        LOOT_MODIFIERS_SERIALIZERS.register("add_item", AddItemModifer.CODEC);

    
    public static void register(IEventBus eventBus){
        LOOT_MODIFIERS_SERIALIZERS.register(eventBus);
    }
} 