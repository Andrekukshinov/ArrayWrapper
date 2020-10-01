package by.kukshinov.app.array.cover.view.impl;

import by.kukshinov.app.array.cover.constants.FilePaths;
import by.kukshinov.app.array.cover.consts.ArrayWrapperConst;
import by.kukshinov.app.array.cover.exception.ArrayException;
import by.kukshinov.app.array.cover.util.processor.ArrayWrapperProcessor;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FileDataPrinterTest {
    private String readFileData(String filePath) {
        String data = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            data = reader.readLine();
	   } catch (IOException e) {
		  throw new RuntimeException(e);
	   }
        return data;
    }
    @Test
    public void testFileDataWriterShouldWriteDataToSpecifiedFile() throws IOException {
        //given
	   FileDataPrinter printer = new FileDataPrinter(FilePaths.TEST_ARRAY_DATA_WRITER_FILE_PATH);
	   ArrayWrapper wrapper = ArrayWrapperConst.WRAPPER;
	   //when
	   printer.printData(wrapper);
	   //then
	   String result = readFileData(FilePaths.TEST_ARRAY_DATA_WRITER_FILE_PATH);
	   Assert.assertEquals(wrapper.toString(), result);
    }

    // TODO: 01.10.2020 fix
    @Test
    public void testFileDataWriterShouldWriteArrayToSpecifiedFile() throws IOException, ArrayException {
        //given
	   FileDataPrinter printer = new FileDataPrinter(FilePaths.TEST_ARRAY_DATA_WRITER_FILE_FOR_DIGITS_ARRAY_PATH);
	   ArrayWrapper wrapper = ArrayWrapperConst.WRAPPER;
	   ArrayWrapperProcessor wrapperProcessor = new ArrayWrapperProcessor();
	   Integer[] processedResult = wrapperProcessor.selectNumbersWithUniqueDigits(wrapper);
	   //when
	   printer.printNumbersWithUniqueDigits(processedResult);
	   //then
	   String result = readFileData(FilePaths.TEST_ARRAY_DATA_WRITER_FILE_FOR_DIGITS_ARRAY_PATH);
	   Assert.assertEquals(Arrays.toString(processedResult), result);
    }
}
