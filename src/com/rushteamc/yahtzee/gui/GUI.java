package com.rushteamc.yahtzee.gui;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import com.rushteamc.yahtzee.Game;
import com.rushteamc.yahtzee.utils.FileHandling;
import com.rushteamc.yahtzee.utils.Players;
import com.rushteamc.yahtzee.utils.Variables;
import com.rushteamc.yahtzee.gui.utils.GUIVariables;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class GUI extends JFrame {

	private static final long serialVersionUID = 435423427892374L;
	private JPanel contentPane;
	private JPanel rightPanel;
	private JPanel leftPanel;
	private JLabel lblScoreSheet;
	private Icon activePlayerIcon;
	
	private JLabel[][] lblGraphicalScores;
	private JLabel[] lblPlayerNames;
	private JLabel[] lblScoreTypes;
	private JLabel[] lblHoldDie;
	private JButton[] btnDieIcon;
	private JButton[] btnSetScore;
	private Image[] dieImages;
//	public static File[] imgFile;
	private JButton btnRollDice;
//	private ImageInputStream[] imageStream;
	private InputStream[] inputStream;
	private URL[] imageUrl;
	private boolean diceRolled = false;

	/**
	 * Create the frame.
	 * @throws URISyntaxException 
	 */
	public GUI()
	{
//		buildPanels();
//		setPanels();
		populateImages();
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
			gbc_lblScoreTypes[i].gridwidth = 2;
			gbc_lblScoreTypes[i].anchor = GridBagConstraints.WEST;
			gbc_lblScoreTypes[i].fill = GridBagConstraints.BOTH;
			gbc_lblScoreTypes[i].insets = new Insets(5,35,5,5);
			lblScoreTypes[i] = new JLabel(Variables.scoreTypes[i]);
			leftPanel.add(lblScoreTypes[i], gbc_lblScoreTypes[i]);
			lblScoreTypes[i].setVisible(false);
		
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
			gbc_lblGraphicalScores[i][j].fill = GridBagConstraints.BOTH;
			gbc_lblGraphicalScores[i][j].gridx = labelsXPos+2+i;
			gbc_lblGraphicalScores[i][j].gridy = labelsYStart+j;
			lblGraphicalScores[i][j] = new JLabel(""); 							// Pre-init
			leftPanel.add(lblGraphicalScores[i][j], gbc_lblGraphicalScores[i][j]);
			
			}
		
		}
		
		lblHoldDie = new JLabel[6];
		dieImages = new BufferedImage[6];
		btnDieIcon = new JButton[6];
		GridBagConstraints[] gbc_lblHoldDie = new GridBagConstraints[lblHoldDie.length];
		GridBagConstraints[] gbc_btnDieIcon = new GridBagConstraints[btnDieIcon.length];
		
		for(int i = 0 ; i < lblHoldDie.length ; i++)
		
		{
			
			gbc_btnDieIcon[i] = new GridBagConstraints();
			gbc_btnDieIcon[i].gridx = i+1;
			gbc_btnDieIcon[i].gridy = 1;
			try {
				dieImages[i] = ImageIO.read(inputStream[i]);	
			} catch(IOException e){
				e.printStackTrace();
			}
			btnDieIcon[i] = new JButton(new ImageIcon(dieImages[i]));
			btnDieIcon[i].setActionCommand("holdButton"+i);
			rightPanel.add(btnDieIcon[i], gbc_btnDieIcon[i]);
			
			// Build dice pictures
			gbc_lblHoldDie[i] = new GridBagConstraints();
			gbc_lblHoldDie[i].gridx = i+1;
			gbc_lblHoldDie[i].gridy = 2;
			lblHoldDie[i] = new JLabel("Held");
			lblHoldDie[i].setVisible(false);
			rightPanel.add(lblHoldDie[i],gbc_lblHoldDie[i]);
			
		}


		GridBagConstraints gbc_btnRollDice = new GridBagConstraints();
		gbc_btnRollDice.fill = GridBagConstraints.BOTH;
		gbc_btnRollDice.gridx = 1;
		gbc_btnRollDice.gridy = 4;
		gbc_btnRollDice.gridwidth = 5;
		btnRollDice = new JButton("Roll Dice");
		rightPanel.add(btnRollDice, gbc_btnRollDice);
		
		btnSetScore = new JButton[Variables.scoreTypes.length];
		GridBagConstraints[] gbc_btnSetScore = new GridBagConstraints[btnSetScore.length];
		
		for(int i = 0 ; i < btnSetScore.length ; i++)
		{
			
			gbc_btnSetScore[i] = new GridBagConstraints();
			gbc_btnSetScore[i].fill = GridBagConstraints.BOTH;
			gbc_btnSetScore[i].gridx = labelsXPos;
			gbc_btnSetScore[i].gridy = labelsYStart+i;
			gbc_btnSetScore[i].insets = new Insets(5,5,5,5);
			
			btnSetScore[i] = new JButton(Variables.scoreTypes[i]);
			btnSetScore[i].setActionCommand("scoreButton"+i);
			
			leftPanel.add(btnSetScore[i], gbc_btnSetScore[i]);
		
		}
		
		lblPlayerNames[0].setIcon(activePlayerIcon);
		
		this.setHandler();			

		this.cleanup();
//		Game.startGame();
	
	}
	
	private void cleanup()
	{
		
		lblHoldDie[lblHoldDie.length-1].setVisible(false);
		btnDieIcon[btnDieIcon.length-1].setVisible(false);
		String[] buttonsToRemove = new String[]
		
		{
					
			Variables.scoreTypes[6],
			Variables.scoreTypes[7],
			Variables.scoreTypes[17],
			Variables.scoreTypes[18]
				
		};
		
		for(int i = 0 ; i < lblScoreTypes.length ; i++)
		{
			
			for(int j = 0 ; j < buttonsToRemove.length ; j++)
			{
				
				if (lblScoreTypes[i].getText() == buttonsToRemove[j])
				{
					
					btnSetScore[i].setVisible(false);
					lblScoreTypes[i].setVisible(true);
				
				}
				
			}
			
		}
		
	}
	
	public void reArm(int playerNumber)
	{
		
		if(!(playerNumber == -1))
		{
			
			if(playerNumber == 0)
			{
				
				int index = Players.getLastPlayerIndex();
				lblPlayerNames[index].setIcon(null);
				lblPlayerNames[playerNumber].setIcon(activePlayerIcon);
		
			}
			
			else
			{
				
				lblPlayerNames[playerNumber-1].setIcon(null);
				lblPlayerNames[playerNumber].setIcon(activePlayerIcon);
		
			}
			
			for(int i = 0 ; i < 6 ; i++)
			{
				
				this.lblHoldDie[i].setVisible(false);
				Variables.dice[i].holdDie(false);
			
			}
			
			for(int i = 0 ; i < lblScoreTypes.length ; i++)
			{
				
				btnSetScore[i].setVisible(!Variables.playerHasAddedScore[playerNumber][i]);
				lblScoreTypes[i].setVisible(Variables.playerHasAddedScore[playerNumber][i]);
				Variables.currentUsedRerolls = -1;
			
			}
			
			cleanup();
		}
		
		else
		{
			
			//Post game GUI elements
		
		}
		
	}
	private void populateImages()
	{
		
		inputStream = new InputStream[6];
		imageUrl = new URL[6];
		
		for(int i = 0 ; i < inputStream.length ; i++)
		{
			
			try {
				this.imageUrl[i] = new URL(FileHandling.getWorkingPaths() + "com/rushteamc/yahtzee/gui/img/Die_" + (i+1) + ".png");
				this.inputStream[i] = new URL(imageUrl[i].toString()).openStream();
//				System.out.println(FileHandling.getWorkingPaths() + "com/rushteamc/yahtzee/gui/img/Die_" + (i+1) + ".png");
				URL activeIconUrl = new URL(FileHandling.getWorkingPaths() + "com/rushteamc/yahtzee/gui/img/active.png");
				InputStream activeIcon = new URL(activeIconUrl.toString()).openStream();
				this.activePlayerIcon = new ImageIcon(ImageIO.read(activeIcon));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void setHandler()
	{
		throwDiceHandler();
		holdDiceHandler();
		addScoreHandler();
		/*
		com.rushteamc.yahtzee.gui.handlers.GUIHandlers.throwDiceHandler();
		com.rushteamc.yahtzee.gui.handlers.GUIHandlers.holdDiceHandler();
		com.rushteamc.yahtzee.gui.handlers.GUIHandlers.addScoreHandler();
		*/
	
	}
	private void throwDiceHandler()
	{
		this.btnRollDice.addActionListener
		(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{	
						if(Variables.currentUsedRerolls != Variables.STANDARD_MAX_REROLLS)
						{

							for(int i = 0 ; i < Variables.dice.length ; i++)
							{
								
								/*
								if(Variables.dice[i].isHeld())
								{
									System.out.println("Die number " + (i+1) + " is held and has value " + Variables.dice[i].getValue());
								}
								*/
								Variables.dice[i].reRoll();
								if(Variables.dice[i].getActive())
								{
									try
									{
										btnDieIcon[i].setIcon(new ImageIcon(ImageIO.read(inputStream[Variables.dice[i].getValue()-1])));
									}
								
									catch(IOException error)
									{
										
										error.printStackTrace();
									
									}
								}
								
							}
							/*
							for(int j = 0 ; j < Variables.dice.length ; j++)
							{
								System.out.println("Die " + (j+1) + " has the value " + Variables.dice[j].getValue()) ;
							}
							*/
							diceRolled = true;
							Variables.currentUsedRerolls++;
							
						}
						else
						{
							GUI.noMoreRerollsError();
						}
					}
				}
		);
	}
	private void holdDiceHandler()
	{
		for(int i = 0 ; i < btnDieIcon.length ; i++)
		{
			btnDieIcon[i].addActionListener
			(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						int buttonNumber = Character.getNumericValue((e.getActionCommand().toString()).charAt(10));
//						System.out.println(buttonNumber);
						if(!diceRolled)
						{
							
							GUI.beforeRollingError();
					
						}
						
						if(Variables.currentUsedRerolls == Variables.STANDARD_MAX_REROLLS) // MUST BE MADE DYNAMIC BEFORE CARD IMPLEMENT'
						{
							
							GUI.noMoreRerollsError();
						
						}
						
						if(!Variables.dice[buttonNumber].isHeld() && diceRolled)
						{
							
							lblHoldDie[buttonNumber].setVisible(true);
							Variables.dice[buttonNumber].holdDie(true);
						
						}
						
						else
						{
							
							lblHoldDie[buttonNumber].setVisible(false);
							Variables.dice[buttonNumber].holdDie(false);
						
						}
						
					}
					
				}
				
			);
			
		}
		
	}
	private void addScoreHandler()
	{
		
		for(int i = 0 ; i < btnSetScore.length; i++)
		{
			
			btnSetScore[i].addActionListener
			(
					
				new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						
						if(diceRolled)
						{
							
							int buttonNumber;
							if(e.getActionCommand().toString().length() == 12)
								buttonNumber = Character.getNumericValue((e.getActionCommand().toString()).charAt(11));
							else
							{
								
								String preProcessed = e.getActionCommand().toString();
								String postProcessed = preProcessed.substring(11);
								buttonNumber = Integer.parseInt(postProcessed);
							
							}
							
							int scoreToAdd = Game.checkForScore(buttonNumber, Variables.dice);
							lblGraphicalScores[Variables.turnNumber][buttonNumber].setText(Integer.toString(scoreToAdd));
							Variables.playerHasAddedScore[Variables.turnNumber][buttonNumber] = true;
							int playerNumber = 0;
							try
							{
								playerNumber = Game.endTurn();
						
							}
							catch (InterruptedException e1)
							{
								
								e1.printStackTrace();
							
							}
							
							diceRolled = false;
							reArm(playerNumber);
						
						}
						else
						{
							
							GUI.beforeRollingError();
						
						}
					
					}
				
				}
				
			);
			
		}
		
	}
	public static void beforeRollingError()
	{
		
		JOptionPane.showMessageDialog(null,"You cannot do this before rolling.");
	
	}
	
	public static void noMoreRerollsError()
	{
		
		JOptionPane.showMessageDialog(null,"You have spent all your rerolls this turn.");	
	
	}
}
