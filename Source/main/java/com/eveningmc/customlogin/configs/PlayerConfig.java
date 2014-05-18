package com.eveningmc.customlogin.configs;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.util.Message;

public class PlayerConfig
{
	
	private static String fileName;
	private static File playerDir;
	private static File userData;
	private static FileConfiguration config;
	
	private static String playerName = null;
	
	public PlayerConfig(String fileName)
	{
		
		PlayerConfig.fileName = fileName;
		playerDir = new File(Customlogin.getInstance().getDataFolder(), "/userdata/");
		userData = null;
		config = null;
		reload();
		
	}
	
	public static FileConfiguration getConfig(String player)
	{
		
		if(config == null)
		{
			
			reload();
			
		}
		
		return config;
		
	}
	
	public static void reload()
	{
		
		if(!playerDir.exists())
		{
			
			try
			{
				
				if(playerDir.mkdir())
				{
					
					Message.log(Level.INFO, "Try to create folder: " + playerDir.getName());
					
				} else
				{
					
					Message.log(Level.WARNING, "Failed to create folder: " + playerDir.getName());
					
				}
				
			} catch (Exception e)
			{
				
				
				
			}
			
		}
		
		userData = new File(playerDir, fileName);
		if(!userData.exists())
		{
			
			try
			{
				
				userData.createNewFile();

	    		set("Messages.Prefix", "&9Customlogin > ");
	    		set("Messages.Login", "&2+ &6(PLAYER)");
	    		set("Messages.Logout", "&4- &6(PLAYER)");
				
			} catch (IOException e)
			{
				
				e.printStackTrace();
				
			}
			
			save(playerName);
			
		}
		
		config = YamlConfiguration.loadConfiguration(userData);
		
	}
	
	public static void save(String player)
	{
		
		if(config == null)
		{
			
			return;
			
		}
		
		try
		{
			
			config.save(userData);
			
		} catch (IOException e)
		{
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void set(String path, Object o)
	{
		
		getConfig(playerName).set(path, o);
		
	}
	
}
