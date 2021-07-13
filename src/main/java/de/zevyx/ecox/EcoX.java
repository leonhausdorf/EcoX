package de.zevyx.ecox;

import de.zevyx.ecox.api.EcoXAPI;
import de.zevyx.ecox.commands.EcoCommand;
import de.zevyx.ecox.configs.DatabaseConfig;
import de.zevyx.ecox.configs.MoneyConfig;
import de.zevyx.ecox.configs.SettingsConfig;
import de.zevyx.ecox.listener.ConnetionListener;
import org.bukkit.Bukkit;
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

        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("         ______          _  __");
        Bukkit.getConsoleSender().sendMessage("        / ____/________ | |/ /");
        Bukkit.getConsoleSender().sendMessage("       / __/ / ___/ __ \\|   / ");
        Bukkit.getConsoleSender().sendMessage("      / /___/ /__/ /_/ /   |  ");
        Bukkit.getConsoleSender().sendMessage("     /_____/\\___/\\____/_/|_|  ");
        Bukkit.getConsoleSender().sendMessage("                    by Zevyx  ");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("Version: " + getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("Start initializing EcoX...");

        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("Loading classes..");

        this.api = new EcoXAPI();
        this.settingsConfig = new SettingsConfig();
        this.moneyConfig = new MoneyConfig();
        this.databaseConfig = new DatabaseConfig();

        getSettingsConfig().initializeDefault();
        getMoneyConfig().initializeDefault();
        getDatabaseConfig().initializeDefault();


        Bukkit.getConsoleSender().sendMessage("Successful §a✔");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("Loading commands...");

        getCommand("ecox").setExecutor(new EcoCommand());

        Bukkit.getConsoleSender().sendMessage("Successful §a✔");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("Loading Listener...");

        Bukkit.getPluginManager().registerEvents(new ConnetionListener(), this);

        Bukkit.getConsoleSender().sendMessage("Successful §a✔");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("EcoX loaded!");

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
