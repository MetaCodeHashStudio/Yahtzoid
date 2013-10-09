package com.rushteamc.yahtzee.utils;

import java.io.File;
import java.net.URISyntaxException;

public class FileHandling
{
	public static void setWorkingPaths() throws URISyntaxException
	{
		String tempPath = new File(FileHandling.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).toString();
		boolean isCompiled;
		if(tempPath.endsWith(".jar"))
		{
			isCompiled = true;
		}
		else
		{
			isCompiled = false;
		}
		if(!isCompiled)
			Variables.internalFilePath = "file:" + tempPath + "/";
		if(isCompiled)
			Variables.internalFilePath = "jar:file:" + tempPath + "!/"; 
	}
}
