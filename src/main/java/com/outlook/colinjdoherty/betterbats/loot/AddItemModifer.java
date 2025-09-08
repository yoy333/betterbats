package com.outlook.colinjdoherty.betterbats.loot;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class AddItemModifer extends LootModifier {
    private final Item item;
    public static final Supplier<Codec<AddItemModifer>> CODEC =
        Suppliers.memoize(() -> 
            RecordCodecBuilder.create(inst -> 
                codecStart(inst)
                    .and(ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.item))
                    .apply(inst, AddItemModifer::new)
            )
        );


    public AddItemModifer(LootItemCondition[] conditions, Item item) {
        super(conditions);
        this.item = item;
    }

    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        for(LootItemCondition condition : this.conditions){
            if(!condition.test(context)){
                return generatedLoot;
            }
        }
        
        generatedLoot.add(new ItemStack(this.item));

        return generatedLoot;
    }

    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}