package ssno.me.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AdminCommands implements CommandExecutor {
    static String prefix = "§7[§bCoords§7] ";
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Path config = Paths.get("plugins/Coords/config.yml");

        if (!sender.hasPermission("op")) {
            sender.sendMessage(prefix + "You don't have permission to use this command!");
            return true;
        }

        if (label.equalsIgnoreCase(("enabletp"))) {
            String str = "tp=true";
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(config)));
                writer.write(str);

                writer.close();
                sender.sendMessage(prefix + "Tp enabled!");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;
        }

        if (label.equalsIgnoreCase(("disabletp"))) {
            String str = "tp=false";
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(config)));
                writer.write(str);

                writer.close();
                sender.sendMessage(prefix + "Tp disabled!");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;
        }
        if (label.equalsIgnoreCase(("statustp"))) {
            Scanner myReader = null;
            try {
                myReader = new Scanner(config);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.equalsIgnoreCase("tp=false")) {
                    sender.sendMessage(prefix + "Tp is set to false");
                    return true;
                }
                if(data.equalsIgnoreCase("tp=true")) {
                    sender.sendMessage(prefix + "Tp is set to true");
                    return true;
                }
            }
            myReader.close();
        }

        return false;
    }
}
