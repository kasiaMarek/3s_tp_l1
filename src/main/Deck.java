import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck;
	Random generator;
	
	Deck(Rank lowestRank){
		if(lowestRank != Rank.TWO && lowestRank != Rank.SEVEN && lowestRank != Rank.NINE)
			throw new IllegalArgumentException("niepoprawna wartosc");
		deck = new ArrayList<Card>();
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		generator = new Random();
		for(Suit suit : suits)
			for(Rank rank : ranks)
				if(rank.compareTo(lowestRank) >= 0)
					deck.add(new Card(rank,suit));
	}
	
	public String toString() {
		int size = deck.size();
		String string = "";
		for(int i = 0; i < size; i++)
			string += deck.get(i).toString();
		return string;
	}
	
	public int getDeckSize() {
		return deck.size();
	}
	
	Card top() {
		return deck.get(deck.size()-1);
	}
	
	Card pop() {
		if(deck.size() == 0)
			return null;
		return deck.remove(deck.size()-1);
	}
	
	void sort() {
		deck.sort(new Comparator<Card>() {
			public int compare (Card card1, Card card2) {
				int compareSuit = card1.getSuit().compareTo(card2.getSuit());
				return compareSuit != 0 ? compareSuit : card1.getRank().compareTo(card2.getRank());
			}
		});
	}
	
	void shuffle() {
		int size = deck.size();
		ArrayList<Card> deck1 = new ArrayList<Card>();
		while(size > 0) {
			int random = generator.nextInt(size);
			deck1.add(deck.remove(random));
			size = deck.size();
		}
		deck = deck1;
	}
	
}
