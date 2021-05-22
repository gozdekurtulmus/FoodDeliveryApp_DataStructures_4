	package FoodDeliveryApp;
	/* This class creates Stack with array and manages it. */

	public class ArrayStack<T> implements StackInterface<T>{
		private T[] stack;  //Array of stack entries
		private int topIndex; //Index of top entry
		private static final int DEFAULT_CAPACITY = 50;
		
		public ArrayStack() {
			@SuppressWarnings("unchecked")
			T[] tempStack = (T[]) new Object[DEFAULT_CAPACITY];
			stack = tempStack;
			topIndex = -1;
		}
			
		public void push(T newEntry) {
			ensureCapacity(); //Check if array is full.If it is full, double its size.
			this.topIndex++;
			stack[topIndex] = newEntry;	//Add given entry to stack
		}

		public T pop() {		
			if ( isEmpty()) {//If the stack is empty return nothing
				return null; 
			}
			else {
				T top = stack[topIndex];//Take the top entry
				stack[topIndex] = null;// take the entry out of the array
				this.topIndex--; 
				return top;	//Return the taken top entry
			}		
		}
		
		public T peek() { //Look at the top of the stack
			if(isEmpty()) {
				return null;
			}
			else {
				return stack[topIndex];
			}
		}
		
		public boolean isEmpty() {
			return topIndex==-1; //return true if the stack is empty
		}
		
		public void clear() {
			while(!isEmpty()) { //Take all the entries out until the stack is empty.
				stack[topIndex] = null;
				topIndex--;
			}	
		}
		
		public void ensureCapacity() { 
			
			if(topIndex == stack.length-1)//If array is full,double its size
			{
				int newLength = 2*stack.length;		
				@SuppressWarnings("unchecked")
				T[] tempArr = (T[]) new Object[newLength];
	            for (int i=0; i < stack.length; i++){ //copy the array to the newly created array.
	                tempArr[i]= stack[i];
	            }
	            stack = tempArr;
			}	
		}
		public int getLength(){ // See how many entries stack has.
			return topIndex+1;
		}

		
	}

