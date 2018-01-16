import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main2 {

  public static void main(String[] dsds) {
    JFrame f;
    f = new JFrame();
    Reprodutor rep;
    f.setContentPane(rep = new Reprodutor());
    //rep.addFig(new DesenhoOval());
    //rep.addFig(new DesenhoQuadrado());

    rep.addMouseListener(new OuveCliques());

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(400,500);
    f.setVisible(true);

  }


 
}//

class Reprodutor extends JPanel {
  private Reproduzivel[] fig = new Reproduzivel[50000];
  private int prox = 0;
  void addFig(Reproduzivel fig) {
     this.fig[prox++] = fig;
  }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    //*****
    for(int i = 0; i<prox; i++) {
        fig[i].reproduzir(g);
    }
    //*****
  }
}

class OuveCliques implements MouseListener {
  
  public void mouseClicked(MouseEvent e) {
     int x,y;
     x = e.getX();
     y = e.getY();
     System.out.print("clique("+ x +","+ y +") - ");
  }
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
}



interface Reproduzivel {
   void reproduzir(Graphics g);
}


class DesenhoOval implements Reproduzivel {
   public void reproduzir(Graphics g) {
       g.drawOval(50,100,80,80);
   }
}


class DesenhoQuadrado implements Reproduzivel {
   public void reproduzir(Graphics g) {
       g.drawRect(50,100,80,80);
   }
}






