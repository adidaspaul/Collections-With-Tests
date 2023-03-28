import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class TheQTest {

	static TheQ qu = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		qu = new TheQ(5);
		qu.add("hello");
		qu.add("YO1");
		qu.add("YO2");
		qu.add("YO3");

	}

	@Test
	public void addTest() {
		assertTrue(qu.add("YO4"));
	}

	@Test
	public void sizeTest() {
		assertEquals(4, qu.size());
		assertEquals(5, qu.size());
	}

	@Test
	public void removeTest() {
		assertNotNull(qu.remove(1));
	}

	@Test
	public void clearTest() {
		qu.clear();
		assertEquals(0, qu.size());
	}
	
	@Test
	public void peekTest() {
		assertNotNull(qu.peek());
	}

	@Test
	public void pollTest() {
		assertNull(qu.poll());
	}
}
