package de.zevyx.ecox.api.money;

import de.zevyx.ecox.EcoX;
import de.zevyx.ecox.api.EcoXAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MoneyAPI {

    public boolean userExistsByName(String name) {
        if(wantsFile())
            return EcoX.getInstance().getMoneyConfig().exists(name);

        return false;
    }

    public void initiateUser(Player p) {
        if(wantsFile())
            EcoXAPI.getAPI().getMoneyFileAPI().initiateUser(p);

        if(EcoX.getInstance().getSettingsConfig().loggingActive())
            Bukkit.getConsoleSender().sendMessage(EcoX.getInstance().getSettingsConfig().getMessage("prefix") + "The User §b" + p.getName() + " §fwas initiated with UUID §b" + p.getUniqueId().toString());
    }

    private boolean wantsFile() {
        return EcoX.getInstance().getSettingsConfig().wantsFile();
    }

    public Integer getMoney(String name) {
        if(wantsFile())
            return EcoXAPI.getAPI().getMoneyFileAPI().getMoney(name);

        return 0;
    }

    public void setMoney(String name, Integer amount) {
        if(wantsFile())
            EcoXAPI.getAPI().getMoneyFileAPI().setMoney(name, amount);
    }

    public void addMoney(String name, Integer amount) {
        if(wantsFile())
            EcoXAPI.getAPI().getMoneyFileAPI().addMoney(name, amount);
    }

    public void removeMoney(String name, Integer amount) {
        if(wantsFile())
            EcoXAPI.getAPI().getMoneyFileAPI().removeMoney(name, amount);
    }

    public boolean haveEnoughMoney(String name, Integer amount) {
        if(wantsFile())
            return EcoXAPI.getAPI().getMoneyFileAPI().haveEnoughMoney(name, amount);

        return false;
    }

}
