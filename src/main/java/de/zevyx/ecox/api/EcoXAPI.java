package de.zevyx.ecox.api;

import de.zevyx.ecox.api.money.MoneyAPI;
import de.zevyx.ecox.api.money.MoneyFileAPI;
import de.zevyx.ecox.api.utils.ItemAPI;
import de.zevyx.ecox.api.utils.PluginUtils;
import org.bukkit.Material;

public class EcoXAPI {

    private static EcoXAPI api;
    private PluginUtils pluginUtils;
    private MoneyFileAPI moneyFileAPI;
    private MoneyAPI moneyAPI;

    public EcoXAPI() {
        api = this;
        this.pluginUtils = new PluginUtils();
        this.moneyFileAPI = new MoneyFileAPI();
        this.moneyAPI = new MoneyAPI();
    }

    public static EcoXAPI getAPI() {
        return api;
    }

    public PluginUtils getPluginUtils() {
        return pluginUtils;
    }

    public MoneyFileAPI getMoneyFileAPI() {
        return moneyFileAPI;
    }

    public MoneyAPI getMoneyAPI() {
        return moneyAPI;
    }

}
