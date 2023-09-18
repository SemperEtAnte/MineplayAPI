package ru.mineplay.mineplayapi.api.inventory.handler.impl;

import lombok.NonNull;
import org.bukkit.event.inventory.InventoryClickEvent;
import ru.mineplay.mineplayapi.api.inventory.BaseInventory;
import ru.mineplay.mineplayapi.api.inventory.handler.BaseInventoryHandler;
import ru.mineplay.mineplayapi.api.utility.WeakObjectCache;

public interface BaseInventoryClickHandler extends BaseInventoryHandler {

    void onClick(@NonNull BaseInventory baseInventory, @NonNull InventoryClickEvent inventoryClickEvent);

    @Override
    default void handle(@NonNull BaseInventory baseInventory,
                        WeakObjectCache objectCache) {

        onClick(baseInventory, objectCache.getObject(InventoryClickEvent.class, "event"));
    }
}
