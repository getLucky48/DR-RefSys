package refsys.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public class RefSys extends JavaPlugin{
	
	public void onEnable() {
		
		File config = new File(getDataFolder() + File.separator + "config.yml");
		
		if(!config.exists()) {
			
			getLogger().info("Creating new config file...");
			
			getConfig().options().copyDefaults(true);
			
			saveDefaultConfig();
			
		}
		
		SettingsManager settings = SettingsManager.getInstance();
		
		settings.setup(this);
		
		getCommand("code").setExecutor(new Handler(this));
		
		Bukkit.getPluginManager().registerEvents(new Handler(this), this);
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[DR-RefSys] ENABLED :)");
		
	}
	public void onDisable() {
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[DR-RefSys] DISABLED :c");
		
	}
	
}
