package edu.handong.csee.java.bousehw;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String inputURL=args[1];
		String outputpath=args[3];
		ArrayList<String> result = new ArrayList<>();
		
		URLReader UR =new URLReader();
		result = UR.read(inputURL);
		
		 
		Writer WR =new Writer();
		WR.creatFile(outputpath,result);

	}

}
