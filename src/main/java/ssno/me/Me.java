package ssno.me;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ssno.me.commands.AdminCommands;
import ssno.me.commands.CoordsCommand;
import ssno.me.cooldown.Cooldown;
import ssno.me.events.onPlayerDeath;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class Me extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
         final String prefix = "§7[§bCoords§7] ";

        getServer().getPluginManager().registerEvents(new onPlayerDeath(), this);
        Cooldown.setupcds();
        getCommand("coords").setExecutor(new CoordsCommand());
        getCommand("enabletp").setExecutor(new AdminCommands());
        getCommand("disabletp").setExecutor(new AdminCommands());
        getCommand("statustp").setExecutor(new AdminCommands());


        Path path = Paths.get("plugins/Coords/");
        Path config = Paths.get("plugins/Coords/config.yml");
        if(Files.exists(config)) {
            return;
        } else {
            try {
                Files.createDirectory(path);
                Files.createFile(config);
                String tp = "tp=false";
                BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(config)));
                writer.write(tp);

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
