package org.randomlima.witchkingofangmar.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.randomlima.witchkingofangmar.itemz.Itemz;

public class AngmarHelmet implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("angmarhelmet")){
            player.getInventory().addItem(Itemz.AngmarHelmet);
        }
        return true;
    }
}
