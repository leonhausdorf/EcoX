package de.zevyx.ecox.api.money;

import de.zevyx.ecox.EcoX;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        EcoX.getInstance().getMoneyConfig().setValue(p.getName() + ".uuid", p.getUniqueId().toString());
        EcoX.getInstance().getMoneyConfig().setValue(p.getName() + ".money", 0);
        EcoX.getInstance().getMoneyConfig().setValue(p.getName() + ".firsttransaction", format.format(now));
    }

    public void setMoney(String name, Integer amount) {
        EcoX.getInstance().getMoneyConfig().setValue(name + ".money", amount);
    }

    public void addMoney(String name, Integer amount) {
        setMoney(name, amount + getMoney(name));
    }

    public void removeMoney(String name, Integer amount) {
       if(getMoney(name) < amount)
           setMoney(name, 0);
       else
           setMoney(name, getMoney(name) - amount);
    }

    public boolean haveEnoughMoney(String name, Integer amount) {
        return getMoney(name) >= amount;
    }

    public Integer getMoney(String name) {
        return (Integer) EcoX.getInstance().getMoneyConfig().getValue(name + ".money");
    }


}
