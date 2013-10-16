package com.rushteamc.yahtzee.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rushteamc.yahtzee.Start;
import com.rushteamc.yahtzee.utils.Players;
import com.rushteamc.yahtzee.utils.Variables;
import com.rushteamc.yahtzee.gui.PlayerNames;



public class PlayerNamesHandlers
{
//	public static JRadioButton[] rdNumPlayers = com.rushteamc.yahtzee.gui.PlayerNumbers.rdNumPlayers;
	public static void generateNames()
	{
		PlayerNames.nextButton.addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					Players.deleteAllPlayerNames();
					int numPlayers = Variables.selectedNumPlayers;
					String[] playerNames = com.rushteamc.yahtzee.gui.utils.GameSetupStates.getSelectedStringText(numPlayers);
					
					for(int i = 0 ; i < numPlayers ; i++)
					{
						
						Variables.playerNames.add(playerNames[i]);
					
					}	
//					Players.getAllPlayerNames();
					com.rushteamc.yahtzee.Start.PlayerNamesFrame.setVisible(false);
					Start.startGame();

				}
			}
		);
        PlayerNames.quitButton.addActionListener
        (
        	new ActionListener()
        	{
        		@Override
       			public void actionPerformed(ActionEvent e)
        		{ 
        			System.exit(0);
        		} 
        	} 
        );
	}
}