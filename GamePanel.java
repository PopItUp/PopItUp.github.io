import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/** CSE 360 Project - GamePanel class
 * @author PopItUp
 * Description: GamePanel is a panel created to feature a 
 *				the PopItUp game
 */
public class GamePanel extends JPanel
{
	private JPanel wholePanel, winPanel, rollPanel, rollEntirePanel;
	private JButton victory, rollDicePlayer1, rollDicePlayer2, rollDicePlayer3, rollDicePlayer4, rollDiceReset;
	private JLabel win, test, player1, player2, player3, player4, test2, reset;
	private int count1, count2, count3, count4;
	private Dice Pl1, Pl2, Pl3, Pl4;
	private boolean won = false;
	
	/** GamePanel - constructor that initializes and sets all the instance variables **/ 
	public GamePanel()
	{

		wholePanel = new JPanel();
		winPanel = new JPanel();
		rollPanel = new JPanel();
		rollEntirePanel = new JPanel();
		test = new JLabel("Instructions: Roll the die, if the die rolls to be even then the number is\n "
				+ "added on, otherwise if the die shows to be odd nothing is added. The first to 20 pops the balloon and wins!");
		test2 = new JLabel(" ");
		
		rollDicePlayer1 = new JButton("Iron Man");
		rollDicePlayer2 = new JButton("Captain America");
		rollDicePlayer3 = new JButton("BlackWidow");
		rollDicePlayer4 = new JButton("SpiderMan");
		rollDiceReset   = new JButton("Civil War-2");
		
		player1 = new JLabel("Player 1");
		player1.setHorizontalAlignment(SwingConstants.CENTER);
		player1.setVerticalAlignment(SwingConstants.CENTER);
		player2 = new JLabel("Player 2");
		player2.setHorizontalAlignment(SwingConstants.CENTER);
		player2.setVerticalAlignment(SwingConstants.CENTER);
		player3 = new JLabel("Player 3");
		player3.setHorizontalAlignment(SwingConstants.CENTER);
		player3.setVerticalAlignment(SwingConstants.CENTER);
		player4 = new JLabel("Player 4");
		player4.setHorizontalAlignment(SwingConstants.CENTER);
		player4.setVerticalAlignment(SwingConstants.CENTER);
		reset = new JLabel("Reseting the Game");
		reset.setHorizontalAlignment(SwingConstants.CENTER);
		reset.setHorizontalAlignment(SwingConstants.CENTER);
		
		wholePanel.setLayout(new GridLayout(2,1));
		wholePanel.add(test);
		
		rollEntirePanel.setLayout(new FlowLayout());
		rollEntirePanel.add(test2);
		rollEntirePanel.add(rollPanel);
		
		rollPanel.setLayout(new GridLayout(6,1));
		rollPanel.add(rollDicePlayer1);
		rollPanel.add(rollDicePlayer2);
		rollPanel.add(player1);
		rollPanel.add(player2);
		rollPanel.add(rollDicePlayer3);
		rollPanel.add(rollDicePlayer4);
		rollPanel.add(player3);
		rollPanel.add(player4);
		rollPanel.add(rollDiceReset);
		rollPanel.add(reset);
		
		setLayout(new GridLayout(1,1));
		add(wholePanel);
		wholePanel.add(rollPanel);

		ButtonListener listener = new ButtonListener();
		rollDicePlayer1.addActionListener(listener);
		rollDicePlayer2.addActionListener(listener);
		rollDicePlayer3.addActionListener(listener);
		rollDicePlayer4.addActionListener(listener);
	    rollDiceReset.addActionListener(listener);
	}

	/** ButtonListener - class that implements ActionListener to account for button clicks **/ 
	private class ButtonListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				int x = (int)(Math.random() * 10);
				Object source = event.getSource();
				if(source == victory){
					winPanel.setVisible(true);
				}
				else if(source == rollDicePlayer1)
				{
					Player.addRoll(1);
					Player.testAdd(1, x);
					if(Player.returnSumPlayer(1) >= 20 && won == false)
					{
						player1.setText("Iron Man" + Player.returnSumPlayer(1));
						test.setText("Iron Man WINS!");
						test.setFont(new Font("Serif", Font.BOLD, 80));
						test.setHorizontalAlignment(SwingConstants.CENTER);
						test.setVerticalAlignment(SwingConstants.CENTER);
						won = true;
						Player.addWin(1);
						Player.setRanks(1, 1);
						Player.adjustRanks(1);
					}
					else{
						player1.setHorizontalAlignment(SwingConstants.CENTER);
						player1.setVerticalAlignment(SwingConstants.CENTER);
						player1.setText("Player 1:" + Player.returnSumPlayer(1));
						/*test.setText("Instructions: Roll the die, if the die rolls to be even then the number is\n "
				+ "added on, otherwise if the die shows to be odd nothing is added. The first to 20 pops the balloon and wins!");
						test.setFont(new Font("Serif", Font.BOLD, 30));
						test.setHorizontalAlignment(SwingConstants.CENTER);
						test.setVerticalAlignment(SwingConstants.CENTER);*/}
				}
				else if(source == rollDicePlayer2)
				{
					Player.addRoll(2);
					Player.testAdd(2, x);
					if(Player.returnSumPlayer(2) >= 20 && won == false)
					{
						player2.setText("Captain America" + Player.returnSumPlayer(2));
						test.setText("Captain America WINS!");
						test.setFont(new Font("Serif", Font.BOLD, 80));
						test.setHorizontalAlignment(SwingConstants.CENTER);
						test.setVerticalAlignment(SwingConstants.CENTER);
						won = true;
						Player.addWin(2);
						Player.setRanks(2, 1);
						Player.adjustRanks(2);
					}	
					else{
						player2.setText("Player 2:" + Player.returnSumPlayer(2));
						/*test.setText("Instructions: Roll the die, if the die rolls to be even then the number is\n "
								+ "added on, otherwise if the die shows to be odd nothing is added. The first to 20 pops the balloon and wins!");
						test.setFont(new Font("Serif", Font.BOLD, 30));
						test.setHorizontalAlignment(SwingConstants.CENTER);
						test.setVerticalAlignment(SwingConstants.CENTER);*/}
				}
				else if(source == rollDicePlayer3)
				{
					Player.addRoll(3);
					Player.testAdd(3, x);
					if(Player.returnSumPlayer(3) >= 20 && won == false)
					{
						player3.setText("BlackWidow" + Player.returnSumPlayer(3));
						test.setText("BlackWidow Wins!!");
						test.setFont(new Font("Serif", Font.BOLD, 80));
						test.setHorizontalAlignment(SwingConstants.CENTER);
						test.setVerticalAlignment(SwingConstants.CENTER);
						won = true;
						Player.addWin(3);
						Player.setRanks(3, 1);
						Player.adjustRanks(3);
					}
					else{
						player3.setText("Player 3:" + Player.returnSumPlayer(3));
						/*test.setText("Instructions: Roll the die, if the die rolls to be even then the number is\n "
								+ "added on, otherwise if the die shows to be odd nothing is added. The first to 20 pops the balloon and wins!");
						test.setFont(new Font("Serif", Font.BOLD, 30));
						test.setHorizontalAlignment(SwingConstants.CENTER);
						test.setVerticalAlignment(SwingConstants.CENTER);*/}
				}
				else if(source == rollDicePlayer4)
				{
					Player.addRoll(4);
					Player.testAdd(4, x);
					if(Player.returnSumPlayer(4) >= 20 && won == false)
					{
						player4.setText("SpiderMan" + Player.returnSumPlayer(4));
						test.setText("SpiderMan!");
						test.setFont(new Font("Serif", Font.BOLD, 80));
						test.setHorizontalAlignment(SwingConstants.CENTER);
						test.setVerticalAlignment(SwingConstants.CENTER);
						won = true;
						Player.addWin(4);
						Player.setRanks(4, 1);
						Player.adjustRanks(4);
					}
					else{
						player4.setText("Player 4:" + Player.returnSumPlayer(4));
						/*test.setText("Instructions: Roll the die, if the die rolls to be even then the number is\n "
								+ "added on, otherwise if the die shows to be odd nothing is added. The first to 20 pops the balloon and wins!");
						test.setFont(new Font("Serif", Font.BOLD, 30));
						test.setHorizontalAlignment(SwingConstants.CENTER);
						test.setVerticalAlignment(SwingConstants.CENTER);*/}
				}
				else if(source == rollDiceReset)
				{
					player1.setText("Player 1:" + Player.returnResetSum(1));
					player2.setText("Player 2:" + Player.returnResetSum(2));
					player3.setText("Player 3:" + Player.returnResetSum(3));
					player4.setText("Player 4:" + Player.returnResetSum(4));
					won = false;
					test.setText("Instructions: Roll the die, if the die rolls to be even then the number is\n "
								+ "added on, otherwise if the die shows to be odd nothing is added. The first to 20 pops the balloon and wins!");
					test.setFont(new Font("Serfi", Font.BOLD,10));
					test.setHorizontalAlignment(SwingConstants.CENTER);
					test.setVerticalAlignment(SwingConstants.CENTER);
				}
				
				updateUI();
			}
		}



