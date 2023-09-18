package ru.mineplay.mineplayapi.api.protocollib.entity.impl;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import ru.mineplay.mineplayapi.api.protocollib.entity.FakeBaseMob;

public class FakeSlime extends FakeBaseMob {

    @Getter
    private int size;

    public FakeSlime(Location location) {
        super(EntityType.SLIME, location);
    }


    /**
     * Установить новый размер для слайма
     *
     * @param size - новый размер
     */
    public synchronized void setSize(int size) {
        this.size = size;

        broadcastDataWatcherObject(12, INT_SERIALIZER, size);
    }

}
