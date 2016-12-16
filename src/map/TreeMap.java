package map;
import tree.*;

public class TreeMap<K extends Comparable, V> implements Map<K,V>{

	BinaryTree<Entry<K,V>> tree = new EmptyBinarySearchTree<Entry<K,V>>();
	int size = 0;
	
	public boolean containsKey(K key){
		Entry<K,V> entry = new Entry<K,V>(key,null);
		return tree.containsKey(entry);
	}
	
	public V get(K key){
		Entry<K,V> entry = new Entry<K,V>(key,null);
		entry = tree.get(entry);
		if(entry == null)return null;
		return entry.value;
	}

	public V put(K key, V value){
		Entry<K,V> newEntry = new Entry<K,V>(key,value);
		Entry<K,V> oldEntry = tree.get(newEntry);
		if(oldEntry == null){
			tree=tree.add(newEntry);
			size++;
			return null;
		}
		V oldValue = oldEntry.value;
		oldEntry.value = value;
		return oldValue;
	}
	
	public V remove(K key){
		Entry<K,V> entry = new Entry<K,V>(key,null);
		entry = tree.get(entry);
		if(entry == null)
			return null;	
		tree=tree.remove(entry);
		size--;
		return entry.value;
	}

	public int size() {
		return size;
	}

	public void clear() {
		tree = new EmptyBinarySearchTree<Entry<K,V>>();
	}

	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public boolean hasDuplicateValues() {
		// TODO Auto-generated method stub
		return false;
	}
}