
public class LinkedL implements Collection {
	
	
	private int currentSize;
	private Node first;
	private Node last;
	
	public LinkedL() {
		this.currentSize = 0;
		this.first = new Node(null,null,null);
		this.last = new Node(null,null,null);
	}
	
	public int getCurrentSize() {
		return currentSize;
	}
	


	private static class Node {
		
		Node behind;
		Object element;
		Node inFront;
		
		public Node(Node behind, Object element, Node inFront) {
			this.behind = behind;
			this.element = element;
			this.inFront = inFront;
		}


	}

	@Override
	public Object remove(int index) {
		Object result = null;
		try {
//			if(index > currentSize) {
//				throw new IndexOutOfBoundsException ();
//			} else 
			if (index < 0) {
				index *= -1;
				Node toRemove = getNode(index);
				result = toRemove.element;
				toRemove.behind.inFront = toRemove.inFront;
				toRemove.inFront.behind = toRemove.behind;
				currentSize--;
				return result;
			}
			else if (currentSize == 1) {
				result = last.element;
				clear();
			} else {
				Node toRemove = getNode(index);
				result = toRemove.element;
				toRemove.behind.inFront = toRemove.inFront;
				toRemove.inFront.behind = toRemove.behind;
				currentSize--;
			}
		} catch (IndexOutOfBoundsException iOB) {
			System.out.println("Nothing is there under this index, try again");
		}
		return result;
	}

	@Override
	public Object get(int index) {
		
		if(getNode(index) == null) {
			String problem = "NPE problem";
			return problem;
		}
		return getNode(index).element;
	}
	private Node getNode(int digit) {
		return digit > currentSize / 2 ? tailNodeSearch(digit) : headNodeSearch(digit);
	}
	
	protected Node tailNodeSearch(int digit) {
		Node searchNode = null;
		try {
			if(digit > currentSize) {
				throw new IllegalArgumentException();
			} else if(digit < 0) {
				digit *= -1;
			}
			int index = currentSize - 1;
			searchNode = last;
			while(searchNode.behind != null) {
				searchNode = searchNode.behind;
				index--;
				if(index == digit) {
					return searchNode;
				}
//			for(int i = currentSize - 1; i > digit; i--) {
//				searchNode = searchNode.behind;
			}
		} catch (IllegalArgumentException iAE) {
			System.out.println("Index -->" + digit +  " is out of bounds, try again");
		} return searchNode;
	}
	
	private Node headNodeSearch(int digit) {
		Node searchNode = null;;
		try {
			if(digit > currentSize) {
				throw new IllegalArgumentException(" ");
			} else if(digit < 0) {
				digit *= -1;
			}
			searchNode = first;
			for( int i = 0; i < digit; i++) {
				searchNode = searchNode.inFront;
			}
		} catch (IllegalArgumentException iAE) {
			System.out.println("Index -->" + digit +  " is out of bounds, try again");
		} return searchNode;
	}

	@Override
	public void clear() {
		currentSize = 0;
		first = new Node(null,null,null);
		last = new Node(null,null,null);

	}

	@Override
	public int size() {
		System.out.println(currentSize);
		return currentSize;
	}

	@Override
	public boolean add(Object o) {
		try {
			if (currentSize == 0) {
				Node startNode = new Node(null, o, null);
				first = startNode;
				last = startNode;
			} else if (currentSize == 1) {
				last = new Node(first, o, null);
				first.inFront = last;
			} else {
				last = new Node(this.last, o, null);
				last.behind.inFront = last;
			}
			currentSize++;
			System.out.println("Object added, link created");
			return true;
		} catch (NullPointerException n) {
			
			System.out.println("Value cannot be null, insert proper object");
		}
		System.out.println("Operation failed try again");
		return false;
	}
   
	@Override
    public String toString() {
        Node bufferNode = first;
        StringBuilder result = new StringBuilder("MyLinkedList: size=" + currentSize + ";\nElements: {");
        for (int i = 0; i < currentSize; i++) {
            if (bufferNode.element != null) {
                result.append(bufferNode.element.toString());
                if(bufferNode.inFront == null) {
                	break;
                }
                result.append(", ");
                bufferNode = bufferNode.inFront;
            }
        }
        result.append("}");
        return result.toString();
    }

}
