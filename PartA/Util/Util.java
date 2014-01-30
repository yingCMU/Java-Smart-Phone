package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


import Exceptions.EmptyRecordException;
import Exceptions.MoreThan40Exception;
import Model.Student;

public class Util {
 private static final int MAX = 40;
public static Student [] readFile(String filename, Student [] stu) throws Exception
 {
 //Reads the file and builds student array.
 //Open the file using FileReader Object.
 //In a loop read a line using readLine method.
 //Tokenize each line using StringTokenizer Object
 //Each token is converted from String to Integer using parseInt method
 //Value is then saved in the right property of Student Object.
	 BufferedReader br = null;   
	 try {
	    	br = new BufferedReader(new FileReader(filename));
	  	  
	    	br.readLine();
	        //StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        int count=-1;
	        while (line != null) {
	        	StringTokenizer st = new StringTokenizer(line);
	        	
	        	int index=0;
	        	Student student = new Student();
	        	while (st.hasMoreTokens()) {
	                //System.out.println();
	        		if(index==0){
	        			index++;
	        			student.setSID(Integer.parseInt(st.nextToken()));
	        			}
	        		else 
	        			student.setScores((index++)-1, Integer.parseInt(st.nextToken()));
	        			
	            }
	        	if(++count>=MAX)
	        		throw new MoreThan40Exception("exception reading more than 40 student");
	        	
	        	
	        	stu[count] = student;
	            line = br.readLine();
	            
	        }
	        if(count==-1)
	        	throw new EmptyRecordException("zero record found");
	        //String everything = sb.toString();
	    } catch(EmptyRecordException e){
	    	System.out.println("no record found, check your file");
	    	System.exit(0);
	    }
	 	catch(ArrayIndexOutOfBoundsException e){
	    	e.printStackTrace();
	    }
	 	catch (MoreThan40Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(FileNotFoundException e){
			System.err.println(filename+" not found, program terminated");
			System.exit(0);
		}
	 		
	 	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    
	 
     return stu;
 }
/*
 public static void main(String [] args) {
	 String file = "C:\\Users\\lily\\Desktop\\input.txt";
	 Student a [] = new Student[40];
	 try {
		readFile(file,a);
	} catch (Exception e) {
		e.printStackTrace();
	}
	 for(int i=0; i<a.length; i++){
		  System.out.println("No. "+i);
   	  for(int j=0;j<5;j++){
   		  System.out.println(a[i].getSID()+"\t");
   	  }
	  }
 }
 */

}
