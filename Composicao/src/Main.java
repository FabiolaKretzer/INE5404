import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Main {
  public static void main(String[] sdsd)  {
     new Main();
  }

  Main() {
    JFrame f = new JFrame();
    JPanel quadro = new JPanel();
    f.setContentPane(quadro);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    ActionListener listener; 
    JLabel rotulo = new JLabel("Digite!");
    listener = new Composicao(rotulo); 
    
    mkgui(quadro,listener,rotulo);

    f.setSize(300,400);
    f.setTitle("Composição");
    f.pack();
    f.setVisible(true);
   
 }
 
  void mkgui(JPanel quadro, ActionListener listener, JLabel rotulo) {
    quadro.setLayout(new BorderLayout()); 

    JPanel q;
    

    q = new JPanel();
    q.setLayout(new FlowLayout(FlowLayout.CENTER));
    quadro.add(q,BorderLayout.NORTH);
    q.add(rotulo);
    
    
    q = new JPanel();
    q.setLayout(new GridLayout(2,2));
    quadro.add(q,BorderLayout.CENTER);
    insereBotao(q, listener);
   
  }
  
  void insereBotao(JPanel q, ActionListener listener) {
    JButton b;
    
    b = new JButton("1");
    q.add(b);
    b.addActionListener(listener);
    b.setActionCommand("1");

    b = new JButton("2");
    q.add(b);
    b.addActionListener(listener);
    b.setActionCommand("2");

    b = new JButton("3");
    q.add(b);
    b.addActionListener(listener);
    b.setActionCommand("3");
    
    b = new JButton("4");
    q.add(b);
    b.addActionListener(listener);
    b.setActionCommand("4");
    
    
  }

  void cfg_rotulo(JLabel rotulo) {
    cfg_rotulo(rotulo,SwingConstants.RIGHT,120,15,Color.blue,Color.lightGray);
  }
  void cfg_rotulo(JLabel rotulo, int hpos, int lar, int alt, Color fcor, Color bcor) {
    
    rotulo.setFont(new Font("Verdana", Font.BOLD, 12));
   
    rotulo.setHorizontalAlignment(hpos);
    
    rotulo.setPreferredSize(new Dimension(lar,alt));
    
    rotulo.setForeground(fcor);
    
    if (bcor != null) {
      rotulo.setOpaque(true); 
      rotulo.setBackground(bcor);
    }
  }

}//



