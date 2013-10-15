package com.rushteamc.yahtzee.dice;

public interface IDice
{
	public boolean setSize(int size); // Sets the size of the die to the value int size.
	
	public int getSize(); // Returns the number of die faces as an integer if active. Else returns 0.
	
	public int getValue(); // Returns the current value of the die as an integer if active. Else returns 0.
	
	public boolean getValue(int checkForValue); // Returns true if the value passed as an argument is the value of the die.
	
	public boolean holdDie(); // Returns true after changing the die's hold state. false if failed.
	
	public boolean isHeld(); // Returns true if die is held. Else false.
	
	public int roll(); // Sets die as unheld and rolls it if active.
	
	public int reRoll(); // Rolls the die if, and only if, the die is both active and not held. Returns the integer rolled.
	
	public boolean getActive();
	
	public boolean setActive(boolean newState);
	
	public boolean toggleActive();

	public boolean setTo(int newValue);
	
	
}
