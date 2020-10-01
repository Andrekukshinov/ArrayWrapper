package by.kukshinov.app.array.cover.util.parser.impl;

import by.kukshinov.app.array.cover.util.parser.Parser;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;

public class IntParser implements Parser<Integer[]> {
    @Override
    public ArrayWrapper parseDataToArrayWrapper(Integer[] source) {
        int[] arrayForWrapper = new int[source.length];
	   int index = 0;
	   for (int element : source) {
		  arrayForWrapper[index++] = element;
	   }
	   return new ArrayWrapper(arrayForWrapper);
    }

    @Override
    public int parseSingleString(String s) {
	   return Integer.parseInt(s);
    }
}
