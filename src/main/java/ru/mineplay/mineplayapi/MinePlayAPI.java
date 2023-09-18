package ru.mineplay.mineplayapi;

import com.comphenix.protocol.ProtocolLibrary;
import lombok.Getter;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import ru.mineplay.mineplayapi.api.actionitem.ActionItemListener;
import ru.mineplay.mineplayapi.api.command.impl.CrashCommand;
import ru.mineplay.mineplayapi.api.inventory.BaseInventoryListener;
import ru.mineplay.mineplayapi.api.listener.PlayerListener;
import ru.mineplay.mineplayapi.api.protocollib.ArmorEquip;
import ru.mineplay.mineplayapi.api.protocollib.HealthHider;
import ru.mineplay.mineplayapi.api.protocollib.PlayerPotionEffectEvents;
import ru.mineplay.mineplayapi.api.protocollib.entity.listener.FakeEntityListener;
import ru.mineplay.mineplayapi.api.protocollib.team.ProtocolTeam;
import ru.mineplay.mineplayapi.api.scoreboard.listener.BaseScoreboardListener;
import ru.mineplay.mineplayapi.api.BukkitAPI;

@Getter
public final class MinePlayAPI extends JavaPlugin {

    @Override
    public void onEnable() {

        // events.
        getServer().getPluginManager().registerEvents(new BaseInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new BaseScoreboardListener(), this);
        getServer().getPluginManager().registerEvents(new ActionItemListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(ProtocolTeam.TEAM_LISTENER, this);
        getServer().getPluginManager().registerEvents(new FakeEntityListener(), this);


        ProtocolLibrary.getProtocolManager().addPacketListener(new HealthHider(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new ArmorEquip(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new PlayerPotionEffectEvents(this));
        ProtocolLibrary.getProtocolManager().addPacketListener(new FakeEntityListener());

        BukkitAPI.registerCommand(new CrashCommand());

        // Руннейбл на обновление инвентарей
        BukkitAPI.INVENTORY_MANAGER.startInventoryUpdateTask(this);

        for (World world : getServer().getWorlds()) {
            world.setGameRuleValue("announceAdvancements", "false");
        }
    }



}
