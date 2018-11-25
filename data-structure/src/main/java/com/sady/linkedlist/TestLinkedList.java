package com.sady.linkedlist;

import java.util.NoSuchElementException;

import org.springframework.beans.propertyeditors.CurrencyEditor;

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
		nodeCount++;
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

	public int size(){
		return nodeCount;
	}
	
	public void insert(int index, T item) {
		if(index > nodeCount){
			throw new IndexOutOfBoundsException("LinkedList is smaller than the given index");
		}
		Node currentNode = first;
		
		for (int i = 1; i < index; i++) {
			currentNode = currentNode.nextNode;
		}
		
		Node node = new Node(item);
		Node nextNode = currentNode.nextNode;
		currentNode.nextNode = node;
		node.nextNode = nextNode;
		nodeCount++;
	}
	
	public T remove(int index){
		if(first == null){
			throw new IllegalStateException("LinkedList is empty");
		}
		
		if(index > nodeCount){
			throw new IndexOutOfBoundsException("LinkedList is smaller than the given index");
		}
		
		Node currentNode = first;
		Node prevNode = first;
		for (int i = 1; i < index; i++) {
			prevNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		
		T nodeItem = currentNode.nodeItem;
		prevNode.nextNode = currentNode.nextNode;
		nodeCount--;
		
		return nodeItem;
	}
	
	public T get(int index){
		if(index > nodeCount){
			throw new IndexOutOfBoundsException("LinkedList is smaller than the given index");
		}
		
		Node currentNode = first;
		for (int i = 1; i < index; i++) {
			currentNode = currentNode.nextNode;
		}
		
		return currentNode.nodeItem;	
	}
	
}


public class TestLinkedList {
	
	public static void main(String[] args) {
		
	}

}
