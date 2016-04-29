import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class PlayerTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void testPlayer() {
		Player player = new Player();
		
		assertNotNull(player);
	}
	
	@Test
	public void testPoppedPlayer1() {
		Player player = new Player();
		
		player.testAdd(1, 20);
		
		assertEquals("The balloon is popped", outContent.toString());
	}
	
	@Test
	public void testPoppedPlayer2() {
		Player player = new Player();
		
		player.testAdd(2, 20);
		
		assertEquals("The balloon is popped", outContent.toString());
	}
	
	@Test
	public void testPoppedPlayer3() {
		Player player = new Player();
		
		player.testAdd(3, 20);
		
		assertEquals("The balloon is popped", outContent.toString());
	}
	
	@Test
	public void testPoppedPlayer4() {
		Player player = new Player();
		
		player.testAdd(4, 20);
		
		assertEquals("The balloon is popped", outContent.toString());
	}
	
	@Test
	public void testNotPoppedOddPlayer1() {
		Player player = new Player();
		
		player.testAdd(1, 5);
		
		assertEquals("The balloon is not popped", outContent.toString());
	}
	
	@Test
	public void testNotPoppedOddPlayer2() {
		Player player = new Player();
		
		player.testAdd(2, 5);
		
		assertEquals("The balloon is not popped", outContent.toString());
	}
	
	@Test
	public void testNotPoppedOddPlayer3() {
		Player player = new Player();
		
		player.testAdd(3, 5);
		
		assertEquals("The balloon is not popped", outContent.toString());
	}
	
	@Test
	public void testNotPoppedOddPlayer4() {
		Player player = new Player();
		
		player.testAdd(4, 5);
		
		assertEquals("The balloon is not popped", outContent.toString());
	}
	
	@Test
	public void testNotPoppedEvenPlayer1() {
		Player player = new Player();
		
		player.testAdd(1, 6);
		
		assertEquals("The balloon is not popped", outContent.toString());
	}
	
	@Test
	public void testNotPoppedEvenPlayer2() {
		Player player = new Player();
		
		player.testAdd(2, 6);
		
		assertEquals("The balloon is not popped", outContent.toString());
	}
	
	@Test
	public void testNotPoppedEvenPlayer3() {
		Player player = new Player();
		
		player.testAdd(3, 6);
		
		assertEquals("The balloon is not popped", outContent.toString());
	}
	
	@Test
	public void testNotPoppedEvenPlayer4() {
		Player player = new Player();
		
		player.testAdd(4, 6);
		
		assertEquals("The balloon is not popped", outContent.toString());
	}
	
	@Test
	public void testRollsPlayer1() {
		Player player = new Player();
		
		player.addRoll(1);
		
		assertEquals(1, player.getRolls(1));
	}
	
	@Test
	public void testRollsPlayer2() {
		Player player = new Player();
		
		player.addRoll(2);
		player.addRoll(2);
		
		assertEquals(2, player.getRolls(2));
	}
	
	@Test
	public void testRollsPlayer3() {
		Player player = new Player();
		
		player.addRoll(3);
		player.addRoll(3);
		player.addRoll(3);
		
		assertEquals(3, player.getRolls(3));
	}
	
	@Test
	public void testRollsPlayer4() {
		Player player = new Player();
		
		player.addRoll(4);
		player.addRoll(4);
		player.addRoll(4);
		player.addRoll(4);
		
		assertEquals(4, player.getRolls(4));
	}
	
	@Test
	public void testRankPlayer1() {
		Player player = new Player();
		
		player.setRanks(1, 2);
		
		assertEquals(2, player.getRanks(1));
	}
	
	@Test
	public void testRankPlayer2() {
		Player player = new Player();
		
		player.setRanks(2, 4);
		
		assertEquals(4, player.getRanks(2));
	}
	
	@Test
	public void testRankPlayer3() {
		Player player = new Player();
		
		player.setRanks(3, 1);
		
		assertEquals(1, player.getRanks(3));
	}
	
	@Test
	public void testRankPlayer4() {
		Player player = new Player();
		
		player.setRanks(4, 4);
		
		assertEquals(4, player.getRanks(4));
	}
	
	@Test
	public void testAdjustRankings() {
		Player player = new Player();
		
		player.testAdd(2, 7);
		player.testAdd(3, 12);
		player.testAdd(4, 3);
		
		player.adjustRanks(1);
		
		assertEquals(3, player.getRanks(4));
		assertEquals(2, player.getRanks(3));
		assertEquals(4, player.getRanks(2));
	}
}
