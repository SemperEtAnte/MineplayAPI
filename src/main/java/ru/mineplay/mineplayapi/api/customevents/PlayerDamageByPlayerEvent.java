package ru.mineplay.mineplayapi.api.customevents;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

@Getter
public class PlayerDamageByPlayerEvent extends PlayerDamageEvent {
    private final Player damager;

    public PlayerDamageByPlayerEvent(Player damager, Player target, DamageCause damageCause, double damage) {
        super(target, damageCause, damage);
        this.damager = damager;
    }

}
