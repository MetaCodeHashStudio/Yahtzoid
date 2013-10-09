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
        public static void SaveGameState()
        {
            PrintStream out = null;
            boolean success;
            
            String Name = System.getProperty("user.name"); 
            success = (new File("C:\\Users\\" + Name + "\\AppData\\Roaming\\.yahtzoid\\aaa")).mkdirs();
            if (!success) {
                System.out.println("Shit! couldnt create folders!");
            }
        
            try
            {
                File newTextFile = new File("C:\\Users\\" + Name + "\\AppData\\"
                        + "Roaming\\.yahtzoid\\aaa\\gameSave.sav");
                
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

