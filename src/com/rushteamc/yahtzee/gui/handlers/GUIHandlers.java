package com.rushteamc.yahtzee.gui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.rushteamc.yahtzee.Game;
import com.rushteamc.yahtzee.utils.RollDice;
import com.rushteamc.yahtzee.utils.Variables;
import com.rushteamc.yahtzee.gui.GUI;

public class GUIHandlers
{
	
	private static boolean diceRolled = false;
	
	public static void throwDiceHandler() throws IOException
	{
		GUI.btnRollDice.addActionListener
		(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{	
						if(Variables.currentUsedRerolls != Variables.STANDARD_MAX_REROLLS)
						{
							int[] heldDice = new int[Variables.standardNumberOfDice];
							int[] dice = Variables.diceArray;
							if(diceRolled)
							{
								for(int i = 0 ; i < dice.length ; i++)
								{
									if(Variables.dieHeld[i])
									{
										heldDice[i] = dice[i];
										System.out.println("Die number " + (i+1) + " is held and has value " + heldDice[i]);
									}
								}
							}
							dice = RollDice.castDice();

							for(int i = 0 ; i < dice.length ; i++)
							{
								if(Variables.dieHeld[i])
								{
									dice[i] = heldDice[i];
									System.out.println();
								}
								try
								{
									URL imageUrl = GUI.imageUrl[dice[i]-1];
									InputStream streamToInsert = new URL(imageUrl.toString()).openStream();
//									System.out.println("Attempting to read file for die value " + dice[i] + ", from die number " + (i+1));
									BufferedImage imageToInsert = ImageIO.read(streamToInsert);
									GUI.btnDieIcon[i].setIcon(new ImageIcon(imageToInsert));
								}
								catch(IOException error)
								{
									error.printStackTrace();
								}

							Variables.dieHeld[i] = false;
							GUI.lblHoldDie[i].setText("Hold");
							}
							for(int j = 0 ; j < dice.length ; j++)
							{
								System.out.println("Die " + (j+1) + " has the value " + dice[j]) ;
							}
							diceRolled = true;
							Variables.diceArray = dice;
							Variables.currentUsedRerolls++;
						}
						else
						{
							GUI.noMoreRerollsError();
						}
					}
				}
		);
	}
	public static void holdDiceHandler()
	{
		for(int i = 0 ; i < GUI.btnDieIcon.length ; i++)
		{
			GUI.btnDieIcon[i].addActionListener
			(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						int buttonNumber = Character.getNumericValue((e.getActionCommand().toString()).charAt(10));
						System.out.println(buttonNumber);
						if(!diceRolled)
						{
							GUI.beforeRollingError();
						}
						if(Variables.currentUsedRerolls == Variables.STANDARD_MAX_REROLLS) // MUST BE MADE DYNAMIC BEFORE CARD IMPLEMENT'
						{
							GUI.noMoreRerollsError();
						}
						if(!Variables.dieHeld[buttonNumber] && diceRolled)
						{
							GUI.lblHoldDie[buttonNumber].setText("Release");
							Variables.dieHeld[buttonNumber] = true;
						}
						else
						{
							GUI.lblHoldDie[buttonNumber].setText("Hold");
							Variables.dieHeld[buttonNumber] = false;
						}
					}
				}
			);
		}
	}
	
	public static void addScoreHandler()
	{
		for(int i = 0 ; i < GUI.btnSetScore.length; i++)
		{
			GUI.btnSetScore[i].addActionListener
			(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						if(diceRolled)
						{
							int buttonNumber = Character.getNumericValue((e.getActionCommand().toString()).charAt(11));
							System.out.println(buttonNumber);
							int scoreToAdd = Game.checkForScore(buttonNumber, Variables.diceArray);
							GUI.lblGraphicalScores[Variables.turnNumber][buttonNumber].setText(Integer.toString(scoreToAdd));
						}
						else
						{
							GUI.beforeRollingError();
						}
					}
				}
			);
		}
	}
}
