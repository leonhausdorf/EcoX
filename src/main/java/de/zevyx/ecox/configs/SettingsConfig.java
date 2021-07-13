package de.zevyx.ecox.configs;

import de.zevyx.ecox.EcoX;
import de.zevyx.ecox.api.EcoXAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class SettingsConfig {

    private File file;
    private YamlConfiguration cfg;

    public SettingsConfig() {
        this.file = new File("plugins/EcoX", "settings.yml");
        this.cfg = YamlConfiguration.loadConfiguration(file);
    }

    public void initializeDefault() {
        if(!EcoX.getInstance().getDataFolder().exists())
            EcoX.getInstance().getDataFolder().mkdirs();
        if(!file.exists()) {
            try {
                file.createNewFile();

                setValue("autoupdate", true);
                setValue("logging", true);
                setValue("storage", "file");


                setValue("messages.prefix", "&6&lEcoX &8| &f");
                setValue("messages.currency", "Coins");
                setValue("messages.noperms", "You don't have enough permissions to execute this command.");
                setValue("messages.notexists", "The Player &b%p% &fdoes not exists.");
            } catch (IOException ex) {
                EcoXAPI.getAPI().getPluginUtils().sendStackTrace(ex);
            }
        }
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getConfig() {
        return cfg;
    }

    public void save() {
        try {
            getConfig().save(getFile());
        } catch (IOException ex) {
            EcoXAPI.getAPI().getPluginUtils().sendStackTrace(ex);
        }
    }

    public void setValue(String path, Object value) {
        getConfig().set(path, value);

        save();
    }

    public Object getValue(String path) {
        return getConfig().get(path);
    }

    public String getMessage(String path) {
        return getConfig().getString("messages." + path).replaceAll("&", "§");
    }

    public Boolean wantsFile() {
        return getValue("storage") == "file";
    }

    public Boolean wantsDatabase() {
        return getValue("storage") == "database";
    }

    public Boolean loggingActive() {
        return getConfig().getBoolean("logging");
    }


}
