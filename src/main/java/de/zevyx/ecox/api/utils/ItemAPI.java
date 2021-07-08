package de.zevyx.ecox.api.utils;

import org.bukkit.Material;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemAPI {

    private ItemStack is;

    public ItemAPI(Material m) {
        is = new ItemStack(m);
    }

    public ItemAPI setDisplayName(String name) {
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        is.setItemMeta(im);

        return this;
    }

}
