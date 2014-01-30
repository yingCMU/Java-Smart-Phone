package Tests;

import java.util.StringTokenizer;

import Model.Statistics;
import Model.Student;
import Util.Util;

public class Test {

	//Putting it altogether:
	public static void main(String [] args){
	 Student lab2 [] = new Student[40];
	 //Populate the student array
	 if(args.length ==0){
		 System.err.println("filename required as first arg");
		 System.out.println("\nusage: java Test filename");
		 
		 return;
	 }
	 String file = args[0];
	 try {
		lab2 = Util.readFile(file, lab2);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 Statistics statlab2 = new Statistics();
	 System.out.println(file+"------------");
	 
	 statlab2.findhigh(lab2);
	 statlab2.findlow(lab2); 
	 statlab2.findavg(lab2);
	 
	}
}
