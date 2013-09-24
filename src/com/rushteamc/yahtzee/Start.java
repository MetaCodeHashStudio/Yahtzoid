package com.rushteamc.yahtzee;

import java.awt.EventQueue;

public class Start
{

	public static void main(String[] args)
	{
		EventQueue.invokeLater
		(
			new Runnable() 
			{
				public void run()
				{
					try
					{
						com.rushteamc.yahtzee.gui.PlayerNumbers PlayerNumberFrame = new com.rushteamc.yahtzee.gui.PlayerNumbers();
						PlayerNumberFrame.setVisible(true);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		);
	}
	public static void setPlayerNumHandler()
	{
		com.rushteamc.yahtzee.gui.handlers.PlayerNumbersHandlers.generateNumbers();
	}
	public static void debugDie(int[] Die, int[] Values)
	{
		System.out.println("Die array looks like: ");
		for
		(
			int i = 0;
				i < Die.length;
				i++
		)
		{
			System.out.print(Die[i] + " ");
		}
		System.out.println();
		System.out.println("The values array now looks like: ");
		for (int i = 1; i <= com.rushteamc.yahtzee.utils.Configurables.getDieSize(); i++)
		{
			System.out.print(i+"\t");
		}
		System.out.println();
		for (int k = 0; k < com.rushteamc.yahtzee.utils.Configurables.getDieSize(); k++)
		{
			System.out.print(Values[k] + "\t");
		}
		System.out.println();
	}

}
