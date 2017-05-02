package conundrum;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
       
		/*String word = "";
        while(s.hasNext()){
            word = s.next();
        }
        s.close();*/

		String word = "RUBSLFBEF";
		String target = "PER";
		char[] arr = word.toCharArray();
		
		int count = 0;
		int index = 0;
		char[] targets = target.toCharArray();
		
		for(int i=0;i<word.length();i++){
			if(targets[index] != arr[i]){
				count++;
			}
			index = (index + 1)%3;
		}
		
		System.out.println(count);
	}

}
