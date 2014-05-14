package com.eveningmc.customlogin.managers;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.exceptions.OutdatedConfigException;

public class ConfigurationManager
{	
	
	private FileConfiguration config;
	private int pluginConfigVersion = 2;
	private int usedPluginVersion = 0;
	private String messages = null;
	private boolean debug = false;
	private boolean autoupdate = false;
	private boolean updatenote = true;
	private boolean userfiles = true;

	public ConfigurationManager()
	{

		if(!new File(Customlogin.getInstance().getDataFolder(), "config.yml").exists())
		{
			
			Customlogin.getInstance().saveResource("config.yml", false);
			this.setConfig(Customlogin.getInstance().getConfig());
			this.save();
			
		}
		else
		{
			
		    this.setConfig(Customlogin.getInstance().getConfig());
		    this.getConfig().getDefaults();
		    
		}

		try
		{
			
			this.load();
			
		}
		catch (OutdatedConfigException e)
		{
			
			e.printStackTrace();

		}

	}

	public void load() throws OutdatedConfigException
	{

		Customlogin.getInstance().reloadConfig();
		this.setUsedPluginVersion(Customlogin.getInstance().getConfig().getInt("configversion", 0));
		if(this.getPluginConfigVersion() == this.getPluginConfigVersion())
		{

		}
		else
		{

			throw new OutdatedConfigException();

		}
		this.setDebug(Customlogin.getInstance().getConfig().getBoolean("Debug", false));
		this.setUpdate(Customlogin.getInstance().getConfig().getBoolean("Auto-Update", false));
		this.setUpdateNote(Customlogin.getInstance().getConfig().getBoolean("Update-Notifacations", true));
		this.setUserFiles(Customlogin.getInstance().getConfig().getBoolean("User-Files", true));
		this.setMessages(Customlogin.getInstance().getConfig().getString("Messages", ""));
		this.setMessages(Customlogin.getInstance().getConfig().getString("Messages.Prefix", "&9Customlogin > "));
		this.setMessages(Customlogin.getInstance().getConfig().getString("Messages.Login", "&a+ &b(PLAYER)"));
		this.setMessages(Customlogin.getInstance().getConfig().getString("Messages.Logout", "&c- &b(PLAYER)"));
		this.setMessages(Customlogin.getInstance().getConfig().getString("Messages.Kick", "&c- &b(PLAYER)"));
		this.setMessages(Customlogin.getInstance().getConfig().getString("Messages.Ban", "&c- &b(PLAYER)"));
	}

	public void save()
	{

		Customlogin.getInstance().saveConfig();

	}

	public FileConfiguration getConfig()
	{

		return this.config;

	}

	private void setConfig(FileConfiguration config)
	{

		this.config = config;

	}


	public String getMessages()
	{

		return this.messages;

	}

	private void setMessages(String messages)
	{

		this.messages = messages;

	}


	public boolean getDebug()
	{

		return this.debug;

	}

	private void setDebug(boolean debug)
	{

		this.debug = debug;

	}

	public boolean getUpdate()
	{

		return this.autoupdate;

	}

	private void setUpdate(boolean autoupdate)
	{

		this.autoupdate = autoupdate;

	}

	public boolean getUpdateNote()
	{

		return this.updatenote;

	}

	private void setUpdateNote(boolean updatenote)
	{

		this.updatenote = updatenote;

	}

	public boolean getUserFiles()
	{

		return userfiles;

	}

	private void setUserFiles(boolean userfiles)
	{

		this.userfiles = userfiles;

	}

	public int getPluginConfigVersion()
	{

		return pluginConfigVersion;

	}

	public int getUsedPluginVersion()
	{

		return usedPluginVersion;

	}

	private void setUsedPluginVersion(int usedPluginVersion)
	{

		this.usedPluginVersion = usedPluginVersion;

	}
	
}
