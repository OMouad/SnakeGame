import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{
    
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;//The size of the objects in the game
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;//The number of objects that is possible to display on the screen
    static final int DELAY = 75;
    //these arrays are going to hold all the coordinates of all the snake's bodyparts including it's head
    final int x[]= new int[GAME_UNITS]; 
    final int y[]= new int[GAME_UNITS];
    //defining the initial amount of body parts of the snake
    int bodyParts = 6;
    int applesEaten =0;
    int appleX,appleY; //These are the random apple's coordinates 
    char direction ='R'; // The snake's direction
    boolean running = false;
    Timer timer;
    Random random;
    
    
    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_WIDTH));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MykeyAdapter());
        startGame();
    }
    public void startGame(){
    }
    public void paintComponent(Graphics g){}
    public void draw(Graphics g){}
    public void newApple(){
        
    }
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
