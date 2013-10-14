package com.rushteamc.yahtzee.dice;

public interface IDice
{
	public boolean setDieSize(int size);
	
	public int getDieSize();
	
	public boolean holdDie();
	
	public boolean isDieHeld();
	
	public int roll();

	public boolean setDieFace(int newValue);
	
	
}
