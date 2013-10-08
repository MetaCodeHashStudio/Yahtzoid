package com.rushteamc.yahtzee.gui.handlers;

import com.rushteamc.yahtzee.gui.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.rushteamc.yahtzee.utils.RollDice;
import com.rushteamc.yahtzee.utils.Variables;

public class GUIHandlers
{
	public static void throwDiceHandler() throws IOException
	{
		GUI.btnRollDice.addActionListener
		(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{	
						int[] Dice = new int[Variables.standardNumberOfDice];
						Dice = RollDice.castDice();
						for(int i = 0 ; i < Dice.length ; i++)
						{
							File fileToInsert = new File("src/com/rushteamc/yahtzee/gui/img/Die_" + (Dice[i]) + ".png");
							try
							{
								BufferedImage imageToInsert = ImageIO.read(fileToInsert);
//								System.out.println("Attempting to update dice number " + i);
								GUI.btnDieIcon[i].setIcon(new ImageIcon(imageToInsert));
							}
							catch(IOException error)
							{
								error.printStackTrace();
							}
						}
					}
				}
		);
	}
	public static void holdDiceHandler()
	{
		
	}
}
