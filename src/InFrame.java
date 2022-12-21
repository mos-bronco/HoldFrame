import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.out;

public class InFrame extends JFrame implements ActionListener {

    String OVER ="false";

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
    JButton Print;
    JButton Clear;

    JTextField Printfield;
    JLabel Printlabel;
    JPanel Printpanel;
   static  String subFirst = "";
    static String subSecond = "";

    static JMenuBar Menubar;
    static JMenu Helpmenu;
    static JMenuItem help, Contactsupport, m3;


    public void Charactercounter(String Comment) {

    int i = 0;
    int S = 0;
    int wc = 0;
    String[] Act = new String[5];
    final int OUT = 0;
    final int IN = 1;
    int state = OUT;
    String first;
    subFirst = "";
    subSecond = "";

    Act[0] = Comment;
        //System.out.println(Act[0]);
        while (i < Act[0].length()) {
            if (Act[0].charAt(i) == ' ' || Act[0].charAt(i) == '\n' || Act[0].charAt(i) == '\t')
                state = OUT;
            else
                if (state == OUT) {
                state = IN;
                ++wc;
                // System.out.println("wc = " + (wc));
                //System.out.println("i = " + (i));
                    // System.out.println("S = " + (S));
                if (wc == 7) S = i;
            }
                // Move to next character
                //System.out.println(i);
            ++i;
        }
        if (i > 75)
            OVER ="true";
        if(Act[1]==null)
            Act[1]=(" ");
        first =Act[0];
        //System.out.println(first);
        // Splits the text lines
        if(S>0) {
            subFirst = first.substring(0, S);
            subSecond = first.substring(S);
        }
        //System.out.println(subFirst);
        //System.out.println(subSecond);
        //System.out.println(Comment);
        else subFirst = first;
        //System.out.println(subFirst);
        //System.out.println(subSecond);
    }
public void Menu(){
    // create a menubar
    Menubar = new JMenuBar();

    // create a menu
    Helpmenu = new JMenu("Help");

    // create menuitems
    help = new JMenuItem(new AbstractAction("Help") {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(new JFrame(), """
                    Press Submit after entering the desired Data for the listed fields. Any field can be left blank.
                    After clicking Submit enter the quantity to print. 
                    This must be a number and can not include any special characters or letters.
                     
                    """);

        }
    });
    Contactsupport = new JMenuItem("Contact Support");
    //m3 = new JMenuItem("MenuItem3");

    Helpmenu.add(help);
    Helpmenu.add(Contactsupport);
    //x.add(m3);

    Menubar.add(Helpmenu);

    Helpmenu.addActionListener(this);


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
        Batchlabel = new JLabel("Batch");


        Inspectorpanel = new JPanel();
        Inspectorpanel.setPreferredSize(new Dimension(125,50));
        Inspectorlabel = new JLabel("Inspector");

        Printpanel = new JPanel();
        //Printpanel.setPreferredSize(new Dimension(50,50));

        //Printlabel.setHorizontalTextPosition(Part.LEFT);

    }

    public void Rightpaneladds(){



    }
    public InFrame(){
        Menu();

        Printlabel = new JLabel(String.valueOf(Pnumber));

        JFrame holdFrame = new JFrame();
        holdFrame.setTitle("TRMD HOLD TAG PRINTER 2.0.0");
        holdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        holdFrame.setLayout(new BorderLayout());
        holdFrame.setResizable(true);
        holdFrame.setJMenuBar(Menubar);


        holdFrame.setSize(400,400);
        ImageIcon image = new ImageIcon("TsIcon.png");
        holdFrame.setIconImage(image.getImage());
        holdFrame.getContentPane().setBackground(Color.green);


        textfields();


        Border blackline = BorderFactory.createLineBorder(Color.black);
        Rightpanel = new JPanel();
        Submit = new JButton("Submit");
        Submit.addActionListener(this);
        Print= new JButton("Print");
        Print.addActionListener(this);
        Clear= new JButton("Clear");
        Clear.addActionListener(this);
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

        Leftpanel.setLayout(new FlowLayout());
        Leftpanel.setBorder(blackline);
        //Rightpanel.setLayout(new FlowLayout());
        Leftpanel.add(Defectpanel);
        Leftpanel.add(Requiredpanel);
        Leftpanel.add(Datepanel);
        Leftpanel.add(Quantitypanel);
        Leftpanel.add(Batchpanel);
        Leftpanel.add(Partpanel);
        Leftpanel.add(Inspectorpanel);

        Rightpanel.setPreferredSize(new Dimension(125,50));
        Rightpanel.setLayout(new BorderLayout());
        Rightpanel.add(Submit);

        holdFrame.add(Leftpanel,BorderLayout.CENTER);

        holdFrame.add(Rightpanel, BorderLayout.SOUTH);
        //holdFrame.add(Submit);
        Rightpanel.setSize(200,600);
        Leftpanel.setSize(200,600);
        holdFrame.setLocationRelativeTo(null);
        //holdFrame.pack();
        holdFrame.setVisible(true);
        Rightpanel.add(Clear,BorderLayout.EAST);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Helpmenu){
            JOptionPane.showMessageDialog(new JFrame(), "You goofed up");

        }



        if (e.getSource() == Submit) {
            Printlabel.setText(" ");
            Pnumber= 0;
            sDefect = (Defect.getText());
            sPart = (Part.getText());
            sDate = (Date.getText());
            sComment = (Requiredaction.getText());
            sQuantity = (Quantity.getText());
            sInspector = (Inspector.getText());
            sBatch = (Batch.getText());

            try {
                Charactercounter(sComment);
                if (OVER.equals("true")) {
                    JOptionPane.showMessageDialog(new JFrame(), "You have entered too many characters //n for the resolution");
                    OVER = "";
                    Requiredaction.setBackground(Color.YELLOW);
                    Requiredaction.setText("");

                    return;
                } else {
                    Printqty = JOptionPane.showInputDialog("Please enter quantity to print");
                    Requiredaction.setBackground(Color.WHITE);
                    Pnumber = Integer.parseInt(Printqty);
                    String copyW = "";
                    if(Pnumber > 1)
                        copyW = "copies";
                    else copyW = "copy";
                    Printlabel = new JLabel("Click print to confirm you would like to print " + Pnumber + " " +copyW);
                    Printpanel.add(Printlabel);


                    out.println(sDefect);
                    out.println(sPart);
                    out.println(sDate);
                    out.println(sComment);
                    out.println(sQuantity);
                    out.println(sInspector);


                    Rightpanel.add(Clear,BorderLayout.EAST);
                    Rightpanel.add(Print,BorderLayout.CENTER);


                    Rightpanel.add(Printpanel,BorderLayout.NORTH);
                    Rightpanel.remove(Submit);
                    Rightpanel.add(Submit,BorderLayout.WEST);
                    Rightpanel.repaint();
                    Rightpanel.revalidate();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "You must only enter numbers.");

            }
        }
        if (e.getSource() == Print){
            try {
                Pnumber = Integer.parseInt(Printqty);
                Tag.main();
                JOptionPane.showMessageDialog(new JFrame(), "Print Job Sent!");
                Rightpanel.remove(Print);
                Rightpanel.remove(Printpanel);
                Rightpanel.remove(Submit);
                Rightpanel.repaint();
                Rightpanel.revalidate();
                Rightpanel.add(Submit);
                Rightpanel.repaint();
                Rightpanel.revalidate();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "You must only enter numbers.");

            }
    }
        if (e.getSource() == Clear){

            Printlabel.setText(" ");

            Defect.setText("");
            Part.setText("");
            Date.setText("");
            Requiredaction.setText("");
            Quantity.setText("");
            Inspector.setText("");
            Batch.setText("");

            Rightpanel.remove(Clear);
            Rightpanel.remove(Print);
            Rightpanel.remove(Printpanel);
            Rightpanel.remove(Submit);
            Rightpanel.repaint();
            Rightpanel.revalidate();
            Rightpanel.add(Submit);
            Rightpanel.add(Clear,BorderLayout.EAST);
            Rightpanel.repaint();
            Rightpanel.revalidate();
        }


            out.println(sDefect);
            out.println(sPart);
            out.println(sDate);
            out.println(sComment);
            out.println(sQuantity);
            out.println(sInspector);

        out.println("P number = "+ Pnumber);
    }

    }
