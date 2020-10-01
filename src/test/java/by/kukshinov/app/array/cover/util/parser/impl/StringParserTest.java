package by.kukshinov.app.array.cover.util.parser.impl;

import by.kukshinov.app.array.cover.util.parser.Parser;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;
import org.junit.Assert;
import org.junit.Test;

public class StringParserTest {
    public static int[] SOURCE_INT = {123, 122, 947, 6, -7, 437, 327, 900, 653, 239, -98, 89};
    public static Integer[] INTEGER_DATA = {123, 122, 947, 6, -7, 437, 327, 900, 653, 239, -98, 89};


    @Test
    public void shouldParseFromStringAndCreateArrayWrapper() {
	   //given
	   Parser<String> stringParser = new StringParser();
	   String source = "123, 122 , 947,6k-7 437, 327, 900, 653, ynuiuy239 -98lmjo m89hkj \n";
	   ArrayWrapper toCompare = new ArrayWrapper(SOURCE_INT);
	   //when
	   ArrayWrapper wrapper = stringParser.parseDataToArrayWrapper(source);
	   //then
	   Assert.assertEquals(toCompare, wrapper);
    }

    @Test
    public void shouldParseFromIntegerArrayAndCreateArrayWrapper() {
	   //given
	   Parser<Integer[]> stringParser = new IntParser();
	   Integer[] source = INTEGER_DATA;
	   ArrayWrapper toCompare = new ArrayWrapper(new int[]{123, 122, 947, 6, -7, 437, 327, 900, 653, 239, -98, 89});
	   //when
	   ArrayWrapper wrapper = stringParser.parseDataToArrayWrapper(source);
	   //then
	   Assert.assertEquals(toCompare, wrapper);
    }

}
