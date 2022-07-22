package com.github.manasmods.unordinary_basics.registry;


import com.github.manasmods.unordinary_basics.item.GliderItem;
import com.github.manasmods.unordinary_basics.item.GrappleHookItem;
import com.github.manasmods.unordinary_basics.item.RabbitBootsItem;
import com.github.manasmods.unordinary_basics.item.Unordinary_BasicsCreativeTab;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ItemRegistry {
    /**
     * This Method will register all Items to Forge.
     * It is called though the {@link Unordinary_BasicsRegistry#register(IEventBus)} Method.
     */
    static void register(DeferredRegister<Item> registry) {
        registerMisc(registry);
    }

    private static void registerMisc(DeferredRegister<Item> registry) {
        registry.register("animal_bait", () -> new Item(new Item.Properties().tab(Unordinary_BasicsCreativeTab.ITEMS)));
        registry.register("rabbit_boots", () -> new RabbitBootsItem(new Item.Properties().tab(Unordinary_BasicsCreativeTab.ITEMS).stacksTo(1)));
        registry.register("glider", () -> new GliderItem(new Item.Properties().tab(Unordinary_BasicsCreativeTab.ITEMS).stacksTo(1).durability(265)));
        registry.register("grapple_hook", () -> new GrappleHookItem(new Item.Properties().tab(Unordinary_BasicsCreativeTab.ITEMS).stacksTo(1)));
    }
}
