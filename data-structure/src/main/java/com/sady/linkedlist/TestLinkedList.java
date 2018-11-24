package com.sady.linkedlist;

import java.util.NoSuchElementException;

class BasicLinkedList<T>{
	
	private Node first;
	private Node last;
	private int nodeCount;
	
	private class Node{
		private T nodeItem; 
		private Node nextNode;
		
		public Node(T item){
			this.nodeItem = item;
			this.nextNode = null;
		}
	}
	
	public BasicLinkedList() {
		this.first = null;
	}
	
	public void add(T item){
		if(first == null){
			first = new Node(item);
			last = first;
		} else {
			Node node = new Node(item);
			last.nextNode = node;
			last = node;
		}
	}
	
	public T remove(){
		if(isEmpty()){
			throw new NoSuchElementException("Linked list is empty");
		}
		T val = first.nodeItem;
		first = first.nextNode;

		return val;
	}
	
	public boolean isEmpty(){
		if(first == null){
			return true;
		}
		return false;
	}
	
	
	//add
	//remove
	//insert
	//removeAt
	//get
	//find
	
	
	
	
	
	
}


public class TestLinkedList {

}
