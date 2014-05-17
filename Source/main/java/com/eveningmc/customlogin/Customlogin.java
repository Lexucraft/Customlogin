package com.eveningmc.customlogin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.eveningmc.customlogin.base.BaseCommand;
import com.eveningmc.customlogin.commands.CommandCustomlogin;
import com.eveningmc.customlogin.events.onJoin;
import com.eveningmc.customlogin.events.onQuit;
import com.eveningmc.customlogin.util.Message;

public class Customlogin extends JavaPlugin
{
	
	public static PluginManager pm;
	public String pluginName;
	public BaseCommand command;

	public FileConfiguration config = null;
	public File userData = null;
	public File playerDir = null;

	public FileConfiguration config2 = null;
	public File configuration = null;
	
	private Economy eco = null;
	Player player = null;
	
	public Message message;
	
	public void load()
	{
		
		setPluginManager(this.getServer().getPluginManager());
		
		
	}
	
	public void onEnable()
	{
		
		this.setMessage(new Message());
		this.getServer().getPluginManager().registerEvents(new onJoin(this), this);
		this.getServer().getPluginManager().registerEvents(new onQuit(this), this);
		
		getCommand("customlogin").setExecutor(new CommandCustomlogin());
		configFile();
		
		setupEconomy();
		
	}
	
	public void onDisable()
	{
		
		this.setMessage(null);
		
	}
	
	public static Customlogin getInstance()
	{
		
		return (Customlogin)Bukkit.getServer().getPluginManager().getPlugin("Customlogin");
		
	}
	
	public static PluginManager getPluginManager()
	{
		
		return pm;
		
	}
	
	private static void setPluginManager(PluginManager plm)
	{
		
		pm = plm;
		
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
	
	private boolean setupEconomy()
    {
		
		if(getServer().getPluginManager().getPlugin("Vault") == null)
		{
			
			Message.log(Level.WARNING, "Vault was not found, disabling economy support!");
			this.getConfig().set("Economy-Support", false);
			return false;
			
		}
		
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) 
        {
        	
            eco = economyProvider.getProvider();
            
        }

        return (eco != null);
    }
	
	private void configFile()
	{
		
		configuration = new File(getDataFolder(), "config.yml");
		config2 = YamlConfiguration.loadConfiguration(configuration);
		
		if(!configuration.exists())
		{
			
			try
            {
				
	            configuration.createNewFile();
	            config2.set("Auto-Update", false);
	            config2.set("Economy-Support", true);
	            config2.set("Debug", false);
	            config2.set("Notify-Updated", true);
	            config2.set("User-Files", true);

	            config2.set("Messages.Prefix", "&9Customlogin > &r");
	            config2.set("Messages.Login", "&2+ &6(PLAYER)");
	            config2.set("Messages.Logout", "&4- &6(PLAYER)");
	            
            } catch (IOException e)
            {
            	
	            e.printStackTrace();
	            
            }
			
			try
            {
				
	            config2.save(configuration);
	            
            } catch (IOException e)
            {
            	
	            e.printStackTrace();
	            
            }
			
		}
		
	}
	
}
