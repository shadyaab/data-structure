package com.sady.stack;

class BasicStack<T>{
	
	private T [] stackArray;
	private int stackPointer;
	
	public BasicStack() {
		stackArray = (T[]) new Object[50];
		stackPointer = 0; 
	}
	
	public void push(T item){
		stackArray[stackPointer++] = item;
	}
	
	public T pop(){
		if(stackPointer == 0){
			throw new IllegalStateException("No item found");
		}
		return stackArray[--stackPointer];
	}
	
	public boolean contains(T item){
		for(int i = 0; i < stackPointer; i++){
			if(stackArray[i].equals(item)){
				return true;
			}
		}
		return false;
	}
	
	public T access(T item){
		for(int i = 0; i < stackPointer; i++){
			if(stackArray[i].equals(item)){
				return stackArray[i];
			}
		}
		
		throw new IllegalStateException("No item found");
	}
	
	public int size(){
		return stackPointer;
	}
}


public class TestStack {
	
	public static void main(String[] args) {
		BasicStack<String> stacklist = new BasicStack<String>();
		stacklist.push("hello");
		
		String s = stacklist.pop();
	}
	
	
	
	
	
}
