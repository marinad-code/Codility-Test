package mytests;

import java.util.Scanner;
import java.util.TreeMap;

public class Test1_TreeMapNote {

	public static void main(String[] args) {
		
      System.out.println("Test1 - programm will print students in ascending order based on reg no");
      Scanner sc = new Scanner(System.in);
      TreeMap<Integer,String>  TreeMapNote =new TreeMap<Integer,String>(); 
      int count =0;
      while(count<3) {
    	  System.out.println("please enter student name");
    	  String tmp_name = sc.nextLine();
    	  System.out.println("please enter student reg no");
    	  Integer tmp_reg_no = Integer.parseInt(sc.nextLine());
    	  TreeMapNote.put(tmp_reg_no, tmp_name);
    	  count++;
    	  
      }
      for(Integer key:TreeMapNote.keySet()) {
    	  System.out.println("Student  " + TreeMapNote.get(key) + "  reg no - " +key);
    	  
      }
sc.close();      
	}

}
