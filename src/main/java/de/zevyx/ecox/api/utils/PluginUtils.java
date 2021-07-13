package de.zevyx.ecox.api.utils;

import de.zevyx.ecox.EcoX;
import de.zevyx.ecox.api.EcoXAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PluginUtils {

    public PluginUtils() {

    }

    public void sendStackTrace(Exception ex) {
        Bukkit.getConsoleSender().sendMessage("§c--------------- Error occured ---------------");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§cError occured in EcoX");
        Bukkit.getConsoleSender().sendMessage(" ");
        ex.printStackTrace();
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§c--------------- Error occured ---------------");
    }

    public void getEcoXHelp(CommandSender c) {
        c.sendMessage("§f§l§m--------------- §r§b§lHelp for EcoX §f§l§m---------------");
        c.sendMessage(" ");
        c.sendMessage("§b§l/ecox help §8| §fDisplays this help");
        c.sendMessage("§b§l/ecox info <Player> §8| §fGet Info about this player");
        c.sendMessage("§b§l/ecox set <Player> <Amount> §8| §fSet the players currency");
        c.sendMessage("§b§l/ecox add <Player> <Amount> §8| §fAdd money to the players currency");
        c.sendMessage("§b§l/ecox remove <Player> <Amount> §8| §fRemove money from the players currency");
        c.sendMessage(" ");
        c.sendMessage("§f§l§m--------------- §r§b§lHelp for EcoX §f§l§m---------------");
    }

    public void getPlayerEcoInfo(CommandSender c, String name) {
        c.sendMessage("§f§l§m--------------- §r§b§lInformation §f§l§m---------------");
        c.sendMessage(" ");
        c.sendMessage("§b§lPlayer §8| §f" + name);
        c.sendMessage("§b§lUUID §8| §f" + EcoX.getInstance().getMoneyConfig().getValue(name + ".uuid"));
        c.sendMessage(" ");
        c.sendMessage("§b§lBalance §8| §f" + EcoXAPI.getAPI().getMoneyAPI().getMoney(name) + " " + EcoX.getInstance().getSettingsConfig().getMessage("currency"));
        c.sendMessage("§b§lFirst Transaction §8| §f" + EcoX.getInstance().getMoneyConfig().getValue(name + ".firsttransaction"));
        c.sendMessage(" ");
        c.sendMessage("§f§l§m--------------- §r§b§lInformation §f§l§m---------------");
    }

}
