package org.randomlima.witchkingofangmar.Listeners;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.randomlima.witchkingofangmar.itemz.Itemz;

public class AngmarPlaceListener implements Listener {
    @EventHandler
    public void blockPlace(BlockPlaceEvent event) {
        if(event.getPlayer().getItemInHand().equals(Itemz.AngmarHelmet)){
            event.setCancelled(true);
        }
    }
}
