package org.randomlima.witchkingofangmar.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.randomlima.witchkingofangmar.itemz.Itemz;

public class AngmarWaterListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        Material blockType = event.getPlayer().getLocation().getBlock().getType();

        if(blockType != Material.WATER)return;
        if(player.getInventory().getHelmet() != null && player.getInventory().getHelmet().equals(Itemz.AngmarHelmet)){
            PotionEffect wither = new PotionEffect(PotionEffectType.WITHER, 50, 2);
            player.addPotionEffect(wither);
        }
    }
}
