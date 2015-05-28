package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testInitGameStateAvailableSpace() {
		Game test = new Game();
		test.initGameState(4, 2048);
		assertTrue(test.availableSpace());
	}

	@Test
	public void testInitGameStateCanShift() {
		Game test = new Game();
		test.initGameState(4, 2048);
		assertTrue(test.canShift());
	}

	@Test
	public void testInitGameStateCanShiftDown() {
		Game test = new Game();
		test.initGameState(4, 2048);
		assertTrue(test.canShiftDown());
	}

	@Test
	public void testInitGameStateCanShiftUp() {
		Game test = new Game();
		test.initGameState(4, 2048);
		assertTrue(test.canShiftUp());
	}

	@Test
	public void testInitGameStateCanShiftLeft() {
		Game test = new Game();
		test.initGameState(4, 2048);
		assertTrue(test.canShiftLeft());
	}

	@Test
	public void testInitGameStateCanShiftRight() {
		Game test = new Game();
		test.initGameState(4, 2048);
		assertTrue(test.canShiftRight());
	}

	@Test
	public void testInitGameStateGameEnded() {
		Game test = new Game();
		test.initGameState(4, 2048);
		assertTrue(!test.gameEnded());
	}

	@Test
	public void testInitGameStateGetBoard() {
		Game test = new Game();
		test.initGameState(4, 2048);
		assertArrayEquals(new int[4][4],test.getBoard());
	}

	@Test
	public void testInitGameStateGetScore() {
		Game test = new Game();
		test.initGameState(4, 2048);
		assertEquals(0,test.getScore());
	}

	@Test
	public void testInitGameAvailableSpace() {
		Game test = new Game();
		test.initGame(4, 2048);
		assertTrue(test.availableSpace());
	}

	@Test
	public void testInitGameCanShift() {
		Game test = new Game();
		test.initGame(4, 2048);
		assertTrue(test.canShift());
	}

	@Test
	public void testInitGameCanShiftDown() {
		Game test = new Game();
		test.initGame(4, 2048);
		assertTrue(test.canShiftDown());
	}

	@Test
	public void testInitGameCanShiftUp() {
		Game test = new Game();
		test.initGame(4, 2048);
		assertTrue(test.canShiftUp());
	}

	@Test
	public void testInitGameCanShiftLeft() {
		Game test = new Game();
		test.initGame(4, 2048);
		assertTrue(test.canShiftLeft());
	}

	@Test
	public void testInitGameCanShiftRight() {
		Game test = new Game();
		test.initGame(4, 2048);
		assertTrue(test.canShiftRight());
	}

	@Test
	public void testInitGameGameEnded() {
		Game test = new Game();
		test.initGame(4, 2048);
		assertTrue(!test.gameEnded());
	}

	@Test
	public void testInitGameGetBoard() {
		Game test = new Game();
		test.initGame(4, 2048);
		for (int[] x : test.getBoard()){
			for (int y : x) {
				assertTrue(0 <= y && y <= 4);
			}
		}
	}

	@Test
	public void testInitGameGetScore() {
		Game test = new Game();
		test.initGame(4, 2048);
		assertEquals(0,test.getScore());
	}

	@Test
	public void testInitGameAvailableSpace1x1() {
		Game test = new Game();
		test.initGame(1, 2048);
		assertTrue(!test.availableSpace());
	}

	@Test
	public void testInitGameCanShift1x1() {
		Game test = new Game();
		test.initGame(1, 2048);
		assertTrue(!test.canShift());
	}

	@Test
	public void testInitGameCanShiftDown1x1() {
		Game test = new Game();
		test.initGame(1, 2048);
		assertTrue(!test.canShiftDown());
	}

	@Test
	public void testInitGameCanShiftUp1x1() {
		Game test = new Game();
		test.initGame(1, 2048);
		assertTrue(!test.canShiftUp());
	}

	@Test
	public void testInitGameCanShiftLeft1x1() {
		Game test = new Game();
		test.initGame(1, 2048);
		assertTrue(!test.canShiftLeft());
	}

	@Test
	public void testInitGameCanShiftRight1x1() {
		Game test = new Game();
		test.initGame(1, 2048);
		assertTrue(!test.canShiftRight());
	}

	@Test
	public void testInitGameGameEnded1x1() {
		Game test = new Game();
		test.initGame(1, 2048);
		assertTrue(test.gameEnded());
	}

	@Test
	public void testInitGameGetBoard1x1() {
		Game test = new Game();
		test.initGame(1, 2048);
		for (int[] x : test.getBoard()){
			for (int y : x) {
				assertTrue(0 <= y && y <= 4);
			}
		}
	}

	@Test
	public void testInitGameGetScore1x1() {
		Game test = new Game();
		test.initGame(1, 2048);
		assertEquals(0,test.getScore());
	}

	@Test(expected = NegativeArraySizeException.class)
	public void testInitGameStateNegativeSize() {
		Game test = new Game();
		test.initGame(-1, 2048);
		assertEquals(1,test.getBoard().length);
	}

	@Test
	public void testInitGameStateNegativeObjective() {
		Game test = new Game();
		test.initGame(1, -1);
		assertTrue(test.objectiveAchieved());
		assertTrue(test.gameEnded());
	}

	@Test
	public void testInitGameStateZeroObjective() {
		Game test = new Game();
		test.initGame(1, 0);
		assertTrue(test.objectiveAchieved());
		assertTrue(test.gameEnded());
	}

	@Test
	public void testAvailableSpaceTrue() {
		Game test = new Game();
		test.initGame(2, 2);
		assertTrue(test.availableSpace());
	}

	@Test
	public void testAvailableSpaceFalse() {
		Game test = new Game();
		test.initGame(1, 2);
		test.generateNewTileIfIsAvailableSpace();
		assertTrue(!test.availableSpace());
	}

}
