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
	
	public PlayerConfig(String fileName)
	{
		
		PlayerConfig.fileName = fileName;
		playerDir = null;
		userData = null;
		config = null;
		reload();
		
	}
	
	public PlayerConfig(String folder, String fileName)
	{
		
		PlayerConfig.fileName = fileName;
		playerDir = new File(Customlogin.getInstance().getDataFolder(), folder);
		userData = null;
		config = null;
		reload();
		
	}
	
	public static FileConfiguration getConfig()
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
			
			save();
			
		}
		
		config = YamlConfiguration.loadConfiguration(userData);
		
	}
	
	public static void save()
	{
		
		if(config == null || userData == null)
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
		
		getConfig().set(path, o);
		
	}
	
}
