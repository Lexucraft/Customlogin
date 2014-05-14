package com.eveningmc.customlogin.base;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.eveningmc.customlogin.exceptions.InsufficientPermissionException;
import com.eveningmc.customlogin.exceptions.NotEnoughArgumentsException;
import com.eveningmc.customlogin.exceptions.PlayerOnlyException;
import com.eveningmc.customlogin.exceptions.TooManyArgumentsException;

public abstract class BaseCommand
{	
	
	private String command;
	private String permission;
	private String desc;
	private String help;
	private String name;
	
	public BaseCommand(String command, String permission, String desc, String help, String name)
	{
		
		this.setCommand(command);
		this.setPermission(permission);
		this.setDesc(desc);
		this.setHelp(help);
		this.setName(name);
		
	}
	
	public String getCommand()
	{
		
		return command;
		
	}
	
	private void setCommand(String command)
	{
		
		this.command = command;
		
	}
	
	public String getPermission()
	{
		
		return "togglepm.toggle" + this.permission;
		
	}
	
	private void setPermission(String permission)
	{
		
		this.permission = permission;
		
	}
	
	public String getDesc()
	{
		
		return desc;
		
	}
	
	private void setDesc(String desc)
	{
		
		this.desc = desc;
		
	}
	
	public String getHelp()
	{
		
		return help;
		
	}
	
	private void setHelp(String help)
	{
		
		this.help = help;
		
	}
	
	public String getName()
	{
		
		return name;
		
	}
	
	private void setName(String name)
	{
		
		this.name = name;
		
	}
	
	public abstract void onCommand(CommandSender sender, Command command, String label, String[] args)
					throws InsufficientPermissionException, NotEnoughArgumentsException, PlayerOnlyException, TooManyArgumentsException;
	
}
