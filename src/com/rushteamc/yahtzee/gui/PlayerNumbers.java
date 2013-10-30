package com.rushteamc.yahtzee.gui;

import com.rushteamc.yahtzee.utils.Variables;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class PlayerNumbers extends JFrame {

	private static final long serialVersionUID = 15465431564646L;
	private JPanel contentPane;
//	public static JPanel mainPane;
//	public static PlayerNumbers dialog;
	private JPanel buttonPane;
	private JButton nextButton;
	private JButton quitButton;
	private JRadioButton[] rdNumPlayers;
	private ButtonGroup numPlayersGroup;


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
		setHandler();
//		com.rushteamc.yahtzee.Start.setPlayerNumHandler();
	}
	private void setComponent()
	{
		createButtonPane();
		createRadios();
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
		gbc_buttonPane.gridy = 3;
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
	private void createRadios()
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
		rdNumPlayers[0].setSelected(true);
	}
	private static void notifyNoSelection()
	{
		JOptionPane.showMessageDialog(null, "No players selected.");
	}
	private void setHandler()
	{
		this.nextButton.addActionListener
		(
				
			new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					
					Variables.selectedNumPlayers = com.rushteamc.yahtzee.gui.utils.GameSetupStates.getSelectedNumbersOfPlayers();
					com.rushteamc.yahtzee.Start.PlayerNumberFrame.setVisible(false);
					com.rushteamc.yahtzee.Start.continueToNames();
				
				}
				
			}
			
		);
		
        this.quitButton.addActionListener
        (
        		
        	new ActionListener()
        	{
        		
        		@Override
       			public void actionPerformed(ActionEvent e)
        		{ 
        			
        			System.exit(0);
        		
        		} 
        	
        	} 
       
        );
	
	}
}
