package com.eveningmc.customlogin.events;

import java.io.IOException;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.configs.PlayerConfig;
import com.eveningmc.customlogin.util.Message;

public class onJoin implements Listener
{
	
	public Customlogin plugin;
	
	public onJoin(Customlogin plugin)
	{
		
		this.plugin = plugin;
		
	}
	
    @SuppressWarnings("unused")
    @EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) throws IOException
	{
		
    	if(Customlogin.getInstance().getConfig().getBoolean("User-Files"))
    	{
    		
    		PlayerConfig config = new PlayerConfig(e.getPlayer().getName() + ".yml");
    		
    		e.setJoinMessage(Message.format(PlayerConfig.getConfig(e.getPlayer().getName()).getString("Messages.Prefix").replace("(PLAYER)", e.getPlayer().getName()) + PlayerConfig.getConfig(e.getPlayer().getName()).getString("Messages.Login").replace("(PLAYER)", e.getPlayer().getName())));
    	
    	} else
    	{
    		
    		e.setJoinMessage(Message.format(Customlogin.getInstance().getConfig().getString("Messages.Prefix").replace("(PLAYER)", e.getPlayer().getName()) + Customlogin.getInstance().getConfig().getString("Messages.Login").replace("(PLAYER)", e.getPlayer().getName())));
    		
    	}
    	
	}
	
}
