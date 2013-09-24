package com.rushteamc.yahtzee.gui.handlers;

import com.rushteamc.yahtzee.utils.Variables;
import com.rushteamc.yahtzee.gui.PlayerNames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
					int numPlayers = Variables.selectedNumPlayers;
					String[] playerNames = com.rushteamc.yahtzee.gui.utils.GameSetupStates.getSelectedStringText(numPlayers);

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