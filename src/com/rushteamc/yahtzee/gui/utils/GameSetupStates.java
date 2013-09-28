package com.rushteamc.yahtzee.gui.utils;
import com.rushteamc.yahtzee.gui.PlayerNames;
import com.rushteamc.yahtzee.gui.PlayerNumbers;

public class GameSetupStates
{
		public static int getSelectedNumbersOfPlayers()
		{
			for (int i = 0 ; i < PlayerNumbers.rdNumPlayers.length ; i++)
			{
				if(PlayerNumbers.rdNumPlayers[i].isSelected())
				{
					return (i+1);
				}
			}
			System.err.println("ERROR: Problem in player selection! Program will now exit.");
			System.exit(0);
			return 0;
		}
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
