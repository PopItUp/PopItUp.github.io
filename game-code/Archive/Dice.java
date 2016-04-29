/** CSE 360 Project - Dice class
 * @author PopItUp
 * Description: The Dice class accounts for the rolls that each player 
 * receives through the add and returnSum methods
 */
public class Dice 
{
	public boolean past = false;
	private int rank = 0;
	private int pops = 0;
	private int rolls = 0;
	private int sum = 0;
	/**add - The dice is rolled and random values are pushed in but only the even numbers will make the balloon pop.
	 * The odd numbers of the dice will not do anything
	 * Also the sum is thing which saves the added values
	 * If the sum is lesser than 20 (which is the max limit to reach by any player) then the balloon dosen't pop
	 * 
	 * @param in, random values that could potentially be added to the score
	 **/
	public void add(int in)
	{
		if(in % 2==0)
		{
			sum += in;
			if(sum >= 20)
			{
				System.out.print("The balloon is popped");
				past = true;
			}
			else
			{
				System.out.print("The balloon is not popped");
			}
		}
		else if(sum < 20)
		{
				System.out.print("The balloon is not popped");
		}
	}
	/** return- returns the calculated total that represents the players current score 
	 * 
	 * @return int, returns the modified private instance variable of sum.
	 * 
	 ** reset- will reset the values as soon as the game is reseted i.e after pressing the Civil War-2 button
	 *
	 *@reset int, returns the sum which is assigned to 0. 
	 **/
	public int resetsum(){
		sum = 0;
		return sum;
	}
	
	public int returnSum()
	{
		return sum;
	}
	
	/** getPops will return the number of games the player has won
	 * 
	 * @return pops - number of balloons popped by the player
	 */
	public int getPops()
	{
		return pops;
	}
	
	/** getRolls will return the number of rolls the player had since the last game
	 * 
	 * @return rolls - the number of times the player rolled the die before the game ended
	 */
	public int getRolls()
	{
		return rolls;
	}
	
	/** getRanks will return the rank that the player has from the last game
	 * 
	 * @return rank - the rank associated with each player
	 */
	public int getRanks()
	{
		return rank;
	}
	
	/** setRank will set the rank of the winner to number one every time
	 * 
	 * @param place - will be the ranking out of 4 that the player receives after the game
	 */
	public void setRank(int place)
	{
		rank = place;
	}
	
	/** incPops will increment the variable that keeps track of how many balloons a registered user has popped
	 * 
	 */
	public void incPops()
	{
		pops += 1;
	}
	
	/** incRolls will increment the variable each player has that keeps track of how many times they rolled the die.
	 * 
	 */
	public void incRolls()
	{
		rolls += 1;
	}
}
