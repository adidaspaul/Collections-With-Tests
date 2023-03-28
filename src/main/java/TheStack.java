import java.util.Arrays;

public class TheStack {

	private int initialSize;
	private int size = 0;

	public TheStack(int initialSize) {
		this.initialSize = initialSize;
		this.theStackStorage = new Object[initialSize];
	}

	Object[] theStackStorage;

	public Object push(Object o) {
		if (size == initialSize) {
			System.out.println("Its full");
			return null;
		}
		theStackStorage[size] = o;
		size++;
		return o;
	}

	public Object remove(int index) {
		Object returnObject = null;
		Object[] tempStackStorage = new Object[initialSize];
		for (int i = 0; i < theStackStorage.length; i++) {
			if (i < index) {
				tempStackStorage[i] = theStackStorage[i];
			}
			else if (i > index) {
				tempStackStorage[i - 1] = theStackStorage[i];
			} else {
				returnObject = theStackStorage[i];
			}
		}
		theStackStorage = Arrays.copyOf(tempStackStorage, initialSize);
		size--;
		return returnObject;
	}

	public Object peek() {
		return theStackStorage[size - 1];
	}

	public Object pop() {
		Object removedObject = theStackStorage[size - 1];
		theStackStorage[size - 1] = null;
		size--;
		return removedObject;
	}

	public void clear() {
		Arrays.fill(theStackStorage, null);
		size = 0;
	}

	public int size() {
		return size;
	}



}
