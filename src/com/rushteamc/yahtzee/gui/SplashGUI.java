package com.rushteamc.yahtzee.gui;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridBagConstraints;

public class SplashGUI extends JFrame {

	private static final long serialVersionUID = 87865423484543L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public SplashGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		setComponent();
	}
	private void setComponent() {
		setMainPanel();
	}
	private void setUpperPanel() {
		imagePanel = new JPanel();
		
	}
	private void setMainPanel() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		
		gbl_contentPane.columnWidths = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_contentPane.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

}
