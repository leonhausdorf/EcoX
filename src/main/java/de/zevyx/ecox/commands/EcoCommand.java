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
                        Bukkit.getConsoleSender().sendMessage("DEBUG EXISTS FUNCTION: " + EcoX.getInstance().getMoneyConfig().exists(pname));
                        Bukkit.getConsoleSender().sendMessage("DEBUG USEREXISTS FUNCTION: " + EcoXAPI.getAPI().getMoneyAPI().userExistsByName(pname));
                        Bukkit.getConsoleSender().sendMessage("DEBUG VALUE: " + EcoX.getInstance().getMoneyConfig().getValue(pname));
                        Bukkit.getConsoleSender().sendMessage("DEBUG BALANCE: " + EcoX.getInstance().getMoneyConfig().getValue(pname + ".balance"));
                        if(EcoXAPI.getAPI().getMoneyAPI().userExistsByName(pname)) {
                            EcoXAPI.getAPI().getPluginUtils().getPlayerEcoInfo(cs, pname);
                        } else
                            cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("notexists").replaceAll("%p%", pname));
                    }
                } else
                    cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("noperms"));
            } else if(args.length == 3) {
                if(args[0].equalsIgnoreCase("set")) {
                    if(cs.hasPermission("ecox.set")) {
                        String pname = args[1];
                        if(EcoXAPI.getAPI().getMoneyAPI().userExistsByName(pname)) {
                            Integer amount = Integer.parseInt(args[2]);
                            EcoXAPI.getAPI().getMoneyAPI().setMoney(pname, amount);
                            cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("moneyset").replaceAll("%p%", pname).replaceAll("%a%", amount.toString()));
                        } else
                            cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("notexists").replaceAll("%p%", pname));
                    } else
                        cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("noperms"));

                } else if(args[0].equalsIgnoreCase("add")) {
                    if(cs.hasPermission("ecox.add")) {
                        String pname = args[1];
                        if(EcoXAPI.getAPI().getMoneyAPI().userExistsByName(pname)) {
                            Integer amount = Integer.parseInt(args[2]);
                            EcoXAPI.getAPI().getMoneyAPI().addMoney(pname, amount);
                            cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("moneyadd").replaceAll("%p%", pname).replaceAll("%a%", amount.toString()));
                        } else
                            cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("notexists").replaceAll("%p%", pname));
                    } else
                        cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("noperms"));
                } else if(args[0].equalsIgnoreCase("remove")) {
                    if (cs.hasPermission("ecox.remove")) {
                        String pname = args[1];
                        if (EcoXAPI.getAPI().getMoneyAPI().userExistsByName(pname)) {
                            Integer amount = Integer.parseInt(args[2]);
                            EcoXAPI.getAPI().getMoneyAPI().removeMoney(pname, amount);
                            cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("moneyremove").replaceAll("%p%", pname).replaceAll("%a%", amount.toString()));
                        } else
                            cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("notexists").replaceAll("%p%", pname));
                    } else
                        cs.sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + EcoX.getInstance().getSettingsConfig().getMessage("noperms"));
                }
            } else
                EcoXAPI.getAPI().getPluginUtils().getEcoXHelp(cs);
        }
        return false;
    }
}
