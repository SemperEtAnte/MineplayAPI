package ru.mineplay.mineplayapi.api.utility.bukkit;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;

import java.util.Objects;

@UtilityClass
public class LocationUtil {

    /**
     * Преобразование локации в строку подобного вида:
     *  - 'world_name, x, y, z, yaw, pitch'
     */
    public String locationToString(Location location) {
        if (location == null) {
            return null;
        }

        return String.format("%s, %s, %s, %s, %s, %s", location.getWorld().getName(),
                location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

    /**
     * Преобразование строки с координатами в саму локацию
     */
    public Location stringToLocation(String locString) {
        if (locString == null) {
            return null;
        }

        String[] locData = locString.split(", ");
        World world = Bukkit.getWorld(locData[0]);

        Objects.requireNonNull(world, "world is null");

        return new Location(world, Double.parseDouble(locData[1]), Double.parseDouble(locData[2]), Double.parseDouble(locData[3]),
                Float.parseFloat(locData[4]), Float.parseFloat(locData[5]));
    }

    /**
     * Проверка дистанции локаций
     */
    public boolean isDistance(Location location1, Location location2, double distance) {
        return location1.distance(location2) <= distance;
    }

    public final BlockFace[] axis = { BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST };
    public final BlockFace[] radial = { BlockFace.NORTH, BlockFace.NORTH_EAST, BlockFace.EAST, BlockFace.SOUTH_EAST, BlockFace.SOUTH, BlockFace.SOUTH_WEST, BlockFace.WEST, BlockFace.NORTH_WEST };

    public BlockFace yawToFace(float yaw) {
        return yawToFace(yaw, true);
    }

    public BlockFace yawToFace(float yaw, boolean useSubCardinalDirections) {
        if (useSubCardinalDirections) {
            return radial[Math.round(yaw / 45f) & 0x7];
        } else {
            return axis[Math.round(yaw / 90f) & 0x3];
        }
    }

    /**
     *  Получить центр блока
     */
    public static Location centerLocation(Location location, boolean centerX, boolean centerY, boolean centerZ) {
        return new Location(
            location.getWorld(),
            location.getBlockX() + (centerX ? 0.5 : 0),
            location.getBlockY() + (centerY ? 0.5 : 0),
            location.getBlockZ() + (centerZ ? 0.5 : 0),
            location.getYaw(),
            location.getPitch()
        );
    }
    public static Location centerLocation(Location location) {
        return centerLocation(location, true, true, true);
    }
    public static float normalizeDegree(float degree) {
        return (Math.round(degree / 90f) * 90f);
    }

    /**
     * Поставить ровно голову смотрящую прямо
     */
    public static Location normalizeYawPitch(Location location) {
        return new Location(
            location.getWorld(),
            location.getX(),
            location.getY(),
            location.getZ(),
            normalizeDegree(location.getYaw()),
            normalizeDegree(location.getPitch())
        );
    }
}
