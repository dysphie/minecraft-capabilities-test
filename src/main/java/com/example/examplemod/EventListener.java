package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.CapabilityItemHandler;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class EventListener {

    @SubscribeEvent
    public static void onAttachCapabilityEvent(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof CatEntity) {
            CatInventoryProvider provider = new CatInventoryProvider();
            event.addCapability(new ResourceLocation(ExampleMod.MOD_ID, "cat_inventory"), provider);
            event.addListener(provider::invalidate);
        }
    }

    @SubscribeEvent
    public static void onEntityAttacked(AttackEntityEvent event) {
        Entity target = event.getTarget();
        if (target instanceof CatEntity)
        {
            event.setCanceled(true);
            target.getCapability(CapabilityCatInventory.CAT_INVENTORY_CAPABILITY).ifPresent(h -> {
                System.out.println("Cat has cat inventory sized " + h.getSlots());
            });

            target.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
                System.out.println("Cat has def inventory sized " + h.getSlots());
            });
        }
    }
}
