package de.zevyx.ecox;

import de.zevyx.ecox.api.EcoXAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class EcoX extends JavaPlugin {

    private static EcoX instance;
    private EcoXAPI api;

    @Override
    public void onLoad() {


    }

    @Override
    public void onEnable() {
        instance = this;
        this.api = new EcoXAPI();
    }

    @Override
    public void onDisable() {


    }

    public static EcoX getInstance() {
        return instance;
    }

    public EcoXAPI getAPI() {
        return api;
    }
}
