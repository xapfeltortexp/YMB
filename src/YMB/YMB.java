package YMB;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import YMB.Commands.YMBCE_ymb;

public class YMB extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	public String prefix = ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GOLD + "" + ChatColor.ITALIC + "YMB" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]" + ChatColor.RESET + " ";
	public YMBCE_ymb ymbCE = new YMBCE_ymb(this);
	/**
	 * Plugin Start
	 */
	public void onEnable() {
		/**
		 * Load Config
		 */
		loadConfig();
		/**
		 * Register Stuff
		 */
		registerStuff();
		/**
		 * Output Message
		 */
		log.log(Level.INFO, "[YMB] Plugin is activated!");
	}
	/**
	 * Plugin Stopp
	 */
	public void onDisable() {
		log.log(Level.INFO, "[YMB] Plugin is deactivated!");
	}
	/**
	 * Config
	 */
	public void loadConfig() {
		FileConfiguration config;
		if (new File("plugins/YMB/config.yml").exists()) {
			config = this.getConfig();
			config.options().copyDefaults(true);
			System.out.println("[YMB] Config successfully loaded.");
		} else {
			saveDefaultConfig();
			config = this.getConfig();
			System.out.println("[YMB] New config file has been successfully created.");
		}
	}
	/**
	 * Register Stuff
	 */
	public void registerStuff() {
		this.getCommand("ymb").setExecutor(ymbCE);
	}
}
