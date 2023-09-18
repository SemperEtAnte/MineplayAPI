package ru.mineplay.mineplayapi.api.inventory.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;
import ru.mineplay.mineplayapi.api.inventory.BaseInventory;
import ru.mineplay.mineplayapi.api.inventory.BaseInventoryItem;

@AllArgsConstructor
@Getter
public class BaseInventoryStackItem implements BaseInventoryItem {

    @Setter
    private int slot;

    private final ItemStack itemStack;

    @Override
    public void onDraw(@NonNull BaseInventory baseInventory) {
        // не важно
    }

}
