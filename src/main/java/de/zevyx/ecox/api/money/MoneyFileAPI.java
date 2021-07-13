package de.zevyx.ecox.api.money;

import de.zevyx.ecox.EcoX;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MoneyFileAPI {

    public boolean userExists(String name) {
        return EcoX.getInstance().getMoneyConfig().exists(name);
    }

    public void initiateUser(Player p) {

        EcoX.getInstance().getMoneyConfig().setValue(p.getName() + ".balance", 0);
    }

    public void setMoney(String name, Integer amount) {
        EcoX.getInstance().getMoneyConfig().setValue(name + ".balance", amount);
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
        return (Integer) EcoX.getInstance().getMoneyConfig().getValue(name + ".balance");
    }


}
