import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class PokerStep implements ActionListener{
	JLabel left;
	JLabel right;
	JLabel r;
	JButton b;
	JButton end;
	JPanel tela;

	Rules rules;

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
	private int dealerhandsize = 5;
	private int playerhandsize = 4;
	ArrayList<String> dealerhand;
	ArrayList<String> playerhand;
	ImageIcon imagemCarta;
	ImageIcon cardback;

	PokerStep(
			JPanel buttons,
			JLabel card1, JLabel card2, JLabel card3, JLabel card4, JLabel card5,
			JLabel card1d, JLabel card2d, JLabel card3d, JLabel card4d, JLabel card5d,
			JLabel left, JLabel right,
			JLabel r,
			JButton b, JButton end,
			JPanel tela,
			Rules rules
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
		rules.reset();
		rules.setup();
		dealerhand = rules.getDealerHand();

		while(currentcard<dealerhandsize){
	    	imagemCarta = new ImageIcon("img/" + dealerhand.get(currentcard) + ".png");
			switch(currentcard){
				case 0:
					card1d.setIcon(imagemCarta);
					break;
				case 1:
					card2d.setIcon(imagemCarta);
					break;
				case 2:
					card3d.setIcon(imagemCarta);
					break;
				case 3:
					card4d.setIcon(imagemCarta);
					break;
				case 4:
					card5d.setIcon(imagemCarta);
					break;
				default:
					break;
			}
			currentcard++;
		}
		currentcard = 0;

    cardback = new ImageIcon("img/capa2.png");
    card3.setIcon(cardback);

    playerhand = rules.getPlayerHand();
    while(currentcard<playerhandsize){
	    	imagemCarta = new ImageIcon("img/" + playerhand.get(currentcard) + ".png");
			switch(currentcard){
				case 0:
					card1.setIcon(imagemCarta);
					break;
				case 1:
					card2.setIcon(imagemCarta);
					break;
				case 2:
					card4.setIcon(imagemCarta);
					break;
				case 3:
					card5.setIcon(imagemCarta);
					break;
				case 4:
					break;
				default:
					break;
			}
			currentcard++;
		}
		currentcard = 0;

		tela.add(left, BorderLayout.LINE_START);
		left.setText(rules.getPlayer1());
		tela.add(right, BorderLayout.LINE_END);
		right.setText(rules.getPlayer2());
		r.setText(rules.getResult());
		tela.repaint();
	}
}
