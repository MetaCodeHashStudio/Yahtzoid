package com.rushteamc.yahtzee.gui.utils;

import com.rushteamc.yahtzee.utils.Variables;

public class GUIVariables
{
	private static final int CONTENT_PANE_RIGHT_WIDTH = 480;
	private static final int CONTENT_PANE_LEFT_WIDTH = 480;
	public static int[] contentPaneXDimensions = new int[]{CONTENT_PANE_LEFT_WIDTH, CONTENT_PANE_RIGHT_WIDTH};
	private static final int LEFT_PANE_GRID_WIDTH = 80;
	private static int[] leftPaneXDimensions;
	
	public static int[] buildLeftPaneXDimensions()
	{
		leftPaneXDimensions = new int[Variables.selectedNumPlayers+2];
		for(int i = 0 ; i < leftPaneXDimensions.length ; i++)
		{
			leftPaneXDimensions[i] = LEFT_PANE_GRID_WIDTH;
		}
		
		return leftPaneXDimensions;
	}
}
