import java.awt.event.*;
import javax.swing.*;

public class Aplicacao implements ActionListener {
	JLabel r;
	JButton b;
	JPanel tela;

	public Aplicacao(JLabel r, JButton b, JPanel tela) {
		this.r = r;
		this.b = b;
		this.tela = tela;		
	}
	public void actionPerformed(ActionEvent e){
		tela.remove(b);
		r.setText("TUDO BEM!");
		tela.repaint();
	}

}
