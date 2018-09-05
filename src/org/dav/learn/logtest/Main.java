package org.dav.learn.logtest;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main
{
	static
	{
		String currentPath = System.getProperty("user.home");
		System.out.println(currentPath);
		
		InputStream input = null;
		try
		{
			input = new FileInputStream(currentPath + File.separator + "lt_logging.properties");
		}
		catch (FileNotFoundException e)
		{}
		
		if (input != null)
		{
			LogManager manager = LogManager.getLogManager();
			try
			{
				manager.readConfiguration(input);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	private static final Logger logger = Logger.getLogger(Main.class.getName());
	
	
	public static void main(String[] args)
	{
		try
		{
			throw new Exception("Test exception!");
		}
		catch (Exception e)
		{
			logger.log(Level.SEVERE, "Exception: ", e);
		}
	}
}
