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

    @CapabilityInject(ICatInventory.class)
    public static Capability<ICatInventory> CAT_INVENTORY_CAPABILITY = null;

    public void register() {
        CapabilityManager.INSTANCE.register(ICatInventory.class, new Storage(), CatInventory::new);
    }

    public static class Storage implements Capability.IStorage<ICatInventory> {

        @Nullable
        @Override
        public INBT writeNBT(Capability<ICatInventory> capability, ICatInventory instance, Direction side) {
            return null;
        }

        @Override
        public void readNBT(Capability<ICatInventory> capability, ICatInventory instance, Direction side, INBT nbt) {

        }
    }
}
