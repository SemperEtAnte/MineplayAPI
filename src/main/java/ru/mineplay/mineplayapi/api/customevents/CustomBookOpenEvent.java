package ru.mineplay.mineplayapi.api.customevents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
@Getter
public class CustomBookOpenEvent extends BaseCustomEvent {

   private final Player player;
   private final Hand hand;
   private final ItemStack book;

   public enum Hand {
      MAIN_HAND, OFF_HAND
   }
}
