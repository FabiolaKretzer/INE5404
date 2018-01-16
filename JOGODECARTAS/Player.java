
import java.util.*;

class Player{
	int score;
	ArrayList<String> hand;

	Player(){
		score = 0;
		hand = new ArrayList<String>();
	}

	/*
	* HAND FUNCTIONS
	*/

	ArrayList<String> getHandList(){
		return hand;
	}

	String getHand(){
		return hand.toString();
	}

	void addHand(String card){
		hand.add(card);
	}

	void resetHand(){
		hand.clear();
	}

	/*
	* SCORE FUNCTIONS
	*/

	int getScore(){
		return score;
	}

	void addScore(int val){
		score+=val;
	}

	void resetScore(){
		score = 0;
	}
	
}
