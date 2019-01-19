package com.sady.avl;

class Node<T extends Comparable<T>> {

	private T data;
	private Node<T> leftNode;
	private Node<T> rightNode;
	private int height;

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node<T> leftNode) {
		this.leftNode = leftNode;
	}

	public Node<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node<T> rightNode) {
		this.rightNode = rightNode;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}

interface Tree<T extends Comparable<T>> {
	
	public void insert(T data);

	public void traversal();

	public T remove(T data);
}

class AvlTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T data) {
		root = insert(root, data);
	}
	
	private Node<T> insert(Node<T> node, T data) {
		if(node == null) {
			return new Node<>(data);
		}
		
		if(data.compareTo(node.getData()) < 0) {
			node.setLeftNode(insert(node.getLeftNode(), data));
		} else if(data.compareTo(node.getData()) > 0) {
			node.setRightNode(insert(node.getRightNode(), data));
		} 
		
		node.setHeight(Math.max(node.getLeftNode().getHeight(), node.getRightNode().getHeight()) + 1);
		
		node = settleViolation(data, node);
		
		return node;
	}


	private Node<T> settleViolation(T data, Node<T> node) {
		
		int balance = getBalance(node);
		
		if(balance > 1 && data.compareTo(node.getLeftNode().getData()) < 0) {
			rightRotation(node);
		}
		if(balance < -1 && data.compareTo(node.getLeftNode().getData()) > 0) {
			leftRotation(node);
		}
		
		if(balance > 1 && data.compareTo(node.getLeftNode().getData()) > 0) {
			node.setLeftNode(leftRotation(node.getLeftNode()));
			rightRotation(node);
		}
		if(balance < -1 && data.compareTo(node.getLeftNode().getData()) < 0) {
			node.setRightNode(rightRotation(node.getRightNode()));
			leftRotation(node);
		}
		return node;
	}

	private Node<T> rightRotation(Node<T> node) {

		System.out.println("Rotating to right...");

		Node<T> tempNode = node.getLeftNode();
		Node<T> t = tempNode.getRightNode();

		tempNode.setRightNode(node);
		node.setLeftNode(t);

		node.setHeight(Math.max(node.getLeftNode().getHeight(), node.getRightNode().getHeight()) + 1);
		tempNode.setHeight(Math.max(node.getLeftNode().getHeight(), node.getRightNode().getHeight()) + 1);

		return tempNode;
	}

	private Node<T> leftRotation(Node<T> node) {

		System.out.println("Rotating to left...");
		
		Node<T> tempNode = node.getRightNode();
		Node<T> t = tempNode.getLeftNode();
		
		tempNode.setLeftNode(node);
		node.setRightNode(t);
		
		node.setHeight(Math.max(node.getLeftNode().getHeight(), node.getRightNode().getHeight()) + 1);
		tempNode.setHeight(Math.max(node.getLeftNode().getHeight(), node.getRightNode().getHeight()) + 1);
		
		return tempNode;

	}

	private int height(Node<T> node) {
		if (node == null) {
			return -1;
		}
		return node.getHeight();
	}

	private int getBalance(Node<T> node) {
		if (node == null) {
			return 0;
		}
		return height(node.getLeftNode()) - height(node.getRightNode());
	}

	@Override
	public void traversal() {
		if (root == null) {
			return;
		}
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node<T> node) {

		if (node.getLeftNode() != null) {
			inOrderTraversal(node.getLeftNode());
		}
		System.out.println(node.getData());

		if (node.getRightNode() != null) {
			inOrderTraversal(node.getRightNode());
		}
	}

	@Override
	public T remove(T data) {
		// TODO Auto-generated method stub
		return null;
	}
}

public class TestAvlTree {

}
