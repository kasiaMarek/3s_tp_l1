import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DecksTest {
	Deck deck;
	
	@Before
	public void beforeTest() {
		System.out.println("A new test started");
		deck = new Deck(Rank.TWO);
	}
	
	@After
	public void afterTest() {
		deck = null;
		System.out.println("A test finished");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWrongDeckSize() {
		new Deck(Rank.FOUR);
	}
	@Test
	public void testDeckSize() {
		deck = new Deck(Rank.SEVEN);
		assertEquals(32,deck.getDeckSize());
	}
	
	@Test
	public void testTop() {
		deck = new Deck(Rank.NINE);
		assertEquals(new Card(Rank.AS, Suit.SPADE).toString(), deck.top().toString());
	}
	
	@Test
	public void testPop() {
		deck.pop();
		assertEquals(Rank.KING, deck.pop().getRank());
	}
	
	@Test
	public void testCardsUnder7AreNotIn32CardsDeck() {
		deck = new Deck(Rank.SEVEN);
		boolean cantFindFive = true;
		while (deck.getDeckSize() > 0) {
			if(deck.pop().getRank() == Rank.FIVE) {
				cantFindFive = false;
			}
		}
		assertTrue(cantFindFive);
	}
	
	@Test
	public void testToSting() {
		Deck deck2 = new Deck(Rank.TWO);
		assertEquals(deck.toString(), deck2.toString());
		
	}
	
	@Test(timeout = 1)
	public void testShuffle() {
		Deck deck2 = new Deck(Rank.TWO);
		deck.shuffle();
		if(deck.toString() == null || deck2.toString() == null)
			fail("one of the decks is null");
		boolean areSame = deck.toString().equals(deck2.toString());
		assertFalse(areSame);
	}
	
	@Test
	public void testSort() {
		Deck deck2 = new Deck(Rank.TWO);
		deck.shuffle();
		deck.sort();
		if(deck.toString() == null || deck2.toString() == null)
			fail("one of the decks is null");
		boolean areSame = deck.toString().equals(deck2.toString());
		assertTrue(deck.toString(), areSame);
	}
	
	@Test
	public void testDecksSizeAfterOperations() {
		deck.shuffle();
		assertEquals(deck.toString(),52,deck.getDeckSize());
		
	}
	
	@Test
	public void testPopingFromEmptyDeck() {
		while(deck.getDeckSize() > 0)
			deck.pop();
		assertNull(deck.pop());
	}
	
	@Test
	public void testPopDoesNotChangeDecksSize() {
		deck.pop();
		assertEquals(deck.toString(),51,deck.getDeckSize());
	}
	
	@Test
	public void testSortDoesNotChangeSize() {
		deck.shuffle();
		deck.sort();
		assertEquals(deck.toString(),52,deck.getDeckSize());
	}
	
	@Ignore
	@Test
	public void testTopDoesNotRemoveCards() {
		deck.top();
		assertEquals(deck.toString(),52,deck.getDeckSize());
	}

}
