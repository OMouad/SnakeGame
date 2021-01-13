import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{
    
    static final int SCREEN_WIDTH = 1300;;
    static final int SCREEN_HEIGHT = 750;
    static final int UNIT_SIZE = 50;//The size of the objects in the game
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);//The number of objects that is possible to display on the screen
    static final int DELAY = 85;
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
	this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
	this.setBackground(Color.black);
	this.setFocusable(true);
	this.addKeyListener(new MykeyAdapter());
	startGame();
    }
    public void startGame(){
	newApple();
	running = true;
	timer = new Timer(DELAY,this);
	timer.start();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE);
        //We choose different color for the head of the snake and the rest of his body;
        for(int i = 0;i< bodyParts;i++){
            if (i==0) {
                g.setColor(Color.green);
            }
            else {
                g.setColor(new Color(45,180,0));
            }
            g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
        }
    }
    public void newApple(){
        appleX= random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY= random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
        
    }
    public void move(){
        for(int i = bodyParts;i>0;i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
        switch(direction){
            case 'U':
                y[0]=y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0]=y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0]=x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0]=x[0] + UNIT_SIZE;
                break;
        }
    }
    public void checkApple(){
        if ((x[0]==appleX)&&(y[0]==appleY)){
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCollisions(){
        // Checks if the body collides with the head
        for (int i = bodyParts;i>0;i--){
            if ((x[0]==x[i])&&(y[0]==y[i])){
                running = false;
            }
        }
        // Checks if the body touches a border
        if (x[0]< 0 || x[0]> SCREEN_WIDTH ||y[0]< 0 || y[0]> SCREEN_HEIGHT){
            running = false;
        }
        if (!running){
            timer.stop();
        }
        
    }
    public void gameOver(Graphics g){}
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }
    public class MykeyAdapter extends KeyAdapter{
    
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                //The if statements are to prevent the user from turning 180 degrees
                case KeyEvent.VK_LEFT:
                    if (direction != 'R'){
                        direction = 'L';
                    }
                break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L'){
                        direction = 'R';
                    }
                break;
                case KeyEvent.VK_UP:
                    if (direction != 'D'){
                        direction = 'U';
                    }
                break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U'){
                        direction = 'D';
                    }
                break;
            }
        }
    }
}
