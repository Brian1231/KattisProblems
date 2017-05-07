package fourthought;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		Scanner s = null;
		try {
			s = new Scanner(new FileReader("fourTest.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int N = s.nextInt();
		int[] cases = new int[N];
		char[] operators = {'+', '-', '*','/'};
		
		for(int i=0;i<N;i++){
			cases[i] = s.nextInt();
		}
		s.close();

		printArray(cases);
		System.out.println();
		
		//Loop through cases
		for(int i=0;i<N;i++){
			
			//Loop through operators
			for(int j=0;j<4;j++){
				
			}
		}
	}
	
	private static void printArray(int[] array){
		System.out.print("{");
		for(int i=0;i<array.length;i++){
			if (i > 0 ) {
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
		System.out.print("}");

	}

}
