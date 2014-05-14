package com.eveningmc.customlogin.exceptions;

public class OutdatedConfigException extends Exception
{
	
    private static final long serialVersionUID = -6503879596824492237L;	
	
    public OutdatedConfigException()
    {
    	
    	super("Your config version is out of date, please remove it and generate a new one!");
    	
    }
    
}
