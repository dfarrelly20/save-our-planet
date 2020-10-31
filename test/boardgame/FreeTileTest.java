package boardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Kevin May
 *
 */
class FreeTileTest {

		//test data
		String validName;
		String messageValid;


		@BeforeEach
		void setUp() throws Exception {
			validName = "Valid Name";
			messageValid = "Valid Message";
		}

		@Test
		void testGoTileConstructorDefault() {
			FreeTile ft = new FreeTile();
			
			assertNotNull(ft);

		}
		@Test
		void testGoTileConstructorArgsValid() {
			
			FreeTile ft = new FreeTile(validName);
			assertEquals(validName, ft.getName());
			
		}
}

