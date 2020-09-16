package mytests;


import java.util.Scanner;
import java.util.TreeMap;
public class Test2_StudentsSorted_by_marks {
	
	static TreeMap<Integer,MyTuple > TreeMapMarks =new TreeMap<Integer,MyTuple>(); 
	
	public static  class MyTuple { 
	    public final String name; 
	    public final Integer reg_no; 
	    public MyTuple(String name, Integer reg_no) { 
	        this.name = name; 
	        this.reg_no = reg_no; 
	    }

	    @Override
	    public String toString() {
	        return (String) ("Student  " + name + ",  Reg No " + reg_no );
	    }
	}
	
	static void fill_TreeMap(String student_str) {
	String[] my_str_arr = 	student_str.split(",");
	String name = my_str_arr[0];
	Integer reg_no = Integer.parseInt(my_str_arr[1]);
	MyTuple mt_temp = new MyTuple(name,reg_no); 
    Integer marks=0;
	for (int i=2;i<my_str_arr.length; i++) {
		marks = marks + Integer.parseInt(my_str_arr[i]);
	}
	
	TreeMapMarks.put(marks,mt_temp);
	
	}
	
	public static void main(String[] args) {
		
	      System.out.println("Test2 - programm will print all students and award the students with 1st rank, 2nd rank and 3rd rank according to marks ");
	      Scanner sc = new Scanner(System.in);

	      int count =0;
	      while(count<3) {
	    	  System.out.println("please enter student name, reg no, marks devided by coma -for example: Dan,1234,99,100,87");
	    	  String tmp_student_data = sc.nextLine();
	    	  fill_TreeMap(tmp_student_data);
	    	  
	    	  count++;
	    	  
	      }
	      int k=1;
	
	      
	      System.out.println("List of all students: Names, Reg no and total Marks");
	      for(Integer key:TreeMapMarks.keySet()) {
	    	  System.out.println(TreeMapMarks.get(key).toString() + ", Marks total = " +key);
	      }
	      for(Integer key:TreeMapMarks. descendingKeySet()) {

	    	  if( k==1){
	    		  System.out.println("     1st rank student  is " + TreeMapMarks.get(key).toString() + ",  Marks total = " + key);
	    	  }
	    	  else {
	    		  if (k==2) {
	    			  System.out.println("     2nd rank student  is " + TreeMapMarks.get(key).toString() + ",  Marks total =  " + key);
	    		  }
	    		  else {
	    			  if (k==3) {
	    				  System.out.println("     3rd rank student  is " + TreeMapMarks.get(key).toString() + ",  Marks total =  " + key);
	    				  
	    			  }
	    		  }
	    	  }
	    	  k++;
	    	  
	      }
	      sc.close();
		}
}
