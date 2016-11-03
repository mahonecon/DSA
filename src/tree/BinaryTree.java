package tree;

public interface BinaryTree<E> {

	E getValue();

	BinaryTree<E> getLeft();

	BinaryTree<E> getRight();

	BinaryTree<E> add(E value);

	E get(E value);

	boolean containsKey(E value);

	BinaryTree<E> remove(Object obj);

	/** @return true if this BinaryTree is empty */
	boolean isEmpty();

	/**  Change the value of this BinaryTree to the given value */
	void setValue (E value);

	/** Change the left child of this BinaryTree to the given BinaryTree */
	void setLeft (BinaryTree <E> left);

	/** Change the right child of this BinaryTree to the given BinaryTree */
	void setRight (BinaryTree <E> right);

	/** @return true only if this BinaryTree is equal to the given obj */
	boolean equals (Object obj);


	/** @return the height of this Binary Tree */
	public int getHeight();
	
	/** @return the number of BinarySearchTrees in the family of this BinaryTree */
	int size();
}