package boardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Kevin May
 *
 */
class PlayerTest {
	
	// test data
	String validName, invalidName;
	
	int validIdLower,  validIdUpper, invalidIdLower, invalidIdUpper;
	int validPositionLower, validPositionMid, validPositionUpper, invalidPositionLower, invalidPositionUpper;
	int validBalanceLower, validBalanceUpper, validBalanceMid, invalidBalanceLower, invalidBalanceUpper;
	
	Player p;

	@BeforeEach
	void setUp() throws Exception {
		Player p = new Player();
		validName = "Valid Name";
		invalidName = " ";
		
		validIdLower = 1;
		validIdUpper = 4;
		invalidIdLower = 0;
		invalidIdUpper = 5;
		
		validPositionLower = 1;
		validPositionMid = 6;
		validPositionUpper = 12;
		invalidPositionLower = 0;
		invalidPositionUpper = 13;
		
		validBalanceLower = 1;
		validBalanceMid = 5000;
		validBalanceUpper = 10000;
		invalidBalanceLower = 0;
		invalidBalanceUpper = 10001;
	}

	@Test
	void testPlayerConstructorDefault() {
		Player p = new Player();
		
		assertNotNull(p);
	}

	@Test
	void testPlayerConstructorArgsValid() {
		Player p = new Player(validIdLower, validName, validBalanceLower, validPositionLower);
		
		assertEquals(validIdLower, p.getId());
		assertEquals(validName, p.getPlayerName());
		assertEquals(validBalanceLower, p.getBalance());
		assertEquals(validPositionLower, p.getPosition());
	}
	
	@Test
	void testConstructorInvalidArgs() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			Player p = new Player(invalidIdLower, validName, validBalanceLower, validPositionLower);
		});	
		
		assertThrows(IllegalArgumentException.class, () -> {
			Player p = new Player(invalidIdUpper, validName, validBalanceLower, validPositionLower);
		});	
		
		assertThrows(IllegalArgumentException.class, () -> {
			Player p = new Player(validIdLower, invalidName, validBalanceLower, validPositionLower);
		});	
		
		assertThrows(IllegalArgumentException.class, () -> {
			Player p = new Player(validIdLower, validName, invalidBalanceLower, validPositionLower);
		});	
		
		assertThrows(IllegalArgumentException.class, () -> {
			Player p = new Player(validIdLower, validName, invalidBalanceUpper, validPositionLower);
		});	
		
		assertThrows(IllegalArgumentException.class, () -> {
			Player p = new Player(validIdLower, validName, validBalanceLower, invalidPositionLower);
		});	
		
		assertThrows(IllegalArgumentException.class, () -> {
			Player p = new Player(validIdLower, validName, validBalanceLower, invalidPositionUpper);
		});	
	}

	@Test
	void testValidPlayerName() {
		Player p = new Player();
		
		p.setPlayerName(validName);
		assertEquals(validName, p.getPlayerName());
	}
	
	@Test
	void testInvalidPlayerName() {
		Player p = new Player();
		
		assertThrows(IllegalArgumentException.class, () -> {
			p.setPlayerName(invalidName);
		});
	}

	@Test
	void testValidBalance() {
		Player p = new Player();
		
		p.setBalance(validBalanceLower);
		assertEquals(validBalanceLower, p.getBalance());
		
		p.setBalance(validBalanceMid);
		assertEquals(validBalanceMid, p.getBalance());
		
		p.setBalance(validBalanceUpper);
		assertEquals(validBalanceUpper, p.getBalance());
	}

	@Test
	void testInvalidBalance() {
		Player p = new Player();
		
		assertThrows(IllegalArgumentException.class, () -> {
			p.setBalance(invalidBalanceLower);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			p.setBalance(invalidBalanceUpper);
		});
	
	}

	@Test
	void testValidId(){
		Player p = new Player();
		
		p.setId(validIdLower);
		assertEquals(validIdLower, p.getId());
		
		p.setId(validIdUpper);
		assertEquals(validIdUpper, p.getId());
	}
	
	@Test
	void testInvalidId(){
		Player p = new Player();
		
		assertThrows(IllegalArgumentException.class, () -> {
			p.setId(invalidIdLower);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			p.setId(invalidIdUpper);
		});
	}
	
	@Test
	void testValidPosition(){
		Player p = new Player();
		
		p.setPosition(validPositionLower);
		assertEquals(validPositionLower, p.getPosition());
		
		p.setPosition(validPositionMid);
		assertEquals(validPositionMid, p.getPosition());
		
		p.setPosition(validPositionUpper);
		assertEquals(validPositionUpper, p.getPosition());
		
	}
	
	@Test
	void testInvalidPosition(){
		Player p = new Player();
		
		assertThrows(IllegalArgumentException.class, () -> {
			p.setPosition(invalidPositionLower);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			p.setPosition(invalidPositionUpper);
		});
	}
	
	@Test
	void testDepositMoneyLower() {
		Player p = new Player();
		
		p.depositFunds(validBalanceLower);
		assertEquals(1, p.getBalance());
		
	}
	
	@Test
	void testDepositMoneyMid() {
		Player p = new Player();
		
		p.depositFunds(validBalanceMid);
		assertEquals(5000, p.getBalance());
		
	}
	
	@Test
	void testDepositMoneyHigher() {
		Player p = new Player();
		
		p.depositFunds(validBalanceUpper);
		assertEquals(10000, p.getBalance());
	}
	
	@Test
	void testWithdrawMoneyLower() {
		Player p = new Player();
		p.setBalance(1000);
		p.withdrawFunds(validBalanceLower);
		assertEquals(999, p.getBalance());

	}
	
	@Test
	void testWithdrawMoneyMid() {
		Player p = new Player();
		p.setBalance(10000);
		p.withdrawFunds(validBalanceMid);
		assertEquals(5000, p.getBalance());

	}
	
	@Test
	void testWithdrawMoneyHigher() {
		Player p = new Player();
		p.setBalance(10000);
		p.withdrawFunds(validBalanceUpper);
		assertEquals(0, p.getBalance());

	}
}
