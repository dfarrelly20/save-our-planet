package boardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Kevin May
 *
 */
class GoTileTest {
	
	//test data
	String validName;


	@BeforeEach
	void setUp() throws Exception {
		validName = "Valid Name";
	}

	@Test
	void testGoTileConstructorDefault() {
		GoTile gt = new GoTile();
		
		assertNotNull(gt);

}
	@Test
	void testGoTileConstructorArgsValid() {
		GoTile gt = new GoTile(validName);
		
		
		assertEquals(validName, gt.getName());
		
	}	
}

