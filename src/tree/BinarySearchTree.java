package tree;

import java.util.*;

import list.Iterator;

public class BinarySearchTree<E extends Comparable> implements BinaryTree<E> {

	E value;
	BinaryTree<E> left = new EmptyBinarySearchTree<E>();
	BinaryTree<E> right = new EmptyBinarySearchTree<E>();
	
	public BinarySearchTree(E value){
		this.value=value;
	}
	
	public E getValue() {
		return value;
	}

	public BinaryTree<E> getLeft() {
		return left;
	}

	public BinaryTree<E> getRight() {
		return right;
	}

	public BinaryTree<E> add(E value) {
		int cmp=value.compareTo(this.value);
		if(cmp<0)
			left=left.add(value);
		else if(cmp>0)
			right=right.add(value);
		return this;
	}

	public E get(E value) {
		int cmp=value.compareTo(this.value);
		if(cmp<0)
			return left.get(value);
		else if(cmp>0)
			return right.get(value);
		return this.value;
	}

	/*if(cmp<0)
	return left.containsKey(value);
	else if(cmp>0)
	return right.containsKey(value);*/
	//Well Balanced: O(log(n))  Poorly Balanced: O(n)
	public boolean containsKey(E value) {
		BinaryTree<E> test=this;
		while(!(test.isEmpty())){
			E temp=test.getValue();
			int cmp=value.compareTo(temp);
			if(cmp==0){
				return true;
			}
			if(cmp<0){
				test=test.getLeft();
			}
			if(cmp>0){
				test=test.getRight();
			}
		}
		return false;
	}

	public BinaryTree<E> remove(Object obj) {
		try{
			E value=(E)obj;
			int cmp=value.compareTo(this.value);
			if(cmp==0){
				List<BinaryTree<E>>kids=children();
				if(kids.size()==0)
					return new EmptyBinarySearchTree<E>();
				if(kids.size()==1)
					return kids.get(0);
				BinaryTree<E>successor=((BinarySearchTree)right).smallest();
				BinaryTree<E> result=remove(successor.getValue());
				result.setValue(successor.getValue());
				return result;
			}
			if(cmp<0)
				left=left.remove(value);
			else if(cmp>0)
				right=right.remove(value);
		}
		catch(ClassCastException cce){}
		return this;
	}
	
	private List<BinaryTree<E>> children(){
		List<BinaryTree<E>> result=new ArrayList<BinaryTree<E>>();
		if(!(left).isEmpty()) result.add(left);
		if(!(right).isEmpty()) result.add(right);
		return result;
	}
	
	private BinaryTree<E> smallest(){
		if(left.isEmpty()) return this;
		return ((BinarySearchTree<E>)left).smallest();
	}

	//Poorly balanced: O(1)
	public boolean isEmpty() {
		return false;
	}

	public void setValue(E value) {		
		this.value=value;
	}

	public void setLeft(BinaryTree<E> left) {
		this.left=left;
		
	}

	public void setRight(BinaryTree<E> right) {
		this.right=right;
	}
	
	public boolean equals(Object obj){
		if(obj.equals(null)||this.isEmpty()&&!obj.equals(null)&&this.isEmpty())
			return false;
		
		else if(((Comparable) obj).compareTo(value)!=0)
			return false;
		
		else{
			while(!(left.isEmpty())){
				int cmp=left.getValue().compareTo(obj);
				if(cmp!=0){
					return false;
				}
			}
			
			while(!(right.isEmpty())){
				int cmp1=right.getValue().compareTo(obj);
				if(cmp1!=0){
					return false;
				}
			}
		}
		return true;
	}

	public int getHeight()
	{
		return 1;
	}

	public int size() {
		return left.size()+right.size()+1;
	}
	
	public Iterator<E> iterator() {
		return new TreeIterator<E>(this);
	}
	
	public String toString() {
		Iterator it = iterator();
		String s = "[";
		while(it.hasNext()) {
			s += it.next();
			if(it.hasNext()) {
				s += ", ";
			}
		}
		return s += "]";
	}

}