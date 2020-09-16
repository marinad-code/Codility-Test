package mytests;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Test4_5uniqueElements {

	public static void main(String[] args) {
		System.out.println("this programm will accsept 5 unique elements (Integers) - if dup enetered - worning will be printed out");
		 Scanner sc = new Scanner(System.in);
	      Set<Integer>  my_set =new HashSet<Integer>();
	      
	      int count =0;
	      while(count<5) {
	    	  System.out.println("please enter an integer");
	    	  Integer element = Integer.parseInt(sc.nextLine());
	    	  int temp_set_size = my_set.size();
	    	  my_set.add(element);
	    	  if(temp_set_size==my_set.size()) {
	    		  //attempt enter dup
	    		  System.out.println("Sorry, try again - dups are not allowed");
	    	  }
	    	  else {
	    		  count++;
	    	  }

	
	    	  
	      }
	      System.out.println(" All elements in sorted order:");
     for (Integer el:my_set) {
    	 System.out.print(el +" ");
     }
     sc.close();
	}

}
