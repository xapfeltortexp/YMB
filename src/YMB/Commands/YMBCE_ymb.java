package YMB.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import YMB.YMB;

public class YMBCE_ymb implements CommandExecutor{
	YMB plugin;
	public YMBCE_ymb(YMB YMB){
		plugin = YMB;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			System.out.println("Command can't be run by console!");
			return true;
		}
		Player player = (Player) sender;
		Configuration config = this.plugin.getConfig();
		if(cmd.getName().equalsIgnoreCase("ymb")){
			if (!player.hasPermission("YMB.use")) {
				player.sendMessage(ChatColor.RED + "You don't have permission for this command!");
				return true;
			}
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("start")){
					Block tBlock = player.getTargetBlock(null, 600);
					if(tBlock.getType() != Material.JUKEBOX){
						player.sendMessage(plugin.prefix + ChatColor.RED + "The target block must be a jukebox!");
						return true;
					}
					Jukebox jb = (Jukebox) tBlock.getState();
					jb.setPlaying(Material.RECORD_3);
					player.sendMessage(plugin.prefix + ChatColor.GREEN + "This jukebox will now automatically play music.");
					return true;
				}
			}
		}
		return false;
	}
}
