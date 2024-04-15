package org.randomlima.witchkingofangmar;

import org.bukkit.plugin.java.JavaPlugin;
import org.randomlima.witchkingofangmar.Commands.AngmarHelmet;
import org.randomlima.witchkingofangmar.Listeners.AngmarListener;
import org.randomlima.witchkingofangmar.Listeners.AngmarWaterListener;
import org.randomlima.witchkingofangmar.itemz.Itemz;

public final class WitchKingOfAngmar extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Itemz.init();
        this.getCommand("angmarhelmet").setExecutor(new AngmarHelmet());
        getServer().getPluginManager().registerEvents(new AngmarListener(), this);
        getServer().getPluginManager().registerEvents(new AngmarWaterListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
