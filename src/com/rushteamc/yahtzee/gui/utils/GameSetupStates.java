package com.rushteamc.yahtzee.gui.utils;

import com.rushteamc.yahtzee.gui.PlayerNumbers;
import com.rushteamc.yahtzee.utils.Variables;

public class GameSetupStates
{
	
	public static int rdPlayerButtonsSelected()
	{
		int maxPlayers = Variables.MAX_SUPPORTED_PLAYERS;
		int curPlayers = 0;
		
		for (int i = 0 ; i < maxPlayers ; i++)
		{
			if((PlayerNumbers.rdNumPlayers[i]).equals(true))
			{
				curPlayers = i;
				Variables.selectedNumPlayers = i;
			}
		}
		return curPlayers;
	}
	
}
