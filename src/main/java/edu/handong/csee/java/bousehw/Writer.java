package edu.handong.csee.java.bousehw;


import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Writer {
	public void creatFile(String input, ArrayList<String> results) {

			try{
				FileOutputStream fileOutputStream = new FileOutputStream(input);
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "html");
				BufferedWriter fw = new BufferedWriter(outputStreamWriter);
				for(String line : results){
					System.out.println(line);
					fw.write(line+"\n");
				}
				fw.flush();
				fw.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	

		
		
	}


