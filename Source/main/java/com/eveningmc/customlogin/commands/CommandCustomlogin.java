package com.eveningmc.customlogin.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.base.BaseCommand;
import com.eveningmc.customlogin.exceptions.InsufficientPermissionException;
import com.eveningmc.customlogin.exceptions.NotEnoughArgumentsException;
import com.eveningmc.customlogin.exceptions.PlayerOnlyException;
import com.eveningmc.customlogin.exceptions.TooManyArgumentsException;

public class CommandCustomlogin extends BaseCommand
{
	
	private HashMap < String, Integer > helpInfo;
	
	public CommandCustomlogin()
    {
		
	    super("customlogin", "base", "Main command for Customlogin!", "/customlogin <args>", "customlogin");
	    
    }
	
	
	
	@Override
    public void onCommand(CommandSender sender, Command command, String label, String[] args) 
    		throws InsufficientPermissionException, NotEnoughArgumentsException, PlayerOnlyException, TooManyArgumentsException
    {
		
		Player player = (Player) sender;
		
		if(sender.hasPermission(this.getPermission()))
		{
			
			if(args.length < 1)
			{
				
				player.sendMessage(Customlogin.getInstance().getMessage().formatMessage("Plugin by EveningMC / Eveninglight | Version: " + Customlogin.getInstance().getDescription().getVersion()));
				player.sendMessage(Customlogin.getInstance().getMessage().formatMessage("Type /customlogin help < Player | Staff | Admin > for command help!"));
				
			/* Help Command */	
				
			} else if(args[0].equalsIgnoreCase("help"))
			{
				if(args.length < 1)
				{
					
					player.sendMessage(Customlogin.getInstance().getMessage().formatMessage("Type /customlogin help < Player | Staff | Admin > for command help!"));
					
				}
				
				if(sender.hasPermission("customlogin.help"))
				{
				
					if(args[1].toLowerCase().startsWith("player"))
					{
					
						player.sendMessage(Customlogin.getInstance().getMessage().formatMessage("Player Commands:"));
					
					}
					
				} else
				{
					
					throw new InsufficientPermissionException();
					
				}
				
				if(sender.hasPermission("custonlogin.help.staff"))
				{
				
					if(args[1].toLowerCase().startsWith("staff"))
					{
					
						player.sendMessage(Customlogin.getInstance().getMessage().formatMessage("Staff Commands:"));
					
					}
					
				} else
				{
					
					throw new InsufficientPermissionException();
					
				}
				
				if(sender.hasPermission("customlogin.help.admin"))
				{
					
					if(args[1].toLowerCase().startsWith("admin"))
					{
						
						player.sendMessage(Customlogin.getInstance().getMessage().formatMessage("Admin Commands:"));
						player.sendMessage(Customlogin.getInstance().getMessage().format("Reload: /customlogin reload - Reload the plugin!"));
					
					} else
					{
						
						player.sendMessage(Customlogin.getInstance().getMessage().formatError(args[1] + "is an invalid page, type /customlogin help < Player | Staff | Admin >"));
						
					}
					
				} else
				{
					
					throw new InsufficientPermissionException();
					
				}
				
			}
			
		} else
		{
			
			throw new InsufficientPermissionException();
			
		}
		
    }	
	
}
