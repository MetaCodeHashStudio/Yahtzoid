package com.rushteamc.yahtzee.gui.utils;
import com.rushteamc.yahtzee.gui.PlayerNames;

public class GameSetupStates
{
		public static String[] getSelectedStringText(int numPlayers)
		{
			String[] playerNames = new String[numPlayers];
			
			for(int i = 0 ; i < numPlayers ; i++)
			{
				playerNames[i] = (PlayerNames.txtPlayerNames[i]).getText();
			}			
			return playerNames;
		}
}
