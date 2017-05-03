package phonelist;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		Scanner s = null;
		try {
			s = new Scanner(new FileReader("test.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[] numbers = new int[100];
		int numberOfCases = s.nextInt();
		int index = 0;
		
		while(s.hasNextInt()){
			numbers[index] = s.nextInt();
			index++;
		}
		s.close();

		int hi = 0;
		int low = 0;
		for(int j = 0;j<numberOfCases;j++){
			//Begin new group
			int N = numbers[hi];
			int subNums[] = new int[N];
			
			//System.out.println("N : " + N);
			//Get numbers for group
			int subIndex = 0;
			for(int i=low;i<N;i++){
				subNums[subIndex] = numbers[i+1];
				subIndex++;
			}
			
			//Update index's
			low = N+1;
			hi = N+1;
			
			//Create group object and evaluate
			phoneGroup group = new phoneGroup(N, subNums);
			group.evaluate();
		}
	}
}
