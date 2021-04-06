package com.example.examplemod;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CatInventoryProvider implements ICapabilityProvider {

    private final ItemStackHandler inventory = new ItemStackHandler(2);
    private final LazyOptional<IItemHandler> inventoryOptional = LazyOptional.of(() -> inventory);

    public void invalidate() {
        inventoryOptional.invalidate();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return inventoryOptional.cast();
    }
}
