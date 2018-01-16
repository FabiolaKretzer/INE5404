
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Deck {
	private ArrayList<String> cards;
	int next = 0;

	Deck(){
		cards = new ArrayList<String>(52);
		this.resetDeck();
	}

	void checkDeck(){ //DEBUG ONLY
	    for(int i=0; i<cards.size(); i++ ){
	      System.out.println(cards.get(i));
	    }
	   System.out.println("===");
	   System.out.println(cards.size());
	   System.out.println("===");
	}

	String drawCard(){
		next = ThreadLocalRandom.current().nextInt(0, cards.size());
		String card = cards.get(next);
		cards.remove(next);
		cards.trimToSize();
		return card;
	}

	void resetDeck(){
		cards.clear();
		cards.trimToSize();
		cards.add("Ac"); //welp, there's probably a better way to do this.
	    cards.add("2c");
	    cards.add("3c");
	    cards.add("4c");
	    cards.add("5c");
	    cards.add("6c");
	    cards.add("7c");
	    cards.add("8c");
	    cards.add("9c");
	    cards.add("10c");
	    cards.add("Jc");
	    cards.add("Qc");
	    cards.add("Kc");
	    cards.add("Ad");
	    cards.add("2d");
	    cards.add("3d");
	    cards.add("4d");
	    cards.add("5d");
	    cards.add("6d");
	    cards.add("7d");
	    cards.add("8d");
	    cards.add("9d");
	    cards.add("10d");
	    cards.add("Jd");
	    cards.add("Qd");
	    cards.add("Kd");
	    cards.add("Ah");
	    cards.add("2h");
	    cards.add("3h");
	    cards.add("4h");
	    cards.add("5h");
	    cards.add("6h");
	    cards.add("7h");
	    cards.add("8h");
	    cards.add("9h");
	    cards.add("10h");
	    cards.add("Jh");
	    cards.add("Qh");
	    cards.add("Kh");
	    cards.add("As");
	    cards.add("2s");
	    cards.add("3s");
	    cards.add("4s");
	    cards.add("5s");
	    cards.add("6s");
	    cards.add("7s");
	    cards.add("8s");
	    cards.add("9s");
	    cards.add("10s");
	    cards.add("Js");
	    cards.add("Qs");
	    cards.add("Ks");
	}
}