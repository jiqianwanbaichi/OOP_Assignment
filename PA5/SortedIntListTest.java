
/**
 * Xueyan Huang
 * xueyanhuang@brandeis.edu
 * Nov 27, 2022
 * PA5
 * Explanation:Test for SortedIntList
 */
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SortedIntListTest {

	/**
	 * @description: test for SortedIntList without unique
	 * @return void
	 */
	@Test
	public void noUniqueListTest() {
		SortedIntList array = new SortedIntList(false);
		array.add(-1);
		array.add(10);
		array.add(-2);
		array.add(0);
		array.add(1);
		array.add(2);
		array.add(-1);
		array.add(10);
		Assert.assertEquals(array.toString(), "S:[-2, -1, -1, 0, 1, 2, 10, 10]");
		Assert.assertEquals(array.getUnique(), false);
		Assert.assertEquals(array.max(), 10);
		Assert.assertEquals(array.min(), -2);
		Assert.assertEquals(array.indexOf(-2), 0);
	}

	/**
	 * @description: test for SortedIntList with unique
	 * @return void
	 */
	@Test
	public void uniqueListTest() {
		SortedIntList array = new SortedIntList(true);
		array.add(-1);
		array.add(10);
		array.add(-2);
		array.add(0);
		array.add(1);
		array.add(2);
		array.add(-1);
		array.add(10);
		Assert.assertEquals(array.toString(), "S:[-2, -1, 0, 1, 2, 10]U");
		Assert.assertEquals(array.getUnique(), true);
		Assert.assertEquals(array.max(), 10);
		Assert.assertEquals(array.min(), -2);
		Assert.assertEquals(array.indexOf(-2), 0);
	}

	/**
	 * @description: test for setUnique method of SortedIntList
	 * @return {*}
	 */
	@Test
	public void setUniqueTest() {
		SortedIntList array = new SortedIntList(false);
		array.add(-1);
		array.add(10);
		array.add(-2);
		array.add(0);
		array.add(1);
		array.add(2);
		array.add(-1);
		array.add(10);
		Assert.assertEquals(array.toString(), "S:[-2, -1, -1, 0, 1, 2, 10, 10]");
		array.setUnique(true);
		Assert.assertEquals(array.toString(), "S:[-2, -1, 0, 1, 2, 10]U");
	}

}
