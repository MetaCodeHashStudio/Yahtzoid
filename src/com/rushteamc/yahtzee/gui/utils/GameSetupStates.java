package com.rushteamc.yahtzee.gui.utils;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import com.rushteamc.yahtzee.gui.PlayerNames;
import com.rushteamc.yahtzee.gui.PlayerNumbers;
import com.rushteamc.yahtzee.utils.Variables;

public class GameSetupStates
{
		public static int getSelectedNumbersOfPlayers()
//		public static int getSelectedButtonText(ButtonGroup numPlayersGroup)
		{
			for (int i = 0 ; i < PlayerNumbers.rdNumPlayers.length ; i++)
			{
				System.out.println("Checking for numbers selection: " + (i+1));
				if(PlayerNumbers.rdNumPlayers[i].isSelected())
				{
					System.out.println("Found players selected: " + (i+1));
					return (i+1);
				}
				else
				{
					System.out.println("No selection found for: " + (i+1));
				}
			}
			System.out.println("FALLBACK: SELECTING 0 PLAYERS(THIS WILL NOW CRASH)");
			return 0;
			/*
			for(Enumeration<AbstractButton> buttons = numPlayersGroup.getElements() ; buttons.hasMoreElements();)
			{
				AbstractButton button = buttons.nextElement();
					
				if (button.isSelected())
				{
					return button.getText();
				}
			}
			*/
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
