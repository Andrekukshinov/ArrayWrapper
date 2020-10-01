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
    public void printData(ArrayWrapper wrapper) throws IOException {
	   File file = new File(filePath);
	   try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
		  writer.write(wrapper.toString());

	   }
    }

    @Override
    public void printNumbersWithUniqueDigits(Integer[] array) throws IOException {
	   File file = new File(filePath);
	   try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
		  writer.write(Arrays.toString(array));
	   }
    }
}
