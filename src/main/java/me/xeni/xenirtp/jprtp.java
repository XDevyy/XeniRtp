package me.xeni.xenirtp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class jprtp implements Listener {

    private Random random = new Random();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        int playerX = player.getLocation().getBlockX();
        int playerY = player.getLocation().getBlockY();
        int playerZ = player.getLocation().getBlockZ();


        Block block = player.getWorld().getBlockAt(playerX, playerY - 1, playerZ);


        if (block.getType() == Material.PURPLE_STAINED_GLASS) {

            Location randomLocation = getRandomLocation(player.getWorld());
            player.teleport(randomLocation);
            player.sendMessage("You Have been Randomly Teleported.");
        }
    }

    private Location getRandomLocation(org.bukkit.World world) {
        int x = random.nextInt(1000) - 500;  // Random X coordinate between -500 and 500
        int z = random.nextInt(1000) - 500;  // Random Z coordinate between -500 and 500
        int y = world.getHighestBlockYAt(x, z);  // Get the highest Y coordinate at the random X and Z
        return new Location(world, x, y, z);
    }



}