import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Return implements ActionListener{
	CardLayout cardLayout;
	JPanel tela;

	Return(CardLayout cardLayout, JPanel tela){
		this.cardLayout = cardLayout;
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e){
		cardLayout.show(tela,"menu");
		tela.repaint();
	}
}