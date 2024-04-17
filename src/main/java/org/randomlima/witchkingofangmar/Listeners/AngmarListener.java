package org.randomlima.witchkingofangmar.Listeners;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.randomlima.witchkingofangmar.itemz.Itemz;

import java.util.*;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.bukkit.Bukkit.getServer;

public class AngmarListener implements Listener {
    //private static Map<String, Boolean> pumpkinPlayers = new HashMap<>();
    //List<String> pumpkinList = new ArrayList<>();
    List<Player> listOfPlayers = new ArrayList<>();



    @EventHandler
    public void onHelmetEquip(PlayerArmorChangeEvent event) {
        Player player = (Player) event.getPlayer();
        if (player.getInventory().getHelmet() != null && player.getInventory().getHelmet().equals(Itemz.AngmarHelmet)) {
            PotionEffect regen = new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 0);
            PotionEffect nv = new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0);
            player.addPotionEffect(regen);
            player.addPotionEffect(nv);
            //pumpkinPlayers.put(player.getName(), true);
            listOfPlayers.add(player);
        } else {
            if (listOfPlayers.contains(player)) {
                player.removePotionEffect(PotionEffectType.REGENERATION);
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                //pumpkinPlayers.remove(player.getName());
                listOfPlayers.remove(player);
            }
        }
    }
//    public HashMap<String, Boolean> getMap() {
//        return (HashMap<String, Boolean>) pumpkinPlayers;
//    }
    public List<Player> getPumpkinList() {
        return listOfPlayers;
    }

}
