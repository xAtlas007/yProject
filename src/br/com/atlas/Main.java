package br.com.atlas;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.atlas.commands.Manutence;
import br.com.atlas.motd.Motd;

public class Main extends JavaPlugin {

	private static Main instance;
	public static Main getInstance() {
		
		return instance;
		
	}
	
	@Override
	
	public void onEnable() {
		
		instance = this;
		
		Bukkit.getConsoleSender().sendMessage("§b§lPLUGIN §aIniciado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§a Developed <3 by xAtlas#0001");
		
		MCConfig();
		
		Bukkit.getPluginManager().registerEvents(new Motd(), this);
		
		getCommand("manutencao").setExecutor(new Manutence());
		
	}
	
	@Override
	
	public void onDisable() {
		
		Bukkit.getConsoleSender().sendMessage("§b§lPLUGIN §cDesativado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§a Developed <3 by xAtlas#0001");
	
		
	}
	
	private void MCConfig() {
		
		getConfig().options().copyDefaults(false);
		saveDefaultConfig();
		
	}
	
}
