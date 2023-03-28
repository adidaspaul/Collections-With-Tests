import java.util.Arrays;

public class TheQ {

	private int initialSize;
	private int size = 0;
	Object[] theQStorage;

	public TheQ(int initialSize) {
		this.initialSize = initialSize;
		this.theQStorage = new Object[initialSize];
	}

	public boolean add(Object o) {
		if (size == initialSize) {
			System.out.println("The Q is full");
			return false;
		}
		theQStorage[size] = o;
		size++;
		return true;
	}

	public Object remove(int index) {
		Object removedObject = null;
		Object[] tempStorage = new Object[initialSize];
		for(int i = 0; i < theQStorage.length; i++) {
			if(i < index) {
			tempStorage[i] = theQStorage[i];
		}
			else if(i > index) {
				tempStorage[i - 1] = theQStorage[i];
			}
			else {
				removedObject = theQStorage[i];
			}
		}
	
	theQStorage=Arrays.copyOf(tempStorage,initialSize);
	size--;
	return removedObject;
	}
	
	public void clear() {
		Arrays.fill(theQStorage, null);
		size = 0;
	}

	public int size() {
		return size;
	}

	public Object peek() {
		Object result = null;
		if (size == 0) {
			return result;
		} else {
			result = theQStorage[0];
		}
		return result;

	}

	public Object poll() {
		Object result = null;
		if (size == 0) {
			return result;
		} else {
			result = theQStorage[0];
			Object[] temp = new Object[initialSize];
			for (int i = 0; i < size; i++) {
				temp[i - 1] = theQStorage[i];
			}
			theQStorage = Arrays.copyOf(temp, initialSize);
			size--;
		}
		return result;
	}
}
