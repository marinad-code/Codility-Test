package mytests;

import java.util.ArrayList;
import java.util.Scanner;


public class Test8_EmployeeArrayList {
	
	public static class Employee{
		private String full_name;
		private String position;
		
	public Employee(String name, String position) {
		this.full_name= name;
		this.position = position;
	}
	public String  get_name() {
		return this.full_name;
	}
	public String  get_position() {
		return this.position;
	}	
	public void  set_name(String name) {
		this.full_name = name;
	}
	public void  set_position(String position) {
		this.position = position;
	}
	}
	
	public static void main(String[] args) {
		ArrayList<Employee> my_arrList = new ArrayList<Employee>();
		System.out.println("Test8 - programm will print Employee ArrayList and remove duplicates ");
	      Scanner sc = new Scanner(System.in);
	      int count =0;
	      
	      while(count<4) {
	    	  System.out.println("please enter Employee name, position devided by coma -for example: Bob Dilan,Staff Engineer ");
	    	  String tmp_employee_data = sc.nextLine();
	    	  String[] my_str_arr =  tmp_employee_data.split(",");
	    	  if(my_str_arr.length>=2) {
	    	  Employee obj = new Employee(my_str_arr[0],my_str_arr[1]);
	    			  my_arrList.add(obj);
	    	  }
	    	  count++;
	    	  
	      }
        for(Employee e:my_arrList) {
        	System.out.print(e.get_name() +", "+e.get_position()+ "    ");
        }
        System.out.println();

        int k= my_arrList.size() +1;
        int m = my_arrList.size() +1;
        boolean dupl = false;
        for(int i = 0; i<my_arrList.size();i++) {
        	if (dupl ==true) {
        		break;
        	}
        	String temp = my_arrList.get(i).get_name();
        	System.out.println(temp);
        	 for(int j = 0; j<my_arrList.size();j++) {
        		 
        		 String temp1 = my_arrList.get(j).get_name();

        		 if(temp.equals(temp1) && i!=j) {
        			 //System.out.println("yes");
        			 dupl =true;
        			 
        			 k=i;
        			 m=j;
        			break;
        		 }
      		 
        	 }
         	
        }
        
      
        System.out.println(k +  " , "+ m);
        if(m!= my_arrList.size() +1) {//find dup - remove
        	System.out.println("After duplicate was removed");
        	my_arrList.remove(k);
        	
        }
        for(Employee e:my_arrList) {
        	System.out.print(e.get_name() +", "+e.get_position() +"     ");
        }
        sc.close();

}
}
