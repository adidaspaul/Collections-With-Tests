import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayListTest {

	static ArrayL list = null;

	@BeforeClass
	public static void setUp() {
		list = new ArrayL();
		list.add(55);
		list.add(67);
		list.add(88);
	}

	@Test
	public void testIndexOutOfBound() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(11);
		});
	}

	@Test
	public void testAddObject() {
		assertTrue(list.add("Yello"));
	}

	@Test
	public void testStartLengthObject() {
		assertEquals(10, list.currentLength);
	}

	@Test
	public void testSizeObject() {
		assertEquals(5, list.size());
	}

	@Test
	public void testRemove() {
		assertEquals(list.get(1), list.remove(1));
	}

	@Test
	public void testNegativeRemove() {
		assertEquals(list.get(1), list.remove(-1));
	}

	@Test
	public void testClear() {
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	public void testGet() {
		assertThrows(NumberFormatException.class, () -> {
			list.get(Integer.parseInt("Three"));
		});

	}

}
