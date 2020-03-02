package br.com.atlas.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.atlas.Main;
import br.com.atlas.api.MineReflect;

public class Manutence implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {			
			Bukkit.getConsoleSender().sendMessage("§c§lERRO §fApenas jogadores podem fazer isso!");	
			return false;
			
		}
		
		Player p = (Player)sender;
		
		if(!p.hasPermission(Main.getInstance().getConfig().getString("Player.permissao").replace("&", "§"))) {
			
			p.sendMessage(Main.getInstance().getConfig().getString("Mensagens.sem_permissao0").replace("&", "§"));
			
			return false;
			
		}
		
		if(args.length == 0) {
			
			p.sendMessage(Main.getInstance().getConfig().getString("Mensagens.comando_errado").replace("&", "§"));
			
			return false;
			
		}
		
		String args1 = args[0];
		
		if(args1.equalsIgnoreCase("on")) {
			
			Bukkit.getServer().setWhitelist(true);
			
			for(Player player : Bukkit.getOnlinePlayers()) {
				
				if(Bukkit.getServer().hasWhitelist()) {
					MineReflect.sendTitle(player, Main.getInstance().getConfig().getString("Title.manutencaoativa_title").replace("&", "§"), 
					Main.getInstance().getConfig().getString("Title.manutencaoativa_subtitle").replace("&", "§"), 20, 20, 20);
					player.sendMessage(Main.getInstance().getConfig().getString("Mensagens.ativou_manutencao").replace("&", "§"));
					player.playSound(p.getLocation(), Sound.LEVEL_UP, 20, 20);
					
				if(!player.isWhitelisted()) {
						player.kickPlayer(Main.getInstance().getConfig().getString("Player.kick_message"));
					
						}	
					}	
				}
			}
		
		if(args1.equalsIgnoreCase("off")) {
			
			Bukkit.getServer().setWhitelist(false);
			
			for(Player players : Bukkit.getOnlinePlayers()) {
				
				MineReflect.sendTitle(p, Main.getInstance().getConfig().getString("Title.manutencaodesativada_title").replace("&", "§"), 
				Main.getInstance().getConfig().getString("Title.manutencaodesativada_subtitle").replace("&", "§"), 20, 20, 20);
				players.sendMessage(Main.getInstance().getConfig().getString("Mensagens.desativou_manutencao").replace("&", "§"));
				players.playSound(p.getLocation(), Sound.LEVEL_UP, 20, 20);
				
				return true;
				
			}
			
		}
		
		return false;
	}

}
