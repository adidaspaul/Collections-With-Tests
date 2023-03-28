

import java.util.Arrays;
import java.util.Objects;

public class ArrayL implements Collection {

	
	private static final int START_SIZE = 10;
	private static final int MAX_SIZE = 150;
	protected Object[] block;
	private int currentSize;
	protected int currentLength;

	
	

	

	
	
	public ArrayL() {
		
		this.block = new Object[START_SIZE];
		this.currentLength = START_SIZE;
		this.currentSize= 0;
	}

	public boolean add(Object o) {
		try {
			if (currentSize >= currentLength - 1) {
				expand();
			}
			block[currentSize] = o;
			currentSize++;
			System.out.println("Object added!");
			return true;
		} catch (RuntimeException re) {
			System.out.println("Something is wrong bro! " + re.getCause());
		}
		return false;
	}

	private void expand() {
		try {
			if (currentSize >= MAX_SIZE) {
				System.out.println("Your list is full");
			}
			currentLength = (currentSize * 2) + 1;
			if (currentLength < currentSize) {
				currentLength *= 2;
			}
			Object[] array = new Object[currentLength];
			System.arraycopy(block, 0, array, 0, currentSize);
			block = array;
		} catch (IllegalArgumentException iAE) {
			System.out.println("Wrong numbers" + iAE.getLocalizedMessage());
		}
	}


	public Object remove(int indexToRemove) {
		try {
			if (indexToRemove < 0) {
				indexToRemove *= -1;
				System.out.println("Next time don't put negative index");

			} else if (currentSize <= 0) {
				System.out.println("There is nothing to remove");
			} 
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index is out of bounds");
		}
	
		Object toRemove = block[indexToRemove];
		if (currentLength - indexToRemove >= 0) {
			System.arraycopy(block, indexToRemove + 1, block, indexToRemove, currentLength - indexToRemove - 1);
			currentSize--;
			if (currentSize <= currentLength / 2) {
				currentSize += 5;
			}
		}
		return toRemove;
	}

	
	public Object get(int digit) {
		String message;
		try {
			if(digit == (int)digit) {
			return block[digit];
			}
		} catch (NumberFormatException e) {
			System.out.println( "The value is not a number");
		}
		return null;
	}
	

	
	public void clear() {
		this.block = new Object[START_SIZE];
		this.currentLength = START_SIZE;
		this.currentSize = 0;
		System.out.println("Cleared, you can start filling it");
	}

	
	public int size() {
		
		System.out.println(currentSize);
		return currentSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(block);
		result = prime * result + Objects.hash(currentLength, currentSize);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArrayL other = (ArrayL) obj;
		return Arrays.deepEquals(block, other.block) && currentLength == other.currentLength
				&& currentSize == other.currentSize;
	}

	@Override
	public String toString() {
		return "List" + "\n" +  Arrays.toString(block) + 
				"\n current size = " + currentSize + 
				"\n current length = "
				+ currentLength;
	}

}
