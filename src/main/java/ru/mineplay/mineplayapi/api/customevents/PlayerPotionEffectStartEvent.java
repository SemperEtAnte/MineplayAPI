package ru.mineplay.mineplayapi.api.customevents;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

@RequiredArgsConstructor
@Getter
public class PlayerPotionEffectStartEvent extends BaseCustomEvent {

  private final Player player;

  private final PotionEffectType potionEffectType;
  private final int duration;
  private final int amplifier;
}
