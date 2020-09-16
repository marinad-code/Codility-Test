package mytests;


import java.util.Scanner;
import java.util.TreeMap;

public class Test5_coins {
	
	static TreeMap<Integer,Integer> my_map = new  TreeMap<Integer,Integer>();
	static int helper(int cents) { 
     int quotient=0;
	 int reminder=0;
	 
	
	 if(cents>=100) {
   	 quotient = cents/100;	
     reminder = cents%100;
     my_map.put(100,quotient );
	 }
	 else {
     if(cents>=25) {
    	 quotient = cents/25;	
         reminder = cents%25;
         my_map.put(25,quotient );
       }
      else {
    	  if(cents>=10) {
    	 quotient = cents/10;	
         reminder = cents%10;
         my_map.put(10,quotient );
          }
    	  else {
    		  if(cents>= 5) {
             	 quotient = cents/5;	
                  reminder = cents%5;
                  my_map.put(5,quotient );
                   }
    		  else {
    			  reminder = cents;
    			  my_map.put(1,reminder );
    			  reminder =0;
    		  }
    	  }
      }
}
	return reminder;	
	}

	public static void main(String[] args) {
		System.out.println("This program will read monetary amount in cents and print the smallest possible number of coins equaling the amount");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter monetary amount in cents : ");
        int cents = Integer.parseInt(sc.nextLine());
        int cents_entered = cents;
        while(cents>0) {
        cents=helper(cents);
       // System.out.println("cents =" + cents);
        }
        System.out.println("In entered monetary amount =  " + cents_entered + " cents the smallest possible number of coins equaling the amount is : ");
        System.out.println();
        int count_coins =0;
        for(Integer k:  my_map.descendingKeySet()){
        
        	
        	switch(k) {
        	case 100:
        		System.out.print(my_map.get(k) + "  dollars  ");
        		count_coins +=my_map.get(k) ;
                  break;      	
        	case 25:
        		System.out.print(my_map.get(k) + "  quarters  ");
        		count_coins +=my_map.get(k) ;
        		break;
        	case 10:
        		System.out.print(my_map.get(k) + "  dimes  ");
        		count_coins +=my_map.get(k) ;
        		break;
        	case 5:
        		System.out.print(my_map.get(k) + "  nickels  ");
        		count_coins +=my_map.get(k) ;
        		break;
        	case 1:
        		System.out.print(my_map.get(k) + "  cents  ");
        		count_coins +=my_map.get(k) ;
        		break;
        	default:
        	System.out.println();
        
        }

	}
System.out.println("total coins = " + count_coins);
sc.close();
}
}