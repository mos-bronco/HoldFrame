import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Calendar;
import java.util.Scanner;

import static java.lang.System.out;


public class Tag extends JFrame {

    static String IsPrinterIp = "10.15.48.219";
    static String QCPrinterIp = "10.15.48.217";

    static String Message = "You are running an outdated version of this app \nPlease contact IS support \n-Dan Duran";

    public static void main() {
        {
            String filelocation = "Configuration\\ZebraPrinter\\";
            String[] Act = new String[2];
            int[] Print = new int[1];
            int pholder = InFrame.Pnumber;
            Scanner Res;
            String choice = "n";
            Calendar cal = Calendar.getInstance();
            int mo = (cal.get(Calendar.MONTH));
            mo = (mo + 1);
            String result = "" + (mo) + ("_") + (cal.get(Calendar.DATE)) + ("_") + (cal.get(Calendar.SECOND));
            try {
                FileWriter writer = new FileWriter(filelocation + (result) + ".txt");
                String host;
                InetAddress addr;
                addr = InetAddress.getLocalHost();
                host = addr.getHostName();
                // Writes hold tag data & image to file
                writer.write("^XA" +
                        "^LRY^FO610,520 ^GB65,610,40^FS                               " +
                        "^FO540,520^GB65,500,40^FS                                     " +
                        "^A0R,^FO680,520 ^GB50,50,4^FS                                 " +
                        "^A0R,^FO670,529,^A0,55^,^FDX^FS                               " +
                        "^A0R,^FO670,640,^A0,55^,^FDIN-PLANT^FS                        " +
                        "^A0R,^FO600,520,^A0,70^,^FDDO NOT USE UNLESS^FS               " +
                        "^A0R,^FO530,520,^A0,70^,^FDRELEASED BY QC^FS                  " +
                        "^LRN^A0R,^FO520,50^A0,175^,^FDHOLD^FS                         " +
                        "^A0R,^FO22,1100^A0,35^,^FD261_1^FS                            " +
                        "^A0R,^FO390,50^A0,85^,^FDDefect^FS                            " +
                        "^FO395,310 ^GB5,890,7^FS                                      " +
                        "^A0R,^FO390,300^A0,100^,^FD " + (InFrame.sDefect) + " ^FS          " +
                        "^A0R,^FO310,10^A0,50^,^FDRequired Action^FS                   " +
                        "^A0R,^FO324,350^A0,40^,^FD" + (InFrame.subFirst) + "    ^FS               " +
                        "^FO318,350 ^GB5,852,7^FS                                      " +
                        "^A0R,^FO258,350^A0,40^,^FD" + (InFrame.subSecond) + "    ^FS              " +
                        "^FO255,350 ^GB5,852,7^FS                                      " +
                        "^A0R,^FO175,100^,^A0,50^,^FDDate^FS                           " +
                        "^A0R,^FO175,200^,^A0,50^,^FD" + (InFrame.sDate) + "    ^FS        " +
                        "^FO175,200 ^GB5,275,7^FS                                      " +
                        "^A0R,^FO175,620^,^A0,50^,^FDPart #^FS                         " +
                        "^A0R,^FO175,750^,^A0,50^,^FD" + (InFrame.sPart) + "    ^FS        " +
                        "^FO175,740 ^GB5,310,7^FS                                      " +
                        "^A0R,^FO100,100^,^A0,50^,^FDQuantity^FS                       " +
                        "^A0R,^FO100,280^,^A0,50^,^FD" + (InFrame.sQuantity) + "    ^FS    " +
                        "^FO100,265 ^GB5,212,7^FS                                      " +
                        "^A0R,^FO22,100^,^A0,50^,^FDBatch^FS                           " +
                        "^A0R,^FO22,240^,^A0,50^,^FD" + (InFrame.sBatch) + " ^FS      " +
                        "^FO22,220 ^GB5,260,7^FS                                       " +
                        "^A0R,^FO100,620^,^A0,50^,^FDInspector^FS                      " +
                        "^A0R,^FO100,840^,^A0,50^,^FD" + (InFrame.sInspector) + "    ^FS   " +
                        "^FO100,810 ^GB5,240,7^FS                                      " +
                        "^A0R,^FO10,10^,^A0,15^,^FD " + (host) + " ^FS                         " +
                        "^XZ                                                           "
                );
                writer.flush();
                writer.close();
                out.println("Filename:" + (result));
                out.println(filelocation + (result));
            } catch (IOException e) {
                out.println("An error occurred when creating the label file \nPlease contact local IS.");
                e.printStackTrace();
            }
//Creates bat file to open ftp connection
            try {
                FileWriter writer = new FileWriter(filelocation + "testyftp" + (result) + ".bat");//, true);
                // Writes the content to the file
                writer.write("cd"+filelocation +"\nftp -n -s:ftpcmd" + (result) + ".txt\npause");
                writer.flush();
                writer.close();
                           System.out.println("Filename:" + (result));
            } catch (IOException e) {
                out.println("An error occurred when creating the .bat file \nPlease contact local IS.");
                e.printStackTrace();
            }
//Logs into printer and sends the number of files to print
            try {

                FileWriter writer = new FileWriter(filelocation + "ftpcmd" + (result) + ".txt");
                // Writes the content to the file
                writer.write("open "+ QCPrinterIp+" \nuser myFTPuser myftppassword");
                //open 10.15.48.219
                while (pholder > 0) {
//                                System.out.print(Print);
                    writer.write("\nsend " + (result) + ".txt");
                    pholder = (pholder - 1);
                }
                writer.write("\nclose\nquit");
                writer.flush();
                writer.close();
                out.println("\nPrint Job Sent");
            } catch (IOException e) {
                out.println("An error occurred when creating the print job file \nPlease contact local IS.");
                e.printStackTrace();
            }
            {
//creates the cmd proccess
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "testyftp" + (result) + ".bat");
                File dir = new File(filelocation);
                pb.directory(dir);
//Executes the .bat
                try {
                    Process p = pb.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        }

    }
}