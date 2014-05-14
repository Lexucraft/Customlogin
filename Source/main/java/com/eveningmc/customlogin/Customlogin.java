package com.eveningmc.customlogin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.eveningmc.customlogin.events.onJoin;
import com.eveningmc.customlogin.events.onQuit;
import com.eveningmc.customlogin.managers.CommandManager;
import com.eveningmc.customlogin.util.Message;

public class Customlogin extends JavaPlugin
{
	
	private static Customlogin instance;
	public PluginManager pm;
	public String pluginName;
	public CommandManager cmd;
	
	public Message message;
	
	public void load()
	{
		
		setInstance(this);
		setPluginManager(this.getServer().getPluginManager());
		setPluginName(this.getDescription().getName());
		
	}
	
	public void onEnable()
	{
		
		this.setMessage(new Message());
		this.setCommandManager(new CommandManager());
		this.getServer().getPluginManager().registerEvents(new onJoin(this), this);
		this.getServer().getPluginManager().registerEvents(new onQuit(this), this);
		
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
	}
	
	public void onDisable()
	{
		
		this.setMessage(null);
		this.setCommandManager(null);
		
	}
	
	public static Customlogin getInstance()
	{
		
		return instance;
		
	}
	
	private void setInstance(Customlogin customlogin)
	{
		
		instance = customlogin;
		
	}
	
	public PluginManager getPluginManager()
	{
		
		return pm;
		
	}
	
	private void setPluginManager(PluginManager pm)
	{
		
		this.pm = pm;
		
	}
	
	public String getPluginName()
	{
		
		return pluginName;
		
	}
	
	private void setPluginName(String pluginName)
	{
		
		this.pluginName = pluginName;
		
	}
	
	/* Defining classes */
	
	public Message getMessage()
	{
		
		return this.message;
		
	}
	
	private void setMessage(Message message)
	{
		
		this.message = message;
		
	}
	
	public CommandManager getCommandManager()
	{
		
		return this.cmd;
		
	}
	
	private void setCommandManager(CommandManager cmd)
	{
		
		this.cmd = cmd;
		
	}
	
}
