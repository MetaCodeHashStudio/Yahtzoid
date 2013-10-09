package com.rushteamc.yahtzee.utils;

public class FileHandling
{
	public static void setWorkingPaths()
	{/*
		URL main = Start.class.getResource("Start.class");
		if (!"file".equalsIgnoreCase(main.getProtocol()))
			throw new IllegalStateException(""+main);
		String path = new String(main.getPath());
//		path = path.replace("file:", "");
		path = path.replace("Start.class", "");
		Variables.diceImagesPath = path + "gui/img/";
	 */
		if(Variables.isCompiled)
		{
			Variables.internalFilePath = "com/rushteamc/yahtzee/";
		}
		else
		{
			Variables.internalFilePath = "src/com/rushteamc/yahtzee/";
		}
			
	}
	
	
}
