import javax.swing.JFrame;

public class GameFrame extends JFrame {
    GameFrame(){
        this.add(new GamePanel());
        this.setTitle("Snake game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //The pack() method is defined in Window class in Java and it sizes the frame so that all its contents are at or above their preferred sizes.
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //This makes the window appear in the middle of the screen
        
    }
}
