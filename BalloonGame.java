import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

 
/** CSE 360 Project - BalloonGame class
 * @author PopItUp
 * Description: BalloonGame extends JApplet and acts as the main
 *				panel to control the CardLayout panel which switches
 *				once a difficulty is specified or area is specified
 * 
 */
@SuppressWarnings("serial")
public class BalloonGame extends JApplet
{
	//private instance variables declared 
	private final int WIDTH = 2000, HEIGHT = 1000;
	private JPanel cards, wholePanel;
	private StartPanel start;
	private GamePanel game; 
	private StatisticsPanel stats; 
	private JRadioButton begin, home, statistics;

	
/** init - constructor that allows for the java applet to be initialized  **/
 public void init()
  {
    setSize (WIDTH, HEIGHT);
    
    cards= new JPanel(new CardLayout());
   
    start = new StartPanel();
    game = new GamePanel(); 
    stats = new StatisticsPanel(); 
    
    wholePanel = new JPanel();
	
	begin = new JRadioButton("Start!");
	begin.setFont(new Font("Serif", Font.BOLD, 30));
	home = new JRadioButton("Go Back!");
	home.setFont(new Font("Serif", Font.BOLD, 30));
	statistics = new JRadioButton("Statistics!");
	statistics.setFont(new Font("Serif", Font.BOLD, 30));
	
	ButtonGroup group = new ButtonGroup();
	group.add(begin);
	group.add(home);
	group.add(statistics);
	
	RadioButtonListener listener = new RadioButtonListener();
	begin.addActionListener(listener);
	home.addActionListener(listener);
	statistics.addActionListener(listener);
	
	wholePanel.setLayout(new GridLayout(1,3));

	wholePanel.add(home);
	wholePanel.add(begin);
	wholePanel.add(statistics);
	home.setVisible(false);
	
	this.setLayout(new BorderLayout());
	this.add(wholePanel, BorderLayout.SOUTH);    
    this.add(cards, BorderLayout.CENTER);
    
    cards.add(start, "StartPanel");
    cards.add(game,"GamePanel");
    cards.add(stats,"StatisticsPanel");
    
    CardLayout card1 = (CardLayout)(cards.getLayout());
	card1.show(cards, "StartPanel");
		
  }
 /** RadioButtonListener - class that uses the ActionListener in order to record when a radio button is clicked **/
	 private class RadioButtonListener implements ActionListener
	 {
	  public void actionPerformed(ActionEvent event)
	   {
		  	Object source = event.getSource();
		  	
		  	if(source == begin)
		  	{
		  		CardLayout card1 = (CardLayout)(cards.getLayout());
		 	    card1.show(cards, "GamePanel");	
		 	    home.setVisible(true);
		  	}
		  	
		  	if(source == home)
		  	{
		  		CardLayout card1 = (CardLayout)(cards.getLayout());
		  		card1.show(cards, "StartPanel");	
		  		home.setVisible(false);
		  	}
		  	
		  	if(source == statistics)
		  	{
		  		CardLayout card1 = (CardLayout)(cards.getLayout());
		  		card1.show(cards, "StatisticsPanel");
		  		home.setVisible(true);
		  	}
		
	   } //end of actionPerformed method
	} //end of RadioButtonListener class
	 
 

}
