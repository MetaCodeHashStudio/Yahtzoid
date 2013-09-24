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
						com.rushteamc.yahtzee.gui.utils.GameSetupStates.getSelectedButtonText(PlayerNumbers.numPlayersGroup);
						
							
						
						com.rushteamc.yahtzee.gui.PlayerNumbers.contentPane.setVisible(false);
					}
				}
		);
	}
}
