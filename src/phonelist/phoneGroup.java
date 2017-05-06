package phonelist;


public class phoneGroup {

	private int N;
	private int[] numbers;
	private int[][] digits;

	public phoneGroup(int N, int[] numbers){
		this.N=N;
		this.numbers = numbers;
		this.digits = new int[N][];
	}

	public String evaluate(){
		
		//To compare the digits of numbers, the numbers must be split into digits
		//For every number,
		for(int j = 0;j<N;j++){
			//Cast int to string
			String temp = Integer.toString(numbers[j]); 

			//Set size of array to hold digits
			digits[j] = new int[temp.length()];
			//Add digits to array
			for (int i = 0; i < temp.length(); i++)
			{
				int tempInt = temp.charAt(i) - '0';
				digits[j][i] = tempInt;
			}
		}

		//Check for collisions within digits[][]
		
		//Get first number
		for(int i=0;i<N;i++){
			int[] currentNumber = digits[i];
			
			
			//Get second number
			for(int j=0;j<N;j++){
				int[] otherNumber = digits[j];

				//Compare the 2 numbers
				if(arraysHaveCollision(currentNumber, otherNumber)) return "NO";
			}
		}

		return "YES";
	}
	
	/*private void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}
	}*/
	
	private boolean arraysHaveCollision(int[] first, int[] second){
		if(first.equals(second)) return false; //Dont compare same arrays
		
		int collisionCount = 0;
		int smallerSize = first.length;
		if(smallerSize > second.length) smallerSize = second.length;
		
		for(int i=0;i<smallerSize;i++){
			if(first[i] == second[i]) collisionCount++;
		}
		
		return collisionCount >= smallerSize;
		
		
	}
}
