package mytests;

public class Test11_My_LinkedList {
	
	Node head;
    static class Node{
		
		
		Object data =null;
		Node next = null;
		
		/*
		 * constractor
		 */
		Node(Object data){
			this.data = data;
			next = null;
			
		}
	}
	
	 public static Test11_My_LinkedList insert(Test11_My_LinkedList my_list, int data) 
	 { 
	     // Create a new node with given data 
	     Node new_node = new Node(data); 
	     new_node.next = null; 

	     // If the Linked List is empty, 
	     // then make the new node as head 
	     if (my_list.head == null) { 
	         my_list.head = new_node; 
	     } 
	     else { 
	         // Else traverse till the last node 
	         // and insert the new_node there 
	         Node last = my_list.head; 
	         while (last.next != null) { 
	             last = last.next; 
	         } 

	         // Insert the new_node at last node 
	         last.next = new_node; 
	     } 

	     // Return the list by head 
	     return my_list; 
	 } 
	// Method to print the LinkedList. 
	 public static void printList(Test11_My_LinkedList my_list) 
	 { 
	     Node currNode = my_list.head; 

	     System.out.print("LinkedList: "); 

	     // Traverse through the LinkedList 
	     while (currNode != null) { 
	         // Print the data at current node 
	         System.out.print(currNode.data + " "); 

	         // Go to next node 
	         currNode = currNode.next; 
	     } 
	 } 
	 public static int getSize(Test11_My_LinkedList my_list) 
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
	 
	// Method to print the LinkedList. 
		 public static Test11_My_LinkedList delete_fromList(Test11_My_LinkedList my_list,Object data) 
		 { 
		     Node currNode = my_list.head; 

		     System.out.print("LinkedList to delete element: "); 

		     // Traverse through the LinkedList 
		     int k=0;
		     int m=0;
		     Node tmp = new Node(null);
		     while (currNode != null) { 
		    	 
		    	 if(currNode.data.equals(data)) {
		    		 System.out.println("About to delete  :" + data.toString());
		    		 tmp.data= currNode.data;
		    		 tmp.next= currNode.next;
		    		 m=k;
		    	 }
		         // Print the data at current node 
		         System.out.print(currNode.data + " "); 

		         // Go to next node 
		         currNode = currNode.next; 
		         k++;
		     } 
		     k=0;
		     System.out.println("m==" +m);
		     if( m!=0) 
		     //Not a first element -need to add check for empty list
		     {
		    	 //traverse again
		    	 currNode = my_list.head;
		    	 while (currNode != null) { 
		    	 
		    	 if((k== m-1)) {
		    		 //System.out.println("About to delete --here  :" + currNode.data.toString());
		    		 
		    		 currNode.next= tmp.next;
		    		 
		    	 }
		  
		         // Go to next node 
		         currNode = currNode.next; 
		         k++;
		     } 
		    	
		     }
		     return my_list;
		 } 
	public static void main(String[] args) {
		Test11_My_LinkedList test_list = new Test11_My_LinkedList();
		for(int i=0; i<10;i++) {
		Test11_My_LinkedList.insert(test_list, (Integer)i*10);
		}
		System.out.println("Size of the list :" +Test11_My_LinkedList.getSize(test_list));
		Test11_My_LinkedList.delete_fromList(test_list, (Integer)70);
		System.out.println("After element was deleted:  ");
		Test11_My_LinkedList.printList(test_list);

	}

}
