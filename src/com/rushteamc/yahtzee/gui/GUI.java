package com.rushteamc.yahtzee.gui;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JPanel rightPanel;
	private JPanel leftPanel;
	private JLabel lblScoreSheet;
	private JLabel lblAces;
	private JLabel lblTwos;
	private JLabel lblThrees;
	private JLabel lblFours;
	private JLabel lblFives;
	private JLabel lblSixes;
	private JLabel lblUpperTotal;
	private JLabel lblBonus;
	private JLabel lblUpperTotalWithBonus;
	private JSeparator ScoreSheetSeparator;
	private JLabel lblThreeOAK;
	
	private JLabel lblFourOAK;
	private JLabel lblFullHouse;
	private JLabel lblSmallStraight;
	private JLabel lblLargeStraight;
	private JLabel lblYahtzee;
	private JLabel lblChance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{480, 480};
		gbl_contentPane.rowHeights = new int[]{128, 128, 128, 128, 128, 128};
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(gbl_contentPane);
		setContentPane(contentPane);
		
		leftPanel = new JPanel();
		leftPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftPanel.setBackground(Color.WHITE);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[]{60, 60, 60, 60, 60, 60, 60, 60};
		gbl_leftPanel.rowHeights = new int[]{24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24};
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
		gbl_rightPanel.columnWidths = new int[]{60, 60, 60, 60, 60, 60, 60, 60};
		gbl_rightPanel.rowHeights = new int[]{48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48};
		rightPanel.setLayout(gbl_rightPanel);
		GridBagConstraints gbc_rightPanel = new GridBagConstraints();
		gbc_rightPanel.insets = new Insets(10, 10, 10, 10);
		gbc_rightPanel.gridx = 1;
		gbc_rightPanel.gridy = 0;
		gbc_rightPanel.gridheight = 6;
		contentPane.add(rightPanel, gbc_rightPanel);
		
		lblScoreSheet = new JLabel("Score sheet");
		GridBagConstraints gbc_lblScoreSheet = new GridBagConstraints();
		gbc_lblScoreSheet.gridwidth = 8;
		gbc_lblScoreSheet.insets = new Insets(0, 0, 5, 0);
		gbc_lblScoreSheet.gridx = 0;
		gbc_lblScoreSheet.gridy = 0;
		leftPanel.add(lblScoreSheet, gbc_lblScoreSheet);
		
		lblAces = new JLabel("Aces");
		GridBagConstraints gbc_lblAces = new GridBagConstraints();
		gbc_lblAces.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAces.gridwidth = 2;
		gbc_lblAces.insets = new Insets(0, 15, 5, 5);
		gbc_lblAces.gridx = 0;
		gbc_lblAces.gridy = 2;
		leftPanel.add(lblAces, gbc_lblAces);
		
		lblTwos = new JLabel("Twos");
		GridBagConstraints gbc_lblTwos = new GridBagConstraints();
		gbc_lblTwos.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTwos.insets = new Insets(0, 15, 5, 5);
		gbc_lblTwos.gridx = 0;
		gbc_lblTwos.gridy = 3;
		leftPanel.add(lblTwos, gbc_lblTwos);
		
		lblThrees = new JLabel("Threes");
		GridBagConstraints gbc_lblThrees = new GridBagConstraints();
		gbc_lblThrees.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblThrees.insets = new Insets(0, 15, 5, 5);
		gbc_lblThrees.gridx = 0;
		gbc_lblThrees.gridy = 4;
		leftPanel.add(lblThrees, gbc_lblThrees);
		
		lblFours = new JLabel("Fours");
		GridBagConstraints gbc_lblFours = new GridBagConstraints();
		gbc_lblFours.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFours.insets = new Insets(0, 15, 5, 5);
		gbc_lblFours.gridx = 0;
		gbc_lblFours.gridy = 5;
		leftPanel.add(lblFours, gbc_lblFours);
		
		lblFives = new JLabel("Fives");
		GridBagConstraints gbc_lblFives = new GridBagConstraints();
		gbc_lblFives.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFives.insets = new Insets(0, 15, 5, 5);
		gbc_lblFives.gridx = 0;
		gbc_lblFives.gridy = 6;
		leftPanel.add(lblFives, gbc_lblFives);
		
		lblSixes = new JLabel("Sixes");
		GridBagConstraints gbc_lblSixes = new GridBagConstraints();
		gbc_lblSixes.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSixes.insets = new Insets(0, 15, 5, 5);
		gbc_lblSixes.gridx = 0;
		gbc_lblSixes.gridy = 7;
		leftPanel.add(lblSixes, gbc_lblSixes);
		
		lblUpperTotal = new JLabel("Upper Total");
		GridBagConstraints gbc_lblUpperTotal = new GridBagConstraints();
		gbc_lblUpperTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUpperTotal.insets = new Insets(0, 15, 5, 5);
		gbc_lblUpperTotal.gridx = 0;
		gbc_lblUpperTotal.gridy = 8;
		leftPanel.add(lblUpperTotal, gbc_lblUpperTotal);
		
		lblBonus = new JLabel("Bonus");
		GridBagConstraints gbc_lblBonus = new GridBagConstraints();
		gbc_lblBonus.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBonus.insets = new Insets(0, 15, 5, 5);
		gbc_lblBonus.gridx = 0;
		gbc_lblBonus.gridy = 9;
		leftPanel.add(lblBonus, gbc_lblBonus);
		
		lblUpperTotalWithBonus = new JLabel("Total");
		GridBagConstraints gbc_lblUpperTotalWithBonus = new GridBagConstraints();
		gbc_lblUpperTotalWithBonus.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUpperTotalWithBonus.insets = new Insets(0, 15, 5, 5);
		gbc_lblUpperTotalWithBonus.gridx = 0;
		gbc_lblUpperTotalWithBonus.gridy = 10;
		leftPanel.add(lblUpperTotalWithBonus, gbc_lblUpperTotalWithBonus);
		
		ScoreSheetSeparator = new JSeparator();
		GridBagConstraints gbc_ScoreSheetSeparator = new GridBagConstraints();
		gbc_ScoreSheetSeparator.fill = GridBagConstraints.HORIZONTAL;
		gbc_ScoreSheetSeparator.insets = new Insets(5, 10, 5, 10);
		gbc_ScoreSheetSeparator.gridx = 0;
		gbc_ScoreSheetSeparator.gridy = 11;
		gbc_ScoreSheetSeparator.gridwidth = 8;
		leftPanel.add(ScoreSheetSeparator, gbc_ScoreSheetSeparator);
		
		lblThreeOAK = new JLabel("Three-of-a-kind");
		GridBagConstraints gbc_lblThreeOAK = new GridBagConstraints();
		gbc_lblThreeOAK.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblThreeOAK.insets = new Insets(0, 15, 5, 5);
		gbc_lblThreeOAK.gridx = 0;
		gbc_lblThreeOAK.gridy = 12;
		leftPanel.add(lblThreeOAK, gbc_lblThreeOAK);
		
		lblFourOAK = new JLabel("Four-of-a-kind");
		GridBagConstraints gbc_lblFourOAK = new GridBagConstraints();
		gbc_lblFourOAK.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFourOAK.insets = new Insets(0, 15, 5, 5);
		gbc_lblFourOAK.gridx = 0;
		gbc_lblFourOAK.gridy = 13;
		leftPanel.add(lblFourOAK, gbc_lblFourOAK);
		
		lblFullHouse = new JLabel("Full House");
		GridBagConstraints gbc_lblFullHouse = new GridBagConstraints();
		gbc_lblFullHouse.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFullHouse.insets = new Insets(0, 15, 5, 5);
		gbc_lblFullHouse.gridx = 0;
		gbc_lblFullHouse.gridy = 14;
		leftPanel.add(lblFullHouse, gbc_lblFullHouse);
		
		lblSmallStraight = new JLabel("Small Straight");
		GridBagConstraints gbc_lblSmallStraight = new GridBagConstraints();
		gbc_lblSmallStraight.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSmallStraight.insets = new Insets(0, 15, 5, 5);
		gbc_lblSmallStraight.gridx = 0;
		gbc_lblSmallStraight.gridy = 15;
		leftPanel.add(lblSmallStraight, gbc_lblSmallStraight);
		
		lblLargeStraight = new JLabel("Large Straight");
		GridBagConstraints gbc_lblLargeStraight = new GridBagConstraints();
		gbc_lblLargeStraight.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLargeStraight.insets = new Insets(0, 15, 5, 5);
		gbc_lblLargeStraight.gridx = 0;
		gbc_lblLargeStraight.gridy = 16;
		leftPanel.add(lblLargeStraight, gbc_lblLargeStraight);
		
		lblYahtzee = new JLabel("Yahtzee");
		GridBagConstraints gbc_lblYahtzee = new GridBagConstraints();
		gbc_lblYahtzee.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblYahtzee.insets = new Insets(0, 15, 5, 5);
		gbc_lblYahtzee.gridx = 0;
		gbc_lblYahtzee.gridy = 17;
		leftPanel.add(lblYahtzee, gbc_lblYahtzee);
		
		lblChance = new JLabel("Chance");
		GridBagConstraints gbc_lblChance = new GridBagConstraints();
		gbc_lblChance.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblChance.insets = new Insets(0, 15, 5, 5);
		gbc_lblChance.gridx = 0;
		gbc_lblChance.gridy = 18;
		leftPanel.add(lblChance, gbc_lblChance);
		
		
	}

}
