package ru.mineplay.mineplayapi.api.inventory.handler;

import lombok.NonNull;
import ru.mineplay.mineplayapi.api.inventory.BaseInventory;
import ru.mineplay.mineplayapi.api.utility.WeakObjectCache;

public interface BaseInventoryHandler {

    void handle(@NonNull BaseInventory baseInventory, WeakObjectCache objectCache);
}
