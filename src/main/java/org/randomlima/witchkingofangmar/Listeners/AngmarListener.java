package org.randomlima.witchkingofangmar.Listeners;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.randomlima.witchkingofangmar.itemz.Itemz;

public class AngmarListener implements Listener {
    @EventHandler
    public void onHelmetEquip(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if(player.getInventory().getHelmet() != null && player.getInventory().getHelmet().equals(Itemz.AngmarHelmet)){
            PotionEffect regen = new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 0);
            PotionEffect nv = new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0);
            player.addPotionEffect(regen);
            player.addPotionEffect(nv);
            applySlownessToNearbyPlayers(player);
        } else{
            if(player.hasPotionEffect(PotionEffectType.REGENERATION) && player.hasPotionEffect(PotionEffectType.NIGHT_VISION)){
                player.removePotionEffect(PotionEffectType.REGENERATION);
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
            }
        }
    }

    private void applySlownessToNearbyPlayers(Player sourcePlayer) {
        for (Player nearbyPlayer : sourcePlayer.getWorld().getPlayers()) {
            if (nearbyPlayer != sourcePlayer && nearbyPlayer.getLocation().distance(sourcePlayer.getLocation()) <= 10) {
                nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 0));
            }
        }
    }
}
