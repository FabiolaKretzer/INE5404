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
		f.setVisible(true);		
	}
	static void configTela(JPanel tela){
		tela.setLayout(new BorderLayout());
		tela.add(new JLabel("A"),BorderLayout.NORTH); //WEST,EAST
		tela.add(new JLabel("B"),BorderLayout.CENTER);
		JPanel p;
		tela.add(p = new JPanel(),BorderLayout.SOUTH);
		p.setLayout(new FlowLayout());
		p.add(new JLabel("C"));
		p.add(new JLabel("D"));
		p.add(new JLabel("E"));
	}
}