package com.eveningmc.customlogin.events;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.eveningmc.customlogin.Customlogin;

public class onJoin implements Listener
{
	
	public Customlogin plugin;
	
	public onJoin(Customlogin plugin)
	{
		
		this.plugin = plugin;
		
	}
	
    @EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) throws IOException
	{
		
		FileConfiguration config = null;
		File playerDir = new File(plugin.getDataFolder() + "/userdata");
		File userData = new File(playerDir + "/" + e.getPlayer().getName() + ".yml");
		
		if(!playerDir.exists())
		{
			
			playerDir.mkdir();
			
		}
		
		if(!userData.exists())
		{
			
			try
			{
				
				userData.createNewFile();
				
			} catch (IOException ex)
			{
				
				ex.printStackTrace();
				
			}
			
		}
		
		config = YamlConfiguration.loadConfiguration(userData);
		config.set("Messages.Prefix", "&9Customlogin > ");
		config.set("Messages.Login", "&a+ &b(PLAYER)");
		config.set("Messages.Logout", "&c- &b(PLAYER)");
		config.set("Messages.Kick", "&c- &b(PLAYER)");
		config.set("Messages.Ban", "&c- &b(PLAYER)");
		config.save(userData);
		
		e.setJoinMessage(plugin.getMessage().format(config.getString("Messages.Prefix") + config.getString("Messages.Login").replace("(PLAYER)", e.getPlayer().getName())));
		
	}
	
}
