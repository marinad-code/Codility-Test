package mytests;
import mytests.Test7_ArraylLst;
public class Test10_MyStack {
	public static class Stack
	{
		private Test7_ArraylLst my_Stack ;
		

		// Constructor to initialize stack - by default -size 3 
		Stack()
		{
			my_Stack = new Test7_ArraylLst();
			
		}
		// Constructor to initialize stack
				Stack(int size)
				{
					my_Stack = new Test7_ArraylLst(size);
					
				}
		// Utility function to add an element x in the stack
		public void push(Object obj)
		{
		     my_Stack.addElement(obj);	
		
			System.out.println("Inserting new object"  );
			//my_Stack.getMyarrayList()[++stack_top] = obj;
		}

		// Utility function to pop top element from the stack
		public Object pop()
		{
			
			Object obj = null;
			// check for stack underflow
			if (my_Stack.getStoredElements()==0)
			{
				System.out.println("My Stack is empty ");
				System.exit(1);
			}
			else {
				int last_added = my_Stack.getStoredElements();
				obj = my_Stack.getElementbyIndex((last_added - 1));
				System.out.println("Removing " + obj);
				my_Stack.removeElement(obj);
			}
			
            
			// decrease stack size by 1 and (optionally) return the popped element
			return obj;
		}

		// Utility function to return top element in a stack
		public Object peek()
		{
			
			Object obj = null;
			if (my_Stack.getStoredElements()!=0)
			{
				int last_added = my_Stack.getStoredElements();
			
			obj = my_Stack.getElementbyIndex((last_added - 1));
			}
				
			else {
				System.out.println("No  elements - stack is empty");
			}
			return obj;
		}
		
		public void print_stack()
		{
			
		
			if (my_Stack.getStoredElements()!=0)
			{  
				
				System.out.println("Currently in Stack -  from the top to the bottom: ");
				for(int i=my_Stack.getStoredElements()-1; i>=0;i--) {
					System.out.println(my_Stack.getElementbyIndex(i).toString());
				}
			
			}
				
}
	
	public static void main(String[] args) {
		
		Stack my_st = new Stack() ;
		
		for(int i = 0; i<10;i++){
		my_st.push((Integer)i);
		}
		my_st.print_stack();
		my_st.pop();
		my_st.print_stack();
		System.out.println("Using peek   " + my_st.peek().toString());
	}
    
}
}

