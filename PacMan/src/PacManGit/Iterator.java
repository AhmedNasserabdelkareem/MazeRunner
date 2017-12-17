package PacManGit;

import Objects.Interactables;

public class Iterator {
	private Node root = new Node();
	private Node last = new Node();
	private Node currentNode;
	
	public Iterator() {
		root.setNext(last);
		root.setPrev(null);
		last.setPrev(root);
		last.setNext(null);
		currentNode = root;
	}
	public void add(Interactables value) {
		Node newNode = new Node();
		
		newNode.setValue(value);
		
		Node tempPrev = last.getPrev();
		
		newNode.setNext(last);
		tempPrev.setNext(newNode);
		
		newNode.setPrev(tempPrev);
		last.setPrev(newNode);
	}
	public boolean hasNext() {
		
		return !last.equals(currentNode.next);
		
	}
	public Interactables next() {
		currentNode = currentNode.next;
		return currentNode.getValue();
	}
	
	public boolean remove(Interactables o) {
		Node temp = root.next;
		while(temp.hasNext()) {
			if(temp.getValue().equals(o)) {
				Node prevTemp = temp.getPrev();
				Node nextTemp = temp.getNext();
				prevTemp.setNext(nextTemp);
				nextTemp.setPrev(prevTemp);
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	public Iterator newInstance() {
		currentNode = null;
		root = new Node();
		root.setNext(last);
		root.setPrev(null);
		last.setPrev(root);
		last.setNext(null);
		return this;
	}
	
	public Iterator getInstance() {
		currentNode = root;
		return this;
	}
	class Node {
		private Interactables value;
		private Node next;
		private Node prev;
		public boolean hasNext() {
			return next != null;
		}
		public void setPrev(Node x) {
			prev = x;
		}
		
		public void setNext(Node x) {
			next = x;
		}
		
		public void setValue(Interactables x) {
			value = x;
		}
		public Node getPrev() {
			return prev;
		}
		public Node getNext() {
			return next;
		}
		
		public Interactables getValue() {
			return value;
		}
		
	}
}


