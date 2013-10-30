package com.rushteamc.yahtzee.gui;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.GridBagConstraints;

import javax.swing.border.LineBorder;

import com.rushteamc.yahtzee.GameShell;
import com.rushteamc.yahtzee.Start;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashGUI extends JFrame {

	private static final long serialVersionUID = 87865423484543L;
	private JPanel contentPane;
	private ImagePanel imagePanel;
	private JButton btnNewGame;
	GameShell gameShell;

	/**
	 * Create the frame.
	 */
	public SplashGUI(GameShell gameShell) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		setComponent();
		setHandler();
	}

	private void setComponent() {
		setMainPanel();
		setImagePanel();
	}

	private void setImagePanel() {
		imagePanel = new ImagePanel(
				"com/rushteamc/yahtzee/gui/img/LogoCTrans.png");
		imagePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_imagePanel = new GridBagConstraints();
		gbc_imagePanel.gridx = 0;
		gbc_imagePanel.gridy = 0;
		gbc_imagePanel.gridwidth = 13;
		gbc_imagePanel.gridheight = 10;
		contentPane.add(imagePanel, gbc_imagePanel);
	}

	private void setMainPanel() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();

		gbl_contentPane.columnWidths = new int[] { 30, 30, 30, 30, 30, 30, 30,
				30, 30, 30, 30, 30, 30 };
		gbl_contentPane.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30,
				30, 30, 30, 30, 30, 30, 30, 30, 30 };

		contentPane.setLayout(gbl_contentPane);
		setContentPane(contentPane);

		btnNewGame = new JButton("New Game");
		GridBagConstraints gbc_btnNewGame = new GridBagConstraints();
		gbc_btnNewGame.gridx = 6;
		gbc_btnNewGame.gridy = 4;
		gbc_btnNewGame.gridwidth = 1;
		gbc_btnNewGame.gridheight = 1;
		contentPane.add(btnNewGame, gbc_btnNewGame);
		btnNewGame.setActionCommand("newGame");

	}

	private void setHandler() {
		btnNewGame.addActionListener(getActionListener());
	}

	private ActionListener getActionListener() {

		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String commandToRun = e.getActionCommand().toString();
				SplashGUI.this.setVisible(false);
				switch (commandToRun) {
				case "newGame"	:	Start.gameShell.newGame();
				break;
				case "saveGame"	:	gameShell.saveGame();
				break;
				case "loadGame"	:	gameShell.loadGame();
				break;
				case "quitGame"	:	gameShell.quitGame();
				break;
				}
			}
		};
		return actionListener;

	}

//	public String getCommand() {
//		return commandToRun;
//	}

}
