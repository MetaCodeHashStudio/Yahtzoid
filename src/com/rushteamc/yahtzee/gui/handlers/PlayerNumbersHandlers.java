package com.rushteamc.yahtzee.gui.handlers;

import com.rushteamc.yahtzee.utils.Variables;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerNumbersHandlers
{
	public static void generateNumbers()
	{
		com.rushteamc.yahtzee.gui.PlayerNumbers.okButton.addActionListener
		(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						for (int i = 0 ; i < Variables.MAX_SUPPORTED_PLAYERS ; i++)
						{
							if(com.rushteamc.yahtzee.gui.PlayerNumbers.rdNumPlayers[i].isSelected())
							{
								Variables.selectedNumPlayers = i+1;
								com.rushteamc.yahtzee.gui.PlayerNames.main();
							}
						}
						if(Variables.selectedNumPlayers < 0)
						{
							com.rushteamc.yahtzee.gui.PlayerNumbers.notifyNoSelection();
						}
					}
				}
		);
	}
}
