import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import static java.lang.System.out;

public class InFrame extends JFrame implements ActionListener {

    static String sDefect;
    static String sPart;
    static String sDate;
    static String sComment;
    static String sQuantity;
    static String sInspector;
    static String Printqty;
    static String sBatch;
    static int Pnumber = 0;


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

    JTextField Requiredaction;
    JLabel Requiredlabel;
    JPanel Requiredpanel;

    JTextField Quantity;
    JLabel Quantitylabel;
    JPanel Quantitypanel;

    JTextField Inspector;
    JLabel Inspectorlabel;
    JPanel Inspectorpanel;

    JTextField Batch;
    JLabel Batchlabel;
    JPanel Batchpanel;

    JButton Submit;


    public void charactercounter() {
    String Comment;
    int i = 0;
    int S = 0;
    int wc = 0;
    String Act[];
    final int OUT = 0;
    final int IN = 1;
    int state = OUT;
    String first:


        Comment = sComment;
        Act[0] = Comment;
        //System.out.println(Act[0]);
        while (i < Act[0].length()) {
            if (Act[0].charAt(i) == ' ' || Act[0].charAt(i) == '\n' || Act[0].charAt(i) == '\t')

            else if (state == OUT) {
                state = IN;
                ++wc;
                // System.out.println("wc = " + (wc));
                //System.out.println("i = " + (i));
                // System.out.println("S = " + (S));
                if (wc == 7) S = i;
            }
            // Move to next character
//                                System.out.println(i);
            ++i;
        }
        if (i > 75) System.out.println("You have entered " + "'" + (i) + "'"
                + " Characters\nPlease try again.");
        while((i >75)||(i ==0));
        if(Act[1]==null)
    Act[1]=(" ");
    first =Act[0];
//                                    System.out.println(first);
// Splits the text lines
                                                                                if(S>0)


        subFirst = first.substring(0, S);
        subSecond = first.substring(S);
//                                        System.out.println(subFirst);
//                                        System.out.println(subSecond);
//De                            System.out.println(Comment);

                                                                                else subFirst =first;
//                                    System.out.println(subFirst);
//                                    System.out.println(subSecond);

}


    public void textfields(){
        Defect = new JTextField();
        Defect.setPreferredSize(new Dimension(100,25));
        Part = new JTextField();
        Part.setPreferredSize(new Dimension(100,25));
        Date = new JTextField();
        Date.setPreferredSize(new Dimension(100,25));
        Requiredaction = new JTextField();
        Requiredaction.setPreferredSize(new Dimension(100,25));
        Quantity = new JTextField();
        Quantity.setPreferredSize(new Dimension(100,25));
        Inspector = new JTextField();
        Inspector.setPreferredSize(new Dimension(100,25));

        Batch = new JTextField();
        Batch.setPreferredSize(new Dimension(100,25));



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


        Requiredpanel = new JPanel();
        Requiredlabel = new JLabel("Required Action");
        Requiredpanel.setPreferredSize(new Dimension(125,50));
        Requiredlabel.setVerticalTextPosition(Defect.TOP);
        Requiredlabel.setHorizontalTextPosition(Defect.CENTER);

        Quantitypanel = new JPanel();
        Quantitypanel.setPreferredSize(new Dimension(125,50));
        Quantitylabel = new JLabel("Quantity");



        Batchpanel = new JPanel();
        Batchpanel.setPreferredSize(new Dimension(125,50));
        //Batchpanel.setBackground(Color.ORANGE);
        Batchlabel = new JLabel("Date");


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


        holdFrame.setSize(400,300);
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

        Requiredpanel.add(Requiredlabel);
        Requiredpanel.add(Requiredaction);

        Quantitypanel.add(Quantitylabel);
        Quantitypanel.add(Quantity);

        Inspectorpanel.add(Inspectorlabel);
        Inspectorpanel.add(Inspector);

        Batchpanel.add(Batchlabel);
        Batchpanel.add(Batch);


        Leftpanel.setBorder(blackline);
        //Rightpanel.setLayout(new FlowLayout());

        Leftpanel.add(Batchpanel);
       Leftpanel.add(Defectpanel);
        Leftpanel.add(Partpanel);
        Leftpanel.add(Datepanel);
        Leftpanel.add(Requiredpanel);
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
            sDefect = (Defect.getText());
            sPart = (Part.getText());
            sDate = (Date.getText());
            sComment = (Requiredaction.getText());
            sQuantity = (Quantity.getText());
            sInspector = (Inspector.getText());
            sBatch = (Batch.getText());


            Printqty = JOptionPane.showInputDialog("Please enter quantity to print");
            try {
                Pnumber = Integer.parseInt(Printqty);
                Tag.main();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(new JFrame(),"You must only enter numbers.");

            }



            out.println(sDefect);
            out.println(sPart);
            out.println(sDate);
            out.println(sComment);
            out.println(sQuantity);
            out.println(sInspector);
        }

    }


}
