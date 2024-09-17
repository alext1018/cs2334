import java.util.Objects;

public class Card implements Comparable<Card>{
	private Rank rank;
	private Suit suit;
	public Card(Rank rank, Suit suit) {
		if(rank==null||suit==null) {
			throw new NullPointerException();
		}
		this.rank=rank;
		this.suit=suit;
	}
	public int compareTo(Card card) {
		
		if(getSuit()!=card.getSuit()) {
			return getSuit().compareTo(card.getSuit());
		}
		if(getRank()!=card.getRank()) {
			return getRank().compareTo(card.getRank());
		}
		return 0;
		
	}
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Card)) {
			return false;
		}
		Card newObject = (Card)obj;
		return newObject.rank==rank&&newObject.suit==suit;
				
	}
	public Rank getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public int hashCode() {
		return Objects.hash(this.rank,this.suit);
	}
	public String toString() {
		return rank.toString()+suit.toString();
	}

	
}
