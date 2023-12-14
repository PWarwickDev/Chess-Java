import javax.swing.*;
import java.awt.*;

public class displayGUI extends JFrame {
    private static final int GAP = 5;

    displayGUI() {
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(GAP, GAP));
        JPanel drawingBoard = new Board.DrawingBoard();
        contentPane.add(drawingBoard, BorderLayout.CENTER);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
