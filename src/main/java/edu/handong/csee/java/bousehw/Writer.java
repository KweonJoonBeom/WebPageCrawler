package edu.handong.csee.java.bousehw;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {

  


   public void creatFile(String outputpath,ArrayList<String> result) {

      PrintWriter out = null;
      
      outputpath = outputpath+"output.html";
      try {
         out = new PrintWriter(outputpath);
         for(String s: result) {	 
         out.write(s+"\n");
         }
      }catch(FileNotFoundException e) {
         System.out.println("Error opening the file " + outputpath);
         System.exit(0);
      }

      out.close();
   }

}
