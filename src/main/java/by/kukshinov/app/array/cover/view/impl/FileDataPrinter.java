package by.kukshinov.app.array.cover.view.impl;

import by.kukshinov.app.array.cover.view.DataPrinter;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FileDataPrinter implements DataPrinter {
    private final String filePath;

    public FileDataPrinter(String filePath) {
	   this.filePath = filePath;
    }

    @Override
    public void printData(ArrayWrapper wrapper, int[] arrayToPrint) throws IOException {
	   File file = new File(filePath);
	   try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
		  printSortedArray(wrapper, writer);
		  writer.newLine();
		  printNumbersWithUniqueDigits(arrayToPrint, writer);
	   }
    }

    private void printSortedArray(ArrayWrapper wrapper, BufferedWriter writer) throws IOException {
	   writer.write((wrapper.toString()));
    }

    private void printNumbersWithUniqueDigits(int[] array, BufferedWriter writer) throws IOException {
	   File file = new File(filePath);
	   writer.write(Arrays.toString(array));
    }
}
