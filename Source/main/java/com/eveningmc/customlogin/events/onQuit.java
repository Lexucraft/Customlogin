package com.eveningmc.customlogin.events;

import java.io.IOException;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.configs.PlayerConfig;
import com.eveningmc.customlogin.util.Message;

public class onQuit implements Listener
{
	
	public Customlogin plugin;
	
	public onQuit(Customlogin plugin)
	{
		
		this.plugin = plugin;
		
	}
	
    @SuppressWarnings("unused")
    @EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) throws IOException
	{
		
    	if(Customlogin.getInstance().getConfig().getBoolean("User-Files"))
    	{
    		
    		PlayerConfig config = new PlayerConfig(e.getPlayer().getName() + ".yml");
    		
    		e.setQuitMessage(Message.format(PlayerConfig.getConfig(e.getPlayer().getName()).getString("Messages.Prefix").replace("(PLAYER)", e.getPlayer().getName()) + PlayerConfig.getConfig(e.getPlayer().getName()).getString("Messages.Logout").replace("(PLAYER)", e.getPlayer().getName())));
    	
    	} else
    	{
    		
    		e.setQuitMessage(Message.format(Customlogin.getInstance().getConfig().getString("Messages.Prefix").replace("(PLAYER)", e.getPlayer().getName()) + Customlogin.getInstance().getConfig().getString("Messages.Logout").replace("(PLAYER)", e.getPlayer().getName())));
    		
    	}
    	
	}
	
}
