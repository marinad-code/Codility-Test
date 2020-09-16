package mytests;

import java.util.Arrays;
import java.util.Scanner;

import mytests.Test2_StudentsSorted_by_marks.MyTuple;

public class Test7_ArraylLst {
	

	    /**
	     * Stores the objects in an array
	     */
	    private Object[] MyarrayList;

	    /**
	     * The current amount of elements in the arrayList array
	     */
	    private int StoredElements;
        public Object[] getMyarrayList() {
        	return MyarrayList;
        }
        public int getStoredElements() {
        	return StoredElements;
        }
	    /**
	     * The default constructor that creates an arrayList with a default size of 3 by calling second constructor 
	     * Precondition: Must instantiate the class without passing a value.
	     * Postcondition: Initializes the arrayList array with a default size of 3.
	     */
	    public  Test7_ArraylLst() {
	        this(3);
	    }

	    /**
	     * Constructor that allows an initial size to be passed to the array.
	     * Precondition: Parameter n must be larger than 0.
	     * Postcondition: The constructor initializes the arrayList data field with size n
	     * and initializes the StoredElements to 0.
	     * @param n | The size of the arrayList array.
	     */
	    public Test7_ArraylLst(int n) {
	        if (n <= 0) {
	            System.out.println("The size must be greater than 0. Try again.");
	            return;
	        }

	        this.MyarrayList = new Object[n];
	        this.StoredElements = 0;
	    }
	    /**
	     * Will copy array into new one and increase in size
	     */
        public void increaseSize() {
        	MyarrayList = Arrays.copyOf(MyarrayList, MyarrayList.length*2);
        	System.out.println("New sisze of arrayList  " + MyarrayList.length);
        }
        
        /**
	     * Will add new element to array list; 
	     * if needed will call increaseSize before adding
	     */
        public void addElement(Object obj) {
        	if((MyarrayList.length -1) == StoredElements) {
        		// need more space
        		increaseSize();
        	}
        	
        		MyarrayList[StoredElements] =obj;
        		StoredElements+=1;
        	
        }
        
        /**
	     * Will check if object to be removed is in ArrayList element; 
	     * if yes - will remove and decrease StoredElements; if no - will print Error massage
	     */
        public void removeElement(Object obj) {
        	int k = -1;
        	for (int i=0; i<StoredElements;i++) {
        		
        		if(MyarrayList[i].toString().equals(obj.toString())) {
        			
        			System.out.println("from remove = found element on index i= " + i);
        			k = i;
        			break;
        		}
        			
        				
        	 }		
        		if(k!= -1) {	
        			
        			MyarrayList[k] = null;
        			
        			while(k<StoredElements) {
        				MyarrayList[k]	= MyarrayList[k+1];
        				MyarrayList[k+1]=null;
        				k++;
        			}
 
        	StoredElements--;	
        	
        	
        		}
        		else {
     				System.out.println("from remove = No such element in arrayList");
            	}
	}
        /**
	     * Return element on given index
	     */
        public Object getElementbyIndex(int index) {
        	Object obj =null;
	         for (int i=0; i<StoredElements;i++) {
	        	 if (i==index) {
	        		 obj =MyarrayList[i];
	        		 break;
	        	 }	          
	         }
	         if (obj==null) {
	        	 System.out.println("Sorry, noobject with such index - returning null");
	         }
	         return obj;
        }
        
        /**
	     * Will print all elements from ArrayList
	     */
        public void printall() {
	         for (int i=0; i<StoredElements;i++) {
		        System.out.println(MyarrayList[i]);
	         }
        }
        
        /**
	     * Will process input and call MyPulip constructor
	     */
	public static MyTuple process_input(String tmp_student_data )
	   {
  	     String[] my_str_arr = 	tmp_student_data.split(",");
  	     String name = my_str_arr[0];
  		 Integer reg_no = Integer.parseInt(my_str_arr[1]);
  		 MyTuple Student = new MyTuple(name,reg_no);
  	return Student;
	    }

	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		Test7_ArraylLst ma = new Test7_ArraylLst();
	      int count =0;
	      System.out.println("---Add student record into my own Array List ----");
	      while(count<5) {
	    	  System.out.println("please enter student name, reg no, marks devided by coma -for example: Dan,1234");
	    	  String tmp_student_data = sc.nextLine();
	    	  
	    	  //re-using code from test2 - creating object Student of MyTulip class
	    	  MyTuple Student = process_input(tmp_student_data);
	    	   		 
	    		ma.addElement(Student);
		        count++;
	      }
	      System.out.println("---All student records currently in my ArrayList ----");
	      	ma.printall();
	      	System.out.println("---Remove student record----");
			System.out.println("Please eneter the  student data to be removed -for example: Dan,1234\"");
			String tmp_student_data = sc.nextLine();
			MyTuple Student = process_input(tmp_student_data);
	    	  ma.removeElement(Student);
	    	  System.out.println("==In my ArrayList after remove was called====");
	  		ma.printall();
	
	  		sc.close();

	}

}
