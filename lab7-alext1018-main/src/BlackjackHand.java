import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
	private static  Map<Rank,Integer> CARD_VALUES = new HashMap<>();
	static {
		CARD_VALUES.put(Rank.TWO, 2);
		CARD_VALUES.put(Rank.THREE, 3);
		CARD_VALUES.put(Rank.FOUR, 4);
		CARD_VALUES.put(Rank.FIVE, 5);
		CARD_VALUES.put(Rank.SIX, 6);
		CARD_VALUES.put(Rank.SEVEN, 7);
		CARD_VALUES.put(Rank.EIGHT, 8);
		CARD_VALUES.put(Rank.NINE, 9);
		CARD_VALUES.put(Rank.TEN, 10);
		CARD_VALUES.put(Rank.JACK, 10);
		CARD_VALUES.put(Rank.QUEEN, 10);
		CARD_VALUES.put(Rank.KING, 10);
		CARD_VALUES.put(Rank.ACE, 11);
		
	}
	private static int MAX_VALUE =21;
	private  List<Card> cards= new ArrayList<>();
	private int value = 0;
	private int numAcesAs11=0;
	public BlackjackHand(Card c1, Card c2) {
		int rank1 = CARD_VALUES.get(c1.getRank());
		int rank2 = CARD_VALUES.get(c2.getRank());
		value = rank1+rank2;
		cards.add(c1);
		if(c1.getRank()==Rank.ACE) {
			numAcesAs11++;
		}
			cards.add(c2);
			if(c2.getRank()==Rank.ACE) {
				numAcesAs11++;
		
		}
			
			if(numAcesAs11 > 0 && value > MAX_VALUE) {
				numAcesAs11--;
				value-=10;
			}
		}
	
	
	public void addCard(Card card) {
        if (card == null)
            throw new NullPointerException();

        if (value < MAX_VALUE) {
            cards.add(card);
            value += CARD_VALUES.get(card.getRank());
            if (card.getRank() == Rank.ACE)
                numAcesAs11++;
        }
        if (value > MAX_VALUE && numAcesAs11 > 0) {
            value -= 10;
            numAcesAs11--;
        }
    }
		
	
	public int size() {
		return cards.size();
		
	}
	public static Map<Rank,Integer> getCardValues(){
		return new HashMap<>(CARD_VALUES);
	}
	public List<Card> getCards(){
		List<Card> newCard= new ArrayList<Card>(cards);
		return newCard;
		
	}
	public int getValue() {

       return value;
    }
	public String toString() {
		return cards.toString();
		
	}
	

}

