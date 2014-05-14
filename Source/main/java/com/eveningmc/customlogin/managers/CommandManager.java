package com.eveningmc.customlogin.managers;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.base.BaseCommand;
import com.eveningmc.customlogin.commands.CommandCustomlogin;
import com.eveningmc.customlogin.exceptions.InsufficientPermissionException;
import com.eveningmc.customlogin.exceptions.NotEnoughArgumentsException;
import com.eveningmc.customlogin.exceptions.PlayerOnlyException;
import com.eveningmc.customlogin.exceptions.TooManyArgumentsException;

public class CommandManager implements CommandExecutor
{

	private ArrayList<BaseCommand> commands = new ArrayList<BaseCommand>();

	public CommandManager()
	{
		
		this.addCommand(new CommandCustomlogin());
		
	}

	public ArrayList<BaseCommand> getCommands()
	{

		return this.commands;

	}

	public void addCommand(BaseCommand command)
	{

		if(this.getCommands().contains(command))
		{
			
			
			
		}
		else
		{

			this.getCommands().add(command);
			if(Customlogin.getInstance().getCommand(command.getCommand()) == null)
			{ 
				
				System.out.println("Command null"); 
				
				} else 
				{ 
					
					Customlogin.getInstance().getCommand(command.getCommand()).setExecutor(this);
				
			}
			
		}

	}

	public void removeCommand(BaseCommand command)
	{

		if(!this.getCommands().contains(command))
		{
			
			

		}
		else
		{

			this.getCommands().remove(command);

		}

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arguments)
	{

		for(BaseCommand command : this.getCommands())
		{

			if(command.getCommand().equalsIgnoreCase(cmd.getLabel()))
			{

				try
				{

					command.onCommand(sender, cmd, label, arguments);
					return true;

				} 
				catch (InsufficientPermissionException e)
				{

					sender.sendMessage(Customlogin.getInstance().getMessage().formatError("You do not have the required permissions for this command!"));
					e.printStackTrace();
					return true;

				}
				catch (NotEnoughArgumentsException e)
				{

					sender.sendMessage(Customlogin.getInstance().getMessage().formatError("You have not provided enough arguments, please use /customlogin help for help!"));
					e.printStackTrace();
					return true;

				}
				catch(PlayerOnlyException e)
				{

					e.printStackTrace();
					return true;

				}
				catch(TooManyArgumentsException e)
				{

					sender.sendMessage(Customlogin.getInstance().getMessage().formatError("Too many arguments have been provivded, please use /customlogin help for help!"));
					e.printStackTrace();
					return true;

				}

			}

		}

		return true;
	}

}