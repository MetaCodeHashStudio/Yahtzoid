package com.rushteamc.yahtzee.dice;

public interface IDice
{
	public boolean setSize(int size);
	
	public int getSize();
	
	public int getValue();
	
	public boolean holdDie();
	
	public boolean isHeld();
	
	public int roll();
	
	public int reRoll();
	
	public boolean getActive();
	
	public boolean setActive(boolean newState);
	
	public boolean toggleActive();

	public boolean setTo(int newValue);
	
	
}
