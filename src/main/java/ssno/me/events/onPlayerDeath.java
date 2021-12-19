package ssno.me.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.lang.annotation.Annotation;

public class onPlayerDeath implements Listener {

    static String overworld = "world";
    static String nether = "world_nether";
    static String end = "world_the_end";

    @EventHandler
    public static void playerDeath(PlayerDeathEvent event) {

        String world = event.getEntity().getPlayer().getWorld().getName();
        double x = event.getEntity().getLocation().getX(); double y = event.getEntity().getLocation().getY(); double z = event.getEntity().getLocation().getZ();
        String xc = Double.toString(Math.floor(x)); String yc = Double.toString(Math.floor(y)); String zc = Double.toString(Math.floor(z));
        if(event.getEntityType() == EntityType.PLAYER) {
            event.getEntity().getPlayer().sendMessage("§cLast Coords: x:" + xc + " y:" + yc + " z:" + zc);
            if (world.equalsIgnoreCase(overworld)) {
                event.getEntity().getPlayer().sendMessage("§4World: OverWorld");
            }
            if (world.contains(nether)) {
                event.getEntity().getPlayer().sendMessage("§4World: Nether");
            }
            if (world.contains(end)) {
                event.getEntity().getPlayer().sendMessage("§4World: The End");
            }
        }
    }

}
