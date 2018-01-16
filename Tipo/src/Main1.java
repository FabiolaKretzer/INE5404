import javax.swing.*;
import java.awt.*;

class Main1 {

  public static void main(String[] dsds) {
    JFrame f;
    f = new JFrame();
    
    Reprodutor rep;
    f.setContentPane(rep = new Reprodutor());
    rep.addFig(new DesenhoQuadrado());
    rep.addFig(new DesenhoOval());
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(400,500);
    f.setVisible(true);

  }
 
}

class Reprodutor extends JPanel {
	public Reprodutor() {

}
   private Reproduzivel [] fig = new Reproduzivel[50000];
   private int prox = 0;
  
   void addFig(Reproduzivel fig){
  	 this.fig[prox++] = fig;
  } 	
  
   public void paintComponent(Graphics g) {
     super.paintComponent(g);
     for(int i = 0; i < prox; i++){
    	 fig[i].reproduzir(g);   
    }
    
  }
}
  
interface Reproduzivel{
	void reproduzir(Graphics g);
	
}
class DesenhoOval implements Reproduzivel{
	public void reproduzir(Graphics g){
		g.drawOval(70,180,70,70);
	}
}

class DesenhoQuadrado implements Reproduzivel{
	public void reproduzir(Graphics g){
		g.drawRect(70,180,70,70);
	}
}
