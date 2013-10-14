package com.rushteamc.yahtzee.dice;

public interface IDice
{
	public boolean setDieSize(int size);
	
	public int getDieSize();
	
	public boolean holdDie();
	
	public boolean isDieHeld();
	
	public int roll();
	
	public int reRoll();
	
	public boolean getActive();
	
	public boolean setActive();
	
	public boolean toggleActive();

	public boolean setDieFace(int newValue);
	
	
}
