package ssno.me.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoordsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String overworld = "world";
        String nether = "world_nether";
        String end = "world_the_end";
        Player player = (Player) sender;
        boolean coordsStatus = true;

        if(label.equalsIgnoreCase("coords")) {
            if (coordsStatus != true) {
                player.sendMessage("This command is disabled!");
                return true;
            }
            else {
                Player p = (Player) player;
                String world = player.getPlayer().getWorld().getName();
                double x = player.getLocation().getX(); double y = player.getLocation().getY(); double z = player.getLocation().getZ();
                String name = player.getName(); String xc = Double.toString(Math.floor(x)); String yc = Double.toString(Math.floor(y)); String zc = Double.toString(Math.floor(z));
                Bukkit.broadcastMessage(name + "'s coords"); Bukkit.broadcastMessage("x:" + xc + " y:" + yc + " z:" + zc);
                if (world.equalsIgnoreCase(overworld)) {
                    Bukkit.broadcastMessage("World: OverWorld");
                }
                if (world.contains(nether)) {
                    Bukkit.broadcastMessage("World: Nether");
                }
                if (world.contains(end)) {
                    Bukkit.broadcastMessage("World: The End");
                }
            }
        }

        return true;
    }
}
