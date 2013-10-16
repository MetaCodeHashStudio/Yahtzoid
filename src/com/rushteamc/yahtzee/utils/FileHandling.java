package com.rushteamc.yahtzee.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;

public class FileHandling
{              
	public static String getWorkingPaths() throws URISyntaxException
	{
		String separator = System.getProperty("file.separator");
		String filePath = new File(FileHandling.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).toString();
		
                if(filePath.endsWith(".jar"))
		{
			filePath = "jar:file:" + filePath + "!/"; 
			return filePath;
		}
		else
		{
			filePath = "file:" + filePath + separator;
			return filePath;
		}
	}
	public static String buildGamePath()
	{
		String separator = System.getProperty("file.separator");
		String path = System.getProperty("user.home") + separator + ".yahtzoid" + separator;
		return path;
	}
	public static void SaveGameState()
	{
		String path = buildGamePath();
		String separator = System.getProperty("file.separator");
		PrintStream out = null;
		boolean success;
            
		success = (new File(path + "save")).mkdirs();
		if (!success)
		{
			System.out.println("Shit! couldnt create folders!");
        }
        
		try
		{
			File newTextFile = new File(path + separator + "save" + separator +"gameSave.sav");
                
			FileWriter fw = new FileWriter(newTextFile);
                
			//Insert data into file
			for(int i = Variables.playerNames.size()-1; i >0; i--)
			{
				fw.write(Variables.playerNames.get(i) + ":" + ""); //Each Line populated: Playername:aceScore:twoScore ...etc... etc...
			}
			fw.close();   
		}
		catch (IOException iox)
		{ 
			iox.printStackTrace();
		} 
		finally
		{
			if (out != null) out.close();
		}
    }
        
    public static boolean generateFolders(String newFolderLocation)
    {
    	String path = buildGamePath();
        boolean createFolder = (new File(path+newFolderLocation)).mkdirs();
        return createFolder;
    }            
}

