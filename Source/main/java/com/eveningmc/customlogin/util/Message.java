package com.eveningmc.customlogin.util;

import java.util.logging.Level;

import com.eveningmc.customlogin.Customlogin;

public class Message
{
	
	public void log(String message)
	{
		
		Customlogin.getInstance().getLogger().info(message);
		
	}
	
	public void log(Level level, String message)
	{
		
		Customlogin.getInstance().getLogger().log(level, message);
		
	}
	
	public void debug(String message)
	{
		
		if(Customlogin.getInstance().getConfig().getString("Debug") != null)
		{
			
			this.log("< DEBUG > " + message);
			
		}
		
	}
	
	public void debug(Level level, String message)
	{
		
		if(Customlogin.getInstance().getConfig().getString("Debug") != null)
		{
			
			this.log(level, "< DEBUG > " + message);
			
		}
		
	}
	
	public String format(String message)
	{
		
		message = message.replaceAll("&", "\247");
		return message;
		
	}
	
	public String formatMessage(String message)
	{

		return this.format("&9" + Customlogin.getInstance().getDescription().getName() + " > &a" + message);
		
	}
	
	public String formatError(String error)
	{
		
		return this.format("&9" + Customlogin.getInstance().getDescription().getName() + " > &c" + error);
		
	}
	
}
