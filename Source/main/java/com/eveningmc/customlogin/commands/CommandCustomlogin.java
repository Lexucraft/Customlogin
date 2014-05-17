package com.eveningmc.customlogin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.configs.PlayerConfig;
import com.eveningmc.customlogin.util.Message;

public class CommandCustomlogin implements CommandExecutor
{
	
	private Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("Customlogin");
	
	public CommandCustomlogin()
    {   
    }
	
    public boolean onCommand(CommandSender sender, Command command, String label, String args[])
    {
    	
		if(sender.hasPermission("customlogin.base"))
		{
			
			if(args.length < 1)
			{
				
				sender.sendMessage(Message.formatMessage("Plugin by EveningMC / Eveninglight | Version: " + Customlogin.getInstance().getDescription().getVersion()));
				sender.sendMessage(Message.formatMessage("Type /customlogin help <Player|Staff|Admin> for command help!"));
				return true;
				
				
			/* Help Command */	
				
			} else if(args[0].equalsIgnoreCase("help"))
			{
				
				if(!(args.length >= 1))
				{
					
					sender.sendMessage(Message.formatMessage("Type /customlogin help <Player|Staff|Admin> for Help"));
					return true;
					
				}
				
				if(sender.hasPermission("customlogin.help"))
				{
				
					if(args[1].toLowerCase().startsWith("player"))
					{
					
						sender.sendMessage(Message.formatMessage("Player Commands:"));
						return true;
						
					}
					
				} else
				{
					
					sender.sendMessage(Message.formatError("You do not have the required permissions to execute this command!"));
					return true;
					
				}
				
				if(sender.hasPermission("custonlogin.help.staff"))
				{
				
					if(args[1].toLowerCase().startsWith("staff"))
					{
					
						sender.sendMessage(Message.formatMessage("Staff Commands:"));
						sender.sendMessage(Message.format("Set: /customlogin set <prefix|join|quit> - Change Messages!"));
						return true;
						
					}
					
				} else
				{

					sender.sendMessage(Message.formatError("You do not have the required permissions to execute this command!"));
					return true;
					
				}
				
				if(sender.hasPermission("customlogin.help.admin"))
				{
					
					if(args[1].toLowerCase().startsWith("admin"))
					{
						
						sender.sendMessage(Message.formatMessage("Admin Commands:"));
						sender.sendMessage(Message.format("Reload: /customlogin reload - Reload the plugin!"));
						return true;
						
					} else
					{
						
						sender.sendMessage(Message.formatError("That page is invalid page, type /customlogin help <Player|Staff|Admin>"));
						return true;
						
					}
					
				} else
				{

					sender.sendMessage(Message.formatError("You do not have the required permissions to execute this command!"));
					return true;
					
				}
				
			} 
			
			
			/* Reload Command */
			else if(args[0].equalsIgnoreCase("reload"))
			{
				
				if(sender.hasPermission("customlogin.admin.reload"))
				{
					
					sender.sendMessage(Message.formatMessage("Reloading plugin..."));
					Bukkit.getServer().getPluginManager().disablePlugin(plugin);
					Bukkit.getServer().getPluginManager().enablePlugin(plugin);
					sender.sendMessage(Message.formatMessage("Plugin reloaded!"));
					
				} else
				{
					
					sender.sendMessage(Message.formatError("You do not have the required permissions to execute this command!"));
					
				}
				
			}
			
			
			/* Message Change Command */
			else if(args[0].equalsIgnoreCase("set"))
			{
				
				if(!(args.length > 1))
				{
					
					sender.sendMessage(Message.formatMessage("Type /customlogin set <Prefix|Join|Quit> to change a message!"));
					return true;
					
				}
				
				if(sender.hasPermission("customlogin.set.prefix"))
				{
				
					if(args[1].toLowerCase().startsWith("prefix"))
					{
						
						if(args.length > 1)
						{
							
							try
							{
								
								Customlogin.getInstance().getConfig().set("Messages.Prefix", Message.toString(args));
								Customlogin.getInstance().saveConfig();
								sender.sendMessage(Message.formatMessage("Prefix changed!"));
								
							} catch (Exception e)
							{
								
								e.printStackTrace();
								
							}
							
						}
						
					}
					
				} else
				{

					sender.sendMessage(Message.formatError("You do not have the required permissions to execute this command!"));
					return true;
					
				}
				
				if(sender.hasPermission("customlogin.set.join"))
				{
				
					if(args[1].toLowerCase().startsWith("join"))
					{
						
						if(args.length > 1)
						{
							
							try
							{
								
								Customlogin.getInstance().getConfig().set("Messages.Login", Message.toString(args));
								Customlogin.getInstance().saveConfig();
								sender.sendMessage(Message.formatMessage("Join message changed!"));
								
							} catch (Exception e)
							{
								
								e.printStackTrace();
								
							}
							
						}
						
						return true;
						
					}
					
				} else
				{

					sender.sendMessage(Message.formatError("You do not have the required permissions to execute this command!"));
					return true;
					
				}
				
				if(sender.hasPermission("customlogin.set.quit"))
				{
				
					if(args[1].toLowerCase().startsWith("quit"))
					{
						
						if(args.length > 1)
						{
							
							try
							{
								
								Customlogin.getInstance().getConfig().set("Messages.Logout", Message.toString(args));
								Customlogin.getInstance().saveConfig();
								sender.sendMessage(Message.formatMessage("Quit message changed!"));
								
							} catch (Exception e)
							{
								
								e.printStackTrace();
								
							}
							
						}
						return true;
						
					}
					
				} else
				{

					sender.sendMessage(Message.formatError("You do not have the required permissions to execute this command!"));
					return true;
					
				}
				
			}
			
			
			/* Personal Message Change Command */
			else if(args[0].equalsIgnoreCase("setp"))
			{
				
				if(!(sender instanceof Player))
				{
					
					sender.sendMessage(Message.formatError("Only ingame players can use this command"));
					
				} else
				{
					
					if(!(args.length > 1))
					{
					
						sender.sendMessage(Message.formatMessage("Type /customlogin setp <Prefix|Join|Quit> to change a message!"));
						return true;
					
					}
				
					if(sender.hasPermission("customlogin.setpersonal.prefix"))
					{
					
						if(args[1].toLowerCase().startsWith("prefix"))
						{
						
							if(args.length > 1)
							{
							
								try
								{

									PlayerConfig.getConfig().set("Messages.Prefix", Message.toString(args));
									PlayerConfig.save();
									sender.sendMessage(Message.formatMessage("Prefix changed!"));
								
								} catch (Exception e)
								{
								
									e.printStackTrace();
								
								}
							
							}
						
						}
					
					} else
					{

						sender.sendMessage(Message.formatError("You do not have the required permissions to execute this command!"));
						return true;
					
					}
				
					if(sender.hasPermission("customlogin.setpersonal.join"))
					{
				
						if(args[1].toLowerCase().startsWith("join"))
						{
						
							if(args.length > 1)
							{
							
								try
								{

									PlayerConfig.getConfig().set("Messages.Login", Message.toString(args));
									PlayerConfig.save();
									sender.sendMessage(Message.formatMessage("Join message changed!"));
								
								} catch (Exception e)
								{
								
									e.printStackTrace();
								
								}
							
							}
						
							return true;
						
						}
					
					} else
					{

						sender.sendMessage(Message.formatError("You do not have the required permissions to execute this command!"));
						return true;
					
					}
				
					if(sender.hasPermission("customlogin.setpersonal.quit"))
					{
				
						if(args[1].toLowerCase().startsWith("quit"))
						{
						
							if(args.length > 1)
							{
							
								try
								{
								
									PlayerConfig.getConfig().set("Messages.Logout", Message.toString(args));
									PlayerConfig.save();
									sender.sendMessage(Message.formatMessage("Quit message changed!"));
								
								} catch (Exception e)
								{
								
									e.printStackTrace();
								
								}
							
							}
							return true;
						
						}
					
					} else
					{

						sender.sendMessage(Message.formatError("You do not have the required permissions to execute this command!"));
						return true;
					}
					
				}
				
			}
			
		} else
		{

			sender.sendMessage(Message.formatError("You do not have the required permissions to execute this command!"));
			return true;
			
		}
		
		return true;
		
    }	
	
}
