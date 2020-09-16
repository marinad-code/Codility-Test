package mytests;

import java.util.Scanner;
import java.util.TreeMap;



public class Test20_Store {
static TreeMap<Integer,MyTuple > TreeMapInStore =new TreeMap<Integer,MyTuple>(); 
	
	public static  class MyTuple { 
	    public final String drinktype; 
	    public  Integer quantity; 
	    public MyTuple(String drinktype, Integer quantity) { 
	        this.drinktype = drinktype; 
	        this.quantity = quantity; 
	    }
	    public Integer get_quantity() {
	    	return quantity;
	    }
	    public void set_quantity(Integer quantity) {
	    	this.quantity= quantity;
	    }
	    @Override
	    public String toString() {
	        return (String) ("Drinktype  " + drinktype + ",  quantity = " + quantity );
	   
	}
	    public static void process_order(Integer input) {
	    for(Integer key:TreeMapInStore.keySet()) {
			if (key ==input) {
				if(TreeMapInStore.get(key).get_quantity()>1) {
					int temp = TreeMapInStore.get(key).get_quantity()-1;
					System.out.println("Drink has been served.Enjoy");
					TreeMapInStore.get(key).set_quantity(temp);
				}
				else {
					System.out.println("Sorry, out of that Drink ");
				}
			}
		}
	    }

	public static void main(String[] args) {
		//Create drinks
		MyTuple drink1 = new MyTuple("Lemonad", 10);
		MyTuple drink2 = new MyTuple("Italian Soda", 10);
		MyTuple drink3 = new MyTuple("Cream Soda", 10);

		TreeMapInStore.put(1,drink1);
		TreeMapInStore.put(2,drink2);
		TreeMapInStore.put(3,drink3);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("please enter the drinktype : - for Lemonad type 1; for Italian Soda 2; for Cream soda -3 ; for exit -777");
		Integer input = Integer.parseInt(sc.nextLine());
		process_order(input);
		while(input!=777) {
			System.out.println("please enter the drinktype :");	
		     input = Integer.parseInt(sc.nextLine());
		     process_order(input);
		}
		sc.close();	
	}

}
}
