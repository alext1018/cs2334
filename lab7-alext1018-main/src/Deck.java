import java.util.Collection;
import java.util.Collections;
import java. util. ArrayList;
import java.util.List;
public class Deck  {
	private List<Card> cards;
	public Deck() {
		cards=new ArrayList<>();
		for(Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card c =new Card(r,s);
				cards.add(c);
			}
			
		}
	}
	public int size() {
		return cards.size();
	}
	public String toString() {
		return cards.toString();
	}
	public Card draw() {		
		if(cards.isEmpty()) {
			return null;
		}
		if(cards.size()>0) {
		cards.get(0);
		}	
		return cards.remove(0);
		
	}
	public List<Card> draw(int count){
		List<Card> remove = new ArrayList<>();
		if(count<0) {	
			return remove;
		}
		if(count>cards.size()) {
			int a = cards.size();
		while(a!=0)
		{
			remove.add(draw());
			a-=1;
			
		}
		return remove;
		}
		for(int j=0;j<count;j++)
		{
			remove.add(draw());
		}
		
		
		return remove;
		}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public List<Card> getCardsByRank(Rank rank){
		List<Card> cardsRank = new ArrayList<>();
		for(int i =0; i<cards.size();i++) {
			if(cards.get(i).getRank() == rank) {
				cardsRank.add(cards.get(i));
			}
		}
		return cardsRank;
	}
	
}
