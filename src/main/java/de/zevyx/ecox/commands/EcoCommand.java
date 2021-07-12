package de.zevyx.ecox.commands;

import de.zevyx.ecox.EcoX;
import de.zevyx.ecox.api.EcoXAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EcoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        if(cmd.getName().equalsIgnoreCase("ecox")) {
            if(args.length == 0)
                EcoXAPI.getAPI().getPluginUtils().getEcoXHelp(cs);
            else if (args.length == 2) {
                if(args[0].equalsIgnoreCase("info")) {
                    String pname = args[1];
                    if(EcoXAPI.getAPI().getMoneyAPI().userExistsByName(pname)) {

                    } else {

                    }
                }
            }
        }
        return false;
    }
}
