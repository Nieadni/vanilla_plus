package com.github.manasmods.unordinary_basics.data;

import com.github.manasmods.manascore.api.data.gen.BlockTagProvider;
import com.github.manasmods.manascore.api.data.gen.ItemTagProvider;
import com.github.manasmods.unordinary_basics.Unordinary_Basics;
import com.github.manasmods.unordinary_basics.item.Unordinary_BasicsItems;
import com.github.manasmods.unordinary_basics.utils.UBTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

public class Unordinary_BasicsItemTagProvider extends ItemTagProvider {

    public Unordinary_BasicsItemTagProvider(GatherDataEvent gatherDataEvent, BlockTagProvider blockTagProvider) {
        super(gatherDataEvent, Unordinary_Basics.MOD_ID, blockTagProvider);
    }

    @Override
    protected void generate() {
        tag(UBTags.Items.POTION_BELT_ITEMS)
                .addTag(UBTags.Items.MILK_BOTTLE)
                .add(Items.GLASS_BOTTLE,Items.DRAGON_BREATH,Items.HONEY_BOTTLE);
        tag(UBTags.Items.UB_SLOT_BACK)
                .add(Items.ELYTRA);
        tag(UBTags.Items.UB_SLOT_WAIST);

        tag(UBTags.Items.MILK_BOTTLE)
                .add(Unordinary_BasicsItems.MILK_BOTTLE, Unordinary_BasicsItems.GOAT_MILK_BOTTLE);
        tag(UBTags.Items.BEAR_FOOD)
                .add(Items.APPLE, Items.COD, Items.CHICKEN, Items.BEEF, Items.MUTTON);
        tag(UBTags.Items.TAME_BEAR_FOOD)
                .add(Items.SWEET_BERRIES, Items.SALMON);
        tag(UBTags.Items.STONE)
                .add(Item.byBlock(Blocks.COBBLESTONE),Item.byBlock(Blocks.STONE),Item.byBlock(Blocks.COBBLED_DEEPSLATE),Item.byBlock(Blocks.DEEPSLATE),Item.byBlock(Blocks.BASALT));
        tag(UBTags.Items.BLACK_DYES)
                .add(Items.CHARCOAL, Items.COAL, Items.INK_SAC, Items.WITHER_ROSE);
        tag(UBTags.Items.WOODEN_STORAGE)
                .add(Item.byBlock(Blocks.CHEST),Item.byBlock(Blocks.BARREL));
    }
}
