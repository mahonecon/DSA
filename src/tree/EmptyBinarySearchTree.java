package tree;

import list.Iterator;

public class EmptyBinarySearchTree<E extends Comparable> implements BinaryTree<E> {

	public E getValue() {
		
		return null;
	}

	public BinaryTree<E> getLeft() {
		
		return null;
	}

	public BinaryTree<E> getRight() {

		return null;
	}

	public BinaryTree<E> add(E value) {

		return new BinarySearchTree<E>(value);
	}

	public E get(E value) {
		return null;
	}

	public boolean containsKey(E value) {

		return false;
	}

	public BinaryTree<E> remove(Object obj) {

		return this;
	}

	public boolean isEmpty() {
		return true;
	}

	public void setValue(E value) {
	}

	public void setLeft(BinaryTree<E> left) {		
	}

	public void setRight(BinaryTree<E> right) {
	}

	public int getHeight() {
		return 0;
	}

	public int size() {
		return 0;
	}

	public Iterator<E> iterator() {
		return new EmptyIterator<E>();
	}
	
	public String toString() {
		return "[]";
	}
	
}
