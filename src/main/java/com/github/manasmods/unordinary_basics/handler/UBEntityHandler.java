package com.github.manasmods.unordinary_basics.handler;

import com.github.manasmods.unordinary_basics.Unordinary_Basics;
import com.github.manasmods.unordinary_basics.item.Unordinary_BasicsItems;
import com.github.manasmods.unordinary_basics.utils.UBUtils;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Unordinary_Basics.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UBEntityHandler {
    /** Used to add the {@link TemptGoal} for the animal bait item to all targeted entities. */
    @SubscribeEvent
    public static void onAnimalJoinWorld(final EntityJoinWorldEvent event) {
        //Check if entity is a PathfinderMob
        if (!(event.getEntity() instanceof PathfinderMob mob)) return;
        //Check if mob is one of the targets
        if (!UBUtils.isInstanceOf(mob, Sheep.class, Cow.class, Pig.class, Chicken.class, Horse.class, Donkey.class, Mule.class, Parrot.class, Rabbit.class)) return;
        //Add Goal
        mob.goalSelector.addGoal(3, new TemptGoal(mob, 1.5D, Ingredient.of(Unordinary_BasicsItems.ANIMAL_BAIT), false));
    }

    @SubscribeEvent
    public static void onVillagerJoinWorld(final EntityJoinWorldEvent event) {
        if (!(event.getEntity() instanceof Villager villager)) return;
        villager.goalSelector.addGoal(3, new TemptGoal(villager, 1.5D, Ingredient.of(Items.EMERALD), false));
        villager.goalSelector.addGoal(3, new TemptGoal(villager, 1.75D, Ingredient.of(Items.EMERALD_BLOCK), false));
    }
}