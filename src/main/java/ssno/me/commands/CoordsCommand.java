package ssno.me.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ssno.me.cooldown.Cooldown;

public class CoordsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String prefix = "§7[§bCoords§7] ";
        String overworld = "world";
        String nether = "world_nether";
        String end = "world_the_end";
        Player player = (Player) sender;
        boolean coordsStatus = true;

        if(label.equalsIgnoreCase("coords")) {
            if (Cooldown.checkCooldown(player.getPlayer())) {
                String world = player.getPlayer().getWorld().getName();
                double x = player.getLocation().getX(); double y = player.getLocation().getY(); double z = player.getLocation().getZ();
                String name = player.getName(); String xc = Double.toString(Math.floor(x)); String yc = Double.toString(Math.floor(y)); String zc = Double.toString(Math.floor(z));
                Bukkit.broadcastMessage(prefix + name + "'s coords"); Bukkit.broadcastMessage(prefix + "x:" + xc + " y:" + yc + " z:" + zc);
                if (world.equalsIgnoreCase(overworld)) {
                    Bukkit.broadcastMessage(prefix + "World: OverWorld");
                }
                if (world.contains(nether)) {
                    Bukkit.broadcastMessage(prefix + "World: Nether");
                }
                if (world.contains(end)) {
                    Bukkit.broadcastMessage(prefix + "World: The End");
                }

                Cooldown.setCooldown(player.getPlayer(), 5);
            }
            else {
                player.sendMessage(ChatColor.RED + "This command is still on cooldown.");
            }
        }

        return true;
    }
}
