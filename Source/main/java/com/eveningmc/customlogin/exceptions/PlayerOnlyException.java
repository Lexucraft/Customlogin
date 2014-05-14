package com.eveningmc.customlogin.exceptions;

public class PlayerOnlyException extends Exception
{
	
    private static final long serialVersionUID = 5665409576261194446L;	
	
    public PlayerOnlyException()
    {
    	
    	super("This command can only be used by an in-game player!");
    	
    }
    
}
