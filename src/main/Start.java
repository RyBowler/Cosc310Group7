package main;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		/* 	
     	Purpose: the purpose of this function is a while loop that reiterates through and asks for users input
		Input:
		Output:
		*/
		Ai ai=new Ai();
    	String out="";
    	Scanner reader;
    	System.out.println("I am robot");
      	String command="";
      	while(command!="exit"){
        	reader = new Scanner(System.in);
        	command = reader.nextLine().toLowerCase();
          	out = ai.getResponse(command);
          	System.out.println(out);
        }

	}

}