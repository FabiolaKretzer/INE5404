import java.awt.event.*;
import javax.swing.*;


class Composicao implements ActionListener {
  private JLabel r;
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  Composicao(JLabel r) {
    this.r = r;
  }

  void atualizar(String num) {
    r.setText(num + "," + "1 = "+ a +"," + "2 = "+ b + "," +"3 =" + c +"," + "4 =" + d);
  }
  
  void incremento1(){
	a = a + 1;
  }
  
  void incremento2(){
	b = b + 1;
  }
  
  void incremento3(){
	c = c + 1; 
  }

  void incremento4(){
	d = d + 1; 
  }  

  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    
    if (cmd.equals("1")) {
       incremento1();
       atualizar("1");
    }
    else if (cmd.equals("2")) {
       incremento2();
       atualizar("2");
    }
    else if (cmd.equals("3")) {
    	incremento3();
       atualizar("3");
    }
    else if (cmd.equals("4")){
    	incremento4();
    	atualizar("4");
    }
  }

}