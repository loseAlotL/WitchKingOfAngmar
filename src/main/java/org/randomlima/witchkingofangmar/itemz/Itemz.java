package org.randomlima.witchkingofangmar.itemz;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Itemz {
    public static ItemStack AngmarHelmet;

    public static void init(){
        createAngmarHelmet();
    }

    private static void createAngmarHelmet() {
        ItemStack item = new ItemStack(Material.CARVED_PUMPKIN,1);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(2);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
        meta.addEnchant(Enchantment.THORNS, 4, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier("GENERIC_MAX_HEALTH", 10, AttributeModifier.Operation.ADD_NUMBER));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName("§4[Witch King of Angmar's Helmet]");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§8The one and only helmet of the Witch King.");
        lore.add("");
        lore.add("§8Gives the wearer §dwithering §8while in water.");
        meta.setLore(lore);
        item.setItemMeta(meta);
        AngmarHelmet = item;
    }

}

