package boardgame;

import static org.junit.Assert.assertNotNull;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Mark Kelly
 *
 */
class DiceTest {
	
	Dice dice;

	@BeforeEach
	void setUp() throws Exception {
		dice = new Dice();
		
	}
	@Test
	public void testDiceConstructor() {
		assertNotNull(dice);
	}

	@Test
	void testValidRoll() {
		for (int loop = 1; loop <= 1; loop++) {
			int value = dice.rollDie();
			Assert.assertTrue(value>2 && value <=12);
		}
	}
	
	@Test 
	void testInvalidRollUpper() {
		for (int loop = 1; loop <= 1; loop++) {
			int value = dice.rollDie();
			Assert.assertFalse(value>12);
		}
	}
	
	@Test
	void testInvalidRollLower() {
		for (int loop = 1; loop <= 1; loop++) {
			int value = dice.rollDie();
			Assert.assertFalse(value<2);
		}
	}

}
