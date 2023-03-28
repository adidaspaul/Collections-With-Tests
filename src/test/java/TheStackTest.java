import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class TheStackTest {


	static TheStack stack = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stack = new TheStack(6);
		stack.push("YO1");
		stack.push("YO2");
		stack.push("YO3");
		stack.push("YO4");
		stack.push("YO5");
	}

	@Test
	public void testPushNullWhenFull() {
		stack.push("YO7");
		assertNull(stack.push("YO6"));
	}

	@Test
	public void testPush() {
		assertNotNull(stack.push("YO7"));
	}

	@Test
	public void testRemove() {
		assertEquals("YO5", stack.remove(4));

	}

	@Test
	public void testPeek() {
		assertEquals("YO5", stack.peek());
	}

	@Test
	public void testPop() {
		assertNotNull(stack.pop());
		assertEquals(4, stack.size());
	}

	@Test
	public void testClear() {
		stack.clear();
		assertEquals(0, stack.size());
	}

	@Test
	public void testSize() {
		assertNotNull(stack.size());

		TheStack stack2 = mock(TheStack.class);
		stack2.size();
		stack2.clear();
		verify(stack2, times(1)).size();
		
		InOrder order = Mockito.inOrder(stack2);
		order.verify(stack2).size();
		order.verify(stack2).clear();

	}

}
