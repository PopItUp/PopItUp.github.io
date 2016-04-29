// CSE 360 Project
// Name: PopItUp
// Description: GamePanel is a panel created to feature a 
//				the PopItUp game
//package cse360BalloonGame;
import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import StatisticsPanel.ButtonListener;

/** CSE 360 Project - Statistics Panel class
 * @author PopItUp
 * Description: GamePanel is a panel created to feature a 
 * 			the PopItUp game
 */
public class StatisticsPanel extends JPanel
{
	private JPanel wholePanel, rankPanel;
	private JButton victory;
	private JLabel test, p1, p2, p3, p4, p1rank, p2rank, p3rank, p4rank, p1rolls, p2rolls, p3rolls, p4rolls, rollsAre, ranksAre, blank;

	/** StatisticsPanel - constructor that initializes and sets all the instance variables **/ 
	public StatisticsPanel()
	{
		wholePanel = new JPanel();
		rankPanel = new JPanel();
		blank = new JLabel("");
		test = new JLabel("You have reached the statistics panel!");
		p1 = new JLabel("Player 1: ");
		p2 = new JLabel("Player 2: ");
		p3 = new JLabel("Player 3: ");
		p4 = new JLabel("Player 4: ");
		
		victory = new JButton("Refresh");
		
		rollsAre = new JLabel("Rolls:");
		ranksAre = new JLabel("Rank:");

		p1rolls = new JLabel("" + Player.getRolls(2));
		p2rolls = new JLabel("" + Player.getRolls(2));
		p3rolls = new JLabel("" + Player.getRolls(3));
		p4rolls = new JLabel("" + Player.getRolls(4));
		
		p1rank = new JLabel("" + Player.getRanks(1));
		p2rank = new JLabel("" + Player.getRanks(2));
		p3rank = new JLabel("" + Player.getRanks(3));
		p4rank = new JLabel("" + Player.getRanks(4));

				
		wholePanel.setLayout(new GridLayout(3,3));
		wholePanel.add(test);
		
		rankPanel.setLayout(new GridLayout(5,3));
		rankPanel.add(blank);
		rankPanel.add(ranksAre);
		rankPanel.add(rollsAre);
		
		rankPanel.add(p1);
		rankPanel.add(p1rank);
		rankPanel.add(p1rolls);

		rankPanel.add(p2);
		rankPanel.add(p2rank);
		rankPanel.add(p2rolls);

		rankPanel.add(p3);
		rankPanel.add(p3rank);
		rankPanel.add(p3rolls);

		rankPanel.add(p4);
		rankPanel.add(p4rank);
		rankPanel.add(p4rolls);
		
		wholePanel.add(rankPanel);
		wholePanel.add(victory);
		
		//setLayout(new GridLayout(1,1));
		add(wholePanel);
		
		ButtonListener listener = new ButtonListener();
		victory.addActionListener(listener);
	}
	
	/** ButtonListener will keep track of when the "victory' JButton has been pressed, and will then update all the statistics for each player from the most recent game.
	 * @author PopItUp
	 * @param event - The event in which the "victory" JButton is pressed
	 */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();
			if(source == victory)
			{
				p1rolls.setText("" + Player.getRolls(1));
				p2rolls.setText("" + Player.getRolls(2));
				p3rolls.setText("" + Player.getRolls(3));
				p4rolls.setText("" + Player.getRolls(4));

				p1rank.setText("" + Player.getRanks(1));
				p2rank.setText("" + Player.getRanks(2));
				p3rank.setText("" + Player.getRanks(3));
				p4rank.setText("" + Player.getRanks(4));
			}
		}
	}
}
