package ssno.me.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class onPlayerDeath implements Listener {

    static String prefix = "§7[§bCoords§7] ";
    static String overworld = "world";
    static String nether = "world_nether";
    static String end = "world_the_end";

    @EventHandler
    public static void playerDeath(PlayerDeathEvent event) {
        String world = event.getEntity().getPlayer().getWorld().getName();
        Location loc = event.getEntity().getPlayer().getLocation();
        double x = event.getEntity().getLocation().getX(); double y = event.getEntity().getLocation().getY(); double z = event.getEntity().getLocation().getZ();
        String xc = Double.toString(Math.floor(x)); String yc = Double.toString(Math.floor(y)); String zc = Double.toString(Math.floor(z));
        Path path = Paths.get("plugins/Coords/");
        Path config = Paths.get("plugins/Coords/config.yml");
        event.deathMessage().equals("");
        String death = event.getDeathMessage();
        if(event.getEntityType() == EntityType.PLAYER) {
            event.getEntity().getPlayer().sendMessage(prefix + "§cLast Coords: x:" + xc + " y:" + yc + " z:" + zc);
            if (world.equalsIgnoreCase(overworld)) {
                event.getEntity().getPlayer().sendMessage(prefix + "§4World: OverWorld");
            }
            if (world.contains(nether)) {
                event.getEntity().getPlayer().sendMessage(prefix + "§4World: Nether");
            }
            if (world.contains(end)) {
                event.getEntity().getPlayer().sendMessage(prefix + "§4World: The End");
            }

            try {
                Scanner myReader = new Scanner(config);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if(data.equalsIgnoreCase("tp=false")) {
                        return;
                    }
                    if(data.equalsIgnoreCase("tp=true")) {
                       return;
                       // soon
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println(prefix + "Config.yml not found. Does it exist?");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
