package com.rushteamc.yahtzee.gui;

import com.rushteamc.yahtzee.utils.Variables;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class PlayerNumbers extends JFrame {

	private static final long serialVersionUID = 15465431564646L;
	public static JPanel contentPane;
//	public static JPanel mainPane;
//	public static PlayerNumbers dialog;
	public static JPanel buttonPane;
	public static JButton nextButton;
	public static JButton quitButton;
	public static JRadioButton[] rdNumPlayers;
	public static ButtonGroup numPlayersGroup;


	/**
	 * Create the dialog.
	 */
	public PlayerNumbers()
	{
		setTitle(Variables.APPLICATION_TITLE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		buttonPane = new JPanel();
//		mainPane = new JPanel();
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{90,90,90,90,90,90};
		gbl_contentPane.rowHeights = new int[]{60,60,60,60};
		contentPane.setLayout(gbl_contentPane);
		setComponent();
		com.rushteamc.yahtzee.Start.setPlayerNumHandler();
	}
	public void setComponent()
	{
		createButtonPane();
		createRadios();
		createNextButton();
		createQuitButton();
	}
	static void createButtonPane()
	{
		buttonPane = new JPanel();
		GridBagLayout gbl_buttonPane = new GridBagLayout();
		gbl_buttonPane.columnWidths = new int[]{90,90,90,90,90,90};
		gbl_buttonPane.rowHeights = new int[]{0,40,0};
		GridBagConstraints gbc_buttonPane = new GridBagConstraints();
		gbc_buttonPane.fill = GridBagConstraints.BOTH;
		gbc_buttonPane.gridx = 0;
		gbc_buttonPane.gridy = 3;
		gbc_buttonPane.gridwidth = 6;
		buttonPane.setLayout(gbl_buttonPane);
		contentPane.add(buttonPane, gbc_buttonPane);
		
	}
	static void createNextButton()
	{
		nextButton = new JButton("Next");
		GridBagConstraints gbc_nextButton = new GridBagConstraints();
		gbc_nextButton.gridx = 2;
		gbc_nextButton.gridy = 0;
		buttonPane.add(nextButton, gbc_nextButton);
	}
	static void createQuitButton()
	{
		quitButton = new JButton("Quit");
		buttonPane.add(quitButton);
	}
	static void createRadios()
	{
		rdNumPlayers = new JRadioButton[Variables.MAX_SUPPORTED_PLAYERS];
		GridBagConstraints[] gbc_rdNumPlayers = new GridBagConstraints[Variables.MAX_SUPPORTED_PLAYERS];
		numPlayersGroup = new ButtonGroup();
		for (int i = 0 ; i < Variables.MAX_SUPPORTED_PLAYERS ; i++)
		{
			gbc_rdNumPlayers[i] = new GridBagConstraints(); // Pre-init
			gbc_rdNumPlayers[i].gridx = 1 + i;
			gbc_rdNumPlayers[i].gridy = 1;
			rdNumPlayers[i] = new JRadioButton(i+1 + " players"); 			// Pre-init
			numPlayersGroup.add(rdNumPlayers[i]);			// Add to button group
			contentPane.add(rdNumPlayers[i], gbc_rdNumPlayers[i]);
		}
	}
	public static void notifyNoSelection()
	{
		JOptionPane.showMessageDialog(null, "No players selected.");
	}
}
