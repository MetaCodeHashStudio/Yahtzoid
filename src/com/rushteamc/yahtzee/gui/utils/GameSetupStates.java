package com.rushteamc.yahtzee.gui.utils;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import com.rushteamc.yahtzee.gui.PlayerNames;

public class GameSetupStates
{
	
		public static String getSelectedButtonText(ButtonGroup numPlayersGroup)
		{
			for(Enumeration<AbstractButton> buttons = numPlayersGroup.getElements() ; buttons.hasMoreElements();)
			{
				AbstractButton button = buttons.nextElement();
					
				if (button.isSelected())
				{
					return button.getText();
				}
			}
			return null;
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
