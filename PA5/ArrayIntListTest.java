
/**
 * Xueyan Huang
 * xueyanhuang@brandeis.edu
 * Nov 27, 2022
 * PA5
 * Explanation:Test for ArrayIntList
 */

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ArrayIntListTest {

	/**
	 * @description: test the capacity of the ArrayIntList
	 * @return void
	 */
	@Test
	public void initTest() {
		ArrayIntList intArray_A = new ArrayIntList();
		Assert.assertEquals(intArray_A.array.length, 10);
		ArrayIntList intArray_B = new ArrayIntList(15);
		Assert.assertEquals(intArray_B.array.length, 15);
	}

	/**
	 * @description: test the add method of ArrayIntList
	 * @return void
	 */
	@Test
	public void addtest() {
		ArrayIntList intArray = createTestArray();
		intArray.add(3);
		intArray.add(1, 10);
		Assert.assertEquals(intArray.toString(), "[0, 10, 1, 2, 3]");
	}

	/**
	 * @description: test the get method of ArrayIntList
	 * @return void
	 */
	@Test
	public void getTest() {
		ArrayIntList intArray = createTestArray();
		Assert.assertEquals(intArray.get(0), 0);
		Assert.assertEquals(intArray.get(1), 1);
	}

	/**
	 * @description: test the indexOf method of ArrayIntList
	 * @return void
	 */
	@Test
	public void indexOfTest() {
		ArrayIntList intArray = createTestArray();
		Assert.assertEquals(intArray.indexOf(1), 1);
		Assert.assertEquals(intArray.indexOf(10), -1);

	}

	/**
	 * @description: test the remove method of ArrayIntList
	 * @return void
	 */
	@Test
	public void removeTest() {
		ArrayIntList intArray = createTestArray();
		intArray.remove(1);
		Assert.assertEquals(intArray.toString(), "[0, 2]");
	}

	/**
	 * @description: test the size method of ArrayIntList
	 * @return void
	 */
	@Test
	public void sizeTest() {
		ArrayIntList intArray = createTestArray();
		Assert.assertEquals(intArray.size(), 3);
	}

	/**
	 * @description: test the clear method of ArrayIntList
	 * @return void
	 */
	@Test
	public void clearTest() {
		ArrayIntList intArray = createTestArray();
		intArray.clear();
		Assert.assertEquals(intArray.size(), 0);
		Assert.assertEquals(intArray.toString(), "[]");
	}

	/**
	 * @description: test the contains method of ArrayIntList
	 * @return void
	 */
	@Test
	public void containsTest() {
		ArrayIntList intArray = createTestArray();
		Assert.assertEquals(intArray.contains(0), true);
		Assert.assertEquals(intArray.contains(10), false);
	}

	/**
	 * @description: create an ArrayIntList for test. The array is [0, 1, 2]
	 * @return ArrayIntList
	 */
	private ArrayIntList createTestArray() {
		ArrayIntList intArray = new ArrayIntList();
		intArray.add(0);
		intArray.add(1);
		intArray.add(2);
		return intArray;
	}

}
