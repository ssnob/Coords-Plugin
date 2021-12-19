package ssno.me;

import org.bukkit.plugin.java.JavaPlugin;
import ssno.me.commands.CoordsCommand;
import ssno.me.events.onPlayerDeath;

public final class Me extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new onPlayerDeath(), this);
        getCommand("coords").setExecutor(new CoordsCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
