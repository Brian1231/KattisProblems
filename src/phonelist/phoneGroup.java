package phonelist;

public class phoneGroup {

	private int N;
	private int[] numbers;
	
	public phoneGroup(int N, int[] numbers){
		this.N=N;
		this.numbers = numbers;
	}
	
	public void evaluate(){
		System.out.println("\nEVALUATE! : " + N);
		for(int n : numbers){
			System.out.println(n);
		}
	}
}
