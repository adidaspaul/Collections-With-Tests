
import java.util.Objects;

import com.sun.org.apache.bcel.internal.classfile.Node;

public class TheHashMap {

	private final Node[][] table = new Node[16][8];
	
	static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	private class Node{
		private int hash;
		private Object key;
		private Object value;
		private Node next;
		
		public Node(int hash, Object key, Object value, Node next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public int getHash() {
			return hash;
		}
		
		public void setHash (int hash) {
			this.hash = hash;
		}
		
		public Object getKey() {
			return key;
		}
		
		public void setKey(Object key) {
			this.key = key;
		}
		
		public Object getValue() {
			return value;
		}
		
		public void setValue(Object value) {
			this.value = value;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	public void put(Object key, Object value) throws NullPointerException {
		if(key.equals(null) || value.equals(null)) {
			throw new NullPointerException();
		}
		int hash = hash(key);
		int bucketNumber = (DEFAULT_INITIAL_CAPACITY - 1)  &  hash;
		for(int i = 0; i < table.length; i++) {
			Node[] bucket = table[i];
			if(i == bucketNumber) {
				if(bucket[0] == null) {
					Node newNode = new Node(hash, key, value, null);
					bucket[0] = newNode;
				} else {
					for(int j = 0; j < bucket.length; j++) {
						if(bucket[j] != null) {
							Node existingNode = bucket[j];
							Object keyPrevious = existingNode.getKey();
							int hashPrevious = existingNode.hash;
							if(keyPrevious.equals(key) && hashPrevious == hash) {
								existingNode.setValue(value);
							} else {
								if(bucket[j] == null && bucket[j - 1] != null) {
									Node newNode = new Node(hash, key, value, null);
									bucket[j] = newNode;
									bucket[j - 1].setNext(newNode);
									break;
								}
							}
						}
					}
				}
			}
		}
	}
	static int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
	
	public void remove (Object key) {
		int hash = hash(key);
		int bucketNumber = (DEFAULT_INITIAL_CAPACITY - 1) & hash;
		Node[] bucket = table[bucketNumber];
		for (int i = 0; i < bucket.length; i++) {
			Node node = bucket[i];
			if(node != null) {
				int hashTemp = node.getHash();
				if(hash == hashTemp) {
					bucket[i] = null;
					if(i != 0) {
						bucket[i - 1].setNext(bucket[i + 1]);
					}
				}
			}
		}
	}
	
	public void clear() {
		for(int i = 0; i < table.length; i++) {
			Node[] bucket = table[i];
			for(int j = 0; j < bucket.length; j++) {
				bucket[j] = null;
			}
		}
	}
	
	public int size() {
		int count = 0;
		for(int i = 0; i < table.length; i++) {
			Node[] bucket = table[i];
			for(int j = 0; j < bucket.length; j++) {
				Node node = bucket[j];
				if(node != null) {
					count++;
				}
			}
		}
		return count;
	}
	
	public Object get(Object key) {
		Object returnObject = null;
		int hash = hash(key);
		int bucketNumber = (DEFAULT_INITIAL_CAPACITY - 1) & hash;
		Node[] bucket = table[bucketNumber];
		for(int i = 0; i < bucket.length; i++) {
			Node node = bucket[i];
			if(node != null) {
				if(node.getKey() == null && key == null) {
					returnObject = node.getValue();
				} else if(node.getKey().equals(key) && node.getHash() == hash) {
					returnObject = node.getValue();
				}
			}
		}
		return returnObject;
	}
	
	
	
}
