package nl.svenar.powercamera.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import nl.svenar.powercamera.PowerCamera;

public class ChatTabExecutor implements TabCompleter {

	private PowerCamera plugin;
	
	public ChatTabExecutor(PowerCamera plugin) {
		this.plugin = plugin;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		if (sender instanceof Player) {
			List<String> list = new ArrayList<String>();
			
			if (args.length == 1) {
				ArrayList<String> commands_list = new ArrayList<String>();
				commands_list.add("help");
				commands_list.add("create");
				commands_list.add("remove");
				commands_list.add("addpoint");
				commands_list.add("delpoint");
				commands_list.add("select");
				commands_list.add("preview");
				commands_list.add("info");
				commands_list.add("setduration");
				commands_list.add("start");
				commands_list.add("stats");

				for (String command : commands_list) {
					if (command.toLowerCase().contains(args[0].toLowerCase()))
						list.add(command);
				}
			}
			
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("select") || args[0].equalsIgnoreCase("start")) {
					for (String camera_name : this.plugin.getConfigCameras().getCameras()) {
						list.add(camera_name);
					}
				}
			}
			
			return list;
		}
		return null;
	}

}
