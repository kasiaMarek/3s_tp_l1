public class Card {
	private Suit suit;
	private Rank rank;
	
	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}
	
	Card(Rank rank, Suit suit) {
		this.suit = suit;
		this.rank = rank;
	}
	public String toString() {
		return rank.toString().toString() + " " + suit.toString();
	}
}
