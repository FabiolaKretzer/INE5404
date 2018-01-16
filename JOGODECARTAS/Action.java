//package generic_cardgame;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Action implements ActionListener{
	JLabel left;
  	JLabel right;
	JLabel r;
    JButton b;
    JButton end;
    JPanel tela;

    Blackjack rules;
    ArrayList<String> playerhand;
    ImageIcon cardimage;

    ImageIcon imagemCardback = new ImageIcon("img/capa2.png");
    JLabel card1;
  	JLabel card2;
	JLabel card3;
	JLabel card4;
	JLabel card5;
	JLabel card1d;
	JLabel card2d;
	JLabel card3d;
	JLabel card4d;
	JLabel card5d;
	JPanel buttons;

	private int currentcard = 0;
	private boolean first = true;

	Action(
			JPanel buttons,
			JLabel card1, JLabel card2, JLabel card3, JLabel card4, JLabel card5,
			JLabel card1d, JLabel card2d, JLabel card3d, JLabel card4d, JLabel card5d,
			JLabel left, JLabel right,
			JLabel r,
			JButton b, JButton end,
			JPanel tela,
			Blackjack rules
			){

		this.buttons = buttons;
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.card4 = card4;
		this.card5 = card5;
		this.card1d = card1d;
		this.card2d = card2d;
		this.card3d = card3d;
		this.card4d = card4d;
		this.card5d = card5d;
		this.left = left;
		this.right = right;
		this.r = r;
		this.b = b;
		this.end = end;
		this.tela = tela;
		this.rules = rules;

	}

	public void actionPerformed(ActionEvent e){
		if (first){
			//to-do reset logic
			buttons.add(end);
			end.addActionListener(new EndGame(buttons,card1,card2,card3,card4,card5, card1d,card2d,card3d,card4d,card5d, left,right,r,b,end,tela,rules)); //sets up the stop button
			first = false;
			rules.dealerHit();
			card1d.setIcon(imagemCardback);
			b.setText("HIT ME");
		}

		rules.playerHit();
		r.setText(String.valueOf(rules.getPlayerScore()));
		playerhand = rules.getPlayerHand();
		cardimage = new ImageIcon("img/" + playerhand.get(currentcard) + ".png");

		switch(currentcard){
		case 0:
			card1.setIcon(cardimage);
			break;
		case 1:
			card2.setIcon(cardimage);
			break;
		case 2:
			card3.setIcon(cardimage);
			break;
		case 3:
			card4.setIcon(cardimage);
			break;
		case 4:
			card5.setIcon(cardimage);
			break;
		default:
			break;
		}
		currentcard++;

		if (rules.getPlayerScore()==21){
			//rules.endgame(false);
			r.setText("YOU WIN [score: " + String.valueOf(rules.getPlayerScore()) + "]");
			buttons.remove(end);
			buttons.remove(b); //temp
		} else if(rules.getPlayerScore() > 21){
			//player loses
			r.setText("YOU LOSE [score: " + String.valueOf(rules.getPlayerScore()) + "]");
			buttons.remove(end);
			buttons.remove(b); //temp
		}
		tela.repaint();

	}

}