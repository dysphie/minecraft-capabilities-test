package com.example.examplemod;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class CapabilityCatInventory {

    @CapabilityInject(CapabilityCatInventory.class)
    public static Capability<IItemHandler> CAT_INVENTORY_CAPABILITY = null;

    public void register() {
        CapabilityManager.INSTANCE.register(IItemHandler.class, new Storage(), CatInventory::new);
    }

    public static class Storage implements Capability.IStorage<IItemHandler> {

        @Nullable
        @Override
        public INBT writeNBT(Capability<IItemHandler> capability, IItemHandler instance, Direction side) {
            return null;
        }

        @Override
        public void readNBT(Capability<IItemHandler> capability, IItemHandler instance, Direction side, INBT nbt) {

        }
    }
}
