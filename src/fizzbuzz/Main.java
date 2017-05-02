package fizzbuzz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        
        Scanner s = new Scanner(System.in);
        long X = 0,Y = 0,N = 0;
        while(s.hasNextLong()){
            X = s.nextLong();
            Y = s.nextLong();
            N = s.nextLong();
        }
        s.close();
        
        for(long i=1;i<=N;i++){
            if(i%X==0 && i%Y==0) System.out.println("FizzBuzz");
            else if(i%X==0) System.out.println("Fizz");
            else if(i%Y==0) System.out.println("Buzz");
            else System.out.println(i);
            
        }
    }
    
    
}