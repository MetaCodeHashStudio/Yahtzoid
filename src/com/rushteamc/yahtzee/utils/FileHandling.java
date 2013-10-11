package com.rushteamc.yahtzee.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;

public class FileHandling
{
	public static void setWorkingPaths() throws URISyntaxException
	{
		String separator = System.getProperty("file.separator");
		String tempPath = new File(FileHandling.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).toString();
		if(tempPath.endsWith(".jar"))
		{
			Variables.internalFilePath = "jar:file:" + tempPath + "!" + separator; 
		}
		else
		{
			Variables.internalFilePath = "file:" + tempPath + separator;
		}
	}
        public static void SaveGameState()
        {
        	String separator = System.getProperty("file.separator");
            PrintStream out = null;
            boolean success;
            String path = System.getProperty("user.home") + separator + ".yahtzoid" + separator;
            success = (new File(path + "save")).mkdirs();
            if (!success) {
                System.out.println("Shit! couldnt create folders!");
            }
        
            try
            {
                File newTextFile = new File(path + separator + "save" + separator +"gameSave.sav");
                
                FileWriter fw = new FileWriter(newTextFile);
                
                //Insert data into file
                for(int i = Variables.playerNames.size()-1; i >0; i--){
                    fw.write(Variables.playerNames.get(i) + ":" + ""); //Each Line populated: Playername:aceScore:twoScore ...etc... etc...
                }
                fw.close();   
            }
            catch (IOException iox) { 
                iox.printStackTrace();
            } 
            finally {
                if (out != null) out.close();
            }
    }
            
}

