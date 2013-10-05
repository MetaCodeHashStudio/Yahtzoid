package com.rushteamc.yahtzee.gui.utils;

import com.rushteamc.yahtzee.utils.Variables;

public class GUIVariables
{
	private static final int CONTENT_PANE_RIGHT_WIDTH = 480;
	public static final int CONTENT_PANE_HEIGHT = 768;
	private static final int CONTENT_PANE_ROWS = 6;
	private static final int CONTENT_PANE_ROW_HEIGHT = CONTENT_PANE_HEIGHT / CONTENT_PANE_ROWS;
	public static int[] contentPaneXDimensions = new int[]{buildLeftPaneWidth(), CONTENT_PANE_RIGHT_WIDTH};
	private static final int LEFT_PANE_COLUMN_WIDTH = 80;
	
	public static int contentPaneWidth;
	private static int contentPaneLeftWidth;
	private static int contentPaneLeftHeight;
	private static int contentPaneRightWidth;
	private static int contentPaneRightHeight;
	
	public static int[] buildContentPaneYDimensions()
	{
		int[] contentPaneYDimensions = new int[CONTENT_PANE_ROWS];
		for(int i = 0 ; i < contentPaneYDimensions.length ; i++)
		{
			contentPaneYDimensions[i] = CONTENT_PANE_ROW_HEIGHT;
		}
		return contentPaneYDimensions;
	}
	public static int buildContentPaneWidth()
	{
		contentPaneWidth = CONTENT_PANE_RIGHT_WIDTH + buildLeftPaneWidth() + 64;
		
		
		return contentPaneWidth;
	}
	
	public static int buildLeftPaneWidth()
	{
		contentPaneLeftWidth = (Variables.selectedNumPlayers+2) * LEFT_PANE_COLUMN_WIDTH;
		return contentPaneLeftWidth;
	}
	
	public static int[] buildLeftPaneXDimensions()
	{
		int[] leftPaneXDimensions = new int[Variables.selectedNumPlayers+2];
		for(int i = 0 ; i < leftPaneXDimensions.length ; i++)
		{
			leftPaneXDimensions[i] = LEFT_PANE_COLUMN_WIDTH;
		}
		return leftPaneXDimensions;
	}

}
