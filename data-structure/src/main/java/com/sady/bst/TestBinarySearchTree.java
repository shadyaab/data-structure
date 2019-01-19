package com.sady.bst;

class Node<T extends Comparable<T>> {

	private T data;
	private Node<T> leftNode;
	private Node<T> rightNode;

	public Node(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return this.data.toString();
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

}

interface Tree<T extends Comparable<T>> {

	public void traversal();

	public void insert(T data);

	public void delete(T data);

	public T getMax();

	public T getMin();

	public Node<T> getRootNode();

	public boolean compareBinaryTree(Node<T> node1, Node<T> node2);

	public Node<T> getKSmallestItem(Node<T> node, int k);

}

class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T data) {

		if (root == null) {
			this.root = new Node<>(data);
		} else {
			insertNode(data, root);
		}

	}

	private void insertNode(T data, Node<T> node) {

		if (data.compareTo(node.getData()) < 0) {
			if (node.getLeftNode() == null) {
				Node<T> tempNode = new Node<>(data);
				node.setLeftNode(tempNode);
			} else {
				insertNode(data, node.getLeftNode());
			}
		} else {
			if (node.getRightNode() == null) {
				Node<T> tempNode = new Node<>(data);
				node.setRightNode(tempNode);
			} else {
				insertNode(data, node.getRightNode());
			}
		}

	}

	@Override
	public void traversal() {
		if (root == null) {
			throw new RuntimeException("Tree is empty");
		}

		inOrderTraversal(root);
		System.out.println();

		preOrderTraversal(root);
		System.out.println();

		postOrderTraversal(root);

	}

	// Left + root + right
	private void inOrderTraversal(Node<T> node) {

		if (node.getLeftNode() != null) {
			inOrderTraversal(node.getLeftNode());
		}

		System.out.print(node.getData() + " --> ");

		if (node.getRightNode() != null) {
			inOrderTraversal(node.getRightNode());
		}
	}

	// Root + left + right
	private void preOrderTraversal(Node<T> node) {

		System.out.print(node.getData() + " --> ");

		if (node.getLeftNode() != null) {
			preOrderTraversal(node.getLeftNode());
		}

		if (node.getRightNode() != null) {
			preOrderTraversal(node.getRightNode());
		}

	}

	// Left + right + root
	private void postOrderTraversal(Node<T> node) {

		if (node.getLeftNode() != null) {
			postOrderTraversal(node.getLeftNode());
		}

		if (node.getRightNode() != null) {
			postOrderTraversal(node.getRightNode());
		}

		System.out.print(node.getData() + " --> ");

	}

	@Override
	public void delete(T data) {
		if (root == null) {
			throw new RuntimeException("Tree is empty");
		}

		delete(data, root);

	}

	private Node<T> delete(T data, Node<T> node) {

		if (node == null) {
			return node;
		}

		if (data.compareTo(node.getData()) < 0) {
			node.setLeftNode(delete(data, node.getLeftNode()));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRightNode(delete(data, node.getRightNode()));
		} else {

			// Removing leaf node
			if (node.getLeftNode() == null && node.getRightNode() == null) {
				System.out.println("Removing leaf node");
				return null;
			}

			// Removing single child node
			if (node.getRightNode() == null) {
				System.out.println("Removing left child node ");
				Node<T> tempNode = node.getLeftNode();
				node = null;
				return tempNode;
			} else if (node.getLeftNode() == null) {
				System.out.println("Removing right child node");
				Node<T> tempNode = node.getRightNode();
				node = null;
				return tempNode;
			}

			// Removing double child node
			System.out.println("Removing two child node");
			Node<T> predecessor = getPredecessor(node.getLeftNode());

			node.setData(predecessor.getData());
			node.setLeftNode(delete(predecessor.getData(), node.getLeftNode()));

		}
		return node;

	}

	private Node<T> getPredecessor(Node<T> node) {
		if (node.getRightNode() != null) {
			getPredecessor(node.getRightNode());
		}
		System.out.println("Predecessor: " + node.getData());
		return node;
	}

	@Override
	public T getMax() {
		if (root == null) {
			throw new RuntimeException("Tree is empty");
		} else {
			return getMax(root);
		}

	}

	private T getMax(Node<T> node) {
		if (node.getRightNode() != null) {
			return getMax(node.getRightNode());
		}
		return node.getData();
	}

	@Override
	public T getMin() {
		if (root == null) {
			throw new RuntimeException("Tree is empty");
		} else {
			return getMin(root);
		}
	}

	private T getMin(Node<T> node) {
		if (node.getLeftNode() != null) {
			return getMin(node.getLeftNode());
		}
		return node.getData();
	}

	@Override
	public Node<T> getRootNode() {
		return this.root;
	}

	@Override
	public boolean compareBinaryTree(Node<T> node1, Node<T> node2) {

		if (node1 == null || node2 == null) {
			return node1 == node2;
		}

		// If the value of node is not same, return false
		if (node1.getData().compareTo(node2.getData()) != 0) {
			return false;
		}

		return compareBinaryTree(node1.getLeftNode(), node2.getLeftNode())
				&& compareBinaryTree(node1.getRightNode(), node2.getRightNode());

	}

	@Override
	public Node<T> getKSmallestItem(Node<T> node, int k) {

		int n = treeSize(node.getLeftNode()) + 1;

		if (n == k) {
			return node;
		}

		if (n > k) {
			return getKSmallestItem(node.getLeftNode(), k);
		}

		if (n < k) {
			return getKSmallestItem(node.getRightNode(), k - n);
		}

		return null;
	}

	private int treeSize(Node<T> node) {

		if (node == null) {
			return 0;
		}
		return treeSize(node.getLeftNode()) + treeSize(node.getRightNode()) + 1;
	}

}

public class TestBinarySearchTree {

	public static void main(String[] args) {

		Tree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(20);
		tree.insert(4);
		tree.insert(1);
		tree.insert(5);
		tree.insert(25);

		System.out.println("Max : " + tree.getMax());
		System.out.println("Min : " + tree.getMin());

		tree.traversal();
	}

}
