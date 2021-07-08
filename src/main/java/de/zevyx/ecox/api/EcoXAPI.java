package de.zevyx.ecox.api;

import de.zevyx.ecox.api.utils.ItemAPI;
import de.zevyx.ecox.api.utils.PluginUtils;
import org.bukkit.Material;

public class EcoXAPI {

    private static EcoXAPI api;
    private PluginUtils pluginUtils;

    public EcoXAPI() {
        api = this;
        this.pluginUtils = new PluginUtils();
    }

    public static EcoXAPI getAPI() {
        return api;
    }

    public PluginUtils getPluginUtils() {
        return pluginUtils;
    }
}
