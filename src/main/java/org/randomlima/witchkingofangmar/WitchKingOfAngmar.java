package org.randomlima.witchkingofangmar;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.randomlima.witchkingofangmar.Commands.AngmarHelmet;
import org.randomlima.witchkingofangmar.Listeners.AngmarListener;

import org.randomlima.witchkingofangmar.Listeners.AngmarPlaceListener;
import org.randomlima.witchkingofangmar.itemz.Itemz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class WitchKingOfAngmar extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Itemz.init();
        this.getCommand("angmarhelmet").setExecutor(new AngmarHelmet());
        getServer().getPluginManager().registerEvents(new AngmarListener(), this);
        getServer().getPluginManager().registerEvents(new AngmarPlaceListener(), this);
        AngmarListener x = new AngmarListener();

        getServer().getScheduler().runTaskTimer(this, () -> {
            // Iterate through online players and check if they are in water
            for (Player player : getServer().getOnlinePlayers()) {
                Material blockType = player.getLocation().getBlock().getType();
                if (player.getInventory().getHelmet() != null && player.getInventory().getHelmet().equals(Itemz.AngmarHelmet)){
                    if (blockType == Material.WATER) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20, 3));
                    }
                }
            }
        }, 0L, 10L); // 10 ticks = 0.5 seconds

        getServer().getScheduler().runTaskTimer(this, () -> {
            //HashMap<String, Boolean> pumpkinDudes = x.getMap();
            //pumpkinDudes.forEach((key, value) -> System.out.println(key + " " + value));

            AngmarListener pumpkinClass = new AngmarListener();
            List<Player> pumpkinList = pumpkinClass.getPumpkinList();
            for(Player player : pumpkinList){
                System.out.println(player.getName());
                for (Entity nearplayer : player.getNearbyEntities(10, 10, 10)){
                    if (nearplayer instanceof Player){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 1));
                    }
                }
            }
        }, 0L, 10L); // 10 ticks = 0.5 seconds
    }




    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
