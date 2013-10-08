package com.rushteamc.yahtzee.gui;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.imageio.ImageIO;

import com.rushteamc.yahtzee.utils.Variables;
import com.rushteamc.yahtzee.gui.utils.GUIVariables;

import java.awt.Toolkit;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JPanel rightPanel;
	private JPanel leftPanel;
	private JLabel lblScoreSheet;
	
	public static JLabel[][] lblGraphicalScores;
	public static JLabel[] lblPlayerNames;
	public static JLabel[] lblScoreTypes;
	public static JButton[] btnHoldDie;
	public static ImageIcon[] dieIcon;
	public static Image[] dieImages;

	/**
	 * Create the frame.
	 */
	public GUI()
	{
//		buildPanels();
//		setPanels();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, GUIVariables.buildContentPaneWidth(), GUIVariables.CONTENT_PANE_HEIGHT);
		setTitle(Variables.APPLICATION_TITLE);

		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = GUIVariables.contentPaneXDimensions;
		gbl_contentPane.rowHeights = GUIVariables.buildContentPaneYDimensions();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(gbl_contentPane);
		setContentPane(contentPane);
		
		leftPanel = new JPanel();
		leftPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftPanel.setBackground(Color.WHITE);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = GUIVariables.buildLeftPaneXDimensions(); // Should return 6*80 for 4 players, 3*80 for 1 player.
		gbl_leftPanel.rowHeights = GUIVariables.buildLeftPaneYDimensions();
		leftPanel.setLayout(gbl_leftPanel);
		GridBagConstraints gbc_leftPanel = new GridBagConstraints();
		gbc_leftPanel.fill = GridBagConstraints.BOTH;
		gbc_leftPanel.gridx = 0;
		gbc_leftPanel.gridy = 0;
		gbc_leftPanel.gridheight = 6;
		gbc_leftPanel.insets = new Insets(10, 10, 10, 10);
		contentPane.add(leftPanel, gbc_leftPanel);
				
		rightPanel = new JPanel();
		GridBagLayout gbl_rightPanel = new GridBagLayout();
		gbl_rightPanel.columnWidths = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50};
		gbl_rightPanel.rowHeights = new int[]{48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48};
		rightPanel.setLayout(gbl_rightPanel);
		GridBagConstraints gbc_rightPanel = new GridBagConstraints();
		gbc_rightPanel.insets = new Insets(10, 10, 10, 10);
		gbc_rightPanel.gridx = 1;
		gbc_rightPanel.gridy = 0;
		gbc_rightPanel.gridheight = 6;
		contentPane.add(rightPanel, gbc_rightPanel);
		
		int labelsXPos = 0;
		int labelsYStart = 2;
		
		lblScoreSheet = new JLabel("Score sheet");
		GridBagConstraints gbc_lblScoreSheet = new GridBagConstraints();
		gbc_lblScoreSheet.anchor = GridBagConstraints.NORTH;
		gbc_lblScoreSheet.gridwidth = 8;
		gbc_lblScoreSheet.insets = new Insets(0, 0, 5, 0);
		gbc_lblScoreSheet.gridx = labelsXPos;
		gbc_lblScoreSheet.gridy = 0;
		leftPanel.add(lblScoreSheet, gbc_lblScoreSheet);
		
		
		lblScoreTypes = new JLabel[Variables.scoreTypes.length];
		GridBagConstraints[] gbc_lblScoreTypes = new GridBagConstraints[Variables.scoreTypes.length];
		
		for(int i = 0 ; i < Variables.scoreTypes.length; i++)
		{
			gbc_lblScoreTypes[i] = new GridBagConstraints(); 				// Pre-init
			gbc_lblScoreTypes[i].gridx = labelsXPos;
			gbc_lblScoreTypes[i].gridy = labelsYStart+i;
			lblScoreTypes[i] = new JLabel(Variables.scoreTypes[i]);
			leftPanel.add(lblScoreTypes[i], gbc_lblScoreTypes[i]);
		}
		
		lblGraphicalScores = new JLabel[Variables.selectedNumPlayers][Variables.scoreTypes.length];
		lblPlayerNames = new JLabel[Variables.selectedNumPlayers];
		GridBagConstraints[] gbc_lblPlayerNames = new GridBagConstraints[Variables.selectedNumPlayers];
		GridBagConstraints[][] gbc_lblGraphicalScores = new GridBagConstraints[Variables.selectedNumPlayers][Variables.scoreTypes.length];

		for(int i = 0 ; i < Variables.selectedNumPlayers ; i++)
		{
			
			gbc_lblPlayerNames[i] = new GridBagConstraints();
			gbc_lblPlayerNames[i].gridx = labelsXPos+2+i;
			gbc_lblPlayerNames[i].gridy = labelsYStart-1;
			lblPlayerNames[i] = new JLabel(Variables.playerNames.get(i));
			leftPanel.add(lblPlayerNames[i], gbc_lblPlayerNames[i]);
			
			for(int j = 0 ; j < Variables.scoreTypes.length ; j++)
			{
			gbc_lblGraphicalScores[i][j] = new GridBagConstraints(); 				// Pre-init
			gbc_lblGraphicalScores[i][j].gridx = labelsXPos+2+i;
			gbc_lblGraphicalScores[i][j].gridy = labelsYStart+j;
			lblGraphicalScores[i][j] = new JLabel("0"); 							// Pre-init
			leftPanel.add(lblGraphicalScores[i][j], gbc_lblGraphicalScores[i][j]);
			}
		}
		btnHoldDie = new JButton[6];
		dieImages = new Image[6];
		dieIcon = new ImageIcon[6];
		GridBagConstraints[] gbc_btnHoldDie = new GridBagConstraints[btnHoldDie.length];
		GridBagConstraints[] gbc_dieIcon = new GridBagConstraints[dieIcon.length];
		for(int i = 0 ; i < btnHoldDie.length ; i++) /* PLACEHOLDER VALUE NEEDS CHANGING */
		{
			gbc_dieIcon[i] = new GridBagConstraints();
			gbc_dieIcon[i].gridx = i+1;
			gbc_dieIcon[i].gridy = 1;
			dieImages[i] = Toolkit.getDefaultToolkit().getImage("src/com/rushteamc/yahtzee/gui/img/Die_" + (i+1) + ".png");
			dieIcon[i] = new ImageIcon(dieImages[i]);
//			rightPanel.add(dieImages[i], gbc_dieIcon[i]);
			
			// Build dice pictures
			gbc_btnHoldDie[i] = new GridBagConstraints();
			gbc_btnHoldDie[i].gridx = i+1;
			gbc_btnHoldDie[i].gridy = 2;
			btnHoldDie[i] = new JButton("Hold");
			rightPanel.add(btnHoldDie[i],gbc_btnHoldDie[i]);
		}
		btnHoldDie[btnHoldDie.length-1].setVisible(false);
		//dieIcon[dieIcon.length-1].setVisible(false);
		// Build roll button
		
	}
}
