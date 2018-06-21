package edu.handong.csee.java.bousehw;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class URLReader {
	static ArrayList<String> inms = new ArrayList<>();
    public ArrayList<String> read(String input) throws Exception {
    	
    	URL oracle = new URL(input);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            inms.add(inputLine + "\n");
        }
        	
        in.close();
        
        return inms;
    }
}