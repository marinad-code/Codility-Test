package mytests;

import java.util.Scanner;
import java.util.Stack;

public class Test9_HanoiTowersWithStack {
	public static  void  solveHanoiStacks(int n, Stack<Integer> rodFrom, Stack<Integer>middleRod,Stack<Integer> rodTo){
		
		if (n>=1) {
			
		solveHanoiStacks(n-1,rodFrom,rodTo, middleRod);
	
			Integer temp1 = (Integer)rodFrom.pop();
		
			rodTo.push(temp1);
		
		solveHanoiStacks(n-1,middleRod, rodFrom,rodTo);
	}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stackFrom = new Stack<Integer>();
		Stack<Integer>  middleStack = new Stack<Integer>();
		Stack <Integer> stackTo = new Stack<Integer>();
		System.out.println("Please enter number of plates for Hanoi tower");
		int n = Integer.parseInt(sc.nextLine());
		for(int i=0; i<n;i++) {
			
			stackFrom.push((Integer)(i*100-i*10));
		}
		// print stackFrom
        for(int i=0; i<stackFrom.size();i++) {
			
		System.out.println("In stackFrom -- "  +stackFrom.get(i));
		}
        solveHanoiStacks(n, stackFrom , middleStack, stackTo );
      
     // print stackTo
        for(int i=0; i<stackTo.size();i++) {
    		
    	System.out.println("In stackTo -- "  +stackTo.get(i));
	}
    
     // print stackFrom
        for(int i=0; i<stackFrom.size();i++) {
			
		System.out.println("In stackFrom --> "  +stackFrom.get(i));
		}
     // print .size();i++) {
		
        for(int i=0; i<middleStack.size();i++) {
			
		System.out.println("In middleStack -- >>"  + middleStack.get(i));
		}
		sc.close();
	}
}
