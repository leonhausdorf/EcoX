package de.zevyx.ecox.configs;

import de.zevyx.ecox.api.EcoXAPI;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MoneyConfig {

    private File file = new File("plugins/EcoX", "balance.yml");
    private YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public void initializeDefault() {
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
                EcoXAPI.getAPI().getPluginUtils().sendStackTrace(ex);
            }
        }
    }

    private void save() {
        try {
            cfg.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
            EcoXAPI.getAPI().getPluginUtils().sendStackTrace(ex);
        }
    }

    public void setValue(String path, Object value) {
        cfg.set(path, value);

        save();
    }

    public Object getValue(String path) {
        return cfg.get(path);
    }

    public Boolean exists(String path) {
        return cfg.getString(path) != null;
    }

}
