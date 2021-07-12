package de.zevyx.ecox.api.money;

import de.zevyx.ecox.EcoX;
import de.zevyx.ecox.api.EcoXAPI;
import org.bukkit.entity.Player;

public class MoneyAPI {

    public boolean userExists(Player p) {
        if(wantsFile())
            return EcoXAPI.getAPI().getMoneyFileAPI().userExists(p);
        return false;
    }

    public boolean userExistsByName(String name) {
        if(wantsFile())
            return EcoXAPI.getAPI().getMoneyFileAPI().userExistsByName(name);
        return false;
    }

    public boolean wantsFile() {
        return EcoX.getInstance().getSettingsConfig().wantsFile();
    }

    public Integer getMoney(Player p) {
        if(wantsFile())
            return EcoXAPI.getAPI().getMoneyFileAPI().getMoney(p);

        return 0;
    }

    public void setMoney(Player p, Integer amount) {
        if(wantsFile())
            EcoXAPI.getAPI().getMoneyFileAPI().setMoney(p, amount);
    }

    public void addMoney(Player p, Integer amount) {
        if(wantsFile())
            EcoXAPI.getAPI().getMoneyFileAPI().addMoney(p, amount);
    }

    public void removeMoney(Player p, Integer amount) {
        if(wantsFile())
            EcoXAPI.getAPI().getMoneyFileAPI().removeMoney(p, amount);
    }

    public boolean haveEnoughMoney(Player p, Integer amount) {
        if(wantsFile())
            return EcoXAPI.getAPI().getMoneyFileAPI().haveEnoughMoney(p, amount);

        return false;
    }

}
