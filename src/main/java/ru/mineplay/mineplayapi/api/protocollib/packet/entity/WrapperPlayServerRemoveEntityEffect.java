package ru.mineplay.mineplayapi.api.protocollib.packet.entity;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.potion.PotionEffectType;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import ru.mineplay.mineplayapi.api.protocollib.packet.AbstractPacket;

public class WrapperPlayServerRemoveEntityEffect extends AbstractPacket {
  public static final PacketType TYPE =
      PacketType.Play.Server.REMOVE_ENTITY_EFFECT;

  public WrapperPlayServerRemoveEntityEffect() {
    super(new PacketContainer(TYPE), TYPE);
    handle.getModifier().writeDefaults();
  }

  public WrapperPlayServerRemoveEntityEffect(PacketContainer packet) {
    super(packet, TYPE);
  }

  /**
   * Retrieve Entity ID.
   * <p>
   * Notes: entity's ID
   *
   * @return The current Entity ID
   */
  public int getEntityID() {
    return handle.getIntegers().read(0);
  }

  /**
   * Set Entity ID.
   *
   * @param value - new value.
   */
  public void setEntityID(int value) {
    handle.getIntegers().write(0, value);
  }

  /**
   * Retrieve the entity of the painting that will be spawned.
   *
   * @param world - the current world of the entity.
   * @return The spawned entity.
   */
  public Entity getEntity(World world) {
    return handle.getEntityModifier(world).read(0);
  }

  /**
   * Retrieve the entity of the painting that will be spawned.
   *
   * @param event - the packet event.
   * @return The spawned entity.
   */
  public Entity getEntity(PacketEvent event) {
    return getEntity(event.getPlayer().getWorld());
  }

  public PotionEffectType getEffect() {
    return handle.getEffectTypes().read(0);
  }

  public void setEffect(PotionEffectType value) {
    handle.getEffectTypes().write(0, value);
  }
}