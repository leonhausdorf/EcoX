package de.zevyx.ecox.configs;

import de.zevyx.ecox.EcoX;
import de.zevyx.ecox.api.EcoXAPI;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MoneyConfig {

    private File file;
    private YamlConfiguration cfg;

    public MoneyConfig() {
        this.file = new File("plugins/EcoX", "money.yml");
        this.cfg = YamlConfiguration.loadConfiguration(file);
    }

    public void initializeDefault() {
        if(!file.exists()) {
            if(EcoX.getInstance().getSettingsConfig().wantsFile()) {
                try {
                    file.createNewFile();


                } catch (IOException ex) {
                    EcoXAPI.getAPI().getPluginUtils().sendStackTrace(ex);
                }
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

}
