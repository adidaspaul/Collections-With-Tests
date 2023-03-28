import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class LinkedListTest {

	
	 static LinkedL list = null;
	@BeforeClass
	public static void setUpBeforeClass()  {
		list = new LinkedL();
		list.add("Hello");
		list.add("Taal");
		list.add("Khalas");
		list.add("Yalla");
		list.add("yalla");
	}


	
	@Test
	public void linkedListObjectTest() {
		assertEquals("Taal", list.get(1));
	}
	
	@Test
	public void linkedListRemoveNegativeTest() {
		assertNotNull(list.remove(-1));
	}
	
	@Test
	public void linkedListAddTest() {
		assertTrue(list.add(new Object()));
	}
	
	@Test
	public void linkedListSizeTest() {
		assertNotEquals(list.size(), 0);
	}
	
	@Test
	public void linkedListCurrentSizeTest() {
		assertEquals(list.size(),list.getCurrentSize());
	}
	
	@Test
	public void linkedListRemoveTest() {
		assertEquals(list.get(2), list.remove(2));
	}
	

	
	@AfterClass
	public static void tearDownAfterClass()  {
		list.clear();
	}
}
