package numbers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		Scanner s = null;
		try {
			s = new Scanner(new FileReader("numbersTest.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int numberOfCases = s.nextInt();
		int cases[] = new int[numberOfCases];
		for(int i=0;i<numberOfCases;i++){
			cases[i] = s.nextInt();

			System.out.println("Case #" + (i+1) + ": " + calc(cases[i]));
		}		
	}

	private static String calc(int N) {
		int number = (int) Math.pow((3 + Math.sqrt(5)), N);

		//System.out.println(number);

		//Convert number to array of ints
		String temp = Integer.toString(number);
		int[] numArray = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++)
		{
			numArray[i] = temp.charAt(i) - '0';
		}

		//Make length 3
		int length = numArray.length;
		if(length != 3){
			int[] newArray = new int[3];
			//Need to add leading zeroes
			if(length < 3){
				int index = 2;
				for(int i=numArray.length-1;i>=0;i--){
					newArray[index--] = numArray[i]; 
				}
			}
			//Need to remove digits
			else{
				int index = 2;
				for(int i=numArray.length-1;index>=0;i--){
					newArray[index--] = numArray[i]; 
				}
			}
			return arrayToString(newArray);
		}
		return arrayToString(numArray);
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

	private static String arrayToString(int[] array){
		String str = "";
		for(int i=0;i<array.length;i++){
			str += array[i];
		}
		return str;
	}

}
