package by.kukshinov.app.array.cover.util.processor;


import by.kukshinov.app.array.cover.consts.ArrayWrapperConst;
import by.kukshinov.app.array.cover.exception.ArrayException;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayWrapperProcessorTest {
    @Test
    public void testShouldSortArrayAscending() {
	   //given
	   ArrayWrapperProcessor sorter = new ArrayWrapperProcessor();
	   int[] sortedArray = ArrayWrapperConst.SORTED_ONE_INT_ARRAY_ASC;
	   ArrayWrapper wrapper = ArrayWrapperConst.WRAPPER;
	   //when
	   int[] result = sorter.sortAscending(wrapper);
	   //then
	   Assert.assertArrayEquals(sortedArray, result);
    }
    @Test
    public void testShouldFilterUniqueDigitsInNumber() throws ArrayException {
	   //given
	   int[] startArray = {101, 105, 999, 590, 950, 654, 456, 456, 9000, 1, -98, -6};
	   ArrayWrapperProcessor filter = new ArrayWrapperProcessor();
	   ArrayWrapper wrapper = new ArrayWrapper(startArray);
	   int[] comparedArray = {105, 590, 950, 654, 456, 456};
	   //when
	   int[] result = filter.selectNumbersWithUniqueDigits(wrapper);
	   //then
	   Assert.assertArrayEquals(comparedArray, result);
    }
    @Test
    public void testShouldSortArrayDescending() {
	   //given
	   ArrayWrapperProcessor sorter = new ArrayWrapperProcessor();
	   int[] sortedArray = ArrayWrapperConst.SORTED_ONE_INT_ARRAY_DESC;
	   ArrayWrapper wrapper = ArrayWrapperConst.WRAPPER;
	   //when
	   int[] result = sorter.sortDescending(wrapper);
	   //then
	   Assert.assertArrayEquals(sortedArray, result);
    }

}
