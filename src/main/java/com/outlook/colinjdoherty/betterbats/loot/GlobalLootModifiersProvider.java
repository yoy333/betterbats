package com.outlook.colinjdoherty.betterbats.loot;

import com.outlook.colinjdoherty.betterbats.BetterBats;
import com.outlook.colinjdoherty.betterbats.item.Items;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class GlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public GlobalLootModifiersProvider(PackOutput output) {
        super(output, BetterBats.MOD_ID);
    }

    @Override
    protected void start() {
        add("bat_wing_from_bat", new AddItemModifer(
            new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.fromNamespaceAndPath("minecraft", "entities/bat")).build()
            },
            Items.BAT_WING.get()
        ));
    }
    
}
