package boardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Kevin May
 *
 */
class PropertyTileTest {

	// test data
	int validValue, invalidValue;
	int validRent;
	String validName, invalidName;
	TerrainTypes validTerrain, invalidTerrain;
	String validOwnerName, invalidOwnerName;
	DevelopmentTypes validDevelopmentType;
		
	@BeforeEach
	void setUp() throws Exception {
		validValue = 100;
		invalidValue = -10;
		validRent = 100;
		validName = "Valid Name";
		invalidName = " ";
		validTerrain = TerrainTypes.DESERT;
		validOwnerName = "Valid Owner Name";
		invalidOwnerName = " ";
		validDevelopmentType = DevelopmentTypes.windfarm;
	}

	@Test
	void testPropertyTileConstructorDefault() {
		PropertyTile pt = new PropertyTile();
		
		assertNotNull(pt);
	}
	
	@Test
	void testPropertyTileConstructorArgs() {
		PropertyTile pt = new PropertyTile(validName, validValue, validTerrain, validRent, validDevelopmentType);

		assertEquals(validName, pt.getName());
		assertEquals(validValue, pt.getValue());
		assertEquals(validTerrain, pt.getTerrain());
		assertEquals(validRent, pt.getRent());
		assertEquals(validDevelopmentType, pt.getDevelopmentType());
	}
	
	@Test
	void testValidOwnerName() {
		PropertyTile pt = new PropertyTile();
		
		pt.setOwnerName(validOwnerName);
		assertEquals(validOwnerName, pt.getOwnerName());
	}
	
	@Test
	void testValidValue() {
		PropertyTile pt = new PropertyTile();
		
		pt.setValue(validValue);
		assertEquals(validValue, pt.getValue());
	}
		
	@Test
	void testValidTerrain() {
		PropertyTile pt = new PropertyTile();
		
		pt.setTerrain(validTerrain);;
		assertEquals(validTerrain, pt.getTerrain());
	}
	
	@Test
	public void testBoughtTrue() {
		PropertyTile pt = new PropertyTile();
		pt.setBought(true);
		assertEquals(true, pt.isBought());
	}
	
	@Test
	public void testBoughtFalse() {
		PropertyTile pt = new PropertyTile();
		pt.setBought(false);
		assertEquals(false, pt.isBought());
	}
	
	
}
