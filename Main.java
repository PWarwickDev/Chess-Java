import javax.swing.*;
import java.awt.*;

public class Main {

    private static final int GAP = 5;
    public static void main(String[] args) {
        Runnable runnable = () -> new Main().displayGUI();
        EventQueue.invokeLater(runnable);
    }
    private void displayGUI() {
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setLayout (new BorderLayout(GAP, GAP));
        JPanel drawingBoard = new Board.DrawingBoard();
        contentPane.add (drawingBoard, BorderLayout.CENTER);


        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
    }


}
