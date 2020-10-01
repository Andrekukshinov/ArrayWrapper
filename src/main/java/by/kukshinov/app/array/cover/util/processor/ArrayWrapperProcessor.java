package by.kukshinov.app.array.cover.util.processor;

import by.kukshinov.app.array.cover.exception.ArrayException;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;

import java.util.ArrayList;
import java.util.List;

public class ArrayWrapperProcessor {
    private void swap(int[] arrayToBeSorted, int previous, int current) {
	   int container = arrayToBeSorted[previous];
	   arrayToBeSorted[previous] = arrayToBeSorted[current];
	   arrayToBeSorted[current] = container;
    }
    private boolean isUnique(int number) {
	   int hundreds = number / 100;
	   int dozens = (number % 100) / 10;
	   int units = (number % 10);
	   return hundreds != dozens && hundreds != units && units != dozens;
    }

    public int[] sortAscending(ArrayWrapper sourceWrapper) {
	   int[] arrayToBeSorted = sourceWrapper.getArray();
	   int length = arrayToBeSorted.length;
	   if (!sourceWrapper.isSorted()) {
		  for (int outerRunner = 0; outerRunner < length; ++outerRunner) {
			 for (int runner = 1; runner < length - outerRunner; ++runner) {
				int prevIndex = runner - 1;
				if (arrayToBeSorted[prevIndex] > arrayToBeSorted[runner]) {
				    swap(arrayToBeSorted, prevIndex, runner);
				}
			 }
		  }
	   }
	   return arrayToBeSorted;
    }
    public int[] sortDescending(ArrayWrapper sourceWrapper) {
	   int[] arrayToBeSorted = sourceWrapper.getArray();
	   int length = arrayToBeSorted.length;
	   if (!sourceWrapper.isSorted()) {
		  for (int outerRunner = 0; outerRunner < length; ++outerRunner) {
			 for (int runner = 1; runner < length - outerRunner; ++runner) {
				int prevIndex = runner - 1;
				if (arrayToBeSorted[prevIndex] < arrayToBeSorted[runner]) {
				    swap(arrayToBeSorted, prevIndex, runner);
				}
			 }
		  }
	   }
	   return arrayToBeSorted;
    }
    public Integer[] selectNumbersWithUniqueDigits(ArrayWrapper wrapper) throws ArrayException {
	   List<Integer> numbersWithUniqueNumbers = new ArrayList<>();
	   for (int runner = 0; runner < wrapper.getLength(); ++runner) {
		  int number = wrapper.getElement(runner);
		  if (isUnique(number)) {
			 numbersWithUniqueNumbers.add(number);
		  }
	   }
	   return numbersWithUniqueNumbers.toArray(new Integer[0]);
    }


}
