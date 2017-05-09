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
		int ans = -1000;
		
		//Loop through cases
		for(int i=0;i<N;i++){
			System.out.println("\nCase: " + cases[i]);
			
			//Loop through operators
			for(int j=0;j<4;j++){
				for(int k=0;k<4;k++){
					for(int l=0;l<4;l++){
						ans = calc(operators[j], operators[k], operators[l]);
						System.out.println(ans);
						if(ans == cases[i]){
							System.out.println("4 " + operators[j] + " 4 " + operators[k] + " 4 " + operators[l] + " 4");
							break;
						}
						if(ans == cases[i]) break;
					}
					if(ans == cases[i]) break;
				}
				if(ans == cases[i]) break;
			}
			if(ans != cases[i])
				System.out.println("Impossible");
		}
	}

	private static int calc(char j, char k, char l){
		//Loop through j
		if(j == '+'){
			return 4 + calc('0', k, l);
		}
		else if(j == '-'){
			return 4 - calc('0', k, l);
		}
		else if(j == '*'){
			return 4 * calc('0', k, l);
		}
		else if(j == '/'){
			return 4 / calc('0', k, l);
		}
		else if(j == '0'){
			//Loop through k
			if(k == '+'){
				return 4 + calc('0', '0', l);
			}
			else if(k == '-'){
				return 4 - calc('0', '0', l);
			}
			else if(k == '*'){
				return 4 * calc('0', '0', l);
			}
			else if(k == '/'){
				return 4 / calc('0', '0', l);
			}
			else if(k == '0'){
				//Loop through l
				if(l == '+'){
					return 4 + calc('0', '0', '0');
				}
				else if(l == '-'){
					return 4 - calc('0', '0', '0'); //0
				}
				else if(l == '*'){
					return 4 * calc('0', '0', '0');
				}
				else if(l == '/'){
					return 4 / calc('0', '0', '0');
				}
			}
		}
		return 4;
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
