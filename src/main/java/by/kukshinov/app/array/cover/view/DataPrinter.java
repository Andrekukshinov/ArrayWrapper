package by.kukshinov.app.array.cover.view;

import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataPrinter {
    void printData(ArrayWrapper wrapper) throws IOException;
    void printNumbersWithUniqueDigits(Integer[] array) throws IOException;
}
