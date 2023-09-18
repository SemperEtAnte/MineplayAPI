package ru.mineplay.mineplayapi.api.customevents;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

@RequiredArgsConstructor
@Getter
public class PlayerPotionEffectEndEvent extends BaseCustomEvent {

  private final Player player;
  private final PotionEffectType potionEffectType;
}
