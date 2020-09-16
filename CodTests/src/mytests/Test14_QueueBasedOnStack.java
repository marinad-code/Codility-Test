package mytests;

import java.util.Stack;

public class Test14_QueueBasedOnStack {
	static class my_queue{
	Stack<Integer> st;
		
	 my_queue(){
		st =new Stack<Integer>();
		}
		public Stack<Integer> push_into_queue(Stack<Integer> st, Integer data){
			
			st.push(data);
		return st;	
		}
		
      public void push_into_queue1( Integer data){
			
			st.push(data);
			
		}
		//FIFO
       public void pull_from_queue(){
			if(st.isEmpty()) {
				System.out.println("Queue is empty");
		    	 throw new RuntimeException("Queue is empty");
			}
			
			Integer first_element_in_stack =st.firstElement();
			System.out.print("Queue to delete first element from the queue: " + st.lastElement()); 
			int index_of_first_element = st.indexOf(first_element_in_stack);
		    st.remove(index_of_first_element);
			
		}
       public void display_queue(Stack<Integer> st){
			if(st.isEmpty()) {
				System.out.println("Queue is empty");
		    	 
			}
			
			Integer last_element_in_stack =st.lastElement();
			
			int index_of_last_element = st.lastIndexOf(last_element_in_stack);
		    for(int i=0;i<index_of_last_element; i++)
		    {
		    	//System.out.printf("%d" + st.get(i));
		    	System.out.println(st.get(i));
		    }
		
		
		}
       public void display_queue1(){
			if(st.isEmpty()) {
				System.out.println("Queue is empty");
		    	 
			}
			System.out.println("Currently in the Queue :");
			Integer last_element_in_stack =st.lastElement();
			
			int index_of_last_element = st.lastIndexOf(last_element_in_stack);
		    for(int i=0;i<=index_of_last_element; i++)
		    {
		    	//System.out.printf("%d" + st.get(i));
		    	System.out.println(st.get(i));
		    }
		
		
		}
     
	}
	public static void main(String[] args) {
		my_queue q= new my_queue();
        for(int i=0; i<=10;i++) 
        {
		q.push_into_queue1(i);
		
	}
        q.push_into_queue1(0);
        q.display_queue1();
        q.pull_from_queue();
        q.display_queue1();
        

}
}