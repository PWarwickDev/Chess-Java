import javax.swing.*;
import java.awt.*;


public class Main extends JPanel {


    public static void main(String[] args) {
        JFrame f=new JFrame("Chess");//creating instance of JFrame

        f.add(new Main());
        f.setSize(800,800);//800 width and 800 height
        f.setVisible(true);//making the frame visible
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        int w = 800;
        int l = 800;
        Graphics2D wSquare = (Graphics2D) g;
        Graphics2D bSquare = (Graphics2D) g;
        wSquare.setColor(Color.WHITE);
        bSquare.setColor(Color.BLACK);
        wSquare.fillRect(0,0, 100,100);

    }
}


