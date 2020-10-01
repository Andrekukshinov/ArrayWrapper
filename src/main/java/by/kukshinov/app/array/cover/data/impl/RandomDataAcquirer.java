package by.kukshinov.app.array.cover.data.impl;

import by.kukshinov.app.array.cover.data.DataAcquirer;
import by.kukshinov.app.array.cover.util.parser.Parser;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;

import java.util.Random;

public class RandomDataAcquirer implements DataAcquirer {
    private final Parser<Integer[]> parser;
    public RandomDataAcquirer(Parser<Integer[]> parser) {
	   this.parser = parser;
    }

    private void fillArray(Random randomizer, Integer[] result) {
	   for (int runner = 0; runner < result.length; ++runner) {
		  result[runner] = randomizer.nextInt(1000);
	   }
    }

    @Override
    public ArrayWrapper getData() {
	   Random randomizer = new Random();
	   Integer[] result = new Integer[randomizer.nextInt(50)];
	   fillArray(randomizer, result);
	   return parser.parseDataToArrayWrapper(result);
    }


}
