package com.rushteamc.yahtzee.gui.utils;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.util.Enumeration;

import com.rushteamc.yahtzee.gui.PlayerNumbers;
import com.rushteamc.yahtzee.utils.Variables;

public class GameSetupStates
{
	
		public static String getSelectedButtonText(ButtonGroup numPlayersGroup)
		{
			for(Enumeration<AbstractButton> buttons = numPlayersGroup.getElements() ; buttons.hasMoreElements();)
			{
				AbstractButton button = buttons.nextElement();
					
				if (button.isSelected())
				{
					System.out.println(button.getText());
					return button.getText();
				}
			}
			return null;
		}


	
}
