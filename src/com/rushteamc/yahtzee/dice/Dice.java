package com.rushteamc.yahtzee.dice;

import java.util.Random;

public class Dice implements IDice
{
	private int dieSize;
	private int dieValue;
	private boolean isActive;
	private boolean isDieHeld;
	
	public Dice(int size)
	{
		
		setActive(true);
		setSize(size);
		holdDie(false);
		roll();
	
	}
	
	public Dice()
	{
		
		setActive(true);
		setSize(6);
		holdDie(false);
		roll();
	
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
				
				}
			this.isDieHeld = false;
			return this.dieValue;
		
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