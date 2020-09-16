package mytests;


public class Test15_MinimumPriorityQueue {
	
	
	static class Student{
		private String name = "";
		private int id =0; 
		
		//constructor
		Student(String name,int id){
		this.name = name;
		this.id = id;
		}
		//getter
		public String get_name() {
			return name;
		}
		//getter
		 public int get_id(){
			return id;
		}
		@Override
		public String toString() {
		return "Student id = " + id + " name  " +name;	
		}
		
	}
	    
		Node head;
		Node tail;
		
	    static class Node{
			
			
			Student data =null;
			Node next = null;
			Node prev = null;
			/*
			 * constractor
			 */
			Node(String name, int id){
				this.data = new Student( name, id);
				next = null;
				prev = null;
			}
		}
		
		 public  Test15_MinimumPriorityQueue EnQueue(Test15_MinimumPriorityQueue my_list, String name, int id) 
		 { 
		     // Create a new node with given data 
		     Node new_node = new Node(name, id); 
		     new_node.next = null; 
		     new_node.prev = null; 
		     
		     // If the Linked List is empty, 
		     // then make the new node as head  and as a tail
		     if (my_list.head == null) { 
		         my_list.head = new_node; 
		         my_list.tail = new_node;
		       
		     } 
		     else { 
		    	 Node current = my_list.head; 
		    	 boolean found = false;
		         //only one element in list
		    	 if(my_list.head.next==null)
		    	 {
		    		 if(current.data.get_id() > new_node.data.get_id()) {
		        		 //spot to insert was found
		        		 new_node.prev = current.prev;
		        		 current.prev = new_node;
		        		 new_node.next = current;
		        		 my_list.tail = current;
		        		 my_list.head = new_node;
		        		 found = true;
		    	 }
		    	 }	 
		         // Else traverse till find the large and insert before that node
		         // insert the new_node there 
		        
		         
		    	 else {
		         while (current.next != null) { 
		        	 if(current.data.get_id() > new_node.data.get_id()) {
		        		 //spot to insert was found
		        		 new_node.prev = current.prev;
		        		 current.prev = new_node;
		        		 new_node.next = current;
		        		 //node ahead
		        		 current.prev.next = new_node;
		        		 //head node was greater than new node
		        		 if(current == my_list.head) {
		        			 my_list.head = new_node;
		        			 
		        		 }
		        		 found = true;
		        		 break;
		        		 
		        	 }
		             current = current.next; 
		         } 
		    	 
		         //  if all smaller than new - Insert the new_node at last node and point prev to last node //check last one!!
		         if (found == false) {
		        	 if(current.data.get_id() > new_node.data.get_id()) {
		        		 new_node.prev = current.prev;
		        		 current.prev.next = new_node;
		        		 current.prev = new_node;
		        		 new_node.next = current; 
		        	 }
		        	 else {
		         current.next = new_node; 
		         new_node.prev = current;
		         current.prev.next = new_node;
		         my_list.tail = new_node;
		        	 }
		         }
		    	 }
		     } 

		     // Return the list 
		     return my_list; 
		 } 
		 // Method to print the LinkedList from first
		 public void printListFromFirst(Test15_MinimumPriorityQueue my_list) 
		 { 
		     Node currNode = my_list.head; 

		     System.out.println(" PriorityQueue from minimum to max id's: "); 

		     // Traverse through the LinkedList 
		     while (currNode.next != null) { 
		         // Print the data at current node 
		         System.out.print(currNode.data + " "); 

		         // Go to next node 
		         currNode = currNode.next; 
		     } 
		     //Last element - next == null 
		     System.out.print(currNode.data + " "); 
		 } 
		 
        //DeQueue
		 public  Test15_MinimumPriorityQueue DeQueue(Test15_MinimumPriorityQueue my_list) 
		 { 
			
			
			if (my_list.tail == null) {
				 System.out.println("PriorityQueue is empty");
		    	 throw new RuntimeException("PriorityQueue is empty");
			}
			Node node_to_remove = my_list.tail;
			
			//only element in list
			if(node_to_remove.prev ==null)
			{
				System.out.println("PriorityQueue will be empty.About to remove :" + node_to_remove.data);
				node_to_remove.data = null;
				my_list.tail = null;
				my_list.head = null;
			}
			else {
				System.out.println("PriorityQueue. About to remove :" + node_to_remove.data);
				Node new_last = node_to_remove.prev;
				new_last.next = null;
				my_list.tail = new_last;
				
			}
			 return my_list;
		 }
		 //peekMin - return student with minimum id
		 public  Student peekMin(Test15_MinimumPriorityQueue my_list) 
		 { 
			
			
			if (my_list.tail == null) {
				 System.out.println("PriorityQueue is empty");
		    	 throw new RuntimeException("PriorityQueue is empty");
			}
			   Node min_node = my_list.tail;
			
		
				System.out.println("PriorityQueue. Returning info about  :" +min_node.data);

				
	
			 return min_node.data;
		 }
		 
	public static void main(String[] args) {
		
		Test15_MinimumPriorityQueue test_q = new Test15_MinimumPriorityQueue();
		//filling up priority queue
		test_q.EnQueue(test_q, "Bella", 25);
		test_q.EnQueue(test_q, "Dora", 1);
		test_q.EnQueue(test_q, "Mari", 19);
		//print current q
		test_q.printListFromFirst(test_q);
		System.out.println("");
		  System.out.println("====================");
		  //remove element with min id
		  test_q.DeQueue(test_q);
		  System.out.println("=After removed=====");
		  test_q.printListFromFirst(test_q);
		  System.out.println("");
		  System.out.println("====================");
		  //call peek to show student with min id
		  System.out.println("=Student with minimum id is :" + "\n" +test_q.peekMin(test_q));

		//Using PriorityQueue
		/*  
		Student temp = new Student("Bella", 25);
		Student temp1 = new Student("Bella2", 1);
		Student temp2 = new Student("Bella1", 19);
		
		Comparator<Student> nameSorter = Comparator.comparing(Student::get_id);
		 
		PriorityQueue<Student> queue = new PriorityQueue<>( nameSorter );
		queue.offer(temp);
		queue.offer(temp1);
		queue.offer(temp2);
		
	

		Student val = null;
		while( (val = queue.poll()) != null) {
		    System.out.println(val.toString());
		*/
		
		
	}

}
