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
                if(cs.hasPermission("ecox.info")) {
                    if(args[0].equalsIgnoreCase("info")) {
                        String pname = args[1];
                        if(EcoXAPI.getAPI().getMoneyAPI().userExistsByName(pname)) {
                            EcoXAPI.getAPI().getPluginUtils().getPlayerEcoInfo(cs, pname);
                        } else
                            cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("notexists").replaceAll("%p%", pname));
                    }
                } else
                    cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("noperms"));
            } else
                EcoXAPI.getAPI().getPluginUtils().getEcoXHelp(cs);
        }
        return false;
    }
}
