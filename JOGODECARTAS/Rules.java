
import java.util.*;

class Rules{

	boolean first;
	Player player;
	Player dealer;
	Deck deck;

	ComparaDuasMaos rodada;
	String result;

	ArrayList<String> playerhand;
	ArrayList<String> dealerhand;
	ArrayList<String> cartas1;
	ArrayList<String> cartas2;
	ValorMao mao1;
	String maoJogador1;
	ValorMao mao2;
	String maoJogador2;

	Rules(){
		this.setup();
	}

	void setup(){
		first = true;
		player = new Player();
		dealer = new Player();
		deck = new Deck();

		this.playerHit();
		this.dealerHit();

		playerhand = this.getPlayerHand();
		dealerhand = this.getDealerHand();

		cartas1 = new ArrayList<String>();
		for (int i = 0; i<2; i++){
			cartas1.add(playerhand.get(i));
		}
		for (int i = 0; i<5; i++){
			cartas1.add(dealerhand.get(i));
		}
		cartas2 = new ArrayList<String>();
		for (int i = 2; i<4; i++){
			cartas2.add(playerhand.get(i));
		}
		for (int i = 0; i<5; i++){
			cartas2.add(dealerhand.get(i));
		}


		mao1 = new ValorMao(cartas1);
		maoJogador1 = mao1.classificaMao();
		mao2 = new ValorMao(cartas2);
		maoJogador2 = mao2.classificaMao();

		rodada = new ComparaDuasMaos(maoJogador1, maoJogador2);
		result = rodada.comparaMaos();
	}

	String getResult(){
		return result;
	}

	String getPlayer1(){
		return rodada.getMao1();
	}

	String getPlayer2(){
		return rodada.getMao2();
	}

	void notFirst(){
		first = false;
	}

	void first(){
		first = true;
	}

	boolean getFirst(){
		return first;
	}

	void reset(){
		first = true;
		player.resetHand();
		dealer.resetHand();
		deck.resetDeck();
	}

	ArrayList<String> getPlayerHand(){
		return player.getHandList();
	}


	ArrayList<String> getDealerHand(){
		return dealer.getHandList();
	}



	void playerHit(){
		player.addHand(deck.drawCard());
		player.addHand(deck.drawCard());
		player.addHand(deck.drawCard());
		player.addHand(deck.drawCard());

	}

	void dealerHit(){
		dealer.addHand(deck.drawCard());
		dealer.addHand(deck.drawCard());
		dealer.addHand(deck.drawCard());
		dealer.addHand(deck.drawCard());
		dealer.addHand(deck.drawCard());


	}
}
