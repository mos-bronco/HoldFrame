import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.out;

public class InFrame extends JFrame implements ActionListener {

    JPanel Leftpanel;

    JPanel Rightpanel;

    JTextField Defect;
    JLabel Defectlabel;
    JPanel Defectpanel;

    JTextField Part;
    JLabel Partlabel;
    JPanel Partpanel;

    JTextField Date;
    JLabel Datelabel;
    JPanel Datepanel;

    JTextField Comment;
    JLabel Commentlabel;
    JPanel Commentpanel;

    JTextField Quantity;
    JLabel Quantitylabel;
    JPanel Quantitypanel;

    JTextField Inspector;
    JLabel Inspectorlabel;
    JPanel Inspectorpanel;

    JButton Submit;



    public void textfields(){
        Defect = new JTextField();
        Defect.setPreferredSize(new Dimension(100,25));
        Part = new JTextField();
        Part.setPreferredSize(new Dimension(100,25));
        Date = new JTextField();
        Date.setPreferredSize(new Dimension(100,25));
        Comment = new JTextField();
        Comment.setPreferredSize(new Dimension(100,25));
        Quantity = new JTextField();
        Quantity.setPreferredSize(new Dimension(100,25));
        Inspector = new JTextField();
        Inspector.setPreferredSize(new Dimension(100,25));




        Leftpanel = new JPanel();




        Defectpanel = new JPanel();
        Defectpanel.setPreferredSize(new Dimension(125,50));
        Defectlabel = new JLabel("Defect");
        Defectlabel.setVerticalTextPosition(Defect.TOP);
        Defectlabel.setHorizontalTextPosition(Defect.CENTER);
        Defectlabel.setHorizontalAlignment(Defect.CENTER);
        Defectlabel.setVerticalAlignment(Defect.CENTER);


        Partpanel = new JPanel();
        Partpanel.setPreferredSize(new Dimension(125,50));
        Partlabel = new JLabel("Part Number");
        Partlabel.setHorizontalTextPosition(Part.LEFT);

        Datepanel = new JPanel();
        Datepanel.setPreferredSize(new Dimension(125,50));
        Datelabel = new JLabel("Date");
        //Datelabel.setVerticalTextPosition(Defect.TOP);
        //Datelabel.setHorizontalTextPosition(Defect.CENTER);

        Commentpanel = new JPanel();
        Commentlabel = new JLabel("Comments");
        Commentpanel.setPreferredSize(new Dimension(125,50));
        Commentlabel.setVerticalTextPosition(Defect.TOP);
        Commentlabel.setHorizontalTextPosition(Defect.CENTER);

        Quantitypanel = new JPanel();
        Quantitypanel.setPreferredSize(new Dimension(125,50));
        Quantitylabel = new JLabel("Quantity");

        Inspectorpanel = new JPanel();
        Inspectorpanel.setPreferredSize(new Dimension(125,50));
        Inspectorlabel = new JLabel("Inspector");


    }


    public InFrame(){



        JFrame holdFrame = new JFrame();
        holdFrame.setTitle("title");
        holdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        holdFrame.setLayout(new BorderLayout());
        holdFrame.setResizable(true);


        holdFrame.setSize(400,400);
        ImageIcon image = new ImageIcon("TsIcon.png");
        holdFrame.setIconImage(image.getImage());
        holdFrame.getContentPane().setBackground(Color.green);

        textfields();


        Border blackline = BorderFactory.createLineBorder(Color.black);
        Rightpanel = new JPanel();
        Submit = new JButton("submit");
        Submit.addActionListener(this);

        Defectpanel.add(Defectlabel);
        Defectpanel.add(Defect);

        Partpanel.add(Partlabel);
        Partpanel.add(Part);

        Datepanel.add(Datelabel);
        Datepanel.add(Date);

        Commentpanel.add(Commentlabel);
        Commentpanel.add(Comment);

        Quantitypanel.add(Quantitylabel);
        Quantitypanel.add(Quantity);

        Inspectorpanel.add(Inspectorlabel);
        Inspectorpanel.add(Inspector);



        Leftpanel.setBorder(blackline);
        //Rightpanel.setLayout(new FlowLayout());


       Leftpanel.add(Defectpanel);
        Leftpanel.add(Partpanel);
        Leftpanel.add(Datepanel);
        Leftpanel.add(Commentpanel);
        Leftpanel.add(Quantitypanel);
        Leftpanel.add(Inspectorpanel);
        Rightpanel.add(Submit);


        Rightpanel.setPreferredSize(new Dimension(125,50));

        holdFrame.add(Leftpanel);
        holdFrame.add(Rightpanel, BorderLayout.SOUTH);

        //holdFrame.add(Submit);
        Rightpanel.setSize(200,600);
        Leftpanel.setSize(200,600);
        holdFrame.setLocationRelativeTo(null);
        //holdFrame.pack();
        holdFrame.setVisible(true);



    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Submit){
            String hi = (Defect.getText());
            out.println(hi);
        }

    }
}
