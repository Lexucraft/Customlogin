package com.eveningmc.customlogin.util;

import java.util.logging.Level;

import org.bukkit.ChatColor;

import com.eveningmc.customlogin.Customlogin;

public class Message
{
	
	public static void log(String message)
	{
		
		Customlogin.getInstance().getLogger().info(message);
		
	}
	
	public static void log(Level level, String message)
	{
		
		Customlogin.getInstance().getLogger().log(level, message);
		
	}
	
	public static void debug(String message)
	{
		
		if(Customlogin.getInstance().getConfig().getString("Debug") != null)
		{
			
			log("< DEBUG > " + message);
			
		}
		
	}
	
	public static void debug(Level level, String message)
	{
		
		if(Customlogin.getInstance().getConfig().getString("Debug") != null)
		{
			
			log(level, "< DEBUG > " + message);
			
		}
		
	}
	
	public static String format(String message)
	{
		
		return ChatColor.translateAlternateColorCodes('&', message);
		
	}
	
	public static String formatMessage(String message)
	{
		
		return (new StringBuilder(String.valueOf(format((new StringBuilder("&9")).append(Customlogin.getInstance().getName()).append(" > &a").toString())))).append(message).toString();
		
	}
	
	public static String formatError(String error)
	{
		
		return (new StringBuilder(String.valueOf(format((new StringBuilder("&9")).append(Customlogin.getInstance().getName()).append(" > &c").toString())))).append(error).toString();
		
	}
	
	public static String toString(String arguments[])
	{
		
		String returnString = "";
		for(int count = 2; count < arguments.length; count++)
		{

			if(count == 2)
			{
				
				returnString = arguments[count];
				
			} else
			{
				
				returnString = returnString + " " + arguments[count];
				
			}

		}

		return returnString;
		
	}
	
}
