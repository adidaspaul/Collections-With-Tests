import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.BeforeClass;
import org.junit.Test;

public class HashMapTest {

	
	static TheHashMap map = null;
	
@BeforeClass
public static void setUpBefore() {
	map = new TheHashMap();
	map.put("Hello", "Bontle");
	map.put("node", "Node");
}

	@Test
	public void getTest() {
		String line = "Bontle";
		assertEquals(line,map.get("Hello"));
	}
	
	@Test
	public void verifyPut() {
		TheHashMap map1 = mock(TheHashMap.class);
		map1.put("Hello", "Hello");
		verify(map1).put("Hello", "Hello");
	}
	
	@Test
	public void putThrowsNpeTest() {
		assertThrows(NullPointerException.class, ()->{
		map.put(null, "Yellow");
		});
	}
	
	@Test
	public void removeTest() {
		TheHashMap map1 = mock(TheHashMap.class);
		map1.remove("node");
		verify(map1, times(1)).remove("node");

	}
	
	@Test
	public void clearTest() {
		map.clear();
		assertTrue(map.size() == 0);
	}

	@Test
	public void sizeTest() {
		assertEquals(2, map.size());
	}
}
