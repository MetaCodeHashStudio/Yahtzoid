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
				public void actionPerformed(ActionEvent arg0)
				{
					String numPlayers = com.rushteamc.yahtzee.gui.utils.GameSetupStates.getSelectedButtonText(PlayerNumbers.numPlayersGroup);
					Variables.selectedNumPlayers = numPlayers.charAt(0) - 48; // Why the hell do I need to subtract 48?!
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
