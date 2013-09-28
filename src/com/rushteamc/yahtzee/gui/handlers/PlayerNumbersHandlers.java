package com.rushteamc.yahtzee.gui.handlers;

import com.rushteamc.yahtzee.utils.Variables;
import com.rushteamc.yahtzee.gui.PlayerNumbers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerNumbersHandlers
{
//	public static JRadioButton[] rdNumPlayers = com.rushteamc.yahtzee.gui.PlayerNumbers.rdNumPlayers;
	public static void generateNumbers()
	{
		PlayerNumbers.nextButton.addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					Variables.selectedNumPlayers = com.rushteamc.yahtzee.gui.utils.GameSetupStates.getSelectedNumbersOfPlayers();
					com.rushteamc.yahtzee.Start.PlayerNumberFrame.setVisible(false);
					com.rushteamc.yahtzee.Start.continueToNames();
				}
			}
		);
        PlayerNumbers.quitButton.addActionListener
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
