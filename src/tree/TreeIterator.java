package tree;

import list.Iterator;
import queue.*;

public class TreeIterator<E> implements Iterator<E> {
	E lastGotten;
	BinaryTree<E> tree;
	QueueADT<E> queue=new Queue<E>();
	
	TreeIterator(BinaryTree<E> tree){
		this.tree=tree;
		buildQ(tree);
	}
	
	private void buildQ(BinaryTree<E> tree){
		if(tree.isEmpty()) return;
		buildQ(tree.getLeft());
		queue.add(tree.getValue());
		buildQ(tree.getRight());
	}

	public boolean hasNext() {
		return !(queue.size()==0);
	}

	public E next() {
		lastGotten=queue.peek();
		return queue.remove();
	}

	public void remove() {
		tree=tree.remove(lastGotten);
	}
	
	
}
