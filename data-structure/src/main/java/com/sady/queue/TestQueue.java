package com.sady.queue;

import java.util.NoSuchElementException;

class BasicQueue<T>{
	
	private T[] queueArray;
	private int front;
	private int end;
	
	public BasicQueue() {
		this(10);
	}
	
	BasicQueue(int size){
		queueArray = (T[]) new Object[size];
	}
	
	public void add(T item){
		if(!isFull()){
			//create new array with double size and copy
		}
		queueArray[end++] = item;
	}
	
	public T peek(){
		if(isEmpty()){
			return null;
		}
		return queueArray[front];
	}
	
	public T element(){
		if(isEmpty()){
			throw new NoSuchElementException("Queue is empty");
		}
		return queueArray[front];
	}
	
	public T remove(){
		if(isEmpty()){
			throw new NoSuchElementException("Queue is empty");
		}
		T val =  queueArray[front++];
		
		//***Condition to empty the Queue
		if(front == end){
			front = 0;
			end = 0;
		}
		return val;
	}
	
	
	public boolean isEmpty(){
		if(front >= end){
			return true;
		}
		return false;
	}
	
	public boolean isFull(){
		if(end == queueArray.length){
			return true;
		}
		return false;
	}
	
	public int size(){
		return end - front;
	}
}


public class TestQueue {

}
