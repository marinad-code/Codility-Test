package mytests;

public class Test13_CircularQueue {

	    
	// Structure of a Node  
	static class Node  
	{  
	    int data;  
	     Node  next;  
	} 
	    
	static class Queue  
	{  
	     Node  front,  rear;  
	} 
	    
	// Function to create Circular queue  
	static void circularQueue(Queue  q, int data)  
	{  
	     Node  temp = new Node();  
	    temp .data = data; 
	    //empty queue
	    if (q.front ==  null) {  
	        q.front = temp;  
	    }
	    else //not empty - insert only into the rear
	    {
	        q.rear.next = temp;  
	    }
	    //new rear
	    q.rear = temp;  
	    q.rear.next = q.front;  
	}  
	    
	// Function to delete element from Circular Queue  
	static void deQueue(Queue  q)  
	{  
	    if (q.front ==  null)  
	    {  
	        System.out.println("\nCircular queue   is empty");
	    	 throw new RuntimeException("\nCircular queue   is empty");
	    }  
	    
	    // If this is the last node to be deleted  

	    //the only one element in queue
	    if (q.front == q.rear)  
	    {  
	    	  System.out.print("\nCircular queue to delete the only element in the queue: " + q.front.data); 
	       
	        q.front =  null;  
	        q.rear =  null;  
	    }  
	    else  // There are more than one nodes  
	    {  
	    	System.out.print("\nCircular queue to delete first element in the queue: " + q.front.data); 
 
	       //remove old q.front; old q.front.next become new q.front
	        q.front = q.front.next;  
	        q.rear.next= q.front;  
	    }  
	    
	   
	}  
	    
	// Function displaying the elements of Circular Queue  
	static void displayQueue( Queue  q)  
	{  
	    if (q.front == null)
	    {
	    	System.out.printf("\nCurrently Circular Queue is empty: ");
	    }
	    else {
	    	
	    
		Node  currNode = q.front;  
	     
	    System.out.printf("\nCurrently in Circular Queue: "); 
	    
	    while (currNode.next != q.front)  
	    {  
	        System.out.printf("%d ", currNode.data);  
	        currNode = currNode.next;  
	    }  
	    System.out.printf("%d", currNode.data);  
	    }
	}  
	    
	/*  Driver of the program  */
	public static void main(String args[]) 
	{  
	    // Create a queue and initialize front and rear  
	    Queue  q = new Queue();  
	    q .front = q .rear =  null;  
	    
	    // Inserting elements in Circular Queue  
	    circularQueue(q, 14);  
	    circularQueue(q, 22);  
	    circularQueue(q, 6);  
	    
	    // Display elements present in Circular Queue  
	    displayQueue(q);  
	    
	    // Deleting elements from Circular Queue  
	    deQueue(q);
	    displayQueue(q);
	    deQueue(q);
	    displayQueue(q);
	    deQueue(q);
	    displayQueue(q);
	    circularQueue(q, 122);  
	    displayQueue(q);
	    deQueue(q);
	    ///when empty - exception expected
	     deQueue(q);
	     
	     

	    
	}  
} 


