package mytests;



public class Test12_DoubleEndedQueue {

	Node head;
	Node tail;
	
    static class Node{
		
		
		Object data =null;
		Node next = null;
		Node prev = null;
		/*
		 * constractor
		 */
		Node(Object data){
			this.data = data;
			next = null;
			prev = null;
		}
	}
	
	 public static Test12_DoubleEndedQueue insertAfterLast(Test12_DoubleEndedQueue my_list, int data) 
	 { 
	     // Create a new node with given data 
	     Node new_node = new Node(data); 
	     new_node.next = null; 
	     new_node.prev = null; 
	     
	     // If the Linked List is empty, 
	     // then make the new node as head  and as a tail
	     if (my_list.head == null) { 
	         my_list.head = new_node; 
	         my_list.tail = new_node;
	     } 
	     else { 
	         // Else traverse till the last node 
	         // and insert the new_node there 
	         Node last = my_list.head; 
	         while (last.next != null) { 
	             last = last.next; 
	         } 

	         // Insert the new_node at last node and point prev to last node
	         last.next = new_node; 
	         new_node.prev = last;
	         my_list.tail = new_node;
	     } 

	     // Return the list by head 
	     return my_list; 
	 } 
	 
	 public static Test12_DoubleEndedQueue inserBeforeFirst(Test12_DoubleEndedQueue my_list, int data) 
	 { 
	     // Create a new node with given data 
	     Node new_node = new Node(data); 
	     new_node.next = null; 
	     new_node.prev = null; 
	     
	     // If the Linked List is empty, 
	     // then make the new node as head  and as a tail
	     if (my_list.head == null) { 
	        
	         my_list.tail = new_node;
	     } 
	     else { 
	         // Else find head and insert before head; 
	    	 my_list.head.prev = new_node;
	     }
	         new_node.next=my_list.head;
	         //in both cases new_node - new head 
             my_list.head = new_node;

	     // Return the list by head 
	     return my_list; 
	 } 
	 
	// Method to print the LinkedList from first
	 public static void printListFromFirst(Test12_DoubleEndedQueue my_list) 
	 { 
	     Node currNode = my_list.head; 

	     System.out.println(" DoubleEndedQueue from first to last: "); 

	     // Traverse through the LinkedList 
	     while (currNode != null) { 
	         // Print the data at current node 
	         System.out.print(currNode.data + " "); 

	         // Go to next node 
	         currNode = currNode.next; 
	     } 
	 } 
	// Method to print the LinkedList from Last
		 public static void printListFromLast(Test12_DoubleEndedQueue my_list) 
		 { 
		     Node currNode = my_list.tail; 

		     System.out.println(" DoubleEndedQueue from last to first: "); 

		     // Traverse through the LinkedList 
		     while (currNode != null) { 
		         // Print the data at current node 
		         System.out.print(currNode.data + " "); 

		         // Go to next node 
		         currNode = currNode.prev; 
		     } 
		 } 
	 public static int getSize(Test12_DoubleEndedQueue my_list) 
	 { 
		 int size=0;
	     Node currNode = my_list.head; 

	     System.out.print("LinkedList: "); 
   
	     // Traverse through the LinkedList 
	     while (currNode != null) { 
	         // Print the data at current node 
	         System.out.print(currNode.data + " "); 

	         // Go to next node 
	         currNode = currNode.next; 
	         size++;
	     } 
	     return size;
	 } 
	 
	// Method to delete from beginning of the LinkedList/DoubleEndedQueue
		 public static Test12_DoubleEndedQueue delete_fromListFirst(Test12_DoubleEndedQueue my_list) 
		 { 
			 if(my_list.head == null) {
		    	 System.out.println("DoubleEndedQueue is empty");
		    	 throw new RuntimeException("DoubleEndedQueue is empty");
		     }
		     
		    //if only one element in list
		     if(my_list.head.next==null) {
		    	 my_list.tail = null;
		    	 my_list.head = null;
		     }
		     else {
		     Node currNode = my_list.head; 

		     System.out.print("DoubleEndedQueue to delete first element from the queue: " + currNode.data); 
		     
		     Node feature_head = my_list.head.next;
		     feature_head.prev =null;
		     my_list.head = feature_head;
		     }
		     return my_list;

		   
		 } 
		// Method to delete from the end of the LinkedList/DoubleEndedQueue
				 public static Test12_DoubleEndedQueue delete_fromListLast(Test12_DoubleEndedQueue my_list) 
				 { 
				     
				     if(my_list.tail == null) {
				    	 System.out.println("DoubleEndedQueue is empty");
				    	 throw new RuntimeException("DoubleEndedQueue is empty");
				     }
				     
				    //if only one element in list
				     if(my_list.tail.prev==null) {
				    	 my_list.tail = null;
				    	 my_list.head = null;
				     }
				     else {
				     
				     Node currNode = my_list.tail; 
				     

				     System.out.print("DoubleEndedQueue to delete last element from the queue: " + currNode.data); 	 
				     Node feature_tail = my_list.tail.prev;
				     feature_tail.next =null;
				     my_list.tail = feature_tail;
				     }
				     return my_list;
				     
				     

				   
				 } 
	public static void main(String[] args) {
		Test12_DoubleEndedQueue test_list = new Test12_DoubleEndedQueue();
		for(int i=0; i<10;i++) {
			Test12_DoubleEndedQueue.inserBeforeFirst(test_list, (Integer)i*10);
			Test12_DoubleEndedQueue.insertAfterLast(test_list, (Integer)i*100);
		}
		System.out.println("Size of the list :" +Test12_DoubleEndedQueue.getSize(test_list));
		System.out.println();
		Test12_DoubleEndedQueue.delete_fromListFirst(test_list);
		System.out.println();
		System.out.println("After element was deleted :  ");
		Test12_DoubleEndedQueue.printListFromFirst(test_list);
		System.out.println();
		Test12_DoubleEndedQueue.delete_fromListLast(test_list);
		System.out.println();
		System.out.println("After element was deleted :  ");
		Test12_DoubleEndedQueue.printListFromLast(test_list);
		//check delete when only one element in queue
		Test12_DoubleEndedQueue test_list1 = new Test12_DoubleEndedQueue();
		Test12_DoubleEndedQueue.inserBeforeFirst(test_list1, (Integer)5*10);
		System.out.println();
		System.out.println();
		System.out.println("Size of the list :" +Test12_DoubleEndedQueue.getSize(test_list1));
		Test12_DoubleEndedQueue.delete_fromListFirst(test_list1);
		System.out.println("After element was deleted :  ");
		Test12_DoubleEndedQueue.printListFromFirst(test_list1);
		//check delete when only one element in queue
			
				Test12_DoubleEndedQueue.inserBeforeFirst(test_list1, (Integer)7*10);
				System.out.println();
				System.out.println();
				System.out.println("Size of the list :" +Test12_DoubleEndedQueue.getSize(test_list1));
				Test12_DoubleEndedQueue.delete_fromListLast(test_list1);
				System.out.println("After element was deleted :  ");
				Test12_DoubleEndedQueue.printListFromLast(test_list1);
				//check delete on empty list
				Test12_DoubleEndedQueue.delete_fromListLast(test_list1);
	}


}
