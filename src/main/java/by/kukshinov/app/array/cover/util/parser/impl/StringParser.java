package by.kukshinov.app.array.cover.util.parser.impl;


import by.kukshinov.app.array.cover.util.parser.Parser;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;


public class StringParser implements Parser<String> {
    private static final String SEPARATOR = "[^(\\-\\d)|+]|-[^\\d]";
    private int getLength(String[] cont) {
	   int length = 0;
	   for (String s : cont) {
		  if (!s.equals("")) {
			 length++;
		  }
	   }
	   return length;
    }

    public ArrayWrapper parseDataToArrayWrapper(String source) {
	   String[] cont = source.split(SEPARATOR);
	   int length = getLength(cont);
	   int[] result = new int[length];
	   int intRunner = 0;
	   for (int runner = 0; runner < cont.length; ++runner) {
		  if (!cont[runner].equals("")) {
			 result[intRunner++] = Integer.parseInt(cont[runner]);
		  }
	   }
	   return new ArrayWrapper(result);
    }

    @Override
    public int parseSingleString(String s) {
	   return Integer.parseInt(s);
    }
}

