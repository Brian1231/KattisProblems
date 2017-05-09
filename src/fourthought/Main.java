package fourthought;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.Timer;


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

		//printArray(cases);
		//System.out.println();
		double ans = -1000;
		
		long startTime = System.currentTimeMillis();
		
		//Loop through cases
		for(int i=0;i<N;i++){
			
			//Loop through operators
			for(int j=0;j<4;j++){
				for(int k=0;k<4;k++){
					for(int l=0;l<4;l++){
						ans = calc(operators[j], operators[k], operators[l]);
						if(ans == cases[i]){
							System.out.println("4 " + operators[j] + " 4 " + operators[k] + " 4 " + operators[l] + " 4 = " + cases[i]);
							break;
						}
						if(ans == cases[i]) break;
					}
					if(ans == cases[i]) break;
				}
				if(ans == cases[i]) break;
			}
			if(ans != cases[i])
				System.out.println("no solution");
		}
		
		long endTime = System.currentTimeMillis();
		long totalTime = ((endTime - startTime));
		System.out.println("\nTime elapsed: " + totalTime);
	}

	private static double calc(char j, char k, char l){
		String operators = "4" + Character.toString(j) + "4" + Character.toString(k) + "4" + Character.toString(l) + "4";
		//System.out.println(operators);
		Object res = "";
		int ans = 0;
		try {
			res =  new ScriptEngineManager().getEngineByName("js").eval(operators);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			ans = (int) res;
		}catch(Exception e){
			//e.printStackTrace();
		}
		return ans;
		
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
