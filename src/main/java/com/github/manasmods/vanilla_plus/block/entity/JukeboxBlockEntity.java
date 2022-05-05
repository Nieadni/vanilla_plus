package com.github.manasmods.vanilla_plus.block.entity;

import com.github.manasmods.vanilla_plus.menu.container.JukeboxContainer;
import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Clearable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class JukeboxBlockEntity extends BlockEntity implements Clearable {
    @Getter
    private final JukeboxContainer container = new JukeboxContainer();
    @Getter
    private boolean isPlaying = false;

    public JukeboxBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(Vanilla_PlusBlockEntities.JUKEBOX_BLOCK_ENTITY, pWorldPosition, pBlockState);
        container.addListener((handler, slot) -> {
            if (slot == 8) {
                isPlaying = false;
            }
            setChanged();
        });
    }

    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.isPlaying = pTag.getBoolean("isPlaying");
        container.deserializeNBT(pTag.getCompound("Inventory"));
    }

    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putBoolean("isPlaying", this.isPlaying);
        pTag.put("Inventory", container.serializeNBT());
    }

    public ItemStack getRecord() {
        return this.container.getCurrentRecord();
    }

    public void setRecord(ItemStack pRecord) {
        this.container.setCurrentRecord(pRecord);
        this.setChanged();
    }


    @Override
    public void clearContent() {
        this.container.clear();
    }

    public void play() {
        this.isPlaying = true;
        setChanged();
    }

    public void stop() {
        this.isPlaying = false;
        setChanged();
    }
}
