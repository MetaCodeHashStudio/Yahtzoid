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
import com.rushteamc.yahtzee.utils.Variables;
import com.rushteamc.yahtzee.gui.GUI;

public class GUIHandlers
{
	
	private static boolean diceRolled = false;
	
	public static void throwDiceHandler()
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

							for(int i = 0 ; i < Variables.dice.length ; i++)
							{
								if(Variables.dice[i].isHeld())
								{
									System.out.println("Die number " + (i+1) + " is held and has value " + Variables.dice[i].getValue());
								}
								Variables.dice[i].reRoll();
								if(Variables.dice[i].getActive())
									try
									{
										URL imageUrl = GUI.imageUrl[(Variables.dice[i].getValue())-1];
										InputStream streamToInsert = new URL(imageUrl.toString()).openStream();
//										System.out.println("Attempting to read file for die value " + dice[i] + ", from die number " + (i+1));
										BufferedImage imageToInsert = ImageIO.read(streamToInsert);
										GUI.btnDieIcon[i].setIcon(new ImageIcon(imageToInsert));
									}
									catch(IOException error)
									{
										error.printStackTrace();
									}
							}
							for(int j = 0 ; j < Variables.dice.length ; j++)
							{
								System.out.println("Die " + (j+1) + " has the value " + Variables.dice[j].getValue()) ;
							}
							diceRolled = true;
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
						if(!Variables.dice[buttonNumber].isHeld() && diceRolled)
						{
							GUI.lblHoldDie[buttonNumber].setVisible(true);
							Variables.dice[buttonNumber].holdDie(true);
						}
						else
						{
							GUI.lblHoldDie[buttonNumber].setVisible(false);
							Variables.dice[buttonNumber].holdDie(false);
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
							int buttonNumber;
							if(e.getActionCommand().toString().length() == 12)
								buttonNumber = Character.getNumericValue((e.getActionCommand().toString()).charAt(11));
							else
							{
								String preProcessed = e.getActionCommand().toString();
								String postProcessed = preProcessed.substring(11);
								buttonNumber = Integer.parseInt(postProcessed);
							}
							
							System.out.println(buttonNumber);
							int scoreToAdd = Game.checkForScore(buttonNumber, Variables.dice);
							GUI.lblGraphicalScores[Variables.turnNumber][buttonNumber].setText(Integer.toString(scoreToAdd));
//							GUI.btnSetScore[buttonNumber].setVisible(false);
							Variables.playerHasAddedScore[Variables.turnNumber][buttonNumber] = true;
							int playerNumber = 0;
							try {
								playerNumber = Game.endTurn();
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							diceRolled = false;
							GUI.reArm(playerNumber);
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
