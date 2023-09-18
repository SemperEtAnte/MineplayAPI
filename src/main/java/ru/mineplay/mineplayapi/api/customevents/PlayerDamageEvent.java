package ru.mineplay.mineplayapi.api.customevents;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

@RequiredArgsConstructor
@Getter
public class PlayerDamageEvent extends BaseCustomEvent {

    private final Player player;
    private final EntityDamageEvent.DamageCause damageCause;
    private final double damage;
}
