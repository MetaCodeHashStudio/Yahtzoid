package com.rushteamc.yahtzee.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PlayerNames extends JFrame {

	private static final long serialVersionUID = 15465431564647L;
	private static JPanel contentPane;
	public static JPanel buttonPane;
	public static JButton nextButton;
	public static JButton quitButton;
	public static JLabel[] nameLabels;
	
	
	public PlayerNames()
	{
		setTitle("Project Yahtzoid version -1");
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
		gbl_contentPane.rowHeights = new int[]{60,60,60,60,60};
		contentPane.setLayout(gbl_contentPane);
		setComponent();
//		com.rushteamc.yahtzee.Start.setPlayerNameHandler(); // Build components before handling.
	}
	public void setComponent()
	{
		createButtonPane();
		createLabels();
		createInputs();
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
	static void createLabels()
	{
		
	}
	static void createInputs()
	{
		
	}

}
