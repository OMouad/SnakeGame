import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{
    
    GamePanel(){
    }
    public void startGame(){
    }
    @Override
    public void paintComponent(Graphics g){}
    public void draw(Graphics g){}
    public void move(){}
    public void checkApple(){}
    public void checkCollisions(){}
    public void gameOver(Graphics g){}
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public class MykeyAdapter extends KeyAdapter{
    
        public void keyPressed(KeyEvent e){
        }
    }
}
