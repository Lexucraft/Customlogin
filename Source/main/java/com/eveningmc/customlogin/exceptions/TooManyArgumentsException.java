package com.eveningmc.customlogin.exceptions;

import com.eveningmc.customlogin.base.BaseCommand;

public class TooManyArgumentsException extends Exception
{
	
    private static final long serialVersionUID = -139556879014479165L;
	
    public TooManyArgumentsException(BaseCommand command)
    {
    	
    	super("You have implemented too meny arguments, try the command like this: " + command.getHelp());
    	
    }
    
}
