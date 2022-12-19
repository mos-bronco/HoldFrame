import javax.swing.*;
import java.awt.*;

public class InFrame extends JFrame{



    public InFrame(){

        JFrame holdFrame = new JFrame();
        holdFrame.setTitle("title");
        holdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //holdFrame.setLayout(null);
        holdFrame.setResizable(true);

        holdFrame.setVisible(true);
        holdFrame.setSize(400,400);
        ImageIcon image = new ImageIcon("TsIcon.png");
        holdFrame.setIconImage(image.getImage());
        holdFrame.getContentPane().setBackground(Color.green);




        //holdFrame.setBackground(Color.red);



    }



}
