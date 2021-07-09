package de.zevyx.ecox;

import de.zevyx.ecox.api.EcoXAPI;
import de.zevyx.ecox.configs.DatabaseConfig;
import de.zevyx.ecox.configs.MoneyConfig;
import de.zevyx.ecox.configs.SettingsConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class EcoX extends JavaPlugin {

    private static EcoX instance;
    private EcoXAPI api;

    private SettingsConfig settingsConfig;
    private MoneyConfig moneyConfig;
    private DatabaseConfig databaseConfig;

    @Override
    public void onLoad() {


    }

    @Override
    public void onEnable() {
        instance = this;
        this.api = new EcoXAPI();
        this.settingsConfig = new SettingsConfig();
        this.moneyConfig = new MoneyConfig();
        this.databaseConfig = new DatabaseConfig();

        getSettingsConfig().initializeDefault();
        getMoneyConfig().initializeDefault();
        getDatabaseConfig().initializeDefault();
    }

    @Override
    public void onDisable() {


    }

    public static EcoX getInstance() {
        return instance;
    }

    public SettingsConfig getSettingsConfig() {
        return settingsConfig;
    }

    public MoneyConfig getMoneyConfig() {
        return moneyConfig;
    }

    public DatabaseConfig getDatabaseConfig() {
        return databaseConfig;
    }

    public EcoXAPI getAPI() {
        return api;
    }
}
