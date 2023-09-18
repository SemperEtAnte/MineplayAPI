package ru.mineplay.mineplayapi.api.customevents;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
@Getter
public class PlayerMoveXYZEvent extends BaseCustomEvent {

  private final Player player;
  private final Location from;
  private final Location to;
}
