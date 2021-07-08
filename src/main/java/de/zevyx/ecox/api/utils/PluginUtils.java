package de.zevyx.ecox.api.utils;

import org.bukkit.Bukkit;

public class PluginUtils {

    public PluginUtils() {

    }

    public void sendStackTrace(Exception ex) {
        Bukkit.getConsoleSender().sendMessage("§c--------------------- Error occured ---------------------");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§cError occured in EcoX");
        Bukkit.getConsoleSender().sendMessage(" ");
        ex.printStackTrace();
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§c--------------------- Error occured ---------------------");
    }

}
