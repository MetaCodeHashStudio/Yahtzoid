package com.rushteamc.yahtzee.gui;

import com.rushteamc.yahtzee.utils.Variables;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class PlayerNumbers extends JDialog {

	private static final JPanel contentPanel = new JPanel();
	private static final long serialVersionUID = 15465431564646L;
	public static JButton okButton;
	public static JRadioButton[] rdNumPlayers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PlayerNumbers dialog = new PlayerNumbers();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PlayerNumbers() {
		setBounds(100, 100, 540, 300);
		getContentPane().setLayout(new BorderLayout());
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{90,90,90,90,90,90};
		gbl_contentPanel.rowHeights = new int[]{60,60,60,60};
		contentPanel.setLayout(gbl_contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Next");
				okButton.setActionCommand("NextToNames");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Quit");
				cancelButton.setActionCommand("Quit");
				buttonPane.add(cancelButton);
			}
		}
		buildRadios();
	}
	public static void buildRadios()
	{
		JRadioButton[] rdNumPlayers = new JRadioButton[Variables.MAX_SUPPORTED_PLAYERS];
		GridBagConstraints[] gbc_rdNumPlayers = new GridBagConstraints[Variables.MAX_SUPPORTED_PLAYERS];
		ButtonGroup numPlayersGroup = new ButtonGroup();
		for (int i = 0 ; i < Variables.MAX_SUPPORTED_PLAYERS ; i++)
		{
			gbc_rdNumPlayers[i] = new GridBagConstraints(); // Pre-init
			gbc_rdNumPlayers[i].gridx = 1 + i;
			gbc_rdNumPlayers[i].gridy = 1;
			rdNumPlayers[i] = new JRadioButton(i+1 + " players"); 			// Pre-init
			numPlayersGroup.add(rdNumPlayers[i]);			// Add to button group
			contentPanel.add(rdNumPlayers[i], gbc_rdNumPlayers[i]);
		}
	}
	public static void notifyNoSelection()
	{
		JOptionPane.showMessageDialog(null, "No players selected.");
	}
}
