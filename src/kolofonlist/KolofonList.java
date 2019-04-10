/*
 * @Henry Huang
 * KolofonList.java
 * April 9, 2019
 * This program is designed to register track and field athlete infomation 
 * into a file to store, and also create a file for each athlete who registered for
 * further revire use.
 */
package kolofonlist;

/**
 *
 * @author HenryHwang
 */

import java.io.*;
import javax.swing.*;
import java.nio.file.*;
public class KolofonList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
       //Declare all variables
       String name, gender, main, second;
       String fileName = "KolofonList.txt";
       String path = "Paths.txt";
       String lines = null;
       int birth = 0;
       int athleteNum = 0;
       
       //Create buffered reader to show the content of file
       BufferedReader readFile = new BufferedReader (new FileReader(fileName));
       
//       while((lines = readFile.readLine()) != null)
//       {
//           System.out.println(lines);
//       }
       
       //Provide choices to user for their purpose
       String cho = JOptionPane.showInputDialog("How can I help you today?" + "\n1-Resiter new athlete   2-Review registered info");
      
       //This is used to opne file to input info to the file
       PrintWriter fileOut = new PrintWriter (new FileWriter(fileName,true));
       PrintWriter pathOut = new PrintWriter (new FileWriter (path,true));
       
       //Check if the user would make a mistake on the inout and remind them 
       // With mistaken input are not able to 
       while (true)
       {
           try
           {
               athleteNum = Integer.parseInt(JOptionPane.showInputDialog("How many " 
               + "athlete do you want to register today?"));
           }
           catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, "Plaese enter an Integer!");
           }
           break;
       }
       
       for (int i = 0; i< athleteNum; i++)
       {
           //JOptionPane.showMessageDialog(null,"Time to register");
           JOptionPane.showMessageDialog(null,"Athlete" + (i + 1) + " :");
           //Ask user question and wait for input
           name = JOptionPane.showInputDialog("What is the name of the athlete ?");
           gender = JOptionPane.showInputDialog("What is the gender of the athlete ?\nEx: Male");
           main = JOptionPane.showInputDialog("What is the main event for the athlete ?\nEx: Triple Jump");
           second = JOptionPane.showInputDialog("What is the second main event for the athlete?\nEx: Long Jump");
           
           //Check to catch error
           while (true)
           {
                try 
                    {
                        birth = Integer.parseInt(JOptionPane.showInputDialog("What is the birthday of the athlete ?\nEx:YYYY/MM/DD"));
                    }
                catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null,"Please enter anInteger!");
                    }
                    break;
                    }
           
           //Direct file to certain memory location
           File ff = new File("C:\\Users\\HenryHwang\\Documents\\NetBeansProjects\\KolofonList");
           //Create tempoary file name and direct it to its location
           File f = File.createTempFile(name, ".txt", ff);
           
           //Get the tempoary file name
           String fName = f.getName();
           //Try to open the file and print
           PrintWriter fOut = new PrintWriter(new FileWriter(fName,true));
           //Display the path of the tempoary file
           System.out.println(f.getPath());
           
           //Mixed all infomation
           String info = "Athlete " + (i+1)+"\n" + "\nName: " + name + "\nAddress: " + gender
                   + "\nBirthday: " + birth + "\nMain Event: " + main + "\nSecond Event: " + second
                   +"\n---------------------------------";
           //Display the info on the file already set
           fileOut.println(info);
           //Display the info on the tempoary file
           fOut.println(info);
       }
           JOptionPane.showMessageDialog(null,"Thanks for using our service!");
           //Close the file
           fileOut.close(); 
       }
    }
    

