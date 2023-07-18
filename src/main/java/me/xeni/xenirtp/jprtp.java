package me.xeni.xenirtp;

import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class jprtp implements Listener {

    private Random random = new Random();
    private Material MATERIAL = Material.PURPLE_STAINED_GLASS;
    private int DISTANCE = 500;

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
        
        if (block.getType() == MATERIAL) {
            Location randomLocation = getRandomLocation(player.getWorld());
            player.teleport(randomLocation);
            player.sendMessage("You Have been Randomly Teleported.");
        }
    }

    private Location getRandomLocation(World world) {
        int x = randomInt(-DISTANCE, DISTANCE);  // Random X coordinate between -500 and 500
        int z = randomInt(-DISTANCE, DISTANCE);  // Random Z coordinate between -500 and 500
        int y = world.getHighestBlockYAt(x, z);  // Get the highest Y coordinate at the random X and Z
        return new Location(world, x, y, z);
    }

    private int randomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}