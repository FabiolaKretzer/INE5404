import java.awt.*;
import javax.swing.*;



public class Main {
	
	public static void main(String[] dsd){
		JFrame f;
		f = new JFrame();
		JPanel tela;
		tela = new JPanel();
		f.setContentPane(tela);
		configTela(tela);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,400); //largura x altura
		//f.pack();
		f.setVisible(true);		
	}
	static void configTela(JPanel tela){
		JLabel r;
		JButton b;
		
		tela.setLayout(new FlowLayout());
		tela.add(r = new JLabel("CLIQUE AO LADO..."));
		tela.add(b = new JButton());
		b.addActionListener(new Aplicacao(r,b,tela));
	}
}