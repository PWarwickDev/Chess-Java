import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame f=new JFrame();//creating instance of JFrame

        JButton b=new JButton("click");//creating instance of JButton
        b.setBounds(400,400,100, 40);//x-axis, y-axis, width, height

        f.add(b);//adding button in JFrame

        f.setSize(800,800);//800 width and 800 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }
}

