package com.rushteamc.yahtzee.dice;

import java.util.Random;

public class Dice implements IDice
{
	private int dieSize;
	private int dieValue;
	private boolean isActive;
	private boolean isDieHeld;
	
		public int getDieSize()
		{
			return dieSize;
		}
		
		public boolean isDieHeld()
		{	
			return isDieHeld;
		}
		public boolean setActive(boolean newState)
		{
			isActive = newState;
			return isActive;
		}
		public boolean toggleActive()
		{
			if(isActive)
			{
				isActive = false;
			}
			if(!isActive)
			{
				isActive = true;
			}
			return isActive;
		}
		public boolean getActive()
		{
			return isActive;
		}
		
		public int roll()
		{
			isDieHeld = false;
			if(isActive)
			{
				Random R = new Random();
				dieValue = (R.nextInt(dieSize)+1);	
			}
			return dieValue;
		}
		public int reRoll()
		{
			if(isActive)
				if(!isDieHeld)
				{
					Random R = new Random();
					dieValue = (R.nextInt(dieSize)+1);
				}
			isDieHeld = false;
			return dieValue;
		}
		public boolean holdDie()
		{
			
			if(!isDieHeld)
				isDieHeld = true;
			if(isDieHeld)
				isDieHeld = false;
			
			return isDieHeld;
		}
		public boolean setDieSize(int howLarge)
		{
			if(isActive)
			{
				dieValue = howLarge;
			}
			if(dieSize == howLarge)
			{
				return true;	
			}
			else
			{
				return false;
			}
			
		}
		
		public boolean setDieFace(int newValue)
		{
			
			if(isActive)
			{
				dieValue = newValue;
			}
			if(dieValue == newValue)
			{
				return true;
			}
			else
			{
			return false;
			}
			
		}
}
