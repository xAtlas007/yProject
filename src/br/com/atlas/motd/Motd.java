package br.com.atlas.motd;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import br.com.atlas.Main;

public class Motd implements Listener {

	@EventHandler
	
	public void MCMotd(ServerListPingEvent e) {
		
		if(Bukkit.getServer().hasWhitelist()) {
			
			e.setMotd(Main.getInstance().getConfig().getString("Motd.whitelist").replace("&", "§"));
			
		} else {
			
			e.setMotd(Main.getInstance().getConfig().getString("Motd.motd").replace("&", "§"));
			
		}
		
	}
	
}
