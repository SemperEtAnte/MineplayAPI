package ru.mineplay.mineplayapi.api.inventory.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;
import ru.mineplay.mineplayapi.api.inventory.handler.impl.BaseInventoryClickHandler;
import ru.mineplay.mineplayapi.api.inventory.BaseInventory;
import ru.mineplay.mineplayapi.api.inventory.BaseInventoryItem;

@AllArgsConstructor
@Getter
public class BaseInventorySelectItem implements BaseInventoryItem {

    @Setter
    private int slot;

    private final ItemStack itemStack;

    private final BaseInventoryClickHandler inventoryClickHandler;
    private final boolean enchanting;

    @Setter
    private boolean selected;

    @Override
    public void onDraw(@NonNull BaseInventory baseInventory) {
        // не важно
    }

}
