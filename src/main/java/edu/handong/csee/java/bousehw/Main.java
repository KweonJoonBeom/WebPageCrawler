package edu.handong.csee.java.bousehw;

import java.util.ArrayList;


import org.apache.commons.cli.CommandLine;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;


public class Main {

	   String inputURL; 
	   String outputpath; 
	   boolean help;


	   public static void main(String[] args) {
	      Main runner = new Main();
	      runner.run(args);
	   }

	   private void run(String[] args) {
	      Options options = createOptions();

	      if(parseOptions(options, args)){
	         if (help){
	            printHelp(options);
	            return;
	         }

	         ArrayList<String> result = new ArrayList<>();
	 		
	 		URLReader UR =new URLReader();
	 		try {
				result = UR.read(inputURL);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		
	 		 
	 		Writer WR =new Writer();
	 		WR.creatFile(outputpath,result);

	      }
	   }


	   private boolean parseOptions(Options options,String[] args) {
	      CommandLineParser parser = new DefaultParser();

	      try {
	         CommandLine cmd = parser.parse(options, args);

	         inputURL = cmd.getOptionValue("u");
	         outputpath = cmd.getOptionValue("d");
	         help = cmd.hasOption("h");

	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         printHelp(options);
	         return false;
	      }

	      return true;

	   }


	   private Options createOptions() {
	      Options options = new Options();

	      options.addOption(Option.builder("u").longOpt("URL address")
	            .desc("Set a urlPath")
	            .hasArg()
	            .argName("URL Path")
	            .required()
	            .build());

	      options.addOption(Option.builder("d").longOpt("outputpath")
	            .desc("Set a filename")
	            .hasArg()
	            .argName("filename to display")
	            .required()
	            .build());

	      options.addOption(Option.builder("h").longOpt("help")
	            .desc("Help")
	            .build());

	      return options;

	   }

	   private void printHelp(Options options) {
	      // automatically generate the help statement
	      HelpFormatter formatter = new HelpFormatter();
	      String header = "WebPageCrawler program";
	      String footer ="\nPlease report issues to 21700052@handong.edu (emails)"; 
	      formatter.printHelp("CLIExample", header, options, footer, true);
	   }

	}

