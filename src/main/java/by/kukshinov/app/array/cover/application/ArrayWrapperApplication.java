package by.kukshinov.app.array.cover.application;


import by.kukshinov.app.array.cover.constants.FilePaths;
import by.kukshinov.app.array.cover.data.DataAcquirer;
import by.kukshinov.app.array.cover.enums.DataAcquirerType;
import by.kukshinov.app.array.cover.exception.ArrayException;
import by.kukshinov.app.array.cover.factory.DataAcquirerCreator;
import by.kukshinov.app.array.cover.util.processor.ArrayWrapperProcessor;
import by.kukshinov.app.array.cover.view.DataPrinter;
import by.kukshinov.app.array.cover.view.impl.FileDataPrinter;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;

import java.io.IOException;

public class ArrayWrapperApplication {
    public static void main(String[] args) throws ArrayException, IOException {
        DataAcquirer acquirer = new DataAcquirerCreator().createDataAcquirer(DataAcquirerType.FILE, FilePaths.ARRAY_DATA_FILE_PATH);
        ArrayWrapperProcessor wrapperServer = new ArrayWrapperProcessor();
        ArrayWrapper wrapper = acquirer.getData();
        int[] res = wrapperServer.sortAscending(wrapper);
        ArrayWrapper sorted = new ArrayWrapper(res);
        Integer[] numbersWithUniqueDigits = wrapperServer.selectNumbersWithUniqueDigits(wrapper);
        DataPrinter printer = new FileDataPrinter(FilePaths.ARRAY_DATA_WRITER_FILE_PATH);
        printer.printData(sorted);
        printer.printNumbersWithUniqueDigits(numbersWithUniqueDigits);
    }
}
