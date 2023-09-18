package ru.mineplay.mineplayapi.api.customevents;

import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

@Getter
public class PlayerDamageByEntityEvent extends PlayerDamageEvent {
    private final Entity damager;

    public PlayerDamageByEntityEvent(Entity damager, Player target, DamageCause damageCause, double damage) {
        super(target, damageCause, damage);
        this.damager = damager;
    }
}
