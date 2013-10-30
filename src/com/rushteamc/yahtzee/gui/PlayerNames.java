package com.rushteamc.yahtzee.gui;


import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.rushteamc.yahtzee.Start;
import com.rushteamc.yahtzee.utils.Players;
import com.rushteamc.yahtzee.utils.Variables;

public class PlayerNames extends JFrame {

	private final long serialVersionUID = 15465431564647L;
	private JPanel contentPane;
	public JPanel buttonPane;
	public JButton nextButton;
	public JButton quitButton;
	public JTextField[] txtPlayerNames = new JTextField[Variables.selectedNumPlayers];
	int numPlayers;
	
	
	public PlayerNames(String gameVersion, int numPlayers)
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
		gbl_contentPane.rowHeights = new int[]{40,40,40,40,40,40};
		contentPane.setLayout(gbl_contentPane);
		setComponent();
		setHandler();
		
		//com.rushteamc.yahtzee.Start.setPlayerNameHandler(); // Build components before handling.
	}
	private void setComponent()
	{
		createButtonPane();
		createLabels();
		createInputs();
		createNextButton();
		createQuitButton();
	}
	private void createButtonPane()
	{
		buttonPane = new JPanel();
		GridBagLayout gbl_buttonPane = new GridBagLayout();
		gbl_buttonPane.columnWidths = new int[]{90,90,90,90,90,90};
		gbl_buttonPane.rowHeights = new int[]{0,40,0};
		GridBagConstraints gbc_buttonPane = new GridBagConstraints();
		gbc_buttonPane.fill = GridBagConstraints.BOTH;
		gbc_buttonPane.gridx = 0;
		gbc_buttonPane.gridy = 5;
		gbc_buttonPane.gridwidth = 6;
		buttonPane.setLayout(gbl_buttonPane);
		contentPane.add(buttonPane, gbc_buttonPane);
	}
	private void createNextButton()
	{
		nextButton = new JButton("Next");
		GridBagConstraints gbc_nextButton = new GridBagConstraints();
		gbc_nextButton.gridx = 2;
		gbc_nextButton.gridy = 0;
		buttonPane.add(nextButton, gbc_nextButton);
	}
	private void createQuitButton()
	{
		quitButton = new JButton("Quit");
		buttonPane.add(quitButton);
	}
	private void createLabels()
	{
		int arraySize = Variables.selectedNumPlayers;
		JLabel[] lblPlayerNames = new JLabel[arraySize];
		GridBagConstraints[] gbc_lblPlayerNames = new GridBagConstraints[arraySize];
		for (int i = 0 ; i < arraySize ; i++)
		{
			gbc_lblPlayerNames[i] = new GridBagConstraints();
			gbc_lblPlayerNames[i].gridx = 1;
			gbc_lblPlayerNames[i].gridy = i;
			lblPlayerNames[i] = new JLabel("Name of player " + (i+1) + ":");
			contentPane.add(lblPlayerNames[i] , gbc_lblPlayerNames[i]);
		}
		
	}
	private void createInputs()
	{
		int arraySize = Variables.selectedNumPlayers;
//		JTextField[] txtPlayerNames = new JTextField[arraySize];
		GridBagConstraints[] gbc_txtPlayerNames = new GridBagConstraints[arraySize];
		for (int i = 0 ; i < arraySize ; i++)
		{
			gbc_txtPlayerNames[i] = new GridBagConstraints();
			gbc_txtPlayerNames[i].gridx = 2;
			gbc_txtPlayerNames[i].gridy = i;
			gbc_txtPlayerNames[i].fill = GridBagConstraints.HORIZONTAL;
			txtPlayerNames[i] = new JTextField();
			contentPane.add(txtPlayerNames[i] , gbc_txtPlayerNames[i]);
		}
	}

	private void setHandler() {
		this.nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String[] playerNames = new String[numPlayers];
				
				for(int i = 0 ; i < numPlayers ; i++)
				{
					if(!(txtPlayerNames[i].getText() == "")) {
						playerNames[i] = txtPlayerNames[i].getText();
					}
					
					Start.gameShell.setPlayerNames(playerNames);
					Start.gameShell.newGame(3);
					
					
				}

			}
		});

		this.quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}