package com.rushteamc.yahtzee.dice;

import java.util.Random;
/*
 * This class imports the data type Dice, which is a less abstract representation of a die 
 * than a simple integer. It has support for some simple logic checking.
 */
public class Dice implements IDice
{
	private int dieSize;
	private int dieValue;
	private boolean isActive;
	private boolean isDieHeld = false;
	
	public Dice(int size)
	{
		
		this.setActive(true);
		this.setSize(size);
		this.holdDie(false);
		this.roll();
	
	}
	
	public Dice()
	{
		
		this.setActive(true);
		this.setSize(6);
		this.holdDie(false);
		this.roll();
	
	}
	
		public int getSize()
		{
			
			return this.dieSize;
		
		}
		
		public int getValue()
		{
			
			if(isActive)
			{
				
				return this.dieValue;	
			
			}
			else
			{
				
				return 0;
			
			}
		
		}
		
		public boolean getValue(int checkForValue)
		{
			
			if(isActive)
			{
				if(this.dieValue == checkForValue)
				{
					return true;
				}
				else
				{
					return false;
				}
			}	
			else
			{
				return false;
			}
			
		}
		
		public boolean isHeld()
		{
			
			return this.isDieHeld;
		
		}
		public boolean setActive(boolean newState)
		{
			
			this.isActive = newState;
			return this.isActive;
		
		}
		
		public boolean toggleActive()
		{
			
			if(this.isActive)
				this.isActive = false;

			if(!this.isActive)
				this.isActive = true;

			return this.isActive;
			
		}
		public boolean getActive()
		{
			
			return this.isActive;
		
		}
		
		public int roll()
		{
			
			this.isDieHeld = false;
			if(this.isActive)
			{
				
				Random R = new Random();
				this.dieValue = (R.nextInt(this.dieSize)+1);	
			
			}
			
			return this.dieValue;
			
		}
		public int reRoll()
		{
			
			if(this.isActive)
				if(!this.isDieHeld)
				{
					
					Random R = new Random();
					this.dieValue = (R.nextInt(this.dieSize)+1);
					return this.dieValue;
				}
			return 0;
		
		}
		public boolean holdDie()
		{
			
			if(!this.isDieHeld)
				this.isDieHeld = true;
			if(this.isDieHeld)
				this.isDieHeld = false;
			
			return this.isDieHeld;
		
		}
		public void holdDie(boolean newState)
		{
			
			this.isDieHeld = newState;
		
		}
		public boolean setSize(int howLarge)
		{
			
			if(this.isActive)
			{
				
				this.dieSize = howLarge;
			
			}
			if(this.dieSize == howLarge)
			{
				
				return true;	
			
			}
			else
			{
				
				return false;
			
			}
			
		}
		
		public boolean setTo(int newValue)
		{
			
			if(this.isActive)
			{
				
				this.dieValue = newValue;
			
			}
			if(this.dieValue == newValue)
			{
				
				return true;
			
			}
			else
			{
				
				return false;
			
			}
			
		}

}