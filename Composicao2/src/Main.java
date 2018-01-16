import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main {

  public static void main(String[] jsdjs) {
    JFrame f;
    f = new JFrame();

    JPanel tela = new JPanel();
    f.setContentPane(tela);

    cfgGUI(tela);

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(400,500);
    f.setVisible(true);

  }

  static void cfgGUI(JPanel tela) {
    tela.setLayout(new GridLayout(2,2,5,5)); //lin x col
    JButton b;
    int n = 1;
    b = new JButton();
    b.addActionListener(new Gestor(n++));
    tela.add(b);
    b = new JButton();
    b.addActionListener(new Gestor(n++));
    tela.add(b);
    b = new JButton();
    b.addActionListener(new Gestor(n++));
    tela.add(b);
    b = new JButton();
    b.addActionListener(new Gestor(n++));
    tela.add(b);
  }

}//


class Gestor implements ActionListener {
   private int n;
   private int novo;
   Gestor(int n){ this.n = n;}
   public void actionPerformed(ActionEvent e) {
	 novo = novo + 1;
     System.out.println(n + " clicado."+ novo);
   }

}//

