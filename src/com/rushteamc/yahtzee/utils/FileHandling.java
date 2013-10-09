package com.rushteamc.yahtzee.utils;

import java.io.File;
import java.net.URISyntaxException;

public class FileHandling
{
	public static void setWorkingPaths() throws URISyntaxException
	{/*
		URL main = Start.class.getResource("Start.class");
		if (!"file".equalsIgnoreCase(main.getProtocol()))
			throw new IllegalStateException(""+main);
		String path = new String(main.getPath());
//		path = path.replace("file:", "");
		path = path.replace("Start.class", "");
		Variables.diceImagesPath = path + "gui/img/";
	 */
		/*
		if(Variables.isCompiled)
		{
			Variables.internalFilePath = "./com/rushteamc/yahtzee/";
		}
		else
		{
			Variables.internalFilePath = "src/com/rushteamc/yahtzee/";
		}
		*/
		String tempPath = new File(FileHandling.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).toString();
		if(!Variables.isCompiled)
			Variables.internalFilePath = "file:" + tempPath+"/";
		if(Variables.isCompiled)
			Variables.internalFilePath = "file:" + tempPath + "!"; 
	}
	
	
}
