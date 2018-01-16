import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class Main3 {
  public static void main(String[] dsds) {
    JFrame f;
    f = new JFrame();
    Reprodutor rep;
    f.setContentPane(rep = new Reprodutor());
    //rep.addFig(new DesenhoOval());
    //rep.addFig(new DesenhoQuadrado());

    rep.addMouseListener(new OuveCliques(rep));
    rep.removeUltimaFig();

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
  void removeUltimaFig(){
    if(prox > 0) prox--; 
  }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    //*****
    for(int i = 0; i < prox; i++) {
        fig[i].reproduzir(g);
    }
    //*****
  }
}



class OuveCliques implements MouseListener {
  private Reprodutor rep;
  OuveCliques(Reprodutor rep) {
    this.rep = rep;
  }
  public void mouseClicked(MouseEvent e) {
     int x, y;
     x = e.getX();
     y = e.getY();
     //*******
     System.out.print("clique("+ x +","+ y +") - ");
     rep.removeUltimaFig();
     rep.addFig(new DesenhoOval(x,y));
     rep.addFig(new DesenhoQuadrado(x,y));
     rep.repaint();
     //*******
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
	private int x ,y;
	DesenhoOval(int x, int y){
		this.x = x;
		this.y = y;
	}
   
   public void reproduzir(Graphics g) {
	   int r = 20;   
	   g.setColor(Color.magenta);
	   g.fillOval(x - r,y - r,2*r,2*r);
	   g.drawOval(x - r,y - r,2*r,2*r);  
   }
}
   
class DesenhoQuadrado implements Reproduzivel {
	   private int x, y;
	   DesenhoQuadrado(int x, int y){
		   this.x = x;
		   this.y = y;
	   }
	   public void reproduzir(Graphics g) {
		   int aresta = 40;
		   int x0 = aresta/2;
		   int y0 = aresta/2;
		   g.setColor(Color.blue);
		   g.fillRect(x - x0, y - y0, aresta, aresta);
		   g.drawRect(x - x0, y - y0, aresta, aresta);
		   g.setColor(Color.red);
		   g.fillRect(x - x0/2, y - y0/2, aresta/6, aresta/6);
		   g.drawRect(x - x0/2, y - y0/2, aresta/6, aresta/6);
		   g.setColor(Color.red);
		   g.fillRect(x + x0/2, y - x0/2, aresta/6, aresta/6);
		   g.drawRect(x + x0/2, y - x0/2, aresta/6, aresta/6);
		   
	   }	   
  }
