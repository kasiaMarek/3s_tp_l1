import junit.framework.TestCase;

public class DeckTest extends TestCase {
	
	public void testDeckSize() {
		Deck deck = new Deck(Rank.SEVEN);
		assertEquals(32,deck.getDeckSize());
	}
	
	public void testTop() {
		Deck deck = new Deck(Rank.NINE);
		assertEquals(new Card(Rank.AS, Suit.SPADE).toString(), deck.top().toString());
	}
	
	public void testPop() {
		Deck deck = new Deck(Rank.TWO);
		deck.pop();
		assertEquals(Rank.KING, deck.pop().getRank());
	}
	
	public void testCardsUnder7AreNotIn32CardsDeck() {
		Deck deck = new Deck(Rank.SEVEN);
		boolean cantFindFive = true;
		while (deck.getDeckSize() > 0) {
			if(deck.pop().getRank() == Rank.FIVE) {
				cantFindFive = false;
			}
		}
		assertTrue(cantFindFive);
	}
	
	public void testToSting() {
		Deck deck1 = new Deck(Rank.TWO);
		Deck deck2 = new Deck(Rank.TWO);
		assertEquals(deck1.toString(), deck2.toString());
		
	}
	
	public void testShuffle() {
		Deck deck1 = new Deck(Rank.TWO);
		Deck deck2 = new Deck(Rank.TWO);
		deck1.shuffle();
		if(deck1.toString() == null || deck2.toString() == null)
			fail("one of the decks is null");
		boolean areSame = deck1.toString().equals(deck2.toString());
		assertFalse(areSame);
	}
	
	public void testSort() {
		Deck deck1 = new Deck(Rank.SEVEN);
		Deck deck2 = new Deck(Rank.SEVEN);
		deck1.shuffle();
		deck1.sort();
		if(deck1.toString() == null || deck2.toString() == null)
			fail("one of the decks is null");
		boolean areSame = deck1.toString().equals(deck2.toString());
		assertTrue(deck1.toString(), areSame);
	}
	
	public void testDecksSizeAfterOperations() {
		Deck deck = new Deck(Rank.SEVEN);
		deck.pop();
		deck.shuffle();
		assertEquals(deck.toString(),31,deck.getDeckSize());
		
	}
}
