package com.eveningmc.customlogin.exceptions;

public class InsufficientPermissionException extends Exception
{
	
    private static final long serialVersionUID = -8459188162564444995L;	
	
    public InsufficientPermissionException()
    {
    	
    	super("Player has denied permission for this command!");
    	
    }
    
}
