package sibice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 
       // Scanner s = new Scanner(System.in);
        Scanner s = null;
		try {
			s = new Scanner(new FileReader("sibiceTest.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        double N = s.nextDouble();
        double width = s.nextDouble();
        double height = s.nextDouble();
       
        double[] matches = new double[(int) N];
        int index = 0;
        while(s.hasNextDouble()){
            matches[index] = s.nextDouble();
            index++;
        }
        s.close();
        
        double maxLength = (double) Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
        for(double match : matches){
        	if(match > maxLength)
        		System.out.println("NE");
        	else
        		System.out.println("DA");
        }
	}

}
