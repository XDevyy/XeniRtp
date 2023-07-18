package me.xeni.xenirtp;

import me.xeni.xenirtp.jprtp;
import org.bukkit.plugin.java.JavaPlugin;

public class XeniRtp extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new jprtp(), this);
    }



}