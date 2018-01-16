
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;

class BlackjackMain implements ActionListener {

	CardLayout cardLayout;
	JPanel tela;


	BlackjackMain(JPanel tela, CardLayout cardLayout){
		this.tela = tela;
		this.cardLayout = cardLayout;
	}

	public void actionPerformed(ActionEvent e){
		JPanel blackjack = new JPanel();
		blackjack.setLayout(new BorderLayout(10,10));

		JPanel playarea = new JPanel();
	  	playarea.setLayout(new BorderLayout(10,10));

	    JLabel r=new JLabel("BLACKJACK", SwingConstants.CENTER);
	    r.setVerticalAlignment(SwingConstants.BOTTOM);

	    JPanel buttons = new JPanel();
	    JPanel centerhand = new JPanel();
	    JLabel card1 = new JLabel();
	    JLabel card2 = new JLabel();
	    JLabel card3 = new JLabel();
	    JLabel card4 = new JLabel();
	    JLabel card5 = new JLabel();
	    JLabel card1d = new JLabel();
	    JLabel card2d = new JLabel();
	    JLabel card3d = new JLabel();
	    JLabel card4d = new JLabel();
	    JLabel card5d = new JLabel();
	    JPanel cardDealer = new JPanel();

	    JButton b;
	    JButton ret;
	    JLabel left = new JLabel("DEALER");
	    JLabel right = new JLabel("YOU");
	    JButton end = new JButton("STOP");
	    Blackjack rules = new Blackjack();

	    blackjack.add(playarea,BorderLayout.CENTER);
	    playarea.add(r,BorderLayout.CENTER);
	    playarea.add(centerhand,BorderLayout.PAGE_END);
	    playarea.add(cardDealer,BorderLayout.PAGE_START);
	    centerhand.add(card1);
	    centerhand.add(card2);
	    centerhand.add(card3);
	    centerhand.add(card4);
	    centerhand.add(card5);
	    cardDealer.add(card1d);
	    cardDealer.add(card2d);
	    cardDealer.add(card3d);
	    cardDealer.add(card4d);
	    cardDealer.add(card5d);
	    blackjack.add(buttons,BorderLayout.PAGE_END);
	    buttons.add(b=new JButton("play"));
	    buttons.add(ret=new JButton("menu"));

	    b.addActionListener(new Action(buttons,card1,card2,card3,card4,card5, card1d,card2d,card3d,card4d,card5d, left,right,r,b,end,blackjack,rules));
	    ret.addActionListener(new Return(cardLayout,tela));
	    tela.add(blackjack, "blackjack");
	    cardLayout.show(tela, "blackjack");
	    tela.repaint();
	}
}