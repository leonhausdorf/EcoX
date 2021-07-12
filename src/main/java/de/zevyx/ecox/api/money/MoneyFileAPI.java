package de.zevyx.ecox.api.money;

import de.zevyx.ecox.EcoX;
import org.bukkit.entity.Player;

public class MoneyFileAPI {

    public boolean userExists(Player p) {
        return EcoX.getInstance().getMoneyConfig().getConfig().contains(p.getUniqueId().toString());
    }

    public boolean userExistsByName(String name) {
        return EcoX.getInstance().getMoneyConfig().getConfig().contains(name);
    }

    public boolean userExistsByUUID(String uuid) {
        return EcoX.getInstance().getMoneyConfig().getConfig().contains(uuid);
    }

    public void initiateUser(Player p) {
        EcoX.getInstance().getMoneyConfig().setValue(p.getName() + ".uuid", p.getUniqueId().toString());
        EcoX.getInstance().getMoneyConfig().setValue(p.getName() + ".money", 0);
    }

    public void setMoney(Player p, Integer amount) {
        EcoX.getInstance().getMoneyConfig().setValue(p.getName() + ".money", amount);
    }

    public void addMoney(Player p, Integer amount) {
        setMoney(p, amount + getMoney(p));
    }

    public void removeMoney(Player p, Integer amount) {
       if(getMoney(p) < amount)
           setMoney(p, 0);
       else
           setMoney(p, getMoney(p) - amount);
    }

    public boolean haveEnoughMoney(Player p, Integer amount) {
        return getMoney(p) >= amount;
    }

    public Integer getMoney(Player p) {
        return (Integer) EcoX.getInstance().getMoneyConfig().getValue(p.getName() + ".money");
    }


}
