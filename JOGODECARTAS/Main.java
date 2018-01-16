import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;

class Main {

	public static void main (String[] args){
		JFrame f;
	    f = new JFrame();
	    JPanel tela;    
	    tela = new JPanel();

	    f.setContentPane(tela);
	    configTela(tela);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setSize(1200,600); //lar x alt
	    f.setVisible(true);
		}

	static void configTela(JPanel tela){
		CardLayout cardLayout = new CardLayout();
		tela.setLayout(cardLayout);

		JPanel menu = new JPanel();
		menu.setLayout(new BorderLayout(10,10));
		tela.add(menu, "menu");
		cardLayout.show(tela, "menu");

		JLabel title = new JLabel("Escolha um jogo",SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		menu.add(title, BorderLayout.CENTER);
		JPanel options = new JPanel();
		JButton b_blackjack = new JButton("BLACKJACK");
		JButton b_poker = new JButton("POKER");
		b_blackjack.addActionListener(new BlackjackMain(tela, cardLayout));
		b_poker.addActionListener(new PokerMain(tela, cardLayout));
		options.add(b_blackjack);
		options.add(b_poker);
		menu.add(options, BorderLayout.PAGE_END);


	}
}