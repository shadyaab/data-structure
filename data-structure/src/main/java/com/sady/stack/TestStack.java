package com.sady.stack;

import java.util.EmptyStackException;

class BasicStack<T>{
	
	private T [] stackArray;
	private int top;
	
	public BasicStack() {
		this(100);
	}
	
	public BasicStack(int size) {
		stackArray = (T[]) new Object[size];
	}
	
	public void push(T item){
		if(top == stackArray.length){
			//copy to new array doubling the size
		}
		stackArray[top++] = item;
	}
	
	public T pop(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return stackArray[--top];
	}
	
	public boolean contains(T item){
		for(int i = 0; i < top; i++){
			if(stackArray[i].equals(item)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmpty(){
		if(top == 0){
			return true;
		}
		return false;
	}
	
	public T peek(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return stackArray[top-1];
	}
	
	public int size(){
		return top;
	}
}


public class TestStack {
	
	public static void main(String[] args) {
		BasicStack<String> stacklist = new BasicStack<String>();
		stacklist.push("hello");
		stacklist.push("hello2");
		
		System.out.println(stacklist.peek());
	}
	
	
	
	
	
}
