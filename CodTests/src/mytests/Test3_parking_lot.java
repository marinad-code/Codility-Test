package mytests;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Test3_parking_lot {
	static List<CarInfo> List1 =new ArrayList<CarInfo>(); 
	static List<CarInfo> List2 =new ArrayList<CarInfo>(); 

	public static  class CarInfo { 
	    public final String model; 
	    public final Integer park_duration;
	    public final String number;
	    public CarInfo(String model, Integer  park_duration, String number) { 
	        this.model = model; 
	        this. park_duration =  park_duration; 
	        this.number = number;
	    }
        public  Integer get_time() {
        	return park_duration;
        }
	    @Override
	    public String toString() {
	        return (String) ("Car info:  " + model + ",  " + number +  " total time on parking lot in minutes: " + park_duration  );
	    }
	}
	
	static void fill_lists(String car_info_str) {
	String[] my_str_arr = 	car_info_str.split(",");
	String model = my_str_arr[0];
	String number = my_str_arr[1];
	Integer park_duration = Integer.parseInt(my_str_arr[2]);
	CarInfo ci_temp = new CarInfo(model, park_duration, number); 
    if(Integer.parseInt(my_str_arr[3])==1) {
    	//add vehicle into first list
    	List1.add(ci_temp);
    }
    else {
    	//add vehicle into second list
    	List2.add(ci_temp);
    }
   
 }
	
	
	public static void main(String[] args) {
		
	      System.out.println("Test3 - program will print one vehicle information which has highest parked hour");
	      Scanner sc = new Scanner(System.in);

	      int count =0;
	      while(count<5) {
	    	  System.out.println("please enter vehicle model, number, total duration in minutes, first or second entrance was used -for example: Honda,13456ww,60,1");
	    	  String tmp_vehicle_data = sc.nextLine();
	    	  fill_lists(tmp_vehicle_data );
	    	  
	    	  count++;
	    	  
	      }

	      System.out.println("In List1 currently : ");
	for(CarInfo ci:List1) {
		System.out.println(ci.toString());
	}
	 System.out.println("In List2 currently : ");
	for(CarInfo ci:List2) {
		System.out.println(ci.toString());
	}      
	//merge into list1
	
	List1.addAll(List2);
    System.out.println("In List1 after merge : ");
	for(CarInfo ci:List1) {
		System.out.println(ci.toString());
	}
	
	Collections.sort(List1, new Comparator<CarInfo>() {
	    public int compare(CarInfo ci1, CarInfo ci2) {
	        return ci1.get_time().compareTo(ci2.get_time());
	    }
	});
	
	System.out.println("In List1 after sort : ");
	for(CarInfo ci:List1) {
		System.out.println(ci.toString());
	}
	System.out.println();
	System.out.println("Vehicle information which has highest parked hour :");
	System.out.println();
	int k=1;
	for(CarInfo ci:List1) {
		if(k==5) {
		System.out.println(ci.toString());
		}
		k++;
	}
	sc.close();
	
		}
}
