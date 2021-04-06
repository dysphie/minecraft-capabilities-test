package com.example.examplemod;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class CatInventory implements ICatInventory {

    @Override
    public IItemHandler getInventory() {
        return new ItemStackHandler(2);
    }
}
