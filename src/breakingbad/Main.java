package breakingbad;

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
			s = new Scanner(new FileReader("breakingBadTest.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Setup to hold input data
		int N = Integer.parseInt(s.nextLine());
		int NsuspiciousPairs = 0;
		String[] items = new String[N];
		String[][] suspiciousPairs = null;

		//Get data
		for(int i=0;i<N;i++){
			items[i] = s.nextLine();
		}
		NsuspiciousPairs = Integer.parseInt(s.nextLine());
		suspiciousPairs = new String[NsuspiciousPairs][];
		for(int i=0;i<NsuspiciousPairs;i++){
			suspiciousPairs[i] = new String[2];
			for(int j=0;j<2;j++){
				suspiciousPairs[i][j] = s.next();
			}
		}

		s.close();

		/*//Print arrays
		System.out.println("Items: ");
		printArray(items);
		System.out.println();
		System.out.println("\nSuspicious Items: ");
		for(String[] pair : suspiciousPairs){
			printArray(pair);
			System.out.println();
		}*/

		//Arrays for Walter and Jesse
		List<String> walter = new LinkedList<String>();
		List<String> jesse = new LinkedList<String>();

		//Split suspicious items between walter and jesse
		for(int i=0;i<NsuspiciousPairs;i++){
			if(!contains(walter, suspiciousPairs[i][0]) && !contains(jesse, suspiciousPairs[i][0])){
				walter.add(suspiciousPairs[i][0]);
			}
			if(!contains(jesse, suspiciousPairs[i][1]) && !contains(walter, suspiciousPairs[i][1])){
				jesse.add(suspiciousPairs[i][1]);
			}
		}

		//Create List of all items
		List<String> allItems = new LinkedList<String>();
		for(int i=0;i<N;i++){
			allItems.add(items[i]);
		}

		//Create List of non-suspicious items
		List<String> nonSuspiciousItems = new LinkedList<String>();
		for(int i=0;i<N;i++){
			if(!contains(jesse, items[i]) && !contains(walter, items[i]))
				nonSuspiciousItems.add(items[i]);
		}

		//Give all non-suspicious items to walter
		for(String str : nonSuspiciousItems){
			walter.add(str);
		}
		
		//Check if all suspicious items are accounted for
		int itemCount = allItems.size();
		for(String str : allItems){
			if(walter.contains(str) || jesse.contains(str))
				itemCount--;
		}

		if(itemCount == 0){
			//Print arrays
			System.out.println("Walter: ");
			printList(walter);
			System.out.println();
			System.out.println("Jesse: ");
			printList(jesse);
		}
		else
			System.out.println("Impossible");
	}

	private static void printArray(String[] array){
		System.out.print("{");
		for(int i=0;i<array.length;i++){
			if (i > 0 ) {
				System.out.print(", ");
			}
			if(array[i].equals(""))
				System.out.print("empty");
			System.out.print(array[i]);
		}
		System.out.print("}");

	}

	private static void printList(List<String> list){
		System.out.print("{");
		for(int i=0;i<list.size();i++){
			if (i > 0 ) {
				System.out.print(", ");
			}
			if(list.get(i).equals(""))
				System.out.print("empty");
			System.out.print(list.get(i));
		}
		System.out.print("}");

	}

	private static void printListProper(List<String> list){
		for(int i=0;i<list.size();i++){
			if (i > 0 ) {
				System.out.print(" ");
			}
			System.out.print(list.get(i));
		}
	}
	private static boolean contains(List<String> list, String string){
		for(String s : list){
			if(s != null && string != null){
				if(s.equals(string)){
					return true;
				}
			}
		}
		return false;
	}

}
