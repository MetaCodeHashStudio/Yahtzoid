package com.rushteamc.yahtzee.dice;

public class Dice implements IDice
{
		public int getDieSize()
		{
			int dieSize = 0;
			
			return dieSize;
		}
		public boolean dieHeld()
		{
			boolean isDieHeld = false;
			
			return isDieHeld;
		}
		
		public int roll()
		{
			int value = 0;
			
			return value;
		}
		public boolean holdDie()
		{
			boolean holdSuccess = false;
			
			return holdSuccess;
		}
		public boolean setDieSize(int howLarge)
		{
			boolean setSuccess = false;
			
			int dieSize = 0;
			if(dieSize == howLarge)
				setSuccess = true;
			return setSuccess;
		}
		
		public boolean setDieFace(int newValue)
		{
			boolean setSuccess = false;
			int dieValue = 0;
			if(dieValue == newValue)
				setSuccess = true;
			/*
			 * Method should change the value of the die to the int newValue.
			 */
			return setSuccess;
		}
}
